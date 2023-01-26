package org.example.starters;

import org.example.domain_one_to_one.Passport;
import org.example.domain_one_to_one.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOne {
    public static void main(String[]args){
        Configuration configuration=new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);
        try(SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session=sessionFactory.openSession()){
            session.beginTransaction();

            Person person=new Person("Tamara",24);
            Passport passport = new Passport(76312299);
            person.setPassport(passport);
            session.save(person);

//            Person person = session.get(Person.class,1);
//            System.out.println(person.getPassport());

//            Passport passport=session.get(Passport.class,1);
//            System.out.println(passport.getPerson());

//              Person person5=session.get(Person.class,1);
//              person.getPassport().setPassportNumber(324234);
//              session.remove(person);

              session.getTransaction().commit();
        }
    }
}
