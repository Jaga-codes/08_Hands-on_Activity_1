import java.util.Scanner;
import java.time.LocalTime;

interface Alarm {
    void setAlarm(String time); // Method to set the alarm
    void showAlarm();          // Method to display alarm details
}

abstract class Weekday implements Alarm {
    // No additional methods or properties here
}

public class Monday extends Weekday {
    private LocalTime alarmTime; // Stores the time for the alarm

    @Override
    public void setAlarm(String time) {
        // Convert the string input to LocalTime
        alarmTime = LocalTime.parse(time);
    }

    @Override
    public void showAlarm() {
        // Get the current time
        LocalTime now = LocalTime.now();

        // Compare the alarm time and current time
        if (alarmTime.isAfter(now)) {
            System.out.println("I'll wake you up later!");
        } else {
            System.out.println("Alarm is set for tomorrow!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Monday monday = new Monday(); // Create an object of Monday class

        System.out.println("Enter the time for the alarm (HH:mm): ");
        String time = scanner.nextLine(); // Read input for the alarm time

        monday.setAlarm(time); // Set the alarm
        monday.showAlarm();    // Display the alarm details

        scanner.close(); // Close the scanner
    }
}
