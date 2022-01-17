package ETL.OutputFiles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputJson extends Output {
    public OutputJson(String path) {
        super(path);
    }

    @Override
    public void write(ArrayList<String[]> records) {
        String [] attributes = records.get(0);

        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();

        for(int i = 1; i < records.size(); i++) {
            //Inserting key-value pairs into the json object
            for(int j = 0; j < records.get(i).length; j++) {
                jsonObject.put(attributes[j], records.get(i)[j]);
            }
            try {
                FileWriter file = new FileWriter(super.getPath(), true);
                file.write(jsonObject.toJSONString());
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            jsonObject.clear();
        }
    }
}