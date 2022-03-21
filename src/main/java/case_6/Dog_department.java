package case_6;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dog_department")
public class Dog_department implements Serializable {
    /*
     CREATE TABLE `new_schema`.`dog_department` (
    `id_dog_department` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `department_case` VARCHAR(45) NULL,
    `available` TINYINT NULL DEFAULT 1,
    PRIMARY KEY (`id_dog_department`),
    UNIQUE INDEX `id_dog_department_UNIQUE` (`id_dog_department` ASC) VISIBLE);
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_dog_department;
    private String name;
    private String department_case;
    private Boolean available;

    public Long getId_dog_department() {
        return id_dog_department;
    }

    public void setId_dog_department(Long id_dog_department) {
        this.id_dog_department = id_dog_department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment_case() {
        return department_case;
    }

    public void setDepartment_case(String department_case) {
        this.department_case = department_case;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Dog_department{" +
                "id_dog_department=" + id_dog_department +
                ", name='" + name + '\'' +
                ", department_case='" + department_case + '\'' +
                ", available=" + available +
                '}';
    }
}
