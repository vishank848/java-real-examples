package org.example.marker;

public class TestMarker {
    public static void main(String[] args) {
        ShapeDao shapeDao = new ShapeDao();
        System.out.println(shapeDao.delete(""));
        System.out.println(shapeDao.delete(new Entity()));
        System.out.println("Done");
    }
}
