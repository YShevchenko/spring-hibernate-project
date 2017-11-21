package com.tryhb.jdbc.task_4_1_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class CreateInstructorDemo {


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

            Instructor instructor = new Instructor("John", "Du", "doe@john.com");

            InstructorDetail instructorDetail = new InstructorDetail("channel1","playing");
            instructor.setInstructorDetail(instructorDetail);
            Course course = new Course();
            course.setTitle("HB");
            course.setInstructor(instructor);
            instructor.addCource(course);

            session.save(instructor);

            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }



}
