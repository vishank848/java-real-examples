package org.example.cloning.deep;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GPA implements Cloneable {
    int firstYear;
    int secondYear;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
