package org.lesson_30_hibernate;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Setter
    private LocalDate deadline;
    private int mark;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Homework() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return Objects.equals(getId(), homework.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Homework{" +
               "description='" + description + '\'' +
               ", deadline=" + deadline +
               ", mark=" + mark +
               '}';
    }
}
