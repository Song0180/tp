package seedu.duke.common;

/**
 * Container for commonly used messages.
 */
public class Messages {
    public static final String MESSAGE_VERSION = "V1.0";
    public static final String MESSAGE_FEATURES = "You can use the app by using command ADD, VIEW, and DELETE.";
    public static final String MESSAGE_WELCOME = "Welcome to your personal fitness app - Healthier\n"
            + "What's in your mind today?\n";
    public static final String MESSAGE_BYE = "Nice work today!\n"
            + "You are one step closer to ultimate fitness!\n"
            + "See you again soon :)\n";
    public static final String MESSAGE_EXIT = "Thank you for using this app. The app is exiting...";
    public static final String MESSAGE_HELP_PROMPT = "Not sure how to use this app?\n"
            + "Use command 'help' to see what you can do.";
    public static final String MESSAGE_HELP_GREETINGS = "Thank you for choosing to be healthier with us.\n"
            + "The current version of this application is: " + MESSAGE_VERSION + "\n"
            + MESSAGE_FEATURES + "\n";
    public static final String MESSAGE_VIEW_TITLE = "Displaying all eligible %s records:\n";
    public static final String MESSAGE_VIEW_HEADER_EXERCISE = "Index\t\tDate\t\tActivity\t\tDuration\t\tCalories\n";
    public static final String MESSAGE_VIEW_HEADER_DIET = "Index\t\tDate\t\tFood Category\t\tWeight\t\tCalories\n";
    public static final String MESSAGE_VIEW_HEADER_SLEEP = "Index\t\tDate\t\t\tDuration\n";
    public static final String MESSAGE_VIEW_HEADER_WEIGHT = "Index\t\tDate\t\t\tBody Weight\n";
    public static final String MESSAGE_NO_RECORD = "Sorry, no records found.\n"
            + "You can try adding records by using command 'add'.";
    public static final String MESSAGE_NO_GOAL = "Sorry, no goals found.\n"
            + "You can try setting a goal by using command 'set'.";
    public static final String MESSAGE_INDEX_NUMBER_FORMAT_EXCEPTION = "The index field is not a valid number.\n"
            + "Please try again.";
    public static final String MESSAGE_CANT_ADD_RECORD = "Sorry, you cannot add record of an unrecognized type.";
    public static final String MESSAGE_CANT_VIEW_LIST = "Sorry, you cannot view record list "
            + "of an incorrect record type.";
    public static final String MESSAGE_SYSTEM_ERROR = "There is something wrong within the system.";
    //public static final String MESSAGE_NUMBER_FORMAT_ERROR = "Please check the value for the number field.";
    public static final String MESSAGE_INVALID_DATE_FORMAT = "The date format is incorrect or the date is invalid. "
            + "Please try again.\n";
    public static final String MESSAGE_INVALID_SLEEP_HOUR = "The duration you entered is invalid.\n"
            + "It should be an positive integer between 0 and 24, with the unit of hour.\nPlease try again.";
    public static final String MESSAGE_INVALID_WORKOUT_MIN = "The duration you entered is invalid.\n"
            + "It should be an positive integer between 0 and 1440, with the unit of minute.\nPlease try again.";
    public static final String MESSAGE_INVALID_WEIGHT = "The weight you entered is invalid.\n"
            + "It should be an positive floating point number, with the unit of kilogram(kg).\nPlease try again.";
    public static final String MESSAGE_INVALID_FOOD_CATEGORY = "The food category you entered is invalid.\n"
            + "The acceptable food category list is:\n";
    public static final String MESSAGE_INVALID_FOOD_AMOUNT = "The amount you entered is invalid.\n"
            + "The acceptable amount of food should be a floating point number, with the unit of gram(g).\n"
            + "Please try again.";
    public static final String MESSAGE_INVALID_WORKOUT_CATEGORY = "The workout category you entered is invalid.\n"
            + "The acceptable workout category list is:\n";
    public static final String MESSAGE_INVALID_COMMAND = "Sorry, the command you entered cannot be recognized.\n\n";
    public static final String MESSAGE_INVALID_COMMAND_WORD = "The command word is invalid. "
            + "Enter help to see help messages\n";
    public static final String MESSAGE_INVALID_COMMAND_SYNTAX = "Sorry, "
            + "the syntax of the command entered is incorrect.\n\n";
    public static final String MESSAGE_SYNTAX_ADD_COMMAND = "The syntax for add command is:\n"
            + "1. Add exercise record\n\tadd t/E a/ACTIVITY_NAME d/DURATION [date/DD-MM-YYYY]\n"
            + "   The duration is with unit of minute.\n"
            + "2. Add diet record\n\tadd t/D f/FOOD_TYPE w/WEIGHT [date/DD-MM-YYYY]\n"
            + "   The amount is with unit of gram.\n"
            + "3. Add sleep record\n\tadd t/S d/DURATION [date/DD-MM-YYYY]\n"
            + "   The duration is with unit of hour.\n"
            + "4. Add body weight record\n\tadd t/W w/WEIGHT [date/DD-MM-YYYY]\n"
            + "   The weight is with unit of kilogram.\n"
            + "Please note the type must be in uppercase.";
    public static final String MESSAGE_SYNTAX_VIEW_COMMAND = "The syntax for view command is:\n"
            + "1. View exercise records\n\tview t/E [a/ACTIVITY_NAME] [date/DD-MM-YYYY]\n"
            + "2. View diet records\n\tview t/D [f/FOOD_NAME] [date/DD-MM-YYYY]\n"
            + "3. View sleep records\n\tview t/S [date/DD-MM-YYYY]\n"
            + "4. View body weight records\n\tview t/W [date/DD-MM-YYYY]";
    public static final String MESSAGE_SYNTAX_DELETE_COMMAND = "The syntax for delete command is:\n"
            + "1. Delete exercise records\n\tdelete t/E [a/ACTIVITY_NAME] [date/DD-MM-YYYY]\n"
            + "2. Delete diet records\n\tdelete t/D i/index\n"
            + "3. Delete sleep records\n\tdelete t/S i/index\n"
            + "4. Delete body weight records\n\tdelete t/W i/index";
}
