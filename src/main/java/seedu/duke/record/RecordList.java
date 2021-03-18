package seedu.duke.record;

import seedu.duke.common.Messages;
import seedu.duke.record.comparator.RecordDateComparator;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents the list that contains all records of one type.
 */
public class RecordList {
    private final ArrayList<Record> records = new ArrayList<>();
    private final RecordType type;

    public RecordList(RecordType type) {
        this.type = type;
    }

    /**
     * Adds a record to the current list.
     *
     * @param newRecord the new record to add.
     */
    public void addRecord(Record newRecord) {
        records.add(newRecord);
        records.sort(new RecordDateComparator());
    }

    /**
     * Removes a record from the current list by index.
     * Return the summary of the deleted record.
     *
     * @param index the index of the record.
     */
    public String removeRecord(int index) {
        Record recordToRemove = records.get(index);
        String recordSummary = recordToRemove.getRecordSummary();
        records.remove(index);
        return recordSummary;
    }

    /**
     * Gets all records in a string.
     *
     * @return a string of all records.
     */
    public String getRecordsToPrint() {
        if (records.isEmpty()) {
            return Messages.MESSAGE_NO_RECORD;
        } else {
            StringBuilder recordStringBuilder = new StringBuilder();
            for (Record record : records) {
                recordStringBuilder.append(record.getRecordSummary()).append("\n");
            }
            return recordStringBuilder.toString();
        }
    }

    /**
     * Gets all records with a given date in a string.
     *
     * @param date the date of the record.
     * @return a string of all records with a given date.
     */
    public String getRecordsToPrint(LocalDate date) {
        if (records.isEmpty()) {
            return Messages.MESSAGE_NO_RECORD;
        } else {
            StringBuilder recordStringBuilder = new StringBuilder();
            for (Record record : records) {
                if (record.getDate().isEqual(date)) {
                    recordStringBuilder.append(record.getRecordSummary()).append("\n");
                }
            }
            boolean hasRecord = recordStringBuilder.length() != 0;
            if (!hasRecord) {
                recordStringBuilder.append(Messages.MESSAGE_NO_RECORD);
            }
            return recordStringBuilder.toString();
        }
    }

    /**
     * Gets all records that match the pattern in the given parameter.
     *
     * @param optionalParam an optional parameter for filtering the records.
     * @return a string of all records that match the pattern in the given parameter.
     */
    public String getRecordsToPrint(String optionalParam) {
        if (records.isEmpty()) {
            return Messages.MESSAGE_NO_RECORD;
        } else {
            StringBuilder recordStringBuilder = new StringBuilder();
            if (type.equals(RecordType.EXERCISE)) {
                return getExerciseRecordString(optionalParam, recordStringBuilder);
            } else if (type.equals(RecordType.DIET)) {
                return getDietRecordString(optionalParam, recordStringBuilder);
            } else {
                return Messages.MESSAGE_CANT_VIEW_LIST;
            }
        }
    }

    /**
     * Gets all records that match the pattern in the given parameter on a given date.
     *
     * @param date          the date of the record.
     * @param optionalParam an optional parameter for filtering the records.
     * @return a string of all records that match the pattern in the given parameter on a given date.
     */
    public String getRecordsToPrint(LocalDate date, String optionalParam) {
        if (records.isEmpty()) {
            return Messages.MESSAGE_NO_RECORD;
        } else {
            StringBuilder recordStringBuilder = new StringBuilder();
            if (type.equals(RecordType.EXERCISE)) {
                return getExerciseRecordString(date, optionalParam, recordStringBuilder);
            } else if (type.equals(RecordType.DIET)) {
                return getDietRecordString(date, optionalParam, recordStringBuilder);
            } else {
                return Messages.MESSAGE_CANT_VIEW_LIST;
            }
        }
    }

    private FoodCategory parseStringToFoodCategory(String optionalParam) throws IllegalArgumentException {
        return FoodCategory.valueOf(optionalParam.toUpperCase());
    }

    private WorkOutCategory parseStringToWorkoutCategory(String optionalParam) throws IllegalArgumentException {
        return WorkOutCategory.valueOf(optionalParam.toUpperCase());
    }
    
    private String getDietRecordString(String optionalParam, StringBuilder recordStringBuilder) {
        for (Record record : records) {
            Diet diet = (Diet) record;
            FoodCategory paramCategory = getFoodCategory(optionalParam);
            if (diet.getFoodCategory().equals(paramCategory)) {
                recordStringBuilder.append(record.getRecordSummary()).append("\n");
            }
        }
        boolean hasRecord = recordStringBuilder.length() != 0;
        if (!hasRecord) {
            recordStringBuilder.append(Messages.MESSAGE_NO_RECORD);
        }
        return recordStringBuilder.toString();
    }

    private String getDietRecordString(LocalDate date, String optionalParam, StringBuilder recordStringBuilder) {
        for (Record record : records) {
            Diet diet = (Diet) record;
            FoodCategory paramCategory = getFoodCategory(optionalParam);
            if (diet.getDate().isEqual(date) && diet.getFoodCategory().equals(paramCategory)) {
                recordStringBuilder.append(record.getRecordSummary()).append("\n");
            }
        }
        boolean hasRecord = recordStringBuilder.length() != 0;
        if (!hasRecord) {
            recordStringBuilder.append(Messages.MESSAGE_NO_RECORD);
        }
        return recordStringBuilder.toString();
    }


    private String getExerciseRecordString(String optionalParam, StringBuilder recordStringBuilder) {
        for (Record record : records) {
            Exercise exercise = (Exercise) record;
            WorkOutCategory paramCategory = getWorkOutCategory(optionalParam);
            if (exercise.getWorkout().getCategory().equals(paramCategory)) {
                recordStringBuilder.append(record.getRecordSummary()).append("\n");
            }
        }
        boolean hasRecord = recordStringBuilder.length() != 0;
        if (!hasRecord) {
            recordStringBuilder.append(Messages.MESSAGE_NO_RECORD);
        }
        return recordStringBuilder.toString();
    }

    private String getExerciseRecordString(LocalDate date, String optionalParam, StringBuilder recordStringBuilder) {
        for (Record record : records) {
            Exercise exercise = (Exercise) record;
            WorkOutCategory paramCategory = getWorkOutCategory(optionalParam);
            if (exercise.getDate().isEqual(date) && exercise.getWorkout().getCategory().equals(paramCategory)) {
                recordStringBuilder.append(record.getRecordSummary()).append("\n");
            }
        }
        boolean hasRecord = recordStringBuilder.length() != 0;
        if (!hasRecord) {
            recordStringBuilder.append(Messages.MESSAGE_NO_RECORD);
        }
        return recordStringBuilder.toString();
    }

    private FoodCategory getFoodCategory(String optionalParam) {
        FoodCategory paramCategory;
        try {
            paramCategory = parseStringToFoodCategory(optionalParam);
        } catch (IllegalArgumentException e) {
            paramCategory = FoodCategory.INVALID;
        }
        return paramCategory;
    }

    private WorkOutCategory getWorkOutCategory(String optionalParam) {
        WorkOutCategory paramCategory;
        try {
            paramCategory = parseStringToWorkoutCategory(optionalParam);
        } catch (IllegalArgumentException e) {
            paramCategory = WorkOutCategory.INVALID;
        }
        return paramCategory;
    }
}
