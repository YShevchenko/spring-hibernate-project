package com.tryhb.jdbc.task_4_1_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourcesDemo {


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
            Course course = new Course();
            course.setTitle("Air Guitar");
            Course course1 = new Course();
            course1.setTitle("Another cource");
            instructor.addCource(course);
            instructor.addCource(course1);

            session.save(course);
            session.save(course1);


            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }



}
