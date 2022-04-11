package case_7;



import case_7.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class HibernateUtilRelated {
    private static SessionFactory sessionFactory;
    static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            sessionFactory=initSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory initSessionFactory() {
        Configuration configuration = new Configuration();
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(
                    "src/main/resources/config_case_7.properties"
            ));
            configuration.setProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        configuration.addAnnotatedClass(Dog.class);
        configuration.addAnnotatedClass(DogDepartment.class);
        configuration.addAnnotatedClass(DepartmentInfo.class);
        configuration.addAnnotatedClass(DogShow.class);
        configuration.addAnnotatedClass(DogShowParticipant.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate serviceRegistry created ");
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
