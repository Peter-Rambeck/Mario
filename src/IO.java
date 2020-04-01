import javafx.scene.control.SortEvent;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class IO {

    public static void controller() throws IOException {

        Scanner valgInput = new Scanner(System.in);
        
        String valg = "";

        Menukort menukort = new Menukort();
        menukort.indlæsMenukort();
        OrdreBog ordreBog = new OrdreBog();

        while (!valg.equalsIgnoreCase("x")) {

            System.out.println(menukort);
            System.out.println(ordreBog);

            System.out.println("Opret ordre: tast o");
            System.out.println("Afslut ordre: tast a");
            System.out.println("Afslut program: tast x");

            valg = valgInput.nextLine();

            if (valg.equalsIgnoreCase("o")) {
                Ordre ordre = new Ordre();
                IO.indlaesOrdre(ordre, menukort);
                ordre.tilFøjOrdre(ordreBog);
            }
            if (valg.equalsIgnoreCase("a")) {
                Ordre ordre = null;
                while (ordre == null) {
                    ordre = afslutHvilkenOrdre(ordreBog);
                    if (ordre == null) {
                        System.out.println("Ordre nr findes ikke");
                    } else {
                        ordreBog.afslutOrdre(ordre);
                    }
                }
            }
        }
    }

    public static Ordre afslutHvilkenOrdre(OrdreBog ordreBog) throws IOException {

        System.out.println(ordreBog);
        Scanner afslutInput = new Scanner(System.in);
        System.out.println("Hvilken ordre skal afsluttes. Intast ordre nr.");

        int nr = 0;
        if (afslutInput.hasNextInt()) {
            nr = afslutInput.nextInt();
        } else {
            System.out.println("Fejl. Indput var ikke et tal. Prøv igen!");
            afslutHvilkenOrdre(ordreBog);
        }
        Ordre ordre;
        ordre = ordreBog.findOrdre(nr);
        return ordre;
    }


    public static void indlaesOrdre(Ordre ordre, Menukort menukort) {

        // Create Scanner
        Scanner ordreInput = new Scanner(System.in);

        // First variable in an order: Pizza('s)
        System.out.println("Vælg pizza nr? \nAfslut ordre med 0");

        // Test if user input is an int
        if (ordreInput.hasNextInt()) {

            // Store user input.
            int valg = ordreInput.nextInt();

            // Test if user input is out of boundaries, menu has 14 pizza's
            // Catch with return new user input


            while (valg > 0) {

                if (valg > 14) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Pizzaen findes ikke\nVælg mellem 1 - 14");
                        indlaesOrdre(ordre, menukort);
                    }
                }

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


            // Catch if user input in NOT an int, with return to new user input
        } else {
            System.out.println("Fejl. Indtast et tal mellem 1 - 14");
            indlaesOrdre(ordre, menukort);
        }
        indlæsTidspunkt(ordre);
    }

    public static void indlæsTidspunkt(Ordre ordre) {

        Scanner ordreInput = new Scanner(System.in);
        // Second variable in an order: Pickup time.
        System.out.println("Vælg afhentningtidspunkt: ");
        // Initialize variable. Adjust for Scanner bug.
        String timeString = ordreInput.nextLine();
        // Store user input in a new String variable
        // timeString = ordreInput.nextLine();


        try {
            // Parse String to LocalTime & call Method from 'ordre'.
            ordre.tilføjKlokkeSlet(LocalTime.parse(timeString));

        } catch (DateTimeParseException e) {
            System.out.println("Indtast korrekt tidspunkt");
            // indlaesOrdre(ordre, menukort);
            // timeString = ordreInput.nextLine();
            indlæsTidspunkt(ordre);
        }
    }


}



