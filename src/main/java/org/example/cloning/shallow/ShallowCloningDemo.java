package org.example.cloning.shallow;

public class ShallowCloningDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        GPA g = new GPA(7, 8);
        Student s = new Student("Justin", g);//original object

        Student copy = (Student) s.clone();//shallow copy

        System.out.println(STR."Original Object's GPA: \{s.getGpa().getFirstYear()} \{s.getGpa().getSecondYear()}");
        System.out.println(STR."Cloned Object's GPA: \{copy.getGpa().getFirstYear()} \{copy.getGpa().getSecondYear()}");

        copy.getGpa().setFirstYear(10);//Changing the GPA field of the shallow copy

        System.out.println("\nAfter changing the shallow copy");
        System.out.println(STR."Original Object's GPA: \{s.getGpa().getFirstYear()} \{s.getGpa().getSecondYear()}");
        System.out.println(STR."Cloned Object's GPA: \{copy.getGpa().getFirstYear()} \{copy.getGpa().getSecondYear()}");

    }
}
