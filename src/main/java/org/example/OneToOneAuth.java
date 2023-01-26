package org.example;

import org.example.domain_one_to_one_auth.Director;
import org.example.domain_one_to_one_auth.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneAuth {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).
        addAnnotatedClass(School.class);
        try(SessionFactory sessionFactory=configuration.buildSessionFactory();
            Session session=sessionFactory.openSession()){
            try{
                 School school=session.get(School.class,1);
                System.out.println(school.getSchoolName());
                System.out.println(school.getDirector().getDirectorName());
                System.out.println("-----");
//                Director director =new Director("Tapinos",56);
//                School school2=new School("42-Musor");
//                director.setScool(school2);
//                session.save(director);
//                System.out.println("-----");
//                School school3=session.get(School.class,3);
//                Director director3=session.get(Director.class,1);
//                director.setScool(school3);
            }catch(Exception e){

            }
        }
    }
}
