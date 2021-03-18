package seedu.duke.exception;

import seedu.duke.common.Messages;
import seedu.duke.record.FoodCategory;
import seedu.duke.record.WorkoutCategory;

public class TypeException extends Exception {
    private String invalidType;

    public TypeException(String type) {
        invalidType = type;
    }

    public String toString() {
        if (invalidType.equals("food type exception")) {
            return Messages.MESSAGE_INVALID_FOOD_CATEGORY
                    + FoodCategory.getValidFoodList();
        }
        if (invalidType.equals("workout type exception")) {
            return Messages.MESSAGE_INVALID_WORKOUT_CATEGORY
                    + WorkoutCategory.getValidWorkoutList();
        }
        return "";
    }
}
