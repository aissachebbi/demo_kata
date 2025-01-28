package org.example.kata.demo1.model;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item")
    private String item;

    @Column(name = "price")
    private double price;

    @Column(name = "available")
    private int available;

    @Column(name = "discount")
    private int discount;

    @Column(name = "category")
    private String category;

    @Column(name = "barcode")
    private String barcode;

    public Product(Long id, String item, double price, int available, int discount, String category, String barcode) {
        this.id = id;
        this.item = item;
        this.price = price;
        this.available = available;
        this.discount = discount;
        this.category = category;
        this.barcode = barcode;
    }

    public Product(Long id, String item, int available) {
        this.id = id;
        this.item = item;
        this.available = available;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailable() {
        return available;
    }

    public int getDiscount() {
        return discount;
    }

    public String getCategory() {
        return category;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

}