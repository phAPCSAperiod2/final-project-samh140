public class calendarTester
{
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Day day = new Day(0.5, 0.5, 0.2, 500);
        System.out.println(day.toString());

        // instance of budgetAnalyzer
        budgetAnalyzer analyzer = new budgetAnalyzer();
        analyzer.getNeedsFeedback(day);

        Calendar calendar = new Calendar(0.5, 0.5, 0.2, 2000);
        System.out.println(calendar.toString());
        System.out.println(calendar.getDay(13));
    }
}



// ask for how much the user makes in main
