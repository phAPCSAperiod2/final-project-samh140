public class budgetAnalyzer {


    public boolean compareNeeds(Day day) {
        if (day.getDailyNeedsBudget() > day.getSpendingForNeeds()) {
            return true;
        }

        return false;
    }

    public boolean compareWants(Day day) {
        if (day.getDailyWantsBudget() > day.getSpendingForWants()) {
            return true;
        }

        return false;
    }

    public boolean compareSavings(Day day) {
        if (day.getDailySavingsBudget() <= day.getSpendingForSavings()) {
            return true;
        }

        return false;
    }


    public double calculateDayTotalSpending(Day day) {
        return day.getSpendingForNeeds() + day.getSpendingForWants() + day.getSpendingForSavings();
    }

    public boolean compareDayTotalSpending(Day day) {
        if (calculateDayTotalSpending(day) < day.getDailyIncome())
        {
            return true;
        }

        return false;
    }

    // feedback for one day
    public void getNeedsFeedback(Day day) {
        if (compareNeeds(day))
        {
            System.out.println("You are staying under budget.");
        }
        else {
            System.out.println("You are spending more on needs. Minimialize spending in other categories to keep your spending balanced!");
        }

    }

    public void getWantsFeedback(Day day) {
        if (compareWants(day))
        {
            System.out.println("You are staying under budget");
        }
        else {
            System.out.println("Prioritize your wants less! Focus on other categories.");
        }

    }

    public void getSavingsFeedback(Day day) {
        if (compareSavings(day))
        {
            System.out.println("Nice job saving. Keep it going!");
        }
        else {
            System.out.println("Make sure to stay consistent with your savings. Reduce spending in other categories to achieve this.");
        }

    }

    public void getTotalSpendingFeedback(Day day) {
        if (compareDayTotalSpending(day))
        {
            System.out.println("You are spending less than you make! This will help you in the long run.")
        }
        else {
            System.out.println("You spent more than you made today! Limit your spending!");
        }
    }

    // I want a method that generalizes the data for the two weeks.
    // feedback generalized to two weeks
}
