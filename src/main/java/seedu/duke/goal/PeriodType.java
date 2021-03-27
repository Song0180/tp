package seedu.duke.goal;

public enum PeriodType {
    DAILY, WEEKLY;

    public static int getPeriodTypeWeight(PeriodType periodType) {
        switch (periodType) {
        case DAILY:
            return 1;
        case WEEKLY:
            return 2;
        default:
            return 9999;
        }
    }
}
