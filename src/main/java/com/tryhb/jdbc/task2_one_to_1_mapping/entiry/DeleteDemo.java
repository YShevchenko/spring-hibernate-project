package com.tryhb.jdbc.task2_one_to_1_mapping.entiry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {


            session.beginTransaction();

            //Instructors
            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println(instructor.toString());

            if (instructor != null) {

                System.out.println(instructor);
            }

            session.delete(instructor);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
