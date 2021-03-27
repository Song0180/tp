package seedu.duke.storage;
/*
import seedu.duke.account.FitCenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private File source;
    public final static String SEPERATOR = " \\| ";

    public FileReader(File file) {
        source = file;
    }

    /**
     * Converts the content of the file into a task list.
     *
     * @return the task list
     * @throws FileNotFoundException if the file doesn't exist

    public FitCenter parseToArraylist() throws FileNotFoundException {
        FitCenter fitCenter = new FitCenter();
        Scanner sc = new Scanner(source);
        while(sc.hasNext()) {
            String currentLine = sc.nextLine();
            String[] taskParts = currentLine.split(SEPERATOR);
            switch (taskParts[0]) {
            case "T":
                tasks.add(new ToDo(taskParts[2], false));
                break;
            case "D":
                tasks.add(new Deadline(taskParts[2], false, taskParts[3]));
                break;
            case "E":
                tasks.add(new Event(taskParts[2], false, taskParts[3]));
                break;
            default:
                System.out.println("Unable to recognize input format: " + currentLine);
                break;
            }
            if(taskParts[1].equals("1")) {
                tasks.get(tasks.size()-1).setDone(true);
            }
        }
        return tasks;
    }
}
*/
