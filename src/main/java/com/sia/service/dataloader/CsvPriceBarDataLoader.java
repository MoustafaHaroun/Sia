package com.sia.service.dataloader;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.sia.model.PriceBar;
import com.sia.service.PriceBarDataLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CsvPriceBarDataLoader implements PriceBarDataLoader {

    private static final CsvMapper CSV = new CsvMapper();
    private static final CsvSchema SCHEMA = CsvSchema.emptySchema().withHeader();
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String useFileType() {
        return "csv";
    }

    @Override
    public List<PriceBar> load(MultipartFile file, PriceBarLoadOptions options) {
        log.info("Loading price bars from CSV: {}", file.getOriginalFilename());
        List<PriceBar> bars = new ArrayList<>();

        try {
            var rows = CSV.readerFor(Map.class).with(SCHEMA).<Map<String, String>>readValues(file.getInputStream());
            int lineNumber = 1;
            while (rows.hasNext()) {
                lineNumber++;
                try {
                    Map<String, String> row = rows.next();

                    bars.add(parsePriceBar(row, options));

                } catch (Exception e) {
                    log.warn("Skipping invalid row {}: {}", lineNumber, e.getMessage());
                }
            }
            log.info("Loaded {} price bars", bars.size());
        } catch (IOException e) {
            log.error("Failed to load CSV file", e);
            throw new RuntimeException("Failed to read CSV file", e);
        }

        return bars;
    }

    private PriceBar parsePriceBar(Map<String, String> row, PriceBarLoadOptions options) {

        String ticker = options.ticker() != null ? options.ticker() : row.get("ticker");
        
        if(ticker == null || ticker.isBlank()) {
            throw new IllegalArgumentException("Ticker is missing");
        }

        LocalDateTime timestamp = LocalDateTime.parse(row.get("timestamp"), TIMESTAMP_FORMATTER);

        BigDecimal open = new BigDecimal(row.get("open"));
        BigDecimal high = new BigDecimal(row.get("high"));
        BigDecimal low = new BigDecimal(row.get("low"));
        BigDecimal close = new BigDecimal(row.get("close"));
        long volume = Long.parseLong(row.get("volume"));

        return PriceBar.builder()
                .ticker(ticker)
                .date(timestamp.toLocalDate())
                .open(open)
                .high(high)
                .low(low)
                .close(close)
                .volume(volume)
                .build();
    }
}
