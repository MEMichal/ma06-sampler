import ETL.InputFiles.InputFileCSV;
import ETL.Load.OutputDirectory;

import java.util.ArrayList;

public class Main {

    public static void main (String[]args) {
        InputFileCSV inputCSV = new InputFileCSV("/home/michal/Documents/ma06-samplerData/MadaReports.csv");
        OutputDirectory outputFilesDirectory = new OutputDirectory("/home/michal/Documents/ma06-samplerData/MadaReports");

        ArrayList<String[]> records = inputCSV.read();
        outputFilesDirectory.writeToFiles(records);
    }
}