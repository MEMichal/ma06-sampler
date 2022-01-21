package ETL.Extract.InputFiles;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class InputFile {
    private String path;

    public InputFile(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public abstract ArrayList<HashMap<String, String>> read();
}
