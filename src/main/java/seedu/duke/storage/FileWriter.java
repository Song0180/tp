package seedu.duke.storage;

import seedu.duke.account.FitCenter;

import java.io.IOException;

public class FileWriter {
    private String recordFilePath;

    public FileWriter(String recorPath) {
        recordFilePath = recorPath;
    }

    /**
     * Stores the current task list to the text file.
     *
     * @throws IOException if there is problem accessing or writing to the file
     */
    public void storeToFile(FitCenter fitCenter) throws IOException {
        java.io.FileWriter recordWriter = new java.io.FileWriter(recordFilePath);
        String stringToStore = fitCenter.getRecordListForStore();
        recordWriter.write(stringToStore);
        recordWriter.close();
    }
}
