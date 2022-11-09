import java.util.Calendar;
import java.util.HashMap;

public class Weekend2 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        int i = c.get(Calendar.DAY_OF_WEEK);
        HashMap<Integer, String> week = new HashMap<>();
        week.put(1, "WEEKEND");
        week.put(2, "Monday");
        week.put(3, "Tuesday");
        week.put(4, "Wednesday");
        week.put(5, "Thursday");
        week.put(6, "Friday");
        week.put(7, "WEEKEND");
        String day = week.get(i);


        if (i != 1 && i != 7) {
            i = (i + 6) % 7;
            int daysToWeekend = 5 - i;
            System.out.println("Today is " + day + ", "+daysToWeekend+" days until weekend.");
        }else{
            System.out.println("It's weekend!");
        }
    }
}
