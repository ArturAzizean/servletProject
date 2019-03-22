package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/exampledb");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "123");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
    }
}
