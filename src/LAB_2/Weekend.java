import java.util.Calendar;

public class Weekend {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        int i = c.get(Calendar.DAY_OF_WEEK);

        if (i != 1 && i != 7) {
            i = (i + 6) % 7;
            int daysToWeekend = 5 - i;
            System.out.println("Liczba dni do weekendu: " + daysToWeekend);
        }else{
            System.out.println("JEST WEEKEND :))))");
        }
    }
}
