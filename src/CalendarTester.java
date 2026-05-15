import java.util.Scanner;

/**
 * A simple console-based tester for the budgeting calendar application.
 * <p>
 * This class handles user interaction, menu display, and day editing for
 * a two-week budget plan using {@link Calendar} and {@link BudgetAnalyzer}.
 *
 * @author Sam Ho
 * @collaborator ChatGPT
 */
public class CalendarTester {
    /**
     * Application entry point. Creates the calendar, budget analyzer, and
     * starts the main program loop.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Calendar calendar = createCalendar(scanner);
        BudgetAnalyzer analyzer = new BudgetAnalyzer();

        runProgram(scanner, calendar, analyzer);

        scanner.close();
    }

    /**
     * Prompts the user for income and budget proportions, validates the input,
     * and returns a configured {@link Calendar} instance.
     *
     * @param scanner the scanner used to read keyboard input
     * @return a new Calendar configured with the provided proportions and income
     */
    public static Calendar createCalendar(Scanner scanner) {
        System.out.println("Welcome! Create a budget calendar for your two-week income plan.");
        System.out.print("Enter your two week income: ");
        double twoWeekIncome = scanner.nextDouble();
        while (!validNumber(twoWeekIncome)) {
            System.out.println("Please enter a nonnegative amount.");
            twoWeekIncome = scanner.nextDouble();
        }

        System.out.print("Enter proportion of income for NEEDS: ");
        double needsProp = scanner.nextDouble();

        System.out.print("Enter proportion of income for WANTS: ");
        double wantsProp = scanner.nextDouble();

        System.out.print("Enter proportion of income for SAVINGS: ");
        double savingsProp = scanner.nextDouble();

        while (!validProportions(needsProp, wantsProp, savingsProp) || !validNumber(needsProp)
                || !validNumber(wantsProp) || !validNumber(savingsProp)) {
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

    /**
     * Runs the main program loop, presenting the user with the primary menu
     * and handling menu selections.
     *
     * @param scanner  the scanner used to read keyboard input
     * @param calendar the calendar containing the 14-day budget data
     * @param analyzer the budget analyzer used for feedback and over-budget checks
     */
    public static void runProgram(Scanner scanner, Calendar calendar, BudgetAnalyzer analyzer) {

        boolean run = true;

        while (run) {
            displayMenu();

            int choice = scanner.nextInt();

            if (choice == 1) {
                editDay(scanner, calendar, analyzer);
            } else if (choice == 2) {
                calendar.updateOverBudgetDays(analyzer);
                System.out.println(calendar.displayOverBudgetDays());
            } else if (choice == 3) {
                run = false;
                System.out.println("Program ended.");
            } else {
                System.out.println("\nInvalid choice.");
            }
        }
    }

    /**
     * Prints the main menu options for the budget tracker application.
     */
    public static void displayMenu() {
        System.out.println("\n===== Budget Tracker =====");
        System.out.println("1. View/Edit Day");
        System.out.println("2. View Days Over Budget");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Allows the user to select a day and either edit spending values or view
     * feedback for that day.
     *
     * @param scanner  the scanner used to read keyboard input
     * @param calendar the calendar containing the day entries
     * @param analyzer the budget analyzer used to update budget status and feedback
     */
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

        while (editingDay) {
            System.out.println("\n===== Current Day Information =====");
            System.out.println(calendar.viewDay(dayNumber));

            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Edit Day");
            System.out.println("2. View Feedback");
            System.out.println("3. Return to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                displayCategoryMenu();

                int categoryChoice = scanner.nextInt();

                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                while (!validNumber(amount)) {
                    System.out.println("Amount cannot be negative.");

                    System.out.print("Re-enter amount: ");
                    amount = scanner.nextDouble();
                }

                if (categoryChoice == 1) {
                    selectedDay.setSpendingForNeeds(amount);

                    calendar.updateOverBudgetDays(analyzer);

                    System.out.println("\n===== Updated Day Information =====");
                    System.out.println(calendar.viewDay(dayNumber));
                } else if (categoryChoice == 2) {
                    selectedDay.setSpendingForWants(amount);

                    calendar.updateOverBudgetDays(analyzer);

                    System.out.println("\n===== Updated Day Information =====");
                    System.out.println(calendar.viewDay(dayNumber));
                } else if (categoryChoice == 3) {
                    selectedDay.setSavingsAllocated(amount);

                    calendar.updateOverBudgetDays(analyzer);

                    System.out.println("\n===== Updated Day Information =====");
                    System.out.println(calendar.viewDay(dayNumber));
                } else {
                    System.out.println("Invalid category.");
                }
            }

            else if (choice == 2) {
                chooseFeedback(scanner, analyzer, selectedDay);
            } else if (choice == 3) {
                editingDay = false;
                System.out.println("\nReturning to main menu.");
            } else {
                System.out.println("\nInvalid choice.");
            }
        }
    }

    /**
     * Prints the category selection menu for editing a day's budget values.
     */
    public static void displayCategoryMenu() {
        System.out.println("\nChoose a category:");
        System.out.println("1. Needs");
        System.out.println("2. Wants");
        System.out.println("3. Savings");
        System.out.print("Choose an option: ");
    }

    /**
     * Presents feedback options for the selected day and forwards the choice
     * to the appropriate analyzer method.
     *
     * @param scanner  the scanner used to read keyboard input
     * @param analyzer the budget analyzer used to generate feedback messages
     * @param day      the day for which feedback is requested
     */
    public static void chooseFeedback(Scanner scanner, BudgetAnalyzer analyzer, Day day) {
        boolean viewingFeedback = true;

        while (viewingFeedback) {
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
            } else if (choice == 2) {
                analyzer.getWantsFeedback(day);
            } else if (choice == 3) {
                analyzer.getSavingsFeedback(day);
            } else if (choice == 4) {
                analyzer.getTotalSpendingFeedback(day);
            } else if (choice == 5) {
                viewingFeedback = false;
                System.out.println("\nReturning to day menu.");
            } else {
                System.out.println("\nInvalid choice.");
            }
        }
    }

    /**
     * Checks whether the budget proportions are valid by verifying that they
     * add up to exactly 1.
     *
     * @param needs   the needs proportion
     * @param wants   the wants proportion
     * @param savings the savings proportion
     * @return true if the proportions sum to 1, false otherwise
     */
    public static boolean validProportions(double needs, double wants, double savings) {
        return needs + wants + savings == 1;
    }

    /**
     * Checks whether a numerical input is nonnegative.
     *
     * @param number the value to validate
     * @return true if the number is zero or positive, false otherwise
     */
    public static boolean validNumber(double number) {
        return number >= 0;
    }
}
