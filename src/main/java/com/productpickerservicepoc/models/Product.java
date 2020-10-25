package com.productpickerservicepoc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private Integer product_id;

    @Column
    private String name;

    @Column
    private String manufacturer_name;

    @Column
    private String category;

    @Column
    private String item_number;

    @Column
    private String description;

    @Column
    private String image_url;

    @Column
    private String created_at;

    public Product(Integer product_id, String name, String manufacturer_name, String category, String item_number, String description, String image_url, String created_at) {
        this.product_id = product_id;
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

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem_number() {
        return item_number;
    }

    public void setItem_number(String item_number) {
        this.item_number = item_number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", manufacturer_name='" + manufacturer_name + '\'' +
                ", category='" + category + '\'' +
                ", item_number='" + item_number + '\'' +
                ", description='" + description + '\'' +
                ", image_url='" + image_url + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
