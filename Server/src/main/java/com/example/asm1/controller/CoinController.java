package com.example.asm1.controller;

import com.example.asm1.dto.CoinDTO;
import com.example.asm1.entity.Coin;
import com.example.asm1.entity.Market;
import com.example.asm1.service.CoinService;
import com.example.asm1.specification.CoinSpecification;
import com.example.asm1.specification.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.asm1.entity.rest.RESTPagination;
import com.example.asm1.entity.rest.RESTResponse;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/markets")
public class CoinController {
    @Autowired
    CoinService coinService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getList( @RequestParam(value = "keyword", required = false) String keyword){
        Specification specification = Specification.where(null);
        if (keyword != null && keyword.length() > 0) {
            specification = specification
                    .and(new CoinSpecification(new SearchCriteria("name", ":", keyword)))
                    .or(new CoinSpecification(new SearchCriteria("marketId", ":", keyword)));
        }

        Page<Coin> coinPage = coinService.coins(specification);
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Action success!")
                .addData(coinPage.getContent().stream().map(x -> new coinPage(x)).collect(Collectors.toList()))
                .build(),
                HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> store(@RequestBody Coin coin) {


        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.CREATED.value())
                .setMessage("Action Success")
                .addData(new CoinDTO(coinService.create(coin)))
                .build(),
                HttpStatus.CREATED);
    }
}
