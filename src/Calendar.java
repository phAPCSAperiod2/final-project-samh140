/**
 * Represents a two-week budget calendar composed of daily entries.
 * Each day is stored as a {@link Day} object, and the calendar can track
 * which days exceed the budget using a {@link BudgetAnalyzer}.
 *
 * @author Sam Ho
 * @collaborator ChatGPT
 */
import java.util.ArrayList;

public class Calendar {
    private Day[][] calendar;
    private final int WEEKS = 2;
    private final int DAYS_PER_WEEK = 7;
    private final int MINIMUM_DAY_NUMBER = 1;
    private final int MAXIMUM_DAY_NUMBER = 14;

    private ArrayList<Integer> overBudgetDays;

    /**
     * Constructs a two-week calendar and initializes each day with the
     * provided budget proportions and income.
     *
     * @param needsProp     the portion of income allocated to needs
     * @param wantsProp     the portion of income allocated to wants
     * @param savingsProp   the portion of income allocated to savings
     * @param twoWeekIncome the total income available for the two-week period
     */
    public Calendar(double needsProp, double wantsProp, double savingsProp, double twoWeekIncome) {
        calendar = new Day[WEEKS][DAYS_PER_WEEK];

        for (int row = 0; row < calendar.length; row++) {
            for (int column = 0; column < calendar[row].length; column++) {
                calendar[row][column] = new Day(needsProp, wantsProp, savingsProp, twoWeekIncome);
            }
        }

        overBudgetDays = new ArrayList<>();

    }

    /**
     * Checks whether the given day number is within the valid range.
     *
     * @param dayNumber the day number to validate
     * @return true when the day number is between 1 and 14, inclusive
     */
    public boolean isValidDayNumber(int dayNumber) {
        return dayNumber >= MINIMUM_DAY_NUMBER && dayNumber <= MAXIMUM_DAY_NUMBER;
    }

    /**
     * Returns the {@link Day} object for the specified day number.
     *
     * @param dayNumber the day number to retrieve
     * @return the Day at that position, or null if the day number is invalid
     */
    public Day getDay(int dayNumber) {
        if (!isValidDayNumber(dayNumber)) {
            return null;
        }

        int row = (dayNumber - 1) / 7;
        int column = (dayNumber - 1) % 7;
        return calendar[row][column];
    }

    /**
     * Returns a string representation of the specified day.
     *
     * @param dayNumber the day number to view
     * @return a textual description of the day, or an invalid message if the number
     *         is wrong
     */
    public String viewDay(int dayNumber) {
        Day day = getDay(dayNumber);

        if (day == null) {
            return "Invalid day number.";
        }

        return day.toString();
    }

    /**
     * Finds the calendar day number for the given Day object.
     *
     * @param target the Day object to locate
     * @return the day number or -1 if the day is not found
     */
    public int getDayNumber(Day target) {
        for (int row = 0; row < calendar.length; row++) {
            for (int column = 0; column < calendar[row].length; column++) {
                if (calendar[row][column] == target) {
                    return row * 7 + column + 1;
                }
            }
        }

        return -1;
    }

    /**
     * Updates the list of over-budget days by checking each day with the provided
     * analyzer.
     *
     * @param analyzer the BudgetAnalyzer used to validate daily spending
     */
    public void overBudgetDays(BudgetAnalyzer analyzer) {
        overBudgetDays.clear();

        for (int row = 0; row < calendar.length; row++) {
            for (int column = 0; column < calendar[row].length; column++) {
                Day selectedDay = calendar[row][column];
                int dayNumber = getDayNumber(selectedDay);

                if (!analyzer.compareDayTotalSpending(selectedDay)) {
                    overBudgetDays.add(dayNumber);
                }

            }
        }
    }

    /**
     * Returns a formatted list of days that exceeded the budget.
     *
     * @return a message showing the over-budget days or a message indicating none
     *         were found
     */
    public String displayOverBudgetDays() {
        if (overBudgetDays.isEmpty()) {
            return "No days are over budget.";
        }

        return "Over budget days: " + overBudgetDays;
    }

    /**
     * Returns a simple text representation of the calendar layout.
     *
     * @return the calendar organized by week and day numbers
     */
    public String toString() {
        String result = "";

        for (int row = 0; row < calendar.length; row++) {
            result += "Week " + (row + 1) + ":\n";

            for (int column = 0; column < calendar[row].length; column++) {
                int dayNumber = row * 7 + column + 1;
                result += "Day " + dayNumber + "      ";
            }
            result += "\n\n";
        }

        return result;
    }

}
