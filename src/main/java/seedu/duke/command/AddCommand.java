package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.exception.TypeException;
import seedu.duke.record.Diet;
import seedu.duke.record.Record;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

public class AddCommand extends Command {
    private static final String FEEDBACK_FORMAT = "A new %s record is added successfully!\nRecord summary:%s";
    private Record record;
    private final CommandRecordType recordType;

    public AddCommand(CommandRecordType recordType, HashMap<String, String> params)
            throws ParseException, TypeException, NumberFormatException {
        SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
        this.recordType = recordType;
        spf.setLenient(false);
        String dateString = params.get("date");
        LocalDate localDate;
        if (dateString != null) {
            Date date = spf.parse(dateString);
            localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            localDate = LocalDate.now();
        }
        switch (recordType) {
        case EXERCISE:
            System.out.println(params.get("activity") + params.get("duration") + localDate.toString());
            break;
        case DIET:
            record = new Diet(params.get("food"), params.get("weight"), localDate);
            break;
        case SLEEP:
            System.out.println(params.get("duration") + localDate.toString());
            break;
        case BODY_WEIGHT:
            System.out.println(params.get("weight") + localDate.toString());
            break;
        default:
            System.out.println("There is something wrong within the system.");
        }
    }

    public CommandResult execute(FitCenter fitCenter) {
        fitCenter.addRecordToList(recordType, record);
        feedback = String.format(FEEDBACK_FORMAT, record.getType(), record.getRecordSummary());
        return new CommandResult(feedback);
    }
}
