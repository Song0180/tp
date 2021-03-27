package seedu.duke.goal.comparator;

import seedu.duke.goal.Goal;
import seedu.duke.goal.PeriodType;

import java.util.Comparator;

public class GoalPeriodTypeComparator implements Comparator<Goal> {
    @Override
    public int compare(Goal goal1, Goal goal2) {
        PeriodType periodType1 = goal1.getPeriodType();
        PeriodType periodType2 = goal2.getPeriodType();
        if (PeriodType.getPeriodTypeWeight(periodType1) == PeriodType.getPeriodTypeWeight(periodType2)) {
            if (goal1.getDaySet().isBefore(goal2.getDaySet())) {
                return -1;
            } else if (goal1.getDaySet().isAfter(goal2.getDaySet())) {
                return 1;
            } else {
                return 0;
            }
        } else if (PeriodType.getPeriodTypeWeight(periodType1) < PeriodType.getPeriodTypeWeight(periodType2)) {
            return -1;
        } else {
            return 1;
        }
    }
}
