package seedu.duke.storage;

import seedu.duke.account.FitCenter;

import java.io.File;
import java.io.IOException;

public class Storage {
    //private FileReader fileReader;
    private FileWriter fileWriter;
    private String filePath;
    private File source;

    public Storage(String filePath) throws IOException {
        this.filePath = filePath;
        source = new File(filePath);
        if (!source.exists()) {
            if (!source.getParentFile().exists()) {
                source.getParentFile().mkdirs();
                source.createNewFile();
            }
        }
        fileWriter = new FileWriter(filePath);
        //fileTaskReader = new FileTaskReader(source);
    }

    public void store(FitCenter fitCenter) throws IOException {
        fileWriter.storeToFile(fitCenter);
    }
}
