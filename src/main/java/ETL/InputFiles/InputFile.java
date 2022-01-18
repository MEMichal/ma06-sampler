package ETL.InputFiles;

import java.util.ArrayList;

public abstract class InputFile {
    private String path;

    public InputFile(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public abstract ArrayList<String[]> read();
}
