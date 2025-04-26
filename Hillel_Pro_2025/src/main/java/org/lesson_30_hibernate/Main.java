package org.lesson_30_hibernate;

import org.hibernate.Session;

import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        StudentDao studentDao = new StudentDao(HibernateUtil.getSessionFactory());

//        Student studentOleg = new Student("Oleg", "Petrov", "petrov@gmail.com");
//        Student studentAnna = new Student("Anna", "Popova", "anna@gmail.com");
//        Student studentVasyl = new Student("Vasyli", "Willis", "vasyl@gmail.com");

//        Homework homework1 = new Homework();
//        homework1.setDescription("Робота з базою даних: SELECT, LIMIT, SUM, GROUP BY");
//        homework1.setMark(100);
//        homework1.setDeadline(LocalDate.of(2025, 5, 6));
//
//        Homework homework2 = new Homework();
//        homework2.setDescription("Практика по JPA/Hibernate");
//        homework2.setMark(100);
//        homework2.setDeadline(LocalDate.of(2025, 5, 24));
//
//        Homework homework3 = new Homework();
//        homework3.setDescription("Робота з JDBC");
//        homework3.setMark(100);
//        homework3.setDeadline(LocalDate.of(2025, 6, 8));



//              addHomework:

//        studentOleg.addHomework(homework1);
//        studentDao.save(studentOleg);
//
//
//        studentAnna.addHomework(homework2);
//        studentDao.save(studentAnna);
//
//
//
//        studentVasyl.addHomework(homework3);
//        studentDao.save(studentVasyl);

//              removeHomework:

//        Student student1 = studentDao.findById(1L);
//        Homework homeworkById = studentDao.findHomeworkById(1L);
//        student1.removeHomework(homeworkById);
//        studentDao.update(student1);

//              findByEmail:

//        System.out.println(studentDao.findByEmail("anna@gmail.com"));

//              update:

//        Student studentF = studentDao.findById(2L);
//        studentF.setFirstName("Emma");
//        System.out.println(studentDao.update(studentF));

//              deleteById:

//        studentDao.deleteById(3L);
//        studentDao.findAll().forEach(System.out::println);

//            HibernateUtil.closeSessionFactory();























//                      ДОБАВЛЕННЯ ДОМАШКІ
        //Homework homework = new Homework();
//        homework.setDescription("Робота з базою даних: SELECT, LIMIT, SUM, GROUP BY");
//        homework.setDeadline(LocalDate.of(2025, 8, 11));
//        homework.setMark(0);
//        studentVasyl.addHomework(homework);
//        studentDao.save(studentVasyl);

//                   findById
        //System.out.println(studentDao.findById(6L));

//                    findByEmail
       // System.out.println(studentDao.findByEmail("vasyl@gmail.com"));

//                   findAll
        //studentDao.findAll().forEach(System.out::println);

//                       update
//        Student studentToUpdate = studentDao.findById(1L);
//        System.out.println(studentToUpdate);
//        studentToUpdate.setFirstName("Bob");
//        studentToUpdate.setEmail("bob@gmail.com");
//        studentDao.update(studentToUpdate);

//                         deleteById

//        studentDao.deleteById(4L);

//        Homework hToRemove = studentDao.findHomeworkById(1L);
//        System.out.println(hToRemove);
//        hToRemove.setStudent(studentVasyl);
//        System.out.println("Before remove: " + studentVasyl.getHomeworks());
//        System.out.println("Contains: " + studentVasyl.getHomeworks().contains(hToRemove));
//
//
//        Student studentWithHomework = hToRemove.getStudent();
//
//        System.out.println("Student: " + studentWithHomework);
//        System.out.println("Student's homeworks: " + studentWithHomework.getHomeworks());

//        studentWithHomework.removeHomework(hToRemove);
//        studentDao.update(studentWithHomework);


//        boolean b = studentVasyl.getHomeworks().contains(hToRemove);
//        System.out.println(b);
//        studentVasyl.removeHomework(hToRemove);
//        studentDao.update(studentVasyl);







    }
}
