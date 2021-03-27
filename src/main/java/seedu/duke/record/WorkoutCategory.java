package seedu.duke.record;

import java.util.Locale;

public enum WorkoutCategory {
    WALKING,
    RUNNING,
    CYCLING,
    ELLIPTICAL,
    ROWER,
    STAIRSTEPPER,
    HIKING,
    HIIT,
    YOGA,
    DANCE,
    COOLDOWN,
    SWIMMING,
    CORETRAINING,
    INVALID;

    public static String getValidWorkoutList() {
        StringBuilder workoutList = new StringBuilder();
        int i = 1;
        for (WorkoutCategory workoutCategory : WorkoutCategory.values()) {
            if (!workoutCategory.equals(INVALID)) {
                workoutList.append(i).append(". ").append(workoutCategory.toString().toLowerCase(Locale.ROOT)).append("\n");
                i++;
            }
        }
        return workoutList.toString();
    }
}
