package com.fr.third.demo2;

import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@REntity
public class Product {
    @RId
    private Long id;
    private String name;
    private Map<String, Integer> itemName2Amount;
    private BigDecimal price;
    private Integer unitsInStock;

    protected Product() {
    }

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public String getName() {
        return name;
    }

    public void addItem(String name, Integer amount) {
        getItemName2Amount().put(name, amount);
    }

    public Integer getItemAmount(String name) {
        return getItemName2Amount().get(name);
    }

    private Map<String, Integer> getItemName2Amount() {
        if (itemName2Amount == null) {
            itemName2Amount = new HashMap<String, Integer>();
        }
        return itemName2Amount;
    }
}

