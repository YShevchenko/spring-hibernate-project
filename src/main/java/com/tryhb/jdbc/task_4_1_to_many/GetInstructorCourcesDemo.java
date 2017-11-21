package com.tryhb.jdbc.task_4_1_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetInstructorCourcesDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 5);
            List<Course> courses = instructor.getCourses();
            System.out.println(courses);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }



}
