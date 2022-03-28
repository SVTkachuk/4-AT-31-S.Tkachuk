package case_5.WrapperJSON_XML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
@XmlRootElement
public class Model implements Serializable {
    //Make some complex models with few fields.
    //Make it serializable.

        private String model;
        private Integer year;


        @XmlElement
        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        @Override
        public String toString() {
            return "{" +
                    "model='" + model + '\'' +
                    ", year=" + year +
                    '}';
        }
    @XmlElement
        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }
    }
