package com.productservicepoc.dto;

public class ProductRequest {
    private Integer id;
    private String name;
    private String manufacturerName;
    private String category;
    private String itemNumber;
    private String description;
    private String imageUrl;
    private String createdAt;

    public ProductRequest(Integer id, String name, String manufacturerName, String category, String itemNumber, String description, String imageUrl, String createdAt) {
        this.id = id;
        this.name = name;
        this.manufacturerName = manufacturerName;
        this.category = category;
        this.itemNumber = itemNumber;
        this.description = description;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", category='" + category + '\'' +
                ", itemNumber='" + itemNumber + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
