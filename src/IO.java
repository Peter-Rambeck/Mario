import java.sql.Time;
import java.time.LocalTime;
import java.util.Scanner;

public class IO {

    public static void indlaesOrdre(Ordre ordre, Menukort menukort) {

        // Create Scanner
        Scanner ordreInput = new Scanner(System.in);

        // Pizza tmpPizza; // Redundant code

        // First variable in an order: Pizza('s)
        System.out.println("Vælg pizza nr? \nAfslut ordre med 0");
        // Store user input.
        int valg = ordreInput.nextInt();
        while (valg > 0) {
            // Instantiate a Pizza object
            Pizza tmpPizza = new Pizza();
            // Based on user input.
            // lockup and initialize the Pizza object with pizza from the menu.
            tmpPizza.findIMenu(menukort, valg);
            // Add the initialized pizza to an order
            ordre.tilføjPizza(tmpPizza);
            // Continue While-Loop
            valg = ordreInput.nextInt();
        }

        // Second variable in an order: Pickup time.
        System.out.println("Vælg afhentningtidspunkt: ");

        // String timeString; // Redundant code

        // Initialize variable. Adjust for Scanner bug.
        String timeString = ordreInput.nextLine();
        // Store user input in a new String variable
        timeString = ordreInput.nextLine();
        // Parse String to LocalTime & call Method from 'ordre'.
        ordre.tilføjKlokkeSlet(LocalTime.parse(timeString));

    }
}
