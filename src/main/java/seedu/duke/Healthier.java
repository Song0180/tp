package seedu.duke;

import seedu.duke.account.FitCenter;
import seedu.duke.account.User;
import seedu.duke.command.Command;
import seedu.duke.command.CommandResult;
import seedu.duke.command.ExitCommand;
import seedu.duke.commandparser.CommandParser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.UI;

import java.io.File;
import java.io.IOException;

public class Healthier {
    private UI ui;
    private Storage storage;
    private final User currentUser = new User();
    private final FitCenter currentFitCenter = currentUser.getFitCenter();

    private void start() {
        ui = new UI();
        String sourceFilePath = "data" + File.separator + "records.txt";
        try {
            storage = new Storage(sourceFilePath);
            // = storage.getTaskList();
        } catch (IOException e) {
            ui.showFileErrorMessage();
            System.exit(0);
        }
        ui.printGreetings();
    }

    private void loopCommand() throws IOException {
        CommandParser commandParser = new CommandParser();
        Command command;
        do {
            String userInput = ui.getUserInput();
            command = commandParser.parseCommand(userInput);
            CommandResult result = command.execute(currentFitCenter);
            ui.printCommandResult(result);
            storage.store(currentFitCenter);
            commandParser.clearParserParams();
        } while (!ExitCommand.isExitCommand(command));
    }

    private void exit() {
        ui.printExitMessage();
        System.exit(0);
    }

    public void run() {
        try {
            start();
            loopCommand();
            exit();
        } catch (IOException e) {
            ui.showFileErrorMessage();
        }
    }

    public static void main(String[] args) {
        new Healthier().run();
    }
}
