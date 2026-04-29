package com.sia.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sia.model.PriceBar;
import com.sia.repository.PriceBarRepository;
import com.sia.service.PriceBarDataLoader;
import com.sia.service.PriceBarService;
import com.sia.service.dataloader.PriceBarLoadOptions;
import com.sia.utils.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PriceBarServiceImpl implements PriceBarService {

    private final List<PriceBarDataLoader> loaders;
    private final PriceBarRepository repository;

    public PriceBarServiceImpl(List<PriceBarDataLoader> loaders, PriceBarRepository repository) {
        this.loaders = loaders;
        this.repository = repository;
    }

    @Override
    public void importData(MultipartFile file, PriceBarLoadOptions options) {
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.isBlank()) {
            throw new IllegalArgumentException("File name is missing");
        }
        String fileType = FileUtils.getFileExtension(originalFilename);
        if (fileType.isBlank()) {
            throw new IllegalArgumentException("Could not determine file type from: " + originalFilename);
        }

        List<PriceBar> priceBars = loaders.stream()
                .filter(loader -> loader.useFileType().equalsIgnoreCase(fileType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Unsupported file type: " + fileType))
                .load(file, options);

        repository.saveAll(priceBars);
    }
}