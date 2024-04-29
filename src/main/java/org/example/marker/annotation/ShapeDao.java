package org.example.marker.annotation;

public class ShapeDao {

    public boolean delete(Object object) {
        if (!(object instanceof Shape)) {
            return false;
        }

        // delete implementation details

        return true;
    }
}
