package seedu.duke.record;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * Represents a workout record.
 */
public class Workout {
    private HashMap<String, Integer> workOutCalPerMin;
    private WorkOutCategory category;
    private int duration;
    private double calories;

    /**
     * Initializes the object with given record type and date.
     *
     * @param type the type of the record.
     * @param date the date of the record.
     */
    public Workout(RecordType type, LocalDate date) {
        duration = 0;
        calories = 0;
    }

    /**
     * Returns the duration of the workout.
     *
     * @return an integer of the duration of the workout.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the workout.
     *
     * @param duration an integer of the duration of the workout.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Returns the total calories burnt during the workout.
     *
     * @return a floating number of the calories burnt during the workout.
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Gets the specific type of workout of this workout record.
     *
     * @return the type of the workout.
     */
    public WorkOutCategory getCategory() {
        return category;
    }

    /**
     * Calculates and returns the calories burnt during the workout.
     *
     * @return the calories burnt during the workout.
     */
    private double calculateCalories() {
        //not sure how to calculate this, formulae online require body weight.
        double bodyWeight = 50.0;
        double durationInHour = duration / 60d;
        int metValue = 12;
        calories = bodyWeight * metValue * durationInHour;
        return calories;
    }
}
