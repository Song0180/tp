package seedu.duke.record;

import java.util.Locale;

public enum FoodCategory {
    VEGETABLE(25),
    PROTEIN(140),
    FRUIT(40),
    GRAIN(350),
    INVALID(0);
    private final double caloriePer100g;
    public static final String validFoodList = "1.VEGETABLE\n2.FRUIT\n3.PROTEIN\n4.GRAIN";

    FoodCategory(double caloriePer100g) {
        this.caloriePer100g = caloriePer100g;
    }

    public double getCaloriePer100g() {
        return caloriePer100g;
    }

    public static FoodCategory getFoodCategory(String foodString) {
        for (int i = 0; i < FoodCategory.values().length; i++) {
            if (foodString.toUpperCase(Locale.ROOT).equals(FoodCategory.values()[i].toString())) {
                return FoodCategory.values()[i];
            }
        }
        return INVALID;
    }
}
