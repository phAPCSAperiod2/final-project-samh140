/**
 * The Day class represents a single day in the budget tracking system.
 * Each Day object tracks budget allocations (needsProp, wantsProp, savingsProp)
 * and
 * actual spending for that day. This allows users to monitor their spending
 * against their budget categories.
 *
 * @author: Sam Ho
 */
public class Day {

    private double needsProp; // Proportion of budget allocated for necessities
    private double wantsProp; // Proportion of budget allocated for discretionary spending
    private double savingsProp; // Proportion of budget allocated for savings

    private double dailyIncome;

    private double dailyNeedsBudget;
    private double dailyWantsBudget;
    private double dailySavingsBudget;

    private double spendingForNeeds; // Actual spending for necessities
    private double spendingForWants; // Actual spending for discretionary spending
    private double savingsAllocated; // Actual amount allocated to savings

    /**
     * Constructs a Day object with specified budget allocations.
     *
     * @param needsProp   the proportion budgeted for necessities
     * @param wantsProp   the proportion budgeted for discretionary spending
     * @param savingsProp the proportion budgeted for savings
     */
    public Day(double needsProp, double wantsProp, double savingsProp, double twoWeekIncome) {
        this.needsProp = needsProp;
        this.wantsProp = wantsProp;
        this.savingsProp = savingsProp;

        dailyIncome = twoWeekIncome / 14;

        this.dailyNeedsBudget = dailyIncome * needsProp;
        this.dailyWantsBudget = dailyIncome * wantsProp;
        this.dailySavingsBudget = dailyIncome * savingsProp;

        this.spendingForNeeds = 0;
        this.spendingForWants = 0;
        this.savingsAllocated = 0;
    }

    /**
     * Sets the spending for needs.
     *
     * @param spendingForNeeds the amount spent on needs
     */
    public void setSpendingForNeeds(double spendingForNeeds) {
        this.spendingForNeeds = spendingForNeeds;
    }

    /**
     * Sets the spending for wants.
     *
     * @param spendingForWants the amount spent on wants
     */
    public void setSpendingForWants(double spendingForWants) {
        this.spendingForWants = spendingForWants;
    }

    /**
     * Sets the amount allocated for savings for the day.
     *
     * @param savingsAllocated the amount allocated toward savings
     */
    public void setSavingsAllocated(double savingsAllocated) {
        this.savingsAllocated = savingsAllocated;
    }

    /**
     * Returns the budget allocated for necessities.
     *
     * @return the needs budget amount
     */
    public double getNeedsProp() {
        return needsProp;
    }

    /**
     * Returns the budget allocated for discretionary spending.
     *
     * @return the wants budget amount
     */
    public double getWantsProp() {
        return wantsProp;
    }

    /**
     * Returns the budget allocated for savings.
     *
     * @return the savings budget amount
     */
    public double getSavingsProp() {
        return savingsProp;
    }

    /**
     * Returns the daily budget for necessities.
     *
     * @return the daily needs budget amount
     */
    public double getDailyNeedsBudget() {
        return dailyNeedsBudget;
    }

    /**
     * Returns the daily budget for discretionary spending.
     *
     * @return the daily wants budget amount
     */
    public double getDailyWantsBudget() {
        return dailyWantsBudget;
    }

    /**
     * Returns the daily budget for savings.
     *
     * @return the daily savings budget amount
     */
    public double getDailySavingsBudget() {
        return dailySavingsBudget;
    }

    /**
     * Returns the spending for needs.
     *
     * @return the spending for needs
     */
    public double getSpendingForNeeds() {
        return spendingForNeeds;
    }

    /**
     * Returns the spending for wants.
     *
     * @return the spending for wants
     */
    public double getSpendingForWants() {
        return spendingForWants;
    }

    /**
     * Returns the amount allocated for savings for the day.
     *
     * @return the daily savings allocation amount
     */
    public double getSavingsAllocated() {
        return savingsAllocated;
    }

    public double getDailyIncome() {
        return dailyIncome;
    }

    /**
     * Returns a string representation of the Day object.
     *
     * @return a string describing the budget plan and spending
     */
    @Override
    public String toString() {
        {
            return "Budget plan for today, in proportions:\nNeeds: " + needsProp + "\nWants: " + wantsProp
                    + "\nSavings: " + savingsProp + "\n\nToday's spendings\nNeeds: $" + spendingForNeeds + "\nWants: $"
                    + spendingForWants + "\nSavings: $" + savingsAllocated;
        }
    }
}
