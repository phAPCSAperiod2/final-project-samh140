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


    public double calculateTotalSpending(Day day) {
        return day.getSpendingForNeeds() + day.getSpendingForWants() + day.getSpendingForSavings();
    }
}
