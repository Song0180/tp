package seedu.duke.record;

import seedu.duke.exception.TypeException;

import java.time.LocalDate;

public class Exercise extends Record {
    private double calories;
    private final WorkoutCategory workoutCategory;
    private final int duration;


    public Exercise(String activityStr, int duration, LocalDate date) throws TypeException {
        super(RecordType.EXERCISE, date);
        try {
            workoutCategory = WorkoutCategory.valueOf(activityStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new TypeException("workout type exception");
        }
        this.duration = duration;
        this.calories = calculateCalories();
    }

    private double calculateCalories() {
        double bodyWeight = 50.0;
        double durationInHour = duration / 60d;
        int metValue = 12;
        calories = bodyWeight * metValue * durationInHour;
        return calories;
    }

    public double getCalories() {
        return calories;
    }

    public WorkoutCategory getWorkoutCategory() {
        return workoutCategory;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String getRecordSummary() {
        return getDuration() + " minutes of "
                + getWorkoutCategory() + " exercise on " + getDate().format(DATE_FORMATTER);
    }

    @Override
    public String getRecordData() {
        return "\t\t\t" + getDate().format(DATE_FORMATTER)
                + "\t" + getWorkoutCategory()
                + "\t\t\t" + getDuration() + " minute(s)"
                + "\t" + getCalories() + " cal";
    }
}
