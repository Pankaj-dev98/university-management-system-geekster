package org.orgless.universityeventmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import utils.Branch;

@Entity
@Table(name = "student")
@Validated
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    @Min(value = 18, message = "Student must be at least 18yr old")
    @Max(value = 25, message = "Student must be at most 25yr old")
    private int age;

    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    private Branch department;

    public Student() {}

    public Student(String firstName, String lastName, int age, Branch department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length() == 0)
            return;

        this.firstName = firstName.substring(0, 1).toUpperCase() + (firstName.length() < 2? "": firstName.substring(1));
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Branch getDepartment() {
        return department;
    }

    public void setDepartment(Branch department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("Id = %2d Name = %16s Age = %2d Department = %s", id, firstName + " " + lastName, age, department.name());
    }
}
