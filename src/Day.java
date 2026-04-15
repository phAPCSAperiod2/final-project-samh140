/**
 * The Day class represents a single day in the budget tracking system.
 * Each Day object tracks budget allocations (needs, wants, savings) and
 * actual spending for that day. This allows users to monitor their spending
 * against their budget categories.
 *
 * author: Sam Ho
 */
public class Day {

    private double needs; // Budget allocated for necessities
    private double wants; // Budget allocated for discretionary spending
    private double savings; // Budget allocated for savings
    private double actualSpending; // Actual amount spent on this day

    /**
     * Constructs a Day object with specified budget allocations.
     *
     * @param needs   the amount budgeted for necessities
     * @param wants   the amount budgeted for discretionary spending
     * @param savings the amount budgeted for savings
     */
    public Day(double needs, double wants, double savings) {
        this.needs = needs;
        this.wants = wants;
        this.savings = savings;
        this.actualSpending = 0;
    }

    /**
     * Sets the actual amount spent on this day.
     *
     * @param actualSpending the amount actually spent
     */
    public void setActualSpending(double actualSpending) {
        this.actualSpending = actualSpending;
    }

    /**
     * Returns the budget allocated for necessities.
     *
     * @return the needs budget amount
     */
    public double getNeeds() {
        return needs;
    }

    /**
     * Returns the budget allocated for discretionary spending.
     *
     * @return the wants budget amount
     */
    public double getWants() {
        return wants;
    }

    /**
     * Returns the budget allocated for savings.
     *
     * @return the savings budget amount
     */
    public double getSavings() {
        return savings;
    }

    /**
     * Returns the actual amount spent on this day.
     *
     * @return the actual spending amount
     */
    public double getActualSpending() {
        return actualSpending;
    }


    @Override @Override
    public String toString() {
        {
            return "Budget plan for today:\nNeeds: " + needs + "%\nWants: " + wants + "%\nSavings: " + savings  + "%\nYour Spendings: $" + actualSpending;
        }
    }
}
