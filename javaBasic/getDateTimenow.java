import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class getDateTimenow {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        // HH format 24h, hh format 12h, a for AM PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy hh:mm a");
        System.out.println(String.valueOf(now.format(formatter)));
    }
}
