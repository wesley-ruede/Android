package com.wesleyruede.todoapp.model;

public class Item {
    private int id;
    private String itemName;
    private String itemColor;
    private int itemAmount;
    private int itemSize;
    private String dateCreated;

    public Item(int id, String itemName, String itemColor, int itemAmount, int itemSize, String dateCreated) {
        this.id = id;
        this.itemName = itemName;
        this.itemColor = itemColor;
        this.itemAmount = itemAmount;
        this.itemSize = itemSize;
        this.dateCreated = dateCreated;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemQuantity) {
        this.itemAmount = itemQuantity;
    }

    public int getItemSize() {
        return itemSize;
    }

    public void setItemSize(int itemSize) {
        this.itemSize = itemSize;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
