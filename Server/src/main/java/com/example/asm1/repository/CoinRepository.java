package com.example.asm1.repository;

import com.example.asm1.entity.Coin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, Integer> {

    Page<Coin> findAll(Specification specification);
}
