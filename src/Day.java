public class Day {

    // each day is an object

    // expand upon budget, give different categories

    // needs, wants, savings are part of the user's budget. Percentages

    private double needs;
    private double wants;
    private double savings;
    private double actualSpending;

    // budget is an object, contains different categories
    // budgets will be edited

    // budgets will not be initialized to 0 similar to spending, budget must be used
    // to create a day

    // constructor
    public Day(double needs, double wants, double savings) {
        this.needs = needs;
        this.wants = wants;
        this.savings = savings;
        this.actualSpending = 0;
    }
}
