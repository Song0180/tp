package seedu.duke.command;

import java.util.Locale;

public enum CommandRecordType {
    EXERCISE("E"), DIET("D"), SLEEP("S"), BODY_WEIGHT("W"), INVALID("I");
    private String recordType;
    CommandRecordType(String type) {
        recordType = type;
    }

    /*public static boolean isValidType(String type) {
        boolean isValid = false;
        for (int i = 0; i < CommandRecordType.values().length; i++) {
            if (type.toUpperCase(Locale.ROOT).equals(CommandRecordType.values()[i].recordType)
            && !CommandRecordType.values()[i].recordType.equals("I")) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
     */
    public static CommandRecordType getType(String typeString) {
        for (int i = 0; i < CommandRecordType.values().length; i++) {
            if (typeString.equals(CommandRecordType.values()[i].recordType)) {
                return CommandRecordType.values()[i];
            }
        }
        return INVALID;
    }
}
