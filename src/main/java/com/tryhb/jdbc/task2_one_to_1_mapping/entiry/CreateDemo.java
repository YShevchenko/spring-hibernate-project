package com.tryhb.jdbc.task2_one_to_1_mapping.entiry;

import com.tryhb.jdbc.task1_map_table.entity.Student;
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

            Instructor instructor = new Instructor("John", "Doe", "doe@john.com");
            InstructorDetail instructorDetail = new InstructorDetail("channel url", "sport");
            instructor.setInstructorDetailId(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }



}
