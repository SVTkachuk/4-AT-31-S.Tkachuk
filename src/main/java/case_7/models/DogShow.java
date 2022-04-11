package case_7.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "dog_show")
public class DogShow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer year;

    @ManyToMany(mappedBy = "shows")
    Set<Dog> dogParticipant;

    public Set<Dog> getDogParticipant() {
        return dogParticipant;
    }

    public void setDogParticipant(Set<Dog> dogParticipant) {
        this.dogParticipant = dogParticipant;
    }

    @Override
    public String toString() {
        return "DogShow{" +
                "id=" + id +
                ", year=" + year +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
