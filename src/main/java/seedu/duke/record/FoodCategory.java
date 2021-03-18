package seedu.duke.record;

import java.util.Locale;

public enum FoodCategory {
    VEGETABLE(25),
    PROTEIN(140),
    FRUIT(40),
    GRAIN(350),
    INVALID(0);
    private final double caloriePer100g;

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

    public static String getValidFoodList() {
        StringBuilder foodList = new StringBuilder();
        int i = 1;
        for (FoodCategory foodCategory : FoodCategory.values()) {
            foodList.append(i).append(". ").append(foodCategory);
            i++;
        }
        return foodList.toString();
    }
}
