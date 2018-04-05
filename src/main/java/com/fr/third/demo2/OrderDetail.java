package com.fr.third.demo2;

import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;
import org.redisson.liveobject.resolver.LongGenerator;

import java.math.BigDecimal;

@REntity
public class OrderDetail {
    @RId(generator = LongGenerator.class)
    private Long id;
    private Order order;
    private Product product;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal discount;
    protected OrderDetail() {
    }
    public OrderDetail(Order order, Product product) {
        super();
        this.order = order;
        this.product = product;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getDiscount() {
        return discount;
    }
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    public Long getId() {
        return id;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Product getProduct() {
        return product;
    }
}