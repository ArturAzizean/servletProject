package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import withDB.modelsDB.UserDB;


public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/exampledb");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "123");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.addResource("User.hbm.xml");
        configuration.setProperty("hibernate.show_sql", "true");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        UserDB user = session.createQuery("from UserDB user where user.id = 1", UserDB.class).getSingleResult();

        session.beginTransaction();
        session.save(new UserDB("Mini", "Max", 29));
        session.getTransaction().commit();

        System.out.println(user);

    }
}
