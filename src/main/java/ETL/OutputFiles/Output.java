package ETL.OutputFiles;

import java.util.ArrayList;

public abstract class Output {
    private String path;

    public Output(String path) {
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }

    public abstract void write(ArrayList<String[]>records);
}
