package com.springboot.beta.request;

import javax.validation.constraints.NotNull;

public class BookRequest {
    @NotNull(message = "Thiếu giá vé")
    private double price;

    public BookRequest() {
    }

    public BookRequest(int scheduleId, int seatId, double price, int seatStatus) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
