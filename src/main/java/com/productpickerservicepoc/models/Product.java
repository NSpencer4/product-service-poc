package com.productpickerservicepoc.models;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    public Integer product_id;

    @Column
    public String name;

    @Column
    public String manufacturer_name;

    @Column
    public String category;

    @Column
    public String item_number;

    @Column
    public String description;

    @Column
    public String image_url;

    @Column
    public String created_at;

    public Product(final Integer productId, final String name,
                   final String manufacturer_name, final String category,
                   final String item_number, final String description,
                   final String image_url, final String created_at) {
        this.product_id = productId;
        this.name = name;
        this.manufacturer_name = manufacturer_name;
        this.category = category;
        this.item_number = item_number;
        this.description = description;
        this.image_url = image_url;
        this.created_at = created_at;
    }

    public Product() {
        //
    }

    public Integer getId() {
        return this.product_id;
    }

    public void setId(Integer productId) {
        this.product_id = productId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturerName() {
        return this.manufacturer_name;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturer_name = manufacturerName;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemNumber() {
        return this.item_number;
    }

    public void setItemNumber(String itemNumber) {
        this.item_number = itemNumber;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return this.image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }

    public String getCreateAt() {
        return this.created_at;
    }

    public void setCreatedAt(String createdAt) {
        this.created_at = createdAt;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("name", this.getName())
                .append("manufacturer_name", this.getManufacturerName())
                .append("category", this.getCategory())
                .append("item_number", this.getItemNumber())
                .append("description", this.getDescription())
                .append("image_url", this.getImageUrl())
                .append("created_at", this.getCreateAt())
                .toString();
    }
}
