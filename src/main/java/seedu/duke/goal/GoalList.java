package seedu.duke.goal;

import seedu.duke.common.Messages;
import seedu.duke.goal.comparator.GoalPeriodTypeComparator;
import seedu.duke.record.RecordType;

import java.util.ArrayList;

public class GoalList {
    private final ArrayList<Goal> goals = new ArrayList<>();
    private final RecordType goalType;

    public GoalList(RecordType type) {
        this.goalType = type;
    }

    public void addGoal(Goal newGoal) {
        goals.add(newGoal);
        goals.sort(new GoalPeriodTypeComparator());
    }

    public String removeGoal(int index) {
        Goal goalToRemove = goals.get(index);
        String goalSummary = goalToRemove.getGoalSummary();
        goals.remove(goalToRemove);
        return goalSummary;
    }

    public String getGoalsToPrint() {
        if (goals.isEmpty()) {
            return Messages.MESSAGE_NO_GOAL;
        } else {
            StringBuilder goalStringBuilder = new StringBuilder();
            int i = 1;
            for (Goal goal : goals) {
                goalStringBuilder.append(i).append(goal.getGoalData()).append("\n");
                i++;
            }
            return goalStringBuilder.toString();
        }
    }
}
