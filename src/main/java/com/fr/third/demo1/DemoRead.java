package com.fr.third.demo1;

import org.redisson.Redisson;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class DemoRead {
    public static void main(String... args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(2);
        RedissonClient client = Redisson.create(config);
        RLiveObjectService liveObjectService = client.getLiveObjectService();
        WorkSheet ws = liveObjectService.get(WorkSheet.class, "wb1");
        System.out.println(ws.getBlocks().get(0).getCellElement(2,2).getValue());
    }
}
