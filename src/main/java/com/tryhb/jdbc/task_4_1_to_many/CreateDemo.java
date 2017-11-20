package com.tryhb.jdbc.task_4_1_to_many;

import com.tryhb.jdbc.task_3_1_to_1_bidirectional.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();

            Instructor instructor = new Instructor("John", "Du", "doe@john.com");
            InstructorDetail instructorDetail = new InstructorDetail("channel url", "sport");
            instructor.setInstructorDetail(instructorDetail);

            session.save(instructor);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }



}
