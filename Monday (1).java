import java.util.Scanner;
import java.time.LocalTime;

interface Alarm {
    void setAlarm(String time); 
    void showAlarm();          
}

abstract class Weekday implements Alarm {
}

public class Monday extends Weekday {
    private LocalTime alarmTime; 

    @Override
    public void setAlarm(String time) {
        alarmTime = LocalTime.parse(time);
    }

    @Override
    public void showAlarm() {
        LocalTime now = LocalTime.now();

        if (alarmTime.isAfter(now)) {
            System.out.println("I'll wake you up later!");
        } else {
            System.out.println("Alarm is set for tomorrow!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Monday monday = new Monday(); 

        System.out.println("Enter the time for the alarm (HH:mm): ");
        String time = scanner.nextLine();

        monday.setAlarm(time); 
        monday.showAlarm();    

        scanner.close(); 
    }
}
