package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Настройте связь между вашим приложением и базой данных
 * MySQL с использованием Hibernate. Создайте несколько
 * объектов Person и сохраните их в базу данных.
 */

public class Main {
    public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration();
            configuration.configure( "hibernate.cfg.xml" );
            configuration.addAnnotatedClass( Person.class );
            try(SessionFactory sessionFactory = configuration
                    .buildSessionFactory()) {

                Session session = sessionFactory.getCurrentSession();
                session.beginTransaction();

                for (int i = 0; i < 5; i++) {
                    Person person = Person.create();
                    session.persist( person );
                    System.out.println("Object person save successfully");
                }

                session.getTransaction().commit();

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
