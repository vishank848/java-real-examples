package org.example.real.life.problem;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    //https://opensource.com/article/20/9/problem-solving-java
    public static void main(String[] args) {
        var packs = new Bought[]{
                new Bought(new Pack("Rice", "Best Family", 10, 5650), 1),
                new Bought(new Pack("Spaghetti", "Best Family", 1, 327), 10),
                new Bought(new Pack("Sardines", "Fresh Caught", 3, 2727), 3),
                new Bought(new Pack("Chickpeas", "Southern Style", 2, 2600), 5),
                new Bought(new Pack("Lentils", "Southern Style", 2, 2378), 5),
                new Bought(new Pack("Vegetable oil", "Crafco", 12, 10020), 1),
                new Bought(new Pack("UHT milk", "Atlantic", 6, 4560), 2),
                new Bought(new Pack("Flour", "Neighbor Mills", 10, 5200), 1),
                new Bought(new Pack("Tomato sauce", "Best Family", 1, 190), 10),
                new Bought(new Pack("Sugar", "Good Price", 1, 565), 10),
                new Bought(new Pack("Tea", "Superior", 5, 2720), 2),
                new Bought(new Pack("Coffee", "Colombia Select", 2, 4180), 5),
                new Bought(new Pack("Tofu", "Gourmet Choice", 1, 1580), 10),
                new Bought(new Pack("Bleach", "Blanchite", 5, 3550), 2),
                new Bought(new Pack("Soap", "Sunny Day", 6, 1794), 2)
        };

        var units = Stream.of(packs)
                .flatMap(bought -> {
                    return bought.unpack().stream();
                })
                .collect(Collectors.toList());

        var valueIdeal = 5000;
        var valueMax = Math.round(valueIdeal * 1.1);
        var rnd = new Random();
        var hamperNumber = 0;                         // [1]

        while (!units.isEmpty()) {                    // [2]
            hamperNumber++;
            var hamper = new ArrayList<Unit>();
            var value = 0;                            // [2.1]
            for (boolean canAdd = true; canAdd; ) {   // [2.2]
                var u = rnd.nextInt(units.size());            // [2.2.1]
                canAdd = false;                               // [2.2.2]
                for (int o = 0; o < units.size(); o++) {      // [2.2.3]
                    var uo = (u + o) % units.size();
                    var unit = units.get(uo);                      // [2.2.3.1]
                    if (units.size() < 3 ||
                            !hamper.contains(unit) &&
                                    (value + unit.getPrice()) < valueMax) { // [2.2.3.2]
                        hamper.add(unit);
                        value += unit.getPrice();
                        units.remove(uo);                           // [2.2.3.3]
                        canAdd = !units.isEmpty();
                        break;                                      // [2.2.3.4]
                    }
                }
            }                                                // [2.2.4]
            System.out.println();
            System.out.printf("Hamper %d value %d:\n", hamperNumber, value);
            hamper.forEach(unit -> {
                System.out.printf("%-25s%-25s%7d\n", unit.getItem(), unit.getBrand(), unit.getPrice());
            });                                                      // [2.3]
            System.out.printf("Remaining units %d\n", units.size());  // [2.4]
        }
    }
}
