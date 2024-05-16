package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Scanner;

import org.example.java15.Employee;
import org.junit.jupiter.api.Test;

class SabreTest2Test {
    SabreTest2 sabreTest2 = new SabreTest2();
    
    @Test
    void test_checkTopNEmployees() {
        List<Employee> employees = getEmployees();
        List<Employee> topNEmployees = sabreTest2.getTopNEmployees(employees, 4);
        topNEmployees.forEach(e -> System.out.println(e));
    }

    @Test
    void test_convertListToMap() {
        sabreTest2.convertListToMap(getEmployees()).forEach((k, v) -> System.out.println(k + " : " + v));
    }

    @Test
    void test_getNonRepeatingCharacter() {
        String str = sabreTest2.getNonRepeatingCharacter("aabbddcmmks");
        assertThat(str).isEqualTo("c");
    }

    private List<Employee> getEmployees() {
        return List.of(new Employee(1, "Ram", 1000, "D1"),
            new Employee(2, "Ram2", 6000, "D2"),
            new Employee(3, "Ram4", 2000, "D3"),
            new Employee(4, "Ram5", 8000, "D4"),
            new Employee(13, "Ram6", 2000, "D5"),
            new Employee(5, "Ram7", 9000, "D6"),
            new Employee(6, "Ram8", 900, "D7"),
            new Employee(7, "Ram9", 800, "D8"),
            new Employee(8, "Ram10", 14000, "D9"),
            new Employee(9, "Ram11", 12000, "D10"),
            new Employee(10, "Ram12", 18000, "D11"),
            new Employee(11, "Ram14", 15000, "D12"),
            new Employee(12, "Ram", 19000, "D13"));
    }

   

}