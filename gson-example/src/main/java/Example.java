import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xjimmy on 8/9/16.
 */
public class Example {

    public static void main(String args[]) {
        try {
            createJSON();
            readJSON();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static void readJSON() throws Exception {

        String inputfile = System.getProperties().getProperty("user.home") + "/test.json";
        System.out.printf("read json from file:%s\n", inputfile);

        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(new FileReader(inputfile));

        System.out.println("cat = " + object.get("cat").getAsString());

        JsonArray languages = object.getAsJsonArray("languages");
        for (JsonElement jsonElement : languages) {
            JsonObject language = jsonElement.getAsJsonObject();
            System.out.println("id = " + language.get("id").getAsInt() + ",ide = " + language.get("ide").getAsString() + ",name = " + language.get("name").getAsString());
        }

        System.out.println("pop = " + object.get("pop").getAsString());

    }

    protected static void createJSON() throws IOException {

        String outputfile = System.getProperties().getProperty("user.home") + "/test.json";
        System.out.printf("write json to file:%s\n", outputfile);

        JsonObject object = new JsonObject();
        object.addProperty("cat", "it");

        JsonArray languages = new JsonArray();
        JsonObject language = new JsonObject();
        language.addProperty("id", 1);
        language.addProperty("ide", "Eclipse");
        language.addProperty("name", "java");
        languages.add(language);

        language = new JsonObject();
        language.addProperty("id", 2);
        language.addProperty("ide", "XCode");
        language.addProperty("name", "Swift");
        languages.add(language);

        language = new JsonObject();
        language.addProperty("id", 3);
        language.addProperty("ide", "Visual Studio");
        language.addProperty("name", "C#");
        languages.add(language);

        object.add("languages", languages);
        object.addProperty("pop", true);

        String jsonStr = object.toString();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outputfile)));
        pw.print(jsonStr);
        pw.flush();
        pw.close();
    }

}
