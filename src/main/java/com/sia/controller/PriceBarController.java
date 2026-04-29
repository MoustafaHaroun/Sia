package com.sia.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sia.service.PriceBarService;
import com.sia.service.dataloader.PriceBarLoadOptions;

@RestController
@RequestMapping("/api/price_bars")
class PriceBarController {

    private final PriceBarService service;

    PriceBarController(PriceBarService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public void upload(
            @RequestPart("file") MultipartFile file,
            @RequestPart(value = "options", required = false) PriceBarLoadOptions options) {

        PriceBarLoadOptions resolved = options != null ? options : PriceBarLoadOptions.defaults();
        service.importData(file, resolved);
    }
}