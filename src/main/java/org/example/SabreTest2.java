package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.java15.Employee;

public class SabreTest2 {

    // employee : id, name, salary, department
    //print to display top N employee based on salary asd order
    // name as key and salary as value

    public List<Employee> getTopNEmployees(List<Employee> employees, int n) {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(n).collect(Collectors.toList());
    }

    public Map<String, Integer> convertListToMap(List<Employee> employees) {
        return employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
    }


}
