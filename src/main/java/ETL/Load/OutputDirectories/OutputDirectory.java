package ETL.Load.OutputDirectories;

import ETL.Load.OutputFiles.OutputFile;
import ETL.Load.OutputFiles.OutputFileJSON;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class OutputDirectory {
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public OutputDirectory(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
    public abstract void writeToDirectory(ArrayList<HashMap<String, String>> records);
}