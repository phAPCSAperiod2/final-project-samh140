public class budgetPlan
{

    // should be percentages, mulitply by weekly pay out

    private double needs;
    private double wants;
    private double savings;

    // should be percentages, mulitply by weekly pay out
    public budget(double needs, double wants, double savings)
    {
        needs = this.needs;
        wants = this.wants;
        savings = this.savings;
    }

    public budget()
    {
        needs = 0.5;
        wants = 0.25;
        wants = 0.25;
    }

    public getNeeds()
    {
        return needs;
    }

    public getWants()
    {
        return wants;
    }

    public getSavings()
    {
        return savings;
    }

    @Override @Override
    public String toString()
    {
        return "Your budget plan:\nNeeds - " + needs + "%\nWants - " + wants + "%\nSavings - " + savings + "%";
    }

}
