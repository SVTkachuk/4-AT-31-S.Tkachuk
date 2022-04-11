package case_7;

import case_7.models.Dog;
import case_7.models.DogShow;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class HibernateMainManyToMany {
    public static void main(String[] args) {
        //CreateDogShow();
        //ReadDogShow(6L);
        // UpdateDogShow(6L);
        //DeleteDogShow(7L);
    }

    private static void DeleteDogShow(long id) {
        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        Dog dog = session.find(Dog.class,id);
        session.delete(dog);
        session.getTransaction().commit();
        session.close();
    }

    private static void UpdateDogShow(long id) {
        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        Dog dog = session.find(Dog.class,id);
        Set<DogShow> shows = dog.getShows();
        DogShow show = new DogShow();

        show.setYear(2005);
        shows.add(show);
        dog.setShows(shows);

        session.save(dog);
        session.getTransaction().commit();
        session.close();
    }

    private static void ReadDogShow(long id) {
        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        Dog dog = session.find(Dog.class,id);
        Set<DogShow> shows = dog.getShows();
        System.out.println(dog);
        System.out.println(shows);
        session.getTransaction().commit();
        session.close();
    }

    private static void CreateDogShow() {
        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        Dog dog = new Dog();
        Set<DogShow> shows = new HashSet<DogShow>();
        DogShow show1 = new DogShow();
        DogShow show2 = new DogShow();

        dog.setName("Kora");
        dog.setBreed("Labrador");
        dog.setThoroughbred(Boolean.TRUE);
        dog.setAge(1);


        show1.setYear(1999);
        show2.setYear(1991);

        shows.add(show1);
        shows.add(show2);
        dog.setShows(shows);

        session.save(dog);
        session.getTransaction().commit();
        session.close();
    }
}
