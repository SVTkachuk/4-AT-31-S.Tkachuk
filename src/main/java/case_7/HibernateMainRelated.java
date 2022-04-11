package case_7;



import case_7.models.DepartmentInfo;
import case_7.models.Dog;
import case_7.models.DogDepartment;
import case_7.models.DogShow;
import org.hibernate.Session;

import java.io.Serializable;

public class HibernateMainRelated {
    public static void main(String[] args) {
        // CreateDogDepartment();
        //ReadDogDepartmentId(7L);
        //UpdateDogDepartment(7L);
        //DeleteDogDepartment(35L);

    }

    private static void DeleteDogDepartment(long id) {
        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        DogDepartment dogDepartment = session.get(DogDepartment.class,id);
        session.delete(dogDepartment);
        session.getTransaction().commit();
        session.close();
    }

    private static void UpdateDogDepartment(long id) {
        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        DogDepartment dogDepartment = session.get(DogDepartment.class,id);
        dogDepartment.setDepartmentCase("Selling");
        DogDepartment readDepartmentInfo = session.find(DogDepartment.class,id);
        DepartmentInfo departmentInfo = readDepartmentInfo.getDepartmentInfo();
        departmentInfo.setAvailable(Boolean.FALSE);
        departmentInfo.setName("SD");
        dogDepartment.setDepartmentInfo(departmentInfo);
        session.getTransaction().commit();
        session.close();

    }

    private static void ReadDogDepartmentId(Long id) {
        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        DogDepartment readDepartmentInfo = session.find(DogDepartment.class,id);
        DepartmentInfo departmentInfo = readDepartmentInfo.getDepartmentInfo();
        session.getTransaction().commit();
        session.close();
        System.out.println(readDepartmentInfo);
        System.out.println(departmentInfo);
    }

    private static void CreateDogDepartment() {
        Session session = HibernateUtilRelated.getSessionFactory().openSession();
        session.beginTransaction();
        DogDepartment dogDepartment = new DogDepartment();
        dogDepartment.setCity("SF");
        dogDepartment.setDepartmentCase("Selling");

        DepartmentInfo departmentInfo = new DepartmentInfo();
        departmentInfo.setAvailable(Boolean.TRUE);
        departmentInfo.setName("SFD");
        dogDepartment.setDepartmentInfo(departmentInfo);

        session.save(dogDepartment);
        session.getTransaction().commit();
        session.close();

    }
}
