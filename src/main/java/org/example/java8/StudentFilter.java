package org.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Student s1 = new Student(1, "A", "1A");
        Student s2 = new Student(2, "B", "2A");
        Student s3 = new Student(3, "C", "1A");
        Student s4 = new Student(4, "D", "1A");
        Student s5 = new Student(5, "E", "3A");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);

        studentList
                .stream()
                .collect(Collectors.groupingBy(Student::getClassId))
                .values()
                .stream()
                .filter(students -> students.size() > 1)
                .findFirst()
                .orElse(new ArrayList<>())
                .forEach(System.out::println);
    }
}
