package case_5.WrapperJSON_XML;



import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class OperationJSON {
    public static void main(String[] args) throws IOException {





        //Read some json from “input.json”


        //and deserialize it to POJO.
        ObjectMapper mapper = new ObjectMapper();
        Model model = mapper.readValue(new File("src/main/java/case_5/WrapperJSON_XML/model.json"),Model.class);
        System.out.println(model);                            
        //Then change a few fields and save it to “output.json”.
        changeField(model,"model", "VI");
        changeField(model,"year",2018);
        mapper.writeValue(new File("src/main/java/case_5/WrapperJSON_XML/model.json"), model);
        model = mapper.readValue(new File("src/main/java/case_5/WrapperJSON_XML/model.json"),Model.class);
        System.out.println(model);
        // ~ returning first values
        changeField(model,"model", "EU");
        changeField(model,"year",2015);
        mapper.writeValue(new File("src/main/java/case_5/WrapperJSON_XML/model.json"), model);




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
