package case_7.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name="dog")
public class Dog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String breed;
    private Integer age;
    private String name;
    private Boolean thoroughbred;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "dog_show_participant",
            joinColumns = @JoinColumn(name = "id_dog"),
            inverseJoinColumns = @JoinColumn(name = "id_show")
    )
    Set<DogShow> shows;

    @ManyToOne()
    @JoinColumn(name="department_id",referencedColumnName = "dogDepartment_id"/*,nullable = false*/)
    private DogDepartment dogDep;

    public DogDepartment getDogDep() {
        return dogDep;
    }

    public void setDogDep(DogDepartment dogDep) {
        this.dogDep = dogDep;
    }

    public Set<DogShow> getShows() {
        return shows;
    }

    public void setShows(Set<DogShow> shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", thoroughbred=" + thoroughbred +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getThoroughbred() {
        return thoroughbred;
    }

    public void setThoroughbred(Boolean thoroughbred) {
        this.thoroughbred = thoroughbred;
    }

    /*public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
*/

}
