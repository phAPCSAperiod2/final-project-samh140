import java.util.Scanner;

public class CalendarTester
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Calendar calendar = createCalendar(scanner);
        BudgetAnalyzer analyzer = new BudgetAnalyzer();

        runProgram(scanner, calendar, analyzer);

        scanner.close();
    }

    public static Calendar createCalendar(Scanner scanner)
    {
        System.out.print("Enter your two week income: ");
        double twoWeekIncome = scanner.nextDouble();

        System.out.print("Enter needs proportion: ");
        double needsProp = scanner.nextDouble();

        System.out.print("Enter wants proportion: ");
        double wantsProp = scanner.nextDouble();

        System.out.print("Enter savings proportion: ");
        double savingsProp = scanner.nextDouble();

        while(!validProportions(needsProp, wantsProp, savingsProp) || !validNumber(needsProp) || !validNumber(wantsProp) || !validNumber(savingsProp)) {
            System.out.println("Proportions must be nonnegative and must be equal to 1.");

            System.out.print("Re-enter needs proportion: ");
            needsProp = scanner.nextDouble();

            System.out.print("Re-enter wants proportion: ");
            wantsProp = scanner.nextDouble();

            System.out.print("Re-enter savings proportion: ");
            savingsProp = scanner.nextDouble();
        }

        return new Calendar(needsProp, wantsProp, savingsProp, twoWeekIncome);
    }

    public static void runProgram(Scanner scanner, Calendar calendar, BudgetAnalyzer analyzer)
    {

        boolean run = true;

        while(run) {
            displayMenu();

            int choice = scanner.nextInt();

            if (choice == 1) {
                editDay(scanner, calendar, analyzer);
            }
            else if (choice == 2) {
                calendar.updateOverBudgetDays(analyzer);
                System.out.println(calendar.displayOverBudgetDays());
            }
            else if (choice == 3) {
                run = false;
                System.out.println("Program ended.");
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("\n===== Budget Tracker =====");
        System.out.println("1. View/Edit Day");
        System.out.println("2. View Over Budget Days");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    public static void editDay(Scanner scanner, Calendar calendar, BudgetAnalyzer analyzer) {
        System.out.println("\n" + calendar);

        System.out.print("Choose a day (1-14): ");
        int dayNumber = scanner.nextInt();

        if (!calendar.isValidDayNumber(dayNumber)) {
            System.out.println("Invalid day number.");
            return;
        }

        Day selectedDay = calendar.getDay(dayNumber);

        System.out.println("\n===== Current Day Information =====");
        System.out.println(calendar.viewDay(dayNumber));

        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Edit Day");
        System.out.println("2. View Feedback");
        System.out.println("3. Return to Main Menu");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();

        if (choice == 1)
        {
            displayCategoryMenu();

            int categoryChoice = scanner.nextInt();

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            while (!validNumber(amount))
            {
                System.out.println("Amount cannot be negative.");

                System.out.print("Re-enter amount: ");
                amount = scanner.nextDouble();
            }

            if (categoryChoice == 1) {
                selectedDay.setSpendingForNeeds(amount);
            }
            else if (categoryChoice == 2) {
                selectedDay.setSpendingForWants(amount);
            }
            else if (categoryChoice == 3) {
                selectedDay.setSavingsAllocated(amount);
            }
            else {
                System.out.println("Invalid category.");
                return;
            }

            calendar.updateOverBudgetDays(analyzer);

            System.out.println("\n===== Updated Day Information =====");
            System.out.println(calendar.viewDay(dayNumber));
        }

        else if (choice == 2){
            chooseFeedback(scanner, analyzer, selectedDay);
        }
        else if (choice == 3) {
            System.out.println("Returning to main menu.");
        }
        else {
            System.out.println("Invalid choice.");
        }
    }

    public static void displayCategoryMenu() {
        System.out.println("\nChoose a category:");
        System.out.println("1. Needs");
        System.out.println("2. Wants");
        System.out.println("3. Savings");
        System.out.print("Choose an option: ");
    }

    public static void chooseFeedback(Scanner scanner, BudgetAnalyzer analyzer, Day day) {
        System.out.println("\n===== Feedback Menu =====");
        System.out.println("1. Needs Feedback");
        System.out.println("2. Wants Feedback");
        System.out.println("3. Savings Feedback");
        System.out.println("4. Total Spending Feedback");
        System.out.print("Choose feedback to view: ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            analyzer.getNeedsFeedback(day);
        }
        else if (choice == 2) {
            analyzer.getWantsFeedback(day);
        }
        else if (choice == 3) {
            analyzer.getSavingsFeedback(day);
        }
        else if (choice == 4) {
            analyzer.getTotalSpendingFeedback(day);
        }
        else {
            System.out.println("Invalid choice.");
        }
    }

    public static boolean validProportions(double needs, double wants, double savings)
    {
        return needs + wants + savings == 1;
    }

    public static boolean validNumber(double number)
    {
        return number >= 0;
    }
}
