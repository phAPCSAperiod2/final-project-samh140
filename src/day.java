public class day
{

    // each day is an object


    // expand upon budget, give different categories

    private budgetPlan budget;
    private double spending;


    // budget is an object, contains different categories
    // budgets will be edited

    // budgets will not be initialized to 0 similar to spending, budget must be used to create a day


    public day(budgetPlan budget, double spending)
    {
        budget = this.budget;
        spending = this.spending;
    }


    // initializes one day (without spending)
    public day(budgetPlan budget)
    {
        budget = this.budget;
        spending = 0;
    }


    public budgetPlan getBudget()
    {
        return budget;
    }

    public double getSpending()
    {
        return spending;
    }

    // name of each day of the week will be implemented in the tester

    // constructor
}
