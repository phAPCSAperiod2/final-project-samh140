import java.util.ArrayList;

public class Calendar
{
    private Day[][] calendar;
    private final int WEEKS = 2;
    private final int DAYS_PER_WEEK = 7;
    private final int MINIMUM_DAY_NUMBER = 1;
    private final int MAXIMUM_DAY_NUMBER = 14;


    private ArrayList<Integer> overBudgetDays;


    public Calendar(double needsProp, double wantsProp, double savingsProp, double twoWeekIncome)
    {
        calendar = new Day[WEEKS][DAYS_PER_WEEK];

        for (int row = 0; row < calendar.length; row++)
        {
            for (int column = 0; column < calendar[row].length; column++)
            {
                calendar[row][column] = new Day(needsProp, wantsProp, savingsProp, twoWeekIncome);
            }
        }

        overBudgetDays = new ArrayList<>();

    }


    public boolean isValidDayNumber(int dayNumber)
    {
        return dayNumber >= MINIMUM_DAY_NUMBER && dayNumber <= MAXIMUM_DAY_NUMBER;
    }

    public Day getDay(int dayNumber)
    {
        if (!isValidDayNumber(dayNumber))
        {
            return null;
        }

        int row = (dayNumber - 1)/7;
        int column = (dayNumber - 1) % 7;
        return calendar[row][column];
    }

    public String viewDay(int dayNumber)
    {
        Day day = getDay(dayNumber);

        if(day == null)
        {
            return "Invalid day number.";
        }

        return day.toString();
    }

    public int getDayNumber(Day target)
    {
        for (int row = 0; row < calendar.length; row++)
        {
            for (int column = 0; column < calendar[row].length; column++)
            {
                if (calendar[row][column] == target)
                {
                    return row * 7 + column + 1;
                }
            }
        }

        return -1;
    }

    public void overBudgetDays(BudgetAnalyzer analyzer)
    {
        overBudgetDays.clear();

        for (int row = 0; row < calendar.length; row++)
        {
            for (int column = 0; column < calendar[row].length; column++)
            {
                Day selectedDay = calendar[row][column];
                int dayNumber = getDayNumber(selectedDay);

                if (!analyzer.compareDayTotalSpending(selectedDay))
                {
                    overBudgetDays.add(dayNumber);
                }

            }
        }
    }

    public String displayOverBudgetDays()
    {
        if (overBudgetDays.isEmpty())
        {
            return "No days are over budget.";
        }

        return "Over budget days: " + overBudgetDays;
    }

    public String toString()
    {
        String result = "";

        for (int row = 0; row < calendar.length; row++)
        {
            result += "Week " + (row + 1) + ":\n";

            for (int column = 0; column < calendar[row].length; column++)
            {
                int dayNumber = row * 7 + column + 1;
                result += "Day " + dayNumber + "      ";
            }
            result+= "\n\n";
        }

        return result;
    }

}
