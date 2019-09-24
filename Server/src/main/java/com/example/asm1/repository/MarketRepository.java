package com.example.asm1.repository;

import com.example.asm1.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Integer> {
}
