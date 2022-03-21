package case_6;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="dog")


public class Dog implements Serializable {

    /*
    CREATE TABLE `new_schema`.`dog` (
  `id_dog` INT NOT NULL AUTO_INCREMENT,
  `breed` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `Thoroughbred` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`id_dog`),
  UNIQUE INDEX `id_dog_UNIQUE` (`id_dog` ASC) VISIBLE);
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_dog;
    private String breed;
    private Integer age;
    private String name;
    private Boolean Thoroughbred;

    public Long getId_dog() {
        return id_dog;
    }

    public void setId_dog(Long id_dog) {
        this.id_dog = id_dog;
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
        return Thoroughbred;
    }

    public void setThoroughbred(Boolean thoroughbred) {
        Thoroughbred = thoroughbred;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id_dog=" + id_dog +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", Thoroughbred=" + Thoroughbred +
                '}';
    }
}
