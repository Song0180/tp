package seedu.duke.record;

import java.time.LocalDate;

public class Sleep extends Record {
    private int duration;

    /**
     * Initializes the object with given record type and date.
     *
     * @param type the type of the record.
     * @param date the date of the record.
     */
    public Sleep(RecordType type, LocalDate date) {
        super(type, date);
        duration = 0;
    }

    /**
     * Gets the duration of a sleep record.
     *
     * @return
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the sleep record.
     *
     * @param duration duration of the sleep record.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Returns the sleep record summary.
     *
     * @return a String of the record summary.
     */
    @Override
    public String getRecordSummary() {
        return getType() + ": " + getDuration() + " on " + getDate();
    }
}
