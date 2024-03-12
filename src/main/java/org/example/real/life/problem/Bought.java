package org.example.real.life.problem;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Bought {
    private Pack pack;
    private int count;

    public Bought(Pack pack, int packCount) {
        this.pack = pack;
        this.count = packCount;
    }

    public String getItem() {
        return pack.getItem();
    }

    public String getBrand() {
        return pack.getBrand();
    }

    public int getUnitPrice() {
        return pack.getUnitPrice();
    }

    public int getUnitCount() {
        return pack.getUnitCount() * count;
    }

    public List<Unit> unpack() {
        return Collections.nCopies(count, pack.unpack()).stream().flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("item: %s brand: %s bought: %d pack(s) totalUnitCount: %d unitPrice: %d",
                pack.getItem(), pack.getBrand(), count, pack.getUnitCount() * count, pack.getUnitPrice());
    }
}
