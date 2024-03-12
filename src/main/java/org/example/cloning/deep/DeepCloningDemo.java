package org.example.cloning.deep;

public class DeepCloningDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        GPA g = new GPA(7, 8);
        Student s = new Student("Justin", g);//original object

        Student copy = (Student) s.clone();//deep copy

        System.out.println("Original Object's GPA: " + s.getGpa().getFirstYear() + " " + s.getGpa().getSecondYear());
        System.out.println("Cloned Object's GPA: " + copy.getGpa().getFirstYear() + " " + copy.getGpa().getSecondYear());

        copy.getGpa().setFirstYear(10);//Changing the GPA field of the deep copy

        System.out.println("\nAfter changing the Deep copy");
        System.out.println("Original Object's GPA: " + s.getGpa().getFirstYear() + " " + s.getGpa().getSecondYear());
        System.out.println("Cloned Object's GPA: " + copy.getGpa().getFirstYear() + " " + copy.getGpa().getSecondYear());

    }
}
