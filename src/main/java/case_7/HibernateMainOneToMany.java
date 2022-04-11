package case_7;

import case_7.models.DepartmentInfo;
import case_7.models.Dog;
import case_7.models.DogDepartment;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class HibernateMainOneToMany {
    public static void main(String[] args) {

        //CreateDogs();
        //ReadDepartmentDogs(51L);
        //UpdateDepartmentDogs(51L);
        //DeleteDepartmentDogs(52L);
    }

    private static void DeleteDepartmentDogs(long id) {
        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        DogDepartment dogDepartment = session.get(DogDepartment.class,id);
        session.delete(dogDepartment);
        session.getTransaction().commit();
        session.close();
    }

    private static void UpdateDepartmentDogs(long id) {
        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        DogDepartment dogDepartment = session.find(DogDepartment.class,id);
        Set<Dog> dogs = dogDepartment.getDogs();

        Dog newDog = new Dog();
        newDog.setDogDep(dogDepartment);
        newDog.setName("Bender");
        newDog.setBreed("Uknown");
        newDog.setThoroughbred(Boolean.FALSE);
        newDog.setAge(8);
        dogs.add(newDog);
        dogDepartment.setDogs(dogs);

        session.getTransaction().commit();
        session.close();

    }

    private static void ReadDepartmentDogs(Long id) {
        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        DogDepartment dogDepartment = session.find(DogDepartment.class,id);
        Set<Dog> dog = dogDepartment.getDogs();
        System.out.println(dogDepartment);
        System.out.println(dog);
        session.getTransaction().commit();
        session.close();

    }

    private static void CreateDogs() {


        DogDepartment dogDepartment = new DogDepartment();
        dogDepartment.setCity("SF");
        dogDepartment.setDepartmentCase("Selling");

        DepartmentInfo departmentInfo = new DepartmentInfo();
        departmentInfo.setAvailable(Boolean.TRUE);
        departmentInfo.setName("SFD");
        dogDepartment.setDepartmentInfo(departmentInfo);

        Set<Dog> dogs = new HashSet<Dog>();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        dog1.setDogDep(dogDepartment);
        dog1.setName("Lia");
        dog1.setBreed("Afador");
        dog1.setThoroughbred(Boolean.FALSE);
        dog1.setAge(3);

        dog2.setDogDep(dogDepartment);
        dog2.setName("Ricko");
        dog2.setBreed("Auggie");
        dog2.setThoroughbred(Boolean.TRUE);
        dog2.setAge(6);
        dogs.add(dog1);
        dogs.add(dog2);

        dogDepartment.setDogs(dogs);

        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(dogDepartment);
        session.getTransaction().commit();
        session.close();
    }
}
