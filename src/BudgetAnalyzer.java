/**
 * Provides budget analysis methods for a single {@link Day} object.
 *
 * This class compares actual spending against budgeted amounts and prints
 * feedback messages for needs, wants, savings, and total daily spending.
 *
 * @author: Sam Ho
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
     * Returns whether the savings allocation meets or exceeds the savings target.
     *
     * @param day the Day object containing savings allocation and budget values
     * @return true if savings allocation is greater than or equal to the savings
     *         budget, false otherwise
     */
    public boolean compareSavings(Day day) {
        if (day.getDailySavingsBudget() <= day.getSavingsAllocated()) {
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
        return day.getSpendingForNeeds() + day.getSpendingForWants() + day.getSavingsAllocated();
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
            System.out.println("You are under budget.");
        }
        else
        {
            if (!compareWants(day))
            {
                System.out.println("Reduce your spending in wants to balance your budget.");
            }
            else if (!compareSavings(day))
            {
                System.out.println("Make sure you are consistent with your saving plan. You can spend less on needs for the following days to balance your spending.");
            }
            else
            {
                System.out.println("You should spend less on your needs.");
            }

        }

    }



    /**
     * Prints feedback about wants spending for the given day.
     *
     * @param day the Day object to evaluate
     */
    public void getWantsFeedback(Day day) {
        if (compareWants(day)) {
            System.out.println("You are under budget");
        }
        else
        {
            if (!compareNeeds(day))
            {
                System.out.println("Prioritize your wants less! You are already over budget on needs.");
            }
            else if (!compareSavings(day))
            {
                System.out.println("Reduce your spending on your wants and invest in savings!");
            }
            else
            {
                System.out.println("You should spend less on your wants.");
            }

        }

    }

    /**
     * Prints feedback about savings for the given day.
     *
     * @param day the Day object to evaluate
     */
    public void getSavingsFeedback(Day day) {
        if (compareSavings(day)) {
            if (compareNeeds(day))
            {
                System.out.println("You can spend more on your needs. Make sure you are paying for everything you need!");
            }
            System.out.println("Nice job saving. Keep it going!");
        }
        else
        {
            if (!compareNeeds(day))
            {
                System.out.println("You should limit your spending on needs. Instead, invest more in your savings to stay consistent.");
            }
            else if (!compareWants(day))
            {
                System.out.println("Limit your spending on your wants and invest in savings!");
            }
            System.out.println("Stay consistant with your savings! It will help in the long run.");
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
        }
        else
        {
            System.out.println("You spent more than you made today! Limit your spending!");
        }
    }


}
