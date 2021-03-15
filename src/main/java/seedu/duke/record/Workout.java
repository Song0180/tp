package seedu.duke.record;

import java.time.LocalDate;
import java.util.HashMap;

public class Workout {
    private HashMap<String, Integer> workOutCalPerMin;
    private WorkOutCategory category;
    private int duration;
    private double calories;

    public Workout(RecordType type, LocalDate date) {
        super();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getCalories() {
        return calories;
    }

    public WorkOutCategory getCategory() {
        return category;
    }

    private double calculateCalories() {
        //hehe
        return calories;
    }
}
