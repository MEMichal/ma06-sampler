import ETL.Extract.InputFiles.InputFileCSV;
import ETL.Load.OutputDirectories.OutputDirectory;
import ETL.Load.OutputDirectories.OutputDirectoryJSON;
import ETL.Load.OutputFiles.OutputFileJSON;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main (String[]args) {
        //A
        InputFileCSV inputCSV = new InputFileCSV("/home/michal/Documents/ma06-samplerData/MadaReports.csv");
        ArrayList<HashMap<String, String>> records = inputCSV.read();

        OutputDirectory outputDirectory = new OutputDirectoryJSON("/home/michal/Documents/ma06-samplerData/MadaReports");
        outputDirectory.writeToDirectory(records);

        //B

    }
}