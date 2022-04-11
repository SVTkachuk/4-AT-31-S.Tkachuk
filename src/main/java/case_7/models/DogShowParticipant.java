package case_7.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity(name = "dog_show_participant")
public class DogShowParticipant implements Serializable {

    @Id
    private Long id;
    @Column(name="id_dog")
    private Integer idShow;
    @Column(name="id_show")
    private Integer idDog;

    public Integer getIdShow() {
        return idShow;
    }

    public void setIdShow(Integer idShow) {
        this.idShow = idShow;
    }

    public Integer getIdDog() {
        return idDog;
    }

    public void setIdDog(Integer idDog) {
        this.idDog = idDog;
    }

    @Override
    public String toString() {
        return "DogShowParticipant{" +
                "idShow=" + idShow +
                ", idDog=" + idDog +
                '}';
    }
}
