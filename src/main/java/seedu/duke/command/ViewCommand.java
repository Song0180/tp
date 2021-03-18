package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

public class ViewCommand extends Command {
    private final CommandRecordType recordType;
    private HashMap<String, String> specifiedParams = null;
    private LocalDate localDate;

    public ViewCommand(CommandRecordType type) {
        recordType = type;
    }

    public ViewCommand(CommandRecordType type, HashMap<String, String> params) throws ParseException {
        recordType = type;
        specifiedParams = params;

        String dateString = params.get("date");
        if (dateString != null) {
            SimpleDateFormat spf = new SimpleDateFormat("dd-MM-yyyy");
            spf.setLenient(false);
            Date date = spf.parse(dateString);
            localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
    }

    private String getRecordsWithOptionalParam(FitCenter fitCenter, String optionalParam) {
        if (specifiedParams.size() == 2) {
            return fitCenter.getRecordListString(recordType, localDate, optionalParam);
        } else if (specifiedParams.size() == 1 && specifiedParams.containsKey("date")) {
            return fitCenter.getRecordListString(recordType, localDate);
        } else {
            return fitCenter.getRecordListString(recordType, optionalParam);
        }
    }

    private String getRecordsWithoutOptionalParam(FitCenter fitCenter) {
        if (specifiedParams != null) {
            return fitCenter.getRecordListString(recordType, localDate);
        } else {
            return fitCenter.getRecordListString(recordType);
        }
    }

    public CommandResult execute(FitCenter fitCenter) {
        switch (recordType) {
        case SLEEP:
            //FALL-THROUGH
        case BODY_WEIGHT:
            feedback = getRecordsWithoutOptionalParam(fitCenter);
            break;
        case EXERCISE:
            if (specifiedParams != null) {
                feedback = getRecordsWithOptionalParam(fitCenter, specifiedParams.get("activity"));
            } else {
                feedback = getRecordsWithoutOptionalParam(fitCenter);
            }
            break;
        case DIET:
            if (specifiedParams != null) {
                feedback = getRecordsWithOptionalParam(fitCenter, specifiedParams.get("food"));
            } else {
                feedback = getRecordsWithoutOptionalParam(fitCenter);
            }
            break;
        default:
            feedback = Messages.MESSAGE_CANT_VIEW_LIST;
        }
        return new CommandResult(feedback);
    }

}