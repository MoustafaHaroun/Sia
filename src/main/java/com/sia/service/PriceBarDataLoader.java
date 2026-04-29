package com.sia.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sia.model.PriceBar;
import com.sia.service.dataloader.PriceBarLoadOptions;

public interface PriceBarDataLoader {
    String useFileType();
    List<PriceBar> load(MultipartFile file, PriceBarLoadOptions options);
}