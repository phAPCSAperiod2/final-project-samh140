/**
 * The Day class represents a single day in the budget tracking system.
 * Each Day object tracks budget allocations (needs, wants, savings) and
 * actual spending for that day. This allows users to monitor their spending
 * against their budget categories.
 *
 * author: Sam Ho
 */
public class Day {

    private double needs; // Proportion of budget allocated for necessities
    private double wants; // Proportion of budget allocated for discretionary spending
    private double savings; // Proportion of budget allocated for savings


    private double spendingForNeeds; // Actual spending for necessities
    private double spendingForWants; // Actual spending for discretionary spending
    private double spendingForSavings; // Actual spending for savings

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

        this.spendingForNeeds = 0;
        this.spendingForWants = 0;
        this.spendingForSavings = 0;
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
     * Sets the spending for savings.
     *
     * @param spendingForSavings the amount spent on savings
     */
    public void setSpendingForSavings(double spendingForSavings) {
        this.spendingForSavings = spendingForSavings;
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
     * Returns the spending for savings.
     *
     * @return the spending for savings
     */
    public double getSpendingForSavings() {
        return spendingForSavings;
    }

    /**
     * Returns a string representation of the Day object.
     *
     * @return a string describing the budget plan and spending
     */
    @Override
    public String toString() {
        {
            return "Budget plan for today, in proportions:\nNeeds: " + needs + "\nWants: " + wants + "\nSavings: " + savings + "\n\nToday's spendings\nNeeds: $" + spendingForNeeds + "\nWants: $" + spendingForWants + "\nSavings: $" + spendingForSavings;
        }
    }
}
