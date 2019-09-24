package com.example.asm1.dto;

import com.example.asm1.entity.Market;
import com.example.asm1.util.DateTimeUtil;
import com.example.asm1.util.ObjectUtil;

public class MarketDTO {
    private String id;
    private String name;
    private String description;

    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String status;

    public MarketDTO(){}

    public MarketDTO(Market market) {
        ObjectUtil.cloneObject(this, market);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
