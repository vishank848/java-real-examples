package org.example.java15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public final class Employee extends Person {
    private int id;
    private String name;
    private int salary;
    private String department;
}
