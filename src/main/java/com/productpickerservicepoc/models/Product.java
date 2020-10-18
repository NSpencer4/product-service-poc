package com.productpickerservicepoc.models;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column
    public String name;

    @Column
    public String shortdescription;

    @Column
    public String imageurl;

    @Column
    public Integer quantity;

    @Column
    public Double price;

    public Product(final Long id, final String name,
                   final String shortdescription, final String imageurl,
                   final Integer quantity, final Double price) {
        this.id = id;
        this.name = name;
        this.shortdescription = shortdescription;
        this.imageurl = imageurl;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {
        //
    }

    public Long getId() {return this.id;}
    public void setId(Long id) { this.id = id;}

    public String getName() {return this.name;}
    public void setName(Long id) { this.name = name;}

    public String getShortDescription() {return this.shortdescription;}
    public void setShortDescription(String shortDescription) { this.shortdescription = shortDescription;}

    public String getImageUrl() {return this.imageurl;}
    public void setImageUrl(String imageUrl) { this.imageurl = imageUrl;}

    public Integer getQuantity() {return this.quantity;}
    public void setQuantity(Integer quantity) { this.quantity = quantity;}

    public Double getPrice() {return this.price;}
    public void setPrice(Double price) { this.price = price;}

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("id", this.getId())
                .append("name", this.getName())
                .append("shortdescription", this.getShortDescription())
                .append("imageurl", this.getImageUrl())
                .append("quantity", this.getQuantity())
                .append("price", this.getPrice())
                .toString();
    }
}
