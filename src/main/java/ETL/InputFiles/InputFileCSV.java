package ETL.InputFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputFileCSV extends InputFile {
    public InputFileCSV(String path) {
        super(path);
    }

    @Override
    public ArrayList<String[]> read() {
        String line = "";
        String splitBy = ",";

        ArrayList<String[]>records = new ArrayList<String[]>();
        try
        {   //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader(super.getPath()));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] record = line.split(splitBy);    // use comma as separator
                records.add(record);
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