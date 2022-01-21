package ETL.Load.OutputDirectories;

import ETL.Load.OutputFiles.OutputFileXML;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class OutputDirectoryXML extends OutputDirectory{
    public OutputDirectoryXML(String path) {
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

        ArrayList<OutputFileXML>outputFileXMLS = new ArrayList<>();

        for(int i = 0; i <= numOfFiles; i++) {
            outputFileXMLS.add(new OutputFileXML(super.getPath() + "/" + fileName + i + ".xml"));
            outputFileXMLS.get(i).write(records);
        }
    }
}
