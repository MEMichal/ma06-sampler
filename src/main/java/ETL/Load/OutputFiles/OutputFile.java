package ETL.Load.OutputFiles;

import java.util.ArrayList;

public abstract class OutputFile {
    private String path;

    public OutputFile(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public abstract void write(ArrayList<String[]>records);
}
