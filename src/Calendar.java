public class Calendar
{
    private Day[][] calendar;
    private final int WEEKS = 2;
    private final int DAYS_PER_WEEK = 7;


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

    }

    public Day getDay(int dayNumber)
    {
        int row = (dayNumber - 1)/7;
        int column = (dayNumber - 1) % 7;
        return calendar[row][column];
    }




}
