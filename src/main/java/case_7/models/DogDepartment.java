package case_7.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name="dog_department")
public class DogDepartment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    @Column(name="case_dep")
    private String departmentCase;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dogDepartment_id",referencedColumnName = "id")
    private DepartmentInfo departmentInfo;

    @OneToMany(mappedBy = "dogDep",cascade = CascadeType.ALL)
    private Set<Dog> dogs;

    public Set<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Dog> dogs) {
        this.dogs = dogs;
    }



    public DepartmentInfo getDepartmentInfo() {
        return departmentInfo;
    }

    public void setDepartmentInfo(DepartmentInfo departmentInfo) {
        this.departmentInfo = departmentInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartmentCase() {
        return departmentCase;
    }

    public void setDepartmentCase(String departmentCase) {
        this.departmentCase = departmentCase;
    }

    @Override
    public String toString() {
        return "DogDepartment{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", departmentCase='" + departmentCase + '\'' +
                '}';
    }
}
