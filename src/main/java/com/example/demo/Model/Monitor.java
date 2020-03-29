package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "Monitor")
@PrimaryKeyJoinColumn(name="item_id")
public class Monitor extends Hardware {

    public Monitor(){

    }

    public Monitor(String name, int price, String product_kind,
                   String description, int brightness, String colour,
                   double size){
        super(name, price, product_kind, description);
        this.setBrightness(brightness);
        this.setColour(colour);
        this.setSize(size);
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    private double size;

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    private int brightness;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    private String colour;
}
