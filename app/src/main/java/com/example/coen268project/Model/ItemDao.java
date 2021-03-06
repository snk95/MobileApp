package com.example.coen268project.Model;
import java.io.Serializable;

public class ItemDao implements Serializable {
    private String itemId;
    private String itemName;
    private String category;
    private String location;
    private String price;
    private String description;
    private String sellerId;
    private String buyerId;
    private String itemStatus;
    private String pictureName;
    private String billingStatus;

    public ItemDao(String itemId, String itemName, String category, String location, String price, String description, String sellerId, String buyerId, String itemStatus, String pictureName, String billingStatus) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.location = location;
        this.price = price;
        this.description = description;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.itemStatus = itemStatus;
        this.pictureName = pictureName;
        this.billingStatus = billingStatus;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }
}
