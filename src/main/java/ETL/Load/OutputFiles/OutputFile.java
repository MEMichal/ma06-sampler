package ETL.Load.OutputFiles;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class OutputFile {
    private String path;

    public OutputFile(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public abstract void write(ArrayList<HashMap<String, String>> records);
}
