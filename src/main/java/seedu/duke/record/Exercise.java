package seedu.duke.record;

import java.time.LocalDate;

public class Exercise extends Record {
    private double totalCalories;
    Workout workout;

    /**
     * Initializes the object with given record type and date.
     *
     * @param type the type of the record.
     * @param date the date of the record.
     */
    public Exercise(RecordType type, LocalDate date) {
        super(type, date);
        totalCalories = 0;
    }

    /**
     * Returns total calories of exercises.
     *
     * @return a float number of total calories.
     */
    public double getTotalCalories() {
        return totalCalories;
    }

    /**
     * Prints the workouts done.
     */
    public void printWorkOuts() {
        System.out.print(workout.getCategory());
    }

    public Workout getWorkout() {
        return workout;
    }

    /**
     * Gets a summary of the record.
     *
     * @return a String of a summary of the record.
     */
    @Override
    public String getRecordSummary() {
        return workout.getCategory() + ": " + workout.getCalories() + " for "
                + workout.getDuration() + " on " + this.getDate();
    }
}
