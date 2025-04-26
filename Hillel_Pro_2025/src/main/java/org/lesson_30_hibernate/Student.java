package org.lesson_30_hibernate;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter

@Entity
@Table(name="students")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column (name="last_name")
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Homework> homeworks = new HashSet<>();

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student() {

    }


    public void addHomework(final Homework homework) {
        homeworks.add(homework);
        homework.setStudent(this);
    }

    public void removeHomework(final Homework homework) {
        homeworks.remove(homework);
        homework.setStudent(null);


    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Student{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}
