package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;
import seedu.duke.exception.TypeException;
import seedu.duke.record.Record;
import seedu.duke.record.BodyWeight;
import seedu.duke.record.Diet;
import seedu.duke.record.Exercise;
import seedu.duke.record.Sleep;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

public class AddCommand extends Command {
    private static final String FEEDBACK_FORMAT = "A new %s record is added successfully!\nRecord summary:%s";
    private final Record record;
    private final CommandRecordType recordType;

    public AddCommand(CommandRecordType recordType, HashMap<String, String> params)
            throws ParseException, TypeException, NumberFormatException {
        SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
        this.recordType = recordType;
        spf.setLenient(false);
        String dateString = params.get("date");
        LocalDate recordDate;
        if (dateString != null) {
            Date date = spf.parse(dateString);
            recordDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            recordDate = LocalDate.now();
        }
        switch (recordType) {
        case EXERCISE:
            record = new Exercise(params.get("activity"), Integer.parseInt(params.get("duration")), recordDate);
            break;
        case DIET:
            record = new Diet(params.get("food"), params.get("weight"), recordDate);
            break;
        case SLEEP:
            record = new Sleep(Integer.parseInt(params.get("duration")), recordDate);
            break;
        case BODY_WEIGHT:
            record = new BodyWeight(Double.parseDouble(params.get("weight")), recordDate);
            break;
        default:
            record = null;
        }
    }

    public CommandResult execute(FitCenter fitCenter) {
        if (record != null) {
            fitCenter.addRecordToList(recordType, record);
            feedback = String.format(FEEDBACK_FORMAT, record.getType(), record.getRecordSummary());
        } else {
            feedback = Messages.MESSAGE_CANT_ADD_RECORD;
        }
        return new CommandResult(feedback);
    }
}
