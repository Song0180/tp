package seedu.duke.commandparser;

import seedu.duke.account.FitCenter;
import seedu.duke.command.AddCommand;
import seedu.duke.command.DeleteCommand;
import seedu.duke.command.CommandRecordType;
import seedu.duke.command.CommandType;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.InvalidCommand;
import seedu.duke.command.ViewCommand;
import seedu.duke.command.Command;
import seedu.duke.common.Messages;
import seedu.duke.exception.TypeException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;

import static seedu.duke.command.CommandRecordType.EXERCISE;
import static seedu.duke.command.CommandRecordType.DIET;
import static seedu.duke.command.CommandRecordType.BODY_WEIGHT;
import static seedu.duke.command.CommandRecordType.SLEEP;
import static seedu.duke.command.CommandRecordType.INVALID;
import static seedu.duke.command.CommandType.DELETE;
import static seedu.duke.command.CommandType.ADD;
import static seedu.duke.command.CommandType.VIEW;

public class CommandParser {
    private final HashMap<String, String> params;

    public CommandParser() {
        params = new HashMap<>();
    }

    public Command parseCommand(String userInput) {
        String[] inputParts = getInputParts(userInput);
        String commandWord = getCommandWord(inputParts);
        switch (commandWord) {
        case "add":
            return prepareAdd(inputParts);
        case "view":
            return prepareView(inputParts);
        case "delete":
            return prepareDelete(inputParts);
        case "exit":
            return new ExitCommand();
        default:
            return new InvalidCommand(Messages.MESSAGE_INVALID_COMMAND + Messages.MESSAGE_HELP);
        }
    }

    private String getCommandWord(String[] inputParts) {
        return inputParts[0];
    }

    private String[] getInputParts(String userInput) {
        return userInput.trim().split("\\s+", 2);
    }

    private Command prepareAdd(String[] inputParts) {
        try {
            if (inputParts.length < 2) {
                return new InvalidCommand(ADD);
            }
            if (inputParts[1].length() < 3) {
                return new InvalidCommand(ADD);
            }
            CommandRecordType recordType = CommandRecordType.getType("" + inputParts[1].trim().charAt(2));
            if (recordType == INVALID) {
                return new InvalidCommand(ADD);
            }

            String[] typeContent = getTypeAndContent(inputParts[1]);
            if (typeContent.length < 2) {
                return new InvalidCommand(ADD);
            }

            String content = typeContent[1];
            content = content.trim();
            switch (recordType) {
            case EXERCISE:
                return prepareAddExercise(content);
            case BODY_WEIGHT:
                return prepareAddBodyWeight(content);
            case DIET:
                return prepareAddDiet(content);
            case SLEEP:
                return prepareAddSleep(content);
            default:
                return new InvalidCommand(Messages.MESSAGE_INVALID_COMMAND_WORD);
            }
        } catch (ParseException e) {
            return new InvalidCommand(Messages.MESSAGE_INVALID_DATE_FORMAT);
        } catch (TypeException e) {
            return new InvalidCommand(e.toString());
        } catch (NumberFormatException e) {
            return new InvalidCommand("Please check the value you filled in for the number field");
        }
    }

    private String[] getTypeAndContent(String inputPart) {
        return inputPart.split("\\s+", 2);
    }

    private Command prepareView(String[] inputParts) {
        try {
            if (inputParts.length < 2) {
                return new InvalidCommand(VIEW);
            }
            if (inputParts[1].length() < 3) {
                return new InvalidCommand(VIEW);
            }
            CommandRecordType recordType = CommandRecordType.getType("" + inputParts[1].trim().charAt(2));
            if (recordType == INVALID) {
                return new InvalidCommand(VIEW);
            }
            String typeContent = inputParts[1];
            String optionalParams = getOptionalParamsForView(typeContent);
            if (optionalParams.equals("")) {
                return new ViewCommand(recordType);
            }
            switch (recordType) {
            case EXERCISE:
                return prepareViewExercise(optionalParams);
            case BODY_WEIGHT:
                return prepareViewBodyWeight(optionalParams);
            case DIET:
                return prepareViewDiet(optionalParams);
            case SLEEP:
                return prepareViewSleep(optionalParams);
            default:
                return new InvalidCommand(VIEW);
            }
        } catch (ParseException e) {
            return new InvalidCommand("The date format is incorrect");
        }
    }

    private String getOptionalParamsForView(String typeContent) {
        String[] rawInput = typeContent.split("\\s+", 2);
        if (rawInput.length == 1) {
            return "";
        } else {
            return rawInput[1].trim();
        }
    }

    private boolean checkDateValid(String dateString) {
        return dateString.startsWith("date/") && dateString.length() > 5;
    }

    private Command prepareDelete(String[] inputParts) {
        try {
            if (inputParts.length < 2) {
                return new InvalidCommand(DELETE);
            }
            if (inputParts[1].length() < 3) {
                return new InvalidCommand(DELETE);
            }
            CommandRecordType recordType = CommandRecordType.getType("" + inputParts[1].trim().charAt(2));
            if (recordType == INVALID) {
                return new InvalidCommand(DELETE);
            }
            String[] typeIndex = inputParts[1].split("\\s+", 2);
            if (typeIndex.length < 2) {
                return new InvalidCommand(DELETE);
            }
            String index = typeIndex[1];
            boolean isIndexValid = index.startsWith("i/") && index.length() >= 3;
            if (!isIndexValid) {
                return new InvalidCommand(DELETE);
            }
            index = index.substring(2);
            params.put("index", index);
            return new DeleteCommand(recordType, params);
            //System.out.println(index);
            //return new InvalidCommand("Invalid");
        } catch (NumberFormatException e) {
            return new InvalidCommand("The index should be an integer");
        }
    }

    private Command prepareViewExercise(String optionalParams) throws ParseException {
        String activity;
        String date;
        boolean hasActivity = optionalParams.contains("a/");
        boolean hasDate = optionalParams.contains("date/");
        if (!hasActivity && !hasDate) {
            return new InvalidCommand(VIEW);
        }
        if (hasActivity) {
            activity = parseExerciseActivity(optionalParams, false);
            if (activity.equals("")) {
                return new InvalidCommand(VIEW);
            }
            if (!hasDate) {
                params.put("activity", activity);
                return new ViewCommand(EXERCISE, params);
            }
            String[] activityDate = getDate(activity);
            if (activityDate.length == 0) {
                return new InvalidCommand(VIEW);
            }
            activity = activityDate[0];
            date = activityDate[1];
            params.put("activity", activity);
            params.put("date", date);
            return new ViewCommand(EXERCISE, params);
        }
        if (!checkDateValid(optionalParams)) {
            return new InvalidCommand(VIEW);
        }
        date = optionalParams.substring(5);
        params.put("date", date);
        return new ViewCommand(EXERCISE, params);
    }

    private Command prepareViewDiet(String optionalParams) throws ParseException {
        String food;
        String date;
        boolean hasFood = optionalParams.contains("f/");
        boolean hasDate = optionalParams.contains("date/");
        if (!hasFood && !hasDate) {
            return new InvalidCommand(VIEW);
        }
        if (hasFood) {
            food = parseDiet(optionalParams, false);
            if (food.equals("")) {
                return new InvalidCommand(VIEW);
            }
            if (!hasDate) {
                params.put("food", food);
                return new ViewCommand(DIET, params);
            }
            String[] foodDate = getDate(food);
            if (foodDate.length == 0) {
                return new InvalidCommand(VIEW);
            }
            food = foodDate[0];
            date = foodDate[1];
            params.put("food", food);
            params.put("date", date);
            return new ViewCommand(DIET, params);
        }
        if (!checkDateValid(optionalParams)) {
            return new InvalidCommand(VIEW);
        }
        date = optionalParams.substring(5);
        params.put("date", date);
        return new ViewCommand(DIET, params);
    }

    private Command prepareViewSleep(String optionalParams) throws ParseException {
        if (!checkDateValid(optionalParams)) {
            return new InvalidCommand(VIEW);
        }
        String date = optionalParams.substring(5);
        params.put("date", date);
        return new ViewCommand(SLEEP, params);
    }

    private Command prepareViewBodyWeight(String optionalParams) throws ParseException {
        if (!checkDateValid(optionalParams)) {
            return new InvalidCommand(VIEW);
        }
        String date = optionalParams.substring(5);
        params.put("date", date);
        return new ViewCommand(BODY_WEIGHT, params);
    }

    private Command prepareAddSleep(String content) throws ParseException, TypeException, NumberFormatException {
        String duration = parseDuration(content, false);
        if (duration.equals("")) {
            return new InvalidCommand(ADD);
        }
        boolean hasDate = content.contains("date/");
        String date;
        if (hasDate) {
            String[] durationDate = getDate(duration);
            if (durationDate.length == 0) {
                return new InvalidCommand(ADD);
            }
            duration = durationDate[0];
            date = durationDate[1];
            params.put("duration", duration);
            params.put("date", date);
            return new AddCommand(SLEEP, params);
        }
        params.put("duration", duration);
        return new AddCommand(SLEEP, params);
    }

    private String[] getDate(String stringWithDate) {
        String[] paramDateRaw = stringWithDate.split("date/", 2);
        String date = paramDateRaw[1].trim();
        String param = paramDateRaw[0].trim();
        boolean isParamValid = param.length() > 0;
        boolean isDateValid = date.length() == 10;
        if (!isParamValid || !isDateValid) {
            return new String[0];
        }
        String[] paramDate = new String[2];
        paramDate[0] = param;
        paramDate[1] = date;
        return paramDate;
    }

    private Command prepareAddDiet(String content) throws ParseException, TypeException, NumberFormatException {
        String[] foodWeight = getFoodAndFoodWeight(content);
        if (foodWeight.length < 2) {
            return new InvalidCommand(ADD);
        }
        String foodRawInput = foodWeight[0].trim();
        String weightRawInput = foodWeight[1].trim();
        String food = parseDiet(foodRawInput, false);
        if (food.equals("")) {
            return new InvalidCommand(ADD);
        }
        String weight = parseWeight(weightRawInput, true);
        if (weight.equals("")) {
            return new InvalidCommand(ADD);
        }
        boolean hasDate = weightRawInput.contains("date/");
        String date;
        if (hasDate) {
            String[] weightDate = getDate(weight);
            if (weightDate.length == 0) {
                return new InvalidCommand(ADD);
            }
            weight = weightDate[0];
            date = weightDate[1];
            params.put("food", food);
            params.put("weight", weight);
            params.put("date", date);
            return new AddCommand(DIET, params);
        }
        params.put("food", food);
        params.put("weight", weight);
        return new AddCommand(DIET, params);
    }

    private String[] getFoodAndFoodWeight(String content) {
        return content.split("w/", 2);
    }

    private Command prepareAddBodyWeight(String content) throws ParseException, TypeException, NumberFormatException {
        String weight = parseWeight(content, false);
        if (weight.equals("")) {
            return new InvalidCommand(ADD);
        }
        boolean hasDate = content.contains("date/");
        String date;
        if (hasDate) {
            String[] weightDate = getDate(weight);
            if (weightDate.length == 0) {
                return new InvalidCommand(ADD);
            }
            weight = weightDate[0];
            date = weightDate[1];
            params.put("weight", weight);
            params.put("date", date);
            return new AddCommand(BODY_WEIGHT, params);
        }
        params.put("weight", weight);
        return new AddCommand(BODY_WEIGHT, params);
    }

    private Command prepareAddExercise(String content) throws ParseException, TypeException, NumberFormatException {
        String[] activityDuration = getActivityAndDuration(content);
        if (activityDuration.length < 2) {
            return new InvalidCommand(ADD);
        }

        String activityRawInput = activityDuration[0].trim();
        String activity = parseExerciseActivity(activityRawInput, false);
        if (activity.equals("")) {
            return new InvalidCommand(ADD);
        }

        String durationRawInput = activityDuration[1].trim();
        String duration = parseDuration(durationRawInput, true);
        if (duration.equals("")) {
            return new InvalidCommand(ADD);
        }

        boolean hasDate = durationRawInput.contains("date/");
        String date;
        if (hasDate) {
            String[] durationDate = getDate(duration);
            if (durationDate.length == 0) {
                return new InvalidCommand(ADD);
            }
            duration = durationDate[0];
            date = durationDate[1];
            params.put("activity", activity);
            params.put("duration", duration);
            params.put("date", date);
            return new AddCommand(EXERCISE, params);
        }

        duration = duration.substring(2);
        params.put("activity", activity);
        params.put("duration", duration);
        return new AddCommand(EXERCISE, params);
    }

    private String[] getActivityAndDuration(String content) {
        return content.split("d/", 2);
    }
    /*
    private CommandRecordType parseType(String input) {
        boolean isTypeKeywordValid = input.startsWith("t/") && input.length() >= 3;
        if (!isTypeKeywordValid) {
            return INVALID;
        }
        String type = "" + input.charAt(2);
        if (!CommandRecordType.isValidType(type)) {
            return INVALID;
        }
        return type.toUpperCase(Locale.ROOT);
    }

    */

    private String parseExerciseActivity(String activityRawInput, boolean isPrefixChecked) {
        boolean isActivityValid;
        if (isPrefixChecked) {
            isActivityValid = activityRawInput.length() > 0;
            if (!isActivityValid) {
                return "";
            }
            return activityRawInput;
        } else {
            isActivityValid = activityRawInput.length() >= 3 && activityRawInput.startsWith("a/");
            if (!isActivityValid) {
                return "";
            }
            return activityRawInput.substring(2);
        }
    }

    private String parseWeight(String bodyWeightRawInput, boolean prefixChecked) {
        boolean isBodyWeightValid;
        if (prefixChecked) {
            isBodyWeightValid = bodyWeightRawInput.length() > 0;
            if (!isBodyWeightValid) {
                return "";
            }
            return bodyWeightRawInput;
        } else {
            isBodyWeightValid = bodyWeightRawInput.length() >= 3 && bodyWeightRawInput.startsWith("w/");
            if (!isBodyWeightValid) {
                return "";
            }
            return bodyWeightRawInput.substring(2);
        }
    }

    private String parseDuration(String durationRawInput, boolean prefixChecked) {
        boolean isDurationValid;
        if (prefixChecked) {
            isDurationValid = durationRawInput.length() > 0;
            if (!isDurationValid) {
                return "";
            }
            return durationRawInput;
        } else {
            isDurationValid = durationRawInput.length() >= 3 && durationRawInput.startsWith("d/");
            if (!isDurationValid) {
                return "";
            }
            return durationRawInput.substring(2);
        }
    }

    private String parseDiet(String dietRawInput, boolean prefixChecked) {
        boolean isDietValid;
        if (prefixChecked) {
            isDietValid = dietRawInput.length() > 0;
            if (!isDietValid) {
                return "";
            }
            return dietRawInput;
        } else {
            isDietValid = dietRawInput.length() >= 3 && dietRawInput.startsWith("f/");
            if (!isDietValid) {
                return "";
            }
            return dietRawInput.substring(2);
        }
    }

    public void clearParserParams() {
        params.clear();
    }

}
