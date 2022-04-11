package case_7.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
@Entity(name="department_info")
public class DepartmentInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean available;


    @OneToOne(mappedBy = "departmentInfo")
   private  DogDepartment dogDepartment;

    public DogDepartment getDogDepartment() {
        return dogDepartment;
    }

    public void setDogDepartment(DogDepartment dogDepartment) {
        this.dogDepartment = dogDepartment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }



    @Override
    public String toString() {
        return "DepartmentInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", available=" + available +
                '}';
    }

}

