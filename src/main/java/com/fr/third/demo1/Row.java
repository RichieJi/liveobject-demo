package com.fr.third.demo1;


import java.util.HashMap;
import java.util.Map;

public class Row {

    private Map<Integer, CellElement> elementData;

    public Row() {
        super();
    }


    public void addElement(CellElement cell, int index) {
        getElementData().put(index, cell);
    }

    private Map<Integer, CellElement> getElementData() {
        if (elementData == null) {
            elementData = new HashMap<Integer, CellElement>();
        }
        return elementData;
    }

    public CellElement getCellElement(int index) {
        return getElementData().get(index);
    }
}
