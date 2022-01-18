package ETL.Load;

import ETL.Load.OutputFiles.OutputFile;
import ETL.Load.OutputFiles.OutputFileJSON;

import java.util.ArrayList;

public class OutputDirectory {
    private String path;
    private ArrayList<OutputFile>outputFiles;

    public OutputDirectory(String path) {
        this.path = path;
        this.outputFiles = new ArrayList<>();
    }

    public void writeToFiles(ArrayList<String[]> records) {
        int numOfFiles = records.size() / 50000;
        if(records.size() % 50000 > 0) {
            numOfFiles++;
        }
        String [] pathDirs = path.split("/");
        String fileName = pathDirs[pathDirs.length - 1];

        for(int i = 0; i <= numOfFiles; i++) {
            outputFiles.add(new OutputFileJSON(path + "/" + fileName + i));
            outputFiles.get(i).write(records);
        }
    }
}
