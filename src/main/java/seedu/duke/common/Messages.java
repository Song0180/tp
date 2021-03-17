package seedu.duke.common;

/**
 * Container for commonly used messages.
 */
public class Messages {
    public static final String MESSAGE_WELCOME = "Welcome to your personal fitness app - Healthier\n"
            + "What's in your mind today?\n";
    public static final String MESSAGE_BYE = "Nice work today!\n"
            + "You are one step closer to ultimate fitness!\n"
            + "See you again soon :)\n";
    public static final String MESSAGE_EXIT = "Thank you for using this app. The app is exiting...";
    public static final String MESSAGE_HELP = "Not sure how to use this app?\n"
            + "Use command 'help' to see what you can do.";
    public static final String MESSAGE_NO_RECORD = "Sorry, no records found.\n"
            + "You can try adding records by using command 'add'.";
    public static final String MESSAGE_SEE_HELP = "To learn more about the commands, try use command 'help'";
    public static final String MESSAGE_CANT_VIEW_LIST = "Sorry, cannot view record list of an incorrect record type.";
    public static final String MESSAGE_SYSTEM_ERROR = "There is something wrong within the system.";
    public static final String MESSAGE_INVALID_DATE_FORMAT = "The date format is incorrect. Please try again.\n";
    public static final String MESSAGE_INVALID_COMMAND = "Sorry, the command you entered cannot be recognized.\n\n";
    public static final String MESSAGE_INVALID_COMMAND_WORD = "The command word is invalid. "
            + "Enter help to see help messages\n";
    public static final String MESSAGE_INVALID_COMMAND_SYNTAX = "Sorry, "
            + "the syntax of the command entered is incorrect.\n\n";
    public static final String MESSAGE_INVALID_ADD_COMMAND = "The syntax for add command is:\n"
            + "1. Add exercise record\n\tadd t/E a/ACTIVITY_NAME d/DURATION [date/DD-MM-YYYY]\n"
            + "2. Add diet record\n\tadd t/D f/FOOD_NAME w/WEIGHT [date/DD-MM-YYYY]\n"
            + "3. Add sleep record\n\tadd t/S d/DURATION [date/DD-MM-YYYY]\n"
            + "4. Add body weight record\n\tadd t/W w/WEIGHT [date/DD-MM-YYYY]";
    public static final String MESSAGE_INVALID_VIEW_COMMAND = "The syntax for view command is:\n"
            + "1. View exercise records\n\tview t/E [a/ACTIVITY_NAME] [date/DD-MM-YYYY]\n"
            + "2. View diet records\n\tview t/D [f/FOOD_NAME] [date/DD-MM-YYYY]\n"
            + "3. View sleep records\n\tview t/S [date/DD-MM-YYYY]\n"
            + "4. View body weight records\n\tview t/W [date/DD-MM-YYYY]";
    public static final String MESSAGE_INVALID_DELETE_COMMAND = "The syntax for delete command is:\n"
            + "1. Delete exercise records\n\tdelete t/E [a/ACTIVITY_NAME] [date/DD-MM-YYYY]\n"
            + "2. Delete diet records\n\tdelete t/D i/index\n"
            + "3. Delete sleep records\n\tdelete t/S i/index\n"
            + "4. Delete body weight records\n\tdelete t/W i/index";
}
