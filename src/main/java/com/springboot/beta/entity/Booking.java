package com.springboot.beta.entity;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "price")
    private double price;

    public Booking() {
    }

    public Booking(int userId, double price) {
        this.userId = userId;
        this.price = price;
   
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
