package com.example.asm1.controller;

import com.example.asm1.dto.MarketDTO;
import com.example.asm1.entity.Market;
import com.example.asm1.entity.rest.RESTResponse;
import com.example.asm1.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/markets")
public class MarketController {
    @Autowired
    MarketService marketService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getList(){
        List<Market> marketList = marketService.markets();
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Action success!")
                .addData(marketList)
                .build());
    }

    @RequestMapping(method = RequestMethod.POST)
    public Market store(@RequestBody Market market){
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.CREATED.value())
                .addData(new MarketDTO(marketService.create(market)))
                .build());
    }
}
