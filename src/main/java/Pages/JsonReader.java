package Pages;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class JsonReader {
    public static class TestJson {
        public static String getJson(String filePath, String key) throws IOException, ParseException, org.json.simple.parser.ParseException {
            JSONObject jsonObject = (JSONObject)
                    new JSONParser().parse(new FileReader(filePath));
            return (String) jsonObject.get(key);
        }
    }
}
