package case_5.WrapperJSON_XML;

import com.fasterxml.jackson.xml.XmlMapper;
import net.bytebuddy.matcher.StringMatcher;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class OperationXML {
    public static void main(String[] args) throws JAXBException, IOException {
        //The same for xml.



        JAXBContext jaxbContext = JAXBContext.newInstance(Model.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Model model = (Model) unmarshaller.unmarshal(new File("src/main/java/case_5/WrapperJSON_XML/model.xml"));
        System.out.println(model);

        changeField(model,"model", "EU");
        changeField(model,"year",2015);
        XmlMapper xmlMapper = new XmlMapper();
        String str = xmlMapper.writeValueAsString(model);
        System.out.println(str);
    }
    private static void changeField(Object object, String fieldName,Object value) {
        Class modelClass=object.getClass();
        try {
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object,value); ;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
