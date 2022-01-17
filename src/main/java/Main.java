import ETL.InputFiles.InputCSV;
import ETL.OutputFiles.OutputJson;
import Mada.Report;

import javax.xml.crypto.dsig.Transform;
import java.awt.font.TransformAttribute;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main (String[]args) {
        InputCSV inputCSV = new InputCSV("/home/michal/Documents/ma06-samplerData/MadaReports.csv");
        OutputJson outputJson = new OutputJson("/home/michal/Documents/ma06-samplerData/MadaReports.json");

        ArrayList<String[]> records = inputCSV.read();
        outputJson.write(records);
    }
}