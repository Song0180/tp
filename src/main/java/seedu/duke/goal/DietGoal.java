package seedu.duke.goal;

import seedu.duke.record.RecordType;

public class DietGoal extends Goal {
    private final double targetEnergy;
    private double progress;

    /**
     * Initialize an instance of an diet goal.
     *
     * @param periodType   the period type of the goal which can be daily or weekly.
     * @param targetEnergy the target energy to be consumed.
     */
    public DietGoal(PeriodType periodType, double targetEnergy) {
        super(RecordType.DIET, periodType);
        this.targetEnergy = targetEnergy;
        initializeProgress();
    }

    /**
     * Gets the the target energy to be consumed.
     *
     * @return the target energy to be consumed in kcal.
     */
    public double getTargetEnergy() {
        return targetEnergy;
    }

    /**
     * Gets the progress of the diet goal (energy consumed).
     *
     * @return the energy consumed in kcal.
     */
    public double getProgress() {
        return progress;
    }

    /**
     * Initializes the progress of the diet goal (energy consumed) to 0 kcal.
     */
    public void initializeProgress() {
        this.progress = 0;
    }

    /**
     * Updates the progress of the diet goal (energy consumed).
     *
     * @param progress the energy consumed in kcal.
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
                + "Target: " + getTargetEnergy() + "\n"
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
                + getTargetEnergy() + "\t"
                + getProgress() + "\n";
    }
}
