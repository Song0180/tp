package seedu.duke.record;

import java.time.LocalDate;

public class Sleep extends Record {
    private final int duration;

    /**
     * Represents a record of sleeping data.
     *
     * @param duration the duration of the sleep.
     * @param date     the date of the sleep.
     */
    public Sleep(int duration, LocalDate date) {
        super(RecordType.SLEEP, date);
        this.duration = duration;
    }

    /**
     * Gets the duration of a sleep record.
     *
     * @return the duration of the sleep record.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Returns the sleep record summary.
     *
     * @return a String of the record summary.
     */
    @Override
    public String getRecordSummary() {
        return "Sleep of " + getDuration() + " hours on " + getDate();
    }
}
