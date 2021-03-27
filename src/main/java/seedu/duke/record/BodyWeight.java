package seedu.duke.record;

import java.time.LocalDate;

public class BodyWeight extends Record {
    private final double weight;

    public BodyWeight(double weight, LocalDate date) {
        super(RecordType.BODYWEIGHT, date);
        this.weight = weight;
    }

    /**
     * Gets the weight date.
     *
     * @return the user's weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets the body weight summary.
     *
     * @return the summary of body weight.
     */
    @Override
    public String getRecordSummary() {
        return "Body weight " + getWeight() + "Kg on " + getDate().format(DATE_FORMATTER);
    }

    @Override
    public String getRecordData() {
        return "\t\t\t" + getDate().format(DATE_FORMATTER)
                + "\t\t" + getWeight() + " Kg";
    }

    @Override
    public String getRecordDataToStore() {
        return "W"  + SEPERATOR + weight + SEPERATOR + getDate().format(DATE_FORMATTER);
    }
}
