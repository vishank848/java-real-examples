package org.example.marker;

public class ShapeDao {

    public boolean delete(Object object) {
        if (!(object instanceof Deletable)) {
            return false;
        }

        // delete implementation details

        return true;
    }
}
