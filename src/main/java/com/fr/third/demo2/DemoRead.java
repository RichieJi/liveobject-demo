package com.fr.third.demo2;

import org.redisson.Redisson;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class DemoRead {
    public static void main(String... args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(8);
        RedissonClient client = Redisson.create(config);
        RLiveObjectService liveObjectService = client.getLiveObjectService();
        Customer customer = liveObjectService.get(Customer.class, "999");

        // 输出"北京市朝阳区"
        System.out.println(customer.getOrders().get(0).getShipAddress());
    }
}

