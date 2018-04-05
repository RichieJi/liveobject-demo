package com.fr.third.demo1;

import org.redisson.Redisson;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class DemoWrite {

    public static void main(String... args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(2);
        RedissonClient client = Redisson.create(config);
        RLiveObjectService liveObjectService = client.getLiveObjectService();

        WorkSheet workSheet = new WorkSheet("wb1");


        Block block2 = new Block("block2");

        addElementToBlock(liveObjectService, block2);

        workSheet.getBlocks().add(block2);


        workSheet = liveObjectService.merge(workSheet);


        WorkSheet ws = liveObjectService.get(WorkSheet.class, "wb1");

        System.out.println(ws);

    }

    private static void addElementToBlock(RLiveObjectService liveObjectService, Block block) {
        for (int i = 0; i < 5; i ++) {
            for (int j = 0; j < 3; j++) {
                CellElement cellElement = new CellElement();
                cellElement.setValue("col:" + j + ";row:" + i);
                block.addCellElement(liveObjectService, cellElement, i, j);
            }
        }
    }
}
