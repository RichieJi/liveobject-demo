package com.fr.third.demo1;

import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;

import java.util.ArrayList;
import java.util.List;

@REntity
public class WorkSheet {

    @RId
    private String name;

    private List<Block> blocks;

    public WorkSheet() {
        super();
    }

    public WorkSheet(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBlock(Block block) {
        getBlocks().add(block);
    }

    public List<Block> getBlocks() {
        if (blocks == null) {
            blocks = new ArrayList<Block>();
        }
        return blocks;
    }

}
