package org.example.real.life.problem;

import java.util.Collections;
import java.util.List;

public class Pack {
    private Unit unit;
    private int count;

    public Pack(String item, String brand, int unitCount, int packPrice) {
        this.unit = new Unit(item, brand, unitCount > 0 ? packPrice / unitCount : 0);
        this.count = unitCount;
    }

    public String getItem() {
        return unit.getItem();
    }

    public String getBrand() {
        return unit.getBrand();
    }

    public int getUnitPrice() {
        return unit.getPrice();
    }

    public int getUnitCount() {
        return count;
    }

    public List<Unit> unpack() {
        return Collections.nCopies(count, unit);
    }


    @Override
    public String toString() {
        return String.format("item: %s brand: %s unitCount: %d unitPrice: %d", 
                unit.getItem(), unit.getBrand(), count, unit.getPrice());
    }
}
