package ETL.InputFiles;

import java.util.ArrayList;

public abstract class Input {
    private String path;

    public Input(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public abstract ArrayList<String[]> read();
}
