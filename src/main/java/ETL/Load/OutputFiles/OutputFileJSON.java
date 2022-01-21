package ETL.Load.OutputFiles;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class OutputFileJSON extends OutputFile {
    public OutputFileJSON(String path) {
        super(path);
    }

    @Override
    public void write(ArrayList<HashMap<String, String>> records) {
        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();

        for(int i = 1; i < records.size(); i++) {
            //Inserting key-value pairs into the json object
            for(String key : records.get(i).keySet()) {
                jsonObject.put(key, records.get(i).get(key));
            }
            try {
                FileWriter fileWriter = new FileWriter(super.getPath(), true);
                fileWriter.write(jsonObject.toJSONString());
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            jsonObject.clear();
        }
    }
}