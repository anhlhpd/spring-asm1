package com.example.asm1.service;

import com.example.asm1.entity.Market;
import com.example.asm1.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class MarketService {
    @Autowired
    MarketRepository marketRepository;

    public List<Market> markets(){
        return marketRepository.findAll();
    }

    public Market create(Market market){
        market.setStatus(1);
        market.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        market.setUpdatedAt(Calendar.getInstance().getTimeInMillis());
        return marketRepository.save(market);
    }
}
