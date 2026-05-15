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
        System.out.println("Welcome! Create a budget calendar for your two-week income plan.");
        System.out.print("Enter your two week income: ");
        double twoWeekIncome = scanner.nextDouble();
        while(!validNumber(twoWeekIncome))
        {
            System.out.println("Please enter a nonnegative amount.");
            twoWeekIncome = scanner.nextDouble();
        }

        System.out.print("Enter proportion of income for NEEDS: ");
        double needsProp = scanner.nextDouble();

        System.out.print("Enter proportion of income for WANTS: ");
        double wantsProp = scanner.nextDouble();

        System.out.print("Enter proportion of income for SAVINGS: ");
        double savingsProp = scanner.nextDouble();

        while(!validProportions(needsProp, wantsProp, savingsProp) || !validNumber(needsProp) || !validNumber(wantsProp) || !validNumber(savingsProp)) {
            System.out.println("Proportions must be nonnegative and must be equal to 1.");

            System.out.print("Re-enter proportion of income for NEEDS: ");
            needsProp = scanner.nextDouble();

            System.out.print("Re-enter proportion of income for WANTS: ");
            wantsProp = scanner.nextDouble();

            System.out.print("Re-enter proportion of income for SAVINGS: ");
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
                System.out.println("\nInvalid choice.");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("\n===== Budget Tracker =====");
        System.out.println("1. View/Edit Day");
        System.out.println("2. View Days Over Budget");
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

        boolean editingDay = true;

        while(editingDay)
        {
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

                    calendar.updateOverBudgetDays(analyzer);

                    System.out.println("\n===== Updated Day Information =====");
                    System.out.println(calendar.viewDay(dayNumber));
                }
                else if (categoryChoice == 2) {
                    selectedDay.setSpendingForWants(amount);

                    calendar.updateOverBudgetDays(analyzer);

                    System.out.println("\n===== Updated Day Information =====");
                    System.out.println(calendar.viewDay(dayNumber));
                }
                else if (categoryChoice == 3) {
                    selectedDay.setSavingsAllocated(amount);

                    calendar.updateOverBudgetDays(analyzer);

                    System.out.println("\n===== Updated Day Information =====");
                    System.out.println(calendar.viewDay(dayNumber));
                }
                else {
                    System.out.println("Invalid category.");
                }
            }

            else if (choice == 2){
                chooseFeedback(scanner, analyzer, selectedDay);
            }
            else if (choice == 3) {
                editingDay = false;
                System.out.println("\nReturning to main menu.");
            }
            else {
                System.out.println("\nInvalid choice.");
            }
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
        boolean viewingFeedback = true;

        while (viewingFeedback)
        {
            System.out.println("\n===== Feedback Menu =====");
            System.out.println("1. Needs Feedback");
            System.out.println("2. Wants Feedback");
            System.out.println("3. Savings Feedback");
            System.out.println("4. Total Spending Feedback");
            System.out.println("5. Return to Day Menu");
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
            else if (choice == 5) {
                viewingFeedback = false;
                System.out.println("\nReturning to day menu.");
            }
            else {
                System.out.println("\nInvalid choice.");
            }
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
