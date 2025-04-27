package org.lesson_30_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.NoSuchElementException;

public class StudentDao implements GenericDao<Student, Long> {

    private SessionFactory sessionFactory;

    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();

        }
    }


    @Override
    public Student findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                            "SELECT s FROM Student s LEFT JOIN FETCH s.homeworks WHERE s.id = :id", Student.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }


    @Override
    public Student findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student s WHERE s.email = :email", Student.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    @Override
    public List<Student> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }

    @Override
    public Student update(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(student);
            transaction.commit();
        }
        return student;
    }



    @Override
    public boolean deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.remove(student);
                transaction.commit();
                return true;
            }

        }
        return false;
    }

    public Homework findHomeworkById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Homework.class, id);
        }
    }
}
