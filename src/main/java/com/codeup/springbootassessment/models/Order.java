package com.codeup.springbootassessment.models;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false)
    private double total_price;

    public Order(){

    }

    public Order(String email, double total_price){
        this.email = email;
        this.total_price = total_price;
    }

    public Order(long id, String email, double total_price){
        this.id = id;
        this.email = email;
        this.total_price = total_price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}
