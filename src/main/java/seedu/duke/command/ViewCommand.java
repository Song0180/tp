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
    private LocalDate recordDate;

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
            recordDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
    }

    public CommandResult execute(FitCenter fitCenter) {
        switch (recordType) {
        case SLEEP:
            feedback = getRecordsWithoutOptionalParam(fitCenter);
            feedback = getFeedbackWithHeader(Messages.MESSAGE_VIEW_HEADER_SLEEP);
            break;
        case BODY_WEIGHT:
            feedback = getRecordsWithoutOptionalParam(fitCenter);
            feedback = getFeedbackWithHeader(Messages.MESSAGE_VIEW_HEADER_WEIGHT);
            break;
        case EXERCISE:
            if (specifiedParams != null) {
                feedback = getRecordsWithOptionalParam(fitCenter, specifiedParams.get("activity"));
            } else {
                feedback = getRecordsWithoutOptionalParam(fitCenter);
            }
            feedback = getFeedbackWithHeader(Messages.MESSAGE_VIEW_HEADER_EXERCISE);
            break;
        case DIET:
            if (specifiedParams != null) {
                feedback = getRecordsWithOptionalParam(fitCenter, specifiedParams.get("food"));
            } else {
                feedback = getRecordsWithoutOptionalParam(fitCenter);
            }
            feedback = getFeedbackWithHeader(Messages.MESSAGE_VIEW_HEADER_DIET);
            break;
        default:
            feedback = Messages.MESSAGE_CANT_VIEW_LIST;
        }
        addTitleToFeedback();
        return new CommandResult(feedback);
    }

    private String getRecordsWithOptionalParam(FitCenter fitCenter, String optionalParam) {
        if (specifiedParams.size() == 2) {
            return fitCenter.getRecordListString(recordType, recordDate, optionalParam);
        } else if (specifiedParams.size() == 1 && specifiedParams.containsKey("date")) {
            return fitCenter.getRecordListString(recordType, recordDate);
        } else {
            return fitCenter.getRecordListString(recordType, optionalParam);
        }
    }

    private String getRecordsWithoutOptionalParam(FitCenter fitCenter) {
        if (specifiedParams != null) {
            return fitCenter.getRecordListString(recordType, recordDate);
        } else {
            return fitCenter.getRecordListString(recordType);
        }
    }

    private void addTitleToFeedback() {
        String recordString = recordType.toString().toLowerCase().replace("_", " ");
        String feedbackHeading = String.format(Messages.MESSAGE_VIEW_TITLE, recordString);
        feedback = feedbackHeading + feedback;
    }

    private String getFeedbackWithHeader(String header) {
        return feedback.contains("Sorry") ? feedback : header + feedback;
    }
}