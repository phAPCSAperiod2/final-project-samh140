Budget Plan Calendar

What Does This Software Do?
This software creates a 2D array with 2 rows representing two weeks and 7 columns representing the days of each week, containing Day objects that represent a two-week calendar. It asks the user for their two-week income and budget plan, and how much money they should allocate their income between the categories Needs, Wants, and Savings. Then, the user can input their spending for each day and receive feedback on how to maintain a balanced budget.

Who Is This Software For?
Young adults and adults (18 - 30 years old) who want to maintain a balanced budget, keep track of their spending, and receive guidance.

How To Run The Program?
Run the CalendarTester class. Then follow the prompts in the terminal. Enter two-week income, budget proportions, and use numbered menu options. Exit the program in the main menu when finished.

Technical Overview:
Day class
  Initializes Day objects containing the user's budget plan and spending.
BudgetAnalyzer class
  Contains a method that compares the user's budget with their spending for each category. Provides detailed feedback for each category.
Calendar class
  Creates a calendar object, a 2D array containing Day objects. Labels Day objects with day numbers (1-14). Initializes an ArrayList containing the day numbers for days the user was over budget on spending.
CalendarTester
  Handles user interaction, menus, and overall program flow.

Class Diagram

Known Limitations / Future Improvements
  - Asks the user to re-enter budget proportions for each category only after the user has inputted proportions in all three categories.
  - The program does not handle invalid data type inputs. The program assumes users input numeric values.
