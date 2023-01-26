package org.example.starters;

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
                session.beginTransaction();
//                School school=session.get(School.class,2);
//                System.out.println(school.getSchoolName());
//                System.out.println(school.getDirector().getDirectorName());
//                System.out.println("-----");
//                Director director =new Director("Tapinos",56);
//                School school2=new School("42-Musor");
//                director.setScool(school2);
//                session.save(director);
                System.out.println("-----");
                School school3=session.get(School.class,2);
                school3.setDirector(null);
                Director director3=session.get(Director.class,1);
                director3.setScool(null);
                director3.setScool(school3);
                session.getTransaction().commit();
            }catch(Exception e){
                session.getTransaction().rollback();
            }
        }
    }
}
