public class calendarTester
{
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Day day = new Day(0.5, 0.5, 0.2, 500);
        System.out.println(day.toString());

        // instance of budgetAnalyzer
        budgetAnalyzer analyzer = new budgetAnalyzer();
        analyzer.getNeedsFeedback(day);
    }
}



// ask for how much the user makes in main
