package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;


public class JsonUtils {

    private static final String JSON_FILE_PATH = "src/test/resources/";
    public String JsonReader;
    String JsonFileName;

    public JsonUtils(String JsonFileName)
    {
        this.JsonFileName = JsonFileName;
        try {
            String fullPath = JSON_FILE_PATH + JsonFileName +".json";
            JSONObject data = (JSONObject) new JSONParser().parse(new FileReader(fullPath));
            JsonReader = data.toJSONString();
        } catch (Exception e) {
            Logs.error(e.getMessage());
        }
    }

    public String getJsonData(String JsonPath)
    {
        String testDate = "";
        try {
            testDate = com.jayway.jsonpath.JsonPath.read(JsonReader, JsonPath);
        } catch (Exception e) {
            Logs.error(e.getMessage(), "No result for json path: " +JsonPath+ "in the json file: ");
        }
        return testDate;
    }

}
