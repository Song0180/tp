package seedu.duke.record;


import java.time.LocalDate;

/**
 * Represents the record for a type of Health info. Contains the date and type of the record.
 */
public abstract class Record {
    protected RecordType type;
    protected LocalDate date;

    /**
     * Gets the date of the record.
     *
     * @return the date of the record in LocalDate.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date of the record.
     *
     * @param date the date of the record in LocalDate.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets the type of the record.
     *
     * @return the type of the record defined in enum RecordType.
     */
    public RecordType getType() {
        return type;
    }

    /**
     * Gets a text summary of the record. To be implemented by child classes.
     *
     * @return a text summary of the record in String.
     */
    public abstract String getRecordSummary();
}
