package case_6;

import org.hibernate.Session;

import java.io.Serializable;

public class HibernateMain {
    public static void main(String[] args) {

        //CreateRow();
        //ReadId(6L);
        //UpdateRow(6L);
       // DeleteId(5L);


    }
    //Delete
    private static void DeleteId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Dog dog = new Dog();
        Dog_department dog_department = new Dog_department();

        session.beginTransaction();
        dog = session.load(Dog.class,id);
        session.delete(dog);
        dog_department = session.load(Dog_department.class,id);
        session.delete(dog_department);
        session.getTransaction().commit();
        session.close();
    }

    //Update
    private static void UpdateRow(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Dog dog = new Dog();
        Dog_department dog_department = new Dog_department();

        session.beginTransaction();
        dog = session.get(Dog.class,id);
        dog.setName("Chunky");
        session.update(dog);
        dog_department = session.get(Dog_department.class,id);
        dog_department.setAvailable(Boolean.FALSE);
        session.update(dog_department);
        session.getTransaction().commit();
        session.close();
    }

    //Create
    private static void CreateRow() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Dog dog = new Dog();
        Dog_department dog_department = new Dog_department();

        dog.setName("Vira");
        dog.setAge(2);
        dog.setBreed("Unknown");
        dog.setThoroughbred(Boolean.FALSE);

        dog_department.setName("Loc");
        dog_department.setDepartment_case("Selling");
        dog_department.setAvailable(Boolean.TRUE);

        session.beginTransaction();
        Serializable dogId = session.save(dog);
        Serializable dog_departmentId = session.save(dog_department);
        session.getTransaction().commit();
        session.close();
    }

    //Read
    private static void ReadId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
       Dog readDog = session.find(Dog.class, id);
       Dog_department readDog_department = session.find(Dog_department.class,id);
       System.out.println(readDog);
       System.out.println(readDog_department);
       session.getTransaction().commit();
       session.close();
    }




}
