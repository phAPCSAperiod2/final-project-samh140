/**
 * Provides budget analysis methods for a single {@link Day} object.
 *
 * This class compares actual spending against budgeted amounts and prints
 * feedback messages for needs, wants, savings, and total daily spending.
 *
 *  author: Sam Ho
 */
public class BudgetAnalyzer {

    /**
     * Returns whether the spending for needs is below the needs budget.
     *
     * @param day the Day object containing spending and budget values
     * @return true if needs spending is less than the needs budget, false otherwise
     */
    public boolean compareNeeds(Day day) {
        if (day.getDailyNeedsBudget() > day.getSpendingForNeeds()) {
            return true;
        }

        return false;
    }

    /**
     * Returns whether the spending for wants is below the wants budget.
     *
     * @param day the Day object containing spending and budget values
     * @return true if wants spending is less than the wants budget, false otherwise
     */
    public boolean compareWants(Day day) {
        if (day.getDailyWantsBudget() > day.getSpendingForWants()) {
            return true;
        }

        return false;
    }

    /**
     * Returns whether the savings spending meets or exceeds the savings target.
     *
     * @param day the Day object containing spending and budget values
     * @return true if savings spending is greater than or equal to the savings
     *         budget, false otherwise
     */
    public boolean compareSavings(Day day) {
        if (day.getDailySavingsBudget() <= day.getSpendingForSavings()) {
            return true;
        }

        return false;
    }

    /**
     * Calculates the total spending for the day across needs, wants, and savings.
     *
     * @param day the Day object containing spending for each category
     * @return the total spending for the day
     */
    public double calculateDayTotalSpending(Day day) {
        return day.getSpendingForNeeds() + day.getSpendingForWants() + day.getSpendingForSavings();
    }

    /**
     * Returns whether total spending is below the daily income.
     *
     * @param day the Day object containing total spending and daily income
     * @return true if total spending is less than daily income, false otherwise
     */
    public boolean compareDayTotalSpending(Day day) {
        if (calculateDayTotalSpending(day) < day.getDailyIncome()) {
            return true;
        }

        return false;
    }

    /**
     * Prints feedback about needs spending for the given day.
     *
     * @param day the Day object to evaluate
     */
    public void getNeedsFeedback(Day day) {
        if (compareNeeds(day)) {
            System.out.println("You are staying under budget.");
        } else {
            System.out.println(
                    "You are spending more on needs. Minimialize spending in other categories to keep your spending balanced!");
        }

    }

    /**
     * Prints feedback about wants spending for the given day.
     *
     * @param day the Day object to evaluate
     */
    public void getWantsFeedback(Day day) {
        if (compareWants(day)) {
            System.out.println("You are staying under budget");
        } else {
            System.out.println("Prioritize your wants less! Focus on other categories.");
        }

    }

    /**
     * Prints feedback about savings for the given day.
     *
     * @param day the Day object to evaluate
     */
    public void getSavingsFeedback(Day day) {
        if (compareSavings(day)) {
            System.out.println("Nice job saving. Keep it going!");
        } else {
            System.out.println(
                    "Make sure to stay consistent with your savings. Reduce spending in other categories to achieve this.");
        }

    }

    /**
     * Prints feedback about total daily spending relative to income.
     *
     * @param day the Day object to evaluate
     */
    public void getTotalSpendingFeedback(Day day) {
        if (compareDayTotalSpending(day)) {
            System.out.println("You are spending less than you make! This will help you in the long run.");
        } else {
            System.out.println("You spent more than you made today! Limit your spending!");
        }
    }

    // I want a method that generalizes the data for the two weeks.
    // feedback generalized to two weeks

    // every day is an object that can be edited. The user can choose feedback they
    // want to see.
    // values that they do not edit are equal to 0, can still get feedback on them.

    // the user will gain full access to the calendar, can edit any days they want,
    // until they complete the week (or choose to compelete it).
    // complete the week, get feedback for whole week.
}
