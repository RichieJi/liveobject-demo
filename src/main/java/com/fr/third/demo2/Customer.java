package com.fr.third.demo2;

import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;
import org.redisson.liveobject.resolver.UUIDGenerator;

import java.util.List;

@REntity
public class Customer {
    @RId(generator = UUIDGenerator.class)
    private String id;
    private List<Order> orders;
    private String name;
    private String address;
    private String phone;
    protected Customer() {
    }
    public Customer(String id) {
        super();
        this.id = id;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public List<Order> getOrders() {
        return orders;
    }
    public String getId() {
        return id;
    }
}