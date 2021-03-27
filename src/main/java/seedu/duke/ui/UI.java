package seedu.duke.ui;

import seedu.duke.command.CommandResult;
import seedu.duke.common.Messages;

import java.util.Scanner;

public class UI {

    public static final String DIVIDER = "--------------------------------------------------------------------\n";
    public static final String DIVIDER_LINE_ONLY =
            "--------------------------------------------------------------------";
    private final Scanner sc;

    public UI() {
        sc = new Scanner(System.in);
    }

    public String getUserInput() {
        return sc.nextLine();
    }

    public void printGreetings() {
        System.out.print(DIVIDER
                + Messages.MESSAGE_WELCOME
                + DIVIDER);
    }

    public void printExitMessage() {
        System.out.print(DIVIDER
                + Messages.MESSAGE_BYE
                + DIVIDER);
    }

    public void printCommandResult(CommandResult commandResult) {
        System.out.println(DIVIDER
                + commandResult.getFeedback()
                + "\n"
                + DIVIDER_LINE_ONLY);
    }

    public void showFileErrorMessage() {
        System.out.println("The source file can't be accessed, please check your access settings.");
    }
}
