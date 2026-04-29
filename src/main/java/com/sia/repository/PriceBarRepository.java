package com.sia.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sia.model.PriceBar;

public interface PriceBarRepository extends JpaRepository<PriceBar, Long> {
}