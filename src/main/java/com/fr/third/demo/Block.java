package com.fr.third.demo;

import org.redisson.api.RLiveObjectService;

import java.util.HashMap;
import java.util.Map;

public class Block {

    private String name;

    private Map<Integer, Row> rows;

    public Block() {
        super();
    }

    public Block(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Map<Integer, Row> getRows() {
        if (rows == null) {
            rows = new HashMap<Integer, Row>();
        }
        return rows;
    }

    public void addCellElement(RLiveObjectService liveObjectService, CellElement cell, int rowIndex, int columnIndex) {
        Row row = getRows().get(rowIndex);
        if (row == null) {
            row = new Row();
            getRows().put(rowIndex, row);
        }
        row.addElement(cell, columnIndex);
    }

    public CellElement getCellElement(int rowIndex, int columnIndex) {
        Row row = getRows().get(rowIndex);
        if (row == null) {
            return null;
        }
        return row.getCellElement(columnIndex);
    }
}
