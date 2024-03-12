package org.example.cloning.shallow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student implements Cloneable {
    private String name;
    private GPA gpa;

    //Standard clone() method to perform Shallow Cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
