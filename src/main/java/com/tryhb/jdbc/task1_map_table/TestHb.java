package com.tryhb.jdbc.task1_map_table;

import com.tryhb.jdbc.task1_map_table.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHb {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Student student = new Student();
            student.setEmail("mail@mail.com");
            student.setFirstName("John");
            student.setLastName("Doe");

            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student student2 = session.get(Student.class, 1);
            student2.setLastName("Bobo");
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.delete(student2);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
