package org.example.marker.annotation;


public class TestMarker {
    public static void main(String[] args) {
        ShapeDao shapeDao = new ShapeDao();
        System.out.println(shapeDao.delete(""));
        System.out.println(shapeDao.delete(new Rectangle()));
        System.out.println("Done");
    }
}
