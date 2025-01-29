package Data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class JsonDataReader {

    public List<HashMap<String, String>> jsonToHashmap() throws IOException {
        //convert JSON to STRING
        String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/src/test/java/Data/testData.json"));
        //convert STRING to HashMap - JACKSON DATABIND
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data =
                mapper.readValue(
                        jsonContent,
                        new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    public static void main(String[] args) throws IOException {
        JsonDataReader js = new JsonDataReader();
        List<HashMap<String,String>> d = js.jsonToHashmap();
        System.out.println(d.get(0));
        System.out.println(d.get(1));
    }
}
