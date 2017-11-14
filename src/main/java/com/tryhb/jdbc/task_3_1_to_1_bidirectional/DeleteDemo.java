package com.tryhb.jdbc.task_3_1_to_1_bidirectional;

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
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 5);
            System.out.println("Instructor" + instructorDetail.toString());
            System.out.println("Related instructor:" + instructorDetail.getInstructor().toString());

            if (instructorDetail != null) {
                session.delete(instructorDetail);
            }



            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}
