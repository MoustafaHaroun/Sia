package com.sia.service;

import org.springframework.web.multipart.MultipartFile;

import com.sia.service.dataloader.PriceBarLoadOptions;

public interface PriceBarService {
    void importData(MultipartFile file, PriceBarLoadOptions options);
}