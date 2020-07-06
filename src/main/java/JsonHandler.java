import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonHandler {

    public static List<Vector> getVectorsFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/json_vectors.json");

        List<Vector> vectors = objectMapper.readValue(file, new TypeReference<List<Vector>>() {
        });

        return vectors;
    }



}
