package seedu.duke.command;


import seedu.duke.account.FitCenter;
import seedu.duke.record.RecordType;


import java.util.HashMap;
import java.util.Locale;

public class DeleteCommand extends Command {
    private static final String FEEDBACK_FORMAT = "You have successfully deleted the %s record of "
            + "index %s!\nRecord summary: %s\nDisplaying current exercise records:";
    private CommandRecordType recordType;
    private int indexToDelete;

    public DeleteCommand(CommandRecordType recordType, HashMap<String, String> params) throws NumberFormatException {
        this.recordType = recordType;
        indexToDelete = Integer.parseInt(params.get("index")) - 1;
    }

    @Override
    public CommandResult execute(FitCenter fitCenter) {
        try {
            String recordSummary = fitCenter.removeRecordFromList(recordType, indexToDelete);
            feedback = String.format(FEEDBACK_FORMAT, recordType, indexToDelete, recordSummary);
            feedback += "\n" + fitCenter.getRecordListString(recordType);
            return new CommandResult(feedback);
        } catch (IndexOutOfBoundsException e) {
            return new CommandResult("The index you entered is out of bound.\n"
                    + "Here are the tasks of type " + recordType.toString().toLowerCase(Locale.ROOT) + ":\n"
                    + fitCenter.getRecordListString(recordType));
        }
    }
}
