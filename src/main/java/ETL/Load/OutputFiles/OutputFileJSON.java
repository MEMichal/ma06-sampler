package ETL.Load.OutputFiles;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputFileJSON extends OutputFile {
    public OutputFileJSON(String path) {
        super(path);
    }

    @Override
    public void write(ArrayList<String[]> records) {
        String [] attributes = records.get(0);

        //Creating a JSONObject object
        JSONObject jsonObject = new JSONObject();

        for(int i = 1; i < 50000; i++) {
            //Inserting key-value pairs into the json object
            for(int j = 0; j < records.get(i).length; j++) {
                jsonObject.put(attributes[j], records.get(i)[j]);
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