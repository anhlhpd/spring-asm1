package com.example.asm1.service;

import com.example.asm1.dto.CoinDTO;
import com.example.asm1.entity.Coin;
import com.example.asm1.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class CoinService {

    @Autowired
    CoinRepository coinRepository;

    public Page<Coin> coins(Specification specification) {
        return coinRepository.findAll(specification);
    }

    public Coin create(CoinDTO coinDTO){
        Coin coin = new Coin(coinDTO);
        coin.setStatus(1);
        coin.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        coin.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return coinRepository.save(coin);
    }
}
