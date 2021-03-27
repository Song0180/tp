package seedu.duke.record;

import seedu.duke.exception.TypeException;

import java.time.LocalDate;
import java.util.Locale;

import static seedu.duke.record.FoodCategory.INVALID;
import static seedu.duke.record.RecordType.DIET;

public class Diet extends Record {
    private final double calorie;
    private final FoodCategory foodCategory;
    private final double amount;
    private final String formattedDate;
    private static final String SUMMARY_FORMAT = "%sg %s on %s";
    private int spaceCount;
    private String seperator = "";

    /**
     * Initializes the object with given record type and date.
     *
     * @param date the date of the record.
     */
    public Diet(String foodString, String amountString, LocalDate date) throws TypeException, NumberFormatException {
        super(DIET, date);
        foodCategory = FoodCategory.getFoodCategory(foodString);
        if (foodCategory == INVALID) {
            throw new TypeException("food type exception");
        }
        spaceCount = 20 - foodCategory.toString().length();
        for (int i = 0; i < spaceCount; i++) {
            seperator += " ";
        }
        amount = Double.parseDouble(amountString);
        calorie = amount * foodCategory.getCaloriePer100g();
        this.date = date;
        formattedDate = date.format(DATE_FORMATTER);
    }

    /**
     * Gets the calorie of the food.
     *
     * @return the calorie of the food.
     */
    public double getCalorie() {
        return calorie;
    }

    /**
     * Gets the weight of the food in g.
     *
     * @return the weight of the food in g.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the category of the food.
     *
     * @return the category of the food.
     */
    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    /**
     * Gets the summary of users' diet record.
     *
     * @return the diet summary.
     */
    @Override
    public String getRecordSummary() {
        return String.format(SUMMARY_FORMAT, "" + amount,
                foodCategory.toString().toLowerCase(Locale.ROOT), formattedDate);
    }

    /**
     * Gets the record data of this diet record in a row.
     *
     * @return a string of the record data of this diet record in a row.
     */
    @Override
    public String getRecordData() {
        return "\t\t\t" + getDate().format(DATE_FORMATTER)
                + "\t" + getFoodCategory()
                + seperator + getAmount() + " g"
                + "\t\t" + getCalorie() + " cal";
    }
}
