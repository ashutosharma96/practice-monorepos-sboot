package org.example;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        Subjects subs1=new Subjects();
        subs1.setId(1);
        subs1.setEnglish(10);
        subs1.setHindi(70);
        subs1.setMaths(80);
        subs1.setScience(50);

        Subjects subs2=new Subjects();
        subs2.setId(2);
        subs2.setEnglish(100);
        subs2.setHindi(10);
        subs2.setMaths(80);
        subs2.setScience(50);

        Subjects subs3=new Subjects();
        subs3.setId(3);
        subs3.setEnglish(75);
        subs3.setHindi(80);
        subs3.setMaths(90);
        subs3.setScience(100);

        Student s1= new Student();
        s1.setRollno(1906969);
        s1.setAge(14);
        s1.setName("Cham-pulao");

        Student s2= new Student();
        s2.setRollno(1906467);
        s2.setAge(22);
        s2.setName("Ashu-lao");

        Student s3= new Student();
        s3.setRollno(1904133);
        s3.setAge(24);
        s3.setName("Cutu-lao");


        s1.setSubs(Arrays.asList(subs1,subs2));
        s2.setSubs(Arrays.asList(subs2,subs3));
        s3.setSubs(Arrays.asList(subs3,subs1));

        subs1.setStuds(Arrays.asList(s1,s3));
        subs2.setStuds(Arrays.asList(s1,s2));
        subs3.setStuds(Arrays.asList(s2,s3));



        SessionFactory sf= new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .addAnnotatedClass(org.example.Subjects.class)
                .configure()
                .buildSessionFactory();



        Session session=sf.openSession();
        Transaction tr= session.beginTransaction();


        session.persist(subs1);
        session.persist(subs2);
        session.persist(subs3);
        session.persist(s1);
        session.persist(s2);
        session.persist(s3);

        tr.commit();
        session.close();
        sf.close();



    }
}