package org.example.real.life.problem;

public class Unit {
    private String item, brand;
    private int price;

    public Unit(String item, String brand, int price) {
        this.item = item;
        this.brand = brand;
        this.price = price;
    }
    public String getItem() { return this.item; }
    public String getBrand() { return this.brand; }
    public int getPrice() { return this.price; }

    @Override
    public String toString() { return String.format("item: %s brand: %s price: %d",item,brand,price); }
}
