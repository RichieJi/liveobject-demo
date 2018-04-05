package com.fr.third.demo2;

import org.redisson.Redisson;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.math.BigDecimal;
import java.util.Date;

public class DemoWrite {
    public static void main(String... args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(8);
        RedissonClient client = Redisson.create(config);
        RLiveObjectService liveObjectService = client.getLiveObjectService();
        Customer customer = new Customer("999");

        customer = liveObjectService.merge(customer);
        customer.setName("王宝强");
        customer.setPhone("+8617798657834");
        customer.setAddress("河南周口");
        Product product = new Product(1L, "食物");

        product = liveObjectService.merge(product);
        product.addItem("苹果", 10);
        product.addItem("香蕉", 12);
        product.setPrice(BigDecimal.valueOf(10));
        product.setUnitsInStock(12);
        Order order = new Order(customer);

        order = liveObjectService.merge(order);
        order.setDate(new Date());
        order.setShipAddress("北京市朝阳区");
        order.setShipName("朝阳群众");
        order.setShipPostalCode("1000000");
        OrderDetail od = new OrderDetail(order, product);

        od = liveObjectService.merge(od);
        od.setPrice(BigDecimal.valueOf(9));
        od.setQuantity(1);
        order.getOrderDetails().add(od);
        customer.getOrders().add(order);
    }
}
