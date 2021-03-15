package seedu.duke.record;

import java.time.LocalDate;

public class Exercise extends Record {
    private double totalCalories;

    /**
     * Initializes the object with given record type and date.
     *
     * @param type the type of the record.
     * @param date the date of the record.
     */
    public Exercise(RecordType type, LocalDate date) {
        super(type, date);
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void printWorkOut() {
        //hehe
    }

    @Override
    public String getRecordSummary() {
        return null;
    }
}
