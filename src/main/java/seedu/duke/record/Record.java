package seedu.duke.record;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents the record for a type of Health info. Contains the date and type of the record.
 */
public abstract class Record {
    protected RecordType type;
    protected LocalDate date;
    protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final String SEPERATOR = " | ";

    /**
     * Initializes the object with given record type and date.
     *
     * @param type the type of the record.
     * @param date the date of the record.
     */
    public Record(RecordType type, LocalDate date) {
        this.type = type;
        this.date = date;
    }

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

    /**
     * Gets all data of the record in a table row.
     *
     * @return a string of all data of the record in a table row.
     */
    public abstract String getRecordData();

    public abstract String getRecordDataToStore();
}
