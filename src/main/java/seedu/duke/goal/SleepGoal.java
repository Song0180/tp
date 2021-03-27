package seedu.duke.goal;

import seedu.duke.record.RecordType;

public class SleepGoal extends Goal {
    private final double targetDuration;
    private double progress;

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType   the period type of the goal which can be daily or weekly.
     * @param targetDuration the target sleeping duration.
     */
    public SleepGoal(PeriodType periodType, double targetDuration) {
        super(RecordType.SLEEP, periodType);
        this.targetDuration = targetDuration;
        initializeProgress();
    }

    /**
     * Gets the the target sleeping duration.
     *
     * @return the target sleeping duration in hour(s).
     */
    public double getTargetDuration() {
        return targetDuration;
    }

    /**
     * Gets the progress of the sleeping duration goal.
     *
     * @return the sleeping duration in hour(s).
     */
    public double getProgress() {
        return progress;
    }

    /**
     * Initializes the progress of the sleeping duration to 0hour.
     */
    public void initializeProgress() {
        this.progress = 0;
    }

    /**
     * Updates the progress of the sleeping duration goal.
     *
     * @param progress the sleeping duration in hour(s).
     */
    public void updateProgress(double progress) {
        this.progress = progress;
    }

    /**
     * Gets a string summary of all info of this goal instance.
     *
     * @return a summary of all info of this goal instance in String.
     */
    @Override
    public String getGoalSummary() {
        return "Date Set: " + getDaySet().toString() + "\n"
                + "Goal Type: " + getType().toString().toLowerCase() + "\n"
                + "Target: " + getTargetDuration() + "\n"
                + "Progress: " + getProgress() + "\n";
    }

    /**
     * Gets all data of the goal in a table row.
     *
     * @return a string of all data of the goal in a table row.
     */
    @Override
    public String getGoalData() {
        return getDaySet().toString() + "\t"
                + getType().toString().toLowerCase() + "\t"
                + getTargetDuration() + "\t"
                + getProgress() + "\n";
    }
}
