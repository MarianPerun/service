package com.example.demo.Model;

import javax.persistence.*;

@Entity(name="Product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    public Product(){
        super();
    }

    public Product(String name, int price, String product_kind){
        this.setName(name);
        this.setPrice(price);
        this.setProduct_kind(product_kind);
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer item_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    public String getProduct_kind() {
        return product_kind;
    }

    public void setProduct_kind(String type) {
        this.product_kind = type;
    }

    private String product_kind;

}
