package seedu.duke.record;

import seedu.duke.exception.TypeException;

import java.time.LocalDate;
import java.util.Locale;

import static seedu.duke.record.FoodCategory.INVALID;
import static seedu.duke.record.RecordType.DIET;

public class Diet extends Record {
    private double calorie;
    private final FoodCategory foodCategory;
    private final double amount;
    private final LocalDate date;
    private final String formattedDate;
    private static final String SUMMARY_FORMAT = "%sg %s on %s";
    private static final String LIST_VIEW_FORMAT = "%s     %s      %sg";

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
        amount = Double.parseDouble(amountString);
        calorie = amount * foodCategory.getCaloriePer100g();
        this.date = date;
        formattedDate = date.format(DATE_FORMATTER);
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

    public String getListViewFormat() {
        return String.format(SUMMARY_FORMAT,
                foodCategory.toString().toLowerCase(Locale.ROOT), "" + amount, formattedDate);
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }
}
