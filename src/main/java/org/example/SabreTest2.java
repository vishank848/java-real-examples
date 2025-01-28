package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.example.java15.Employee;

public class SabreTest2 {

    // employee : id, name, salary, department
    //print to display top N employee based on salary asd order
    // name as key and salary as value

    public List<Employee> getTopNEmployees(List<Employee> employees, int n) {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(n).collect(Collectors.toList());
    }

    public Map<String, Integer> convertListToMap(List<Employee> employees) {
        return employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));
    }

    public String getNonRepeatingCharacter(String str) {
        str.chars().mapToObj(i -> Character.toLowerCase((char) i))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
        return Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }


}
