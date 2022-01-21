package ETL.Load.OutputDirectories;

import ETL.Load.OutputFiles.OutputFileJSON;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class OutputDirectoryJSON extends OutputDirectory{
    public OutputDirectoryJSON(String path) {
        super(path);
    }

    @Override
    public void writeToDirectory(ArrayList<HashMap<String, String>> records) {
        File file = new File(super.getPath());
        file.mkdirs();

        int numOfFiles = records.size() / 50000;
        if(records.size() % 50000 > 0) {
            numOfFiles++;
        }
        String [] pathDirs = super.getPath().split("/");
        String fileName = pathDirs[pathDirs.length - 1];

        ArrayList<OutputFileJSON>outputFileJSONS = new ArrayList<>();

        for(int i = 0; i <= numOfFiles; i++) {
            outputFileJSONS.add(new OutputFileJSON(super.getPath() + "/" + fileName + i + ".json"));
            outputFileJSONS.get(i).write(records);
        }
    }
}
