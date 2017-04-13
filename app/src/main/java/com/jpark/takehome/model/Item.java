package com.jpark.takehome.model;

/**
 * Created by JH on 2017-04-13.
 */

public class Item {
    private String itemName;
    public Item(String name){
        this.itemName = name;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
