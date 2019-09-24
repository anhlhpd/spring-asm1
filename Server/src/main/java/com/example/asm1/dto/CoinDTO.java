package com.example.asm1.dto;

import com.example.asm1.entity.Coin;
import com.example.asm1.util.DateTimeUtil;
import com.example.asm1.util.ObjectUtil;

public class CoinDTO {
    private int id;
    private String name;
    private String baseAsset;
    private String quoteAsset;
    private String lastPrice;
    private String  volumn24h;

    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String status;

    public CoinDTO(){}

    public CoinDTO(Coin coin){
        ObjectUtil.cloneObject(this, coin);
        this.createdAt = DateTimeUtil.formatDateFromLong(coin.getCreatedAt());
        this.updatedAt = DateTimeUtil.formatDateFromLong(coin.getUpdatedAt());
        this.deletedAt = DateTimeUtil.formatDateFromLong(coin.getDeletedAt());
        this.status = coin.getStatus() == 1 ? "Active" : "Deactive";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getVolumn24h() {
        return volumn24h;
    }

    public void setVolumn24h(String volumn24h) {
        this.volumn24h = volumn24h;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
