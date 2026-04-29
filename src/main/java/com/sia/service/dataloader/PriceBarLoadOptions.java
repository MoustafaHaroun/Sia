package com.sia.service.dataloader;

public record PriceBarLoadOptions(String ticker) {

    public static PriceBarLoadOptions defaults() {
        return new PriceBarLoadOptions(null);
    }
}
