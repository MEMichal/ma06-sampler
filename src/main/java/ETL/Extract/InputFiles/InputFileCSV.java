package ETL.Extract.InputFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class InputFileCSV extends InputFile {
    public InputFileCSV(String path) {
        super(path);
    }

    @Override
    public ArrayList<HashMap<String, String>> read() {
        String line = "";
        String splitBy = ",";

        ArrayList<HashMap<String, String>>records = new ArrayList<>();
        try
        {   //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(super.getPath()));

            String [] attributes = br.readLine().split(splitBy);

            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] record = line.split(splitBy);    // use comma as separator
                HashMap<String, String>recordHash = new HashMap<>();
                for(int i = 0; i < record.length; i++) {
                    recordHash.put(attributes[i], record[i]);
                }
                records.add(recordHash);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return records;
    }
}