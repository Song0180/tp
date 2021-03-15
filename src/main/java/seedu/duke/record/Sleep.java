package seedu.duke.record;

import java.time.LocalDate;

public class Sleep extends Record {
    private int duration;

    public Sleep(RecordType type, LocalDate date) {
        super(type, date);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String getRecordSummary() {
        return "You have slept for " + duration + " minutes!";
    }
}
