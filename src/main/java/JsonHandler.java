import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonHandler {

    public static List<Vector> getVectorsFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/json_vectors.json");

        List<Vector> vectors = objectMapper.readValue(file,
                new TypeReference<>() {
                });

        return vectors;
    }

    public void setVectorInJson(Object object) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/json_in_vectors.json");
        objectMapper.writeValue(file,object);
    }

    public static Map getOptions(){ //
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/json_in_vectors.json\"");
        //Map<Integer,String> mOptions = objectMapper.readValue(file, TypeReference<Map<Integer,String>>(){});
        return null;
    }


}
