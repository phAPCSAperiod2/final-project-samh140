public class calendarTester
{
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Day day = new Day(0.5, 0.5, 0.2, 500);
        System.out.println(day.toString());

        // instance of budgetAnalyzer
        BudgetAnalyzer analyzer = new BudgetAnalyzer();
        analyzer.getNeedsFeedback(day);

        Calendar calendar = new Calendar(0.5, 0.5, 0.2, 2000);
        System.out.println(calendar.toString());
        System.out.println(calendar.getDay(13));



        System.out.println(day.getDailyIncome());
        Day selectedDay = calendar.getDay(3);

        selectedDay.setSpendingForNeeds(3000);
        calendar.overBudgetDays(analyzer);



        System.out.println(calendar.displayOverBudgetDays());
    }
}



// ask for how much the user makes in main
