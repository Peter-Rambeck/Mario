import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Scanner;

public class IO {


    public static void controller() throws IOException {

        Scanner valgInput = new Scanner(System.in);
        System.out.println("Opret ordre: tast o");
        System.out.println("Afslut ordre: tast a");

        String valg = valgInput.nextLine();

        Menukort menukort = new Menukort();
        menukort.indlæsMenukort();
        OrdreBog ordreBog = new OrdreBog();

        while (valg != "x") {

            System.out.println(menukort);
            System.out.println(ordreBog);

            System.out.println("Opret ordre: tast o");
            System.out.println("Afslut ordre: tast a");

            // System.out.println("While");
            if (valg.equals("o")) {
                // System.out.println("o");
                Ordre ordre = new Ordre();
                IO.indlaesOrdre(ordre, menukort);
                ordre.tilFøjOrdre(ordreBog);
            }
            if (valg.equals("a")) {
                // System.out.println("a");
                Ordre ordre;
                ordre = afslutHvilkenOrdre(ordreBog);
                ordreBog.afslutOrdre(ordre);
            }
            valg = valgInput.nextLine();
        }
    }

    public static Ordre afslutHvilkenOrdre(OrdreBog ordreBog) throws IOException {

        System.out.println(ordreBog);
        Scanner afslutInput = new Scanner(System.in);
        System.out.println("Hvilken ordre skal afsluttes. Intast ordre nr.");
        int nr = afslutInput.nextInt();

        Ordre ordre;
        ordre = ordreBog.findOrdre(nr);

        return ordre;
    }


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
