import DataMapper.OrdreMapper;
import model.Menukort;
import model.Ordre;
import model.OrdreBog;
import model.Pizza;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class IO {

    public static void controller() throws IOException {

        // Create Scanner to receive user input
        Scanner valgInput = new Scanner(System.in);

        // Initialize variable
        String valg = "";

        // Create new Menu object
        Menukort menukort = new Menukort();
        // Display Menu
        menukort.indlæsMenukort();
        // Create new order log
        OrdreBog ordreBog = new OrdreBog();
        OrdreMapper om=new OrdreMapper();
        om.indlaesAabneOrdrer(ordreBog);

        // Correct for wrong or random user input
        while (!valg.equalsIgnoreCase("x")) {

            // Display menu
            System.out.println(menukort);
            // Display order log
            System.out.println(ordreBog);

            // User input instructions
            System.out.println("Opret ordre: tast o");
            System.out.println("Afslut ordre: tast a");
            System.out.println("Afslut program: tast x");

            // Create new Pizza
            System.out.println("Lav ny Pizza: tast p");

            // Store user input
            valg = valgInput.nextLine();

            // Correct for wrong or random user input
            if (valg.equalsIgnoreCase("o")) {
                // Create a new empty order
                Ordre ordre = new Ordre();
                // Call order method to take input
                indlaesOrdre(ordre, menukort);
                // Add the final order to the order log
                ordre.tilFøjOrdre(ordreBog);
            }
            if (valg.equalsIgnoreCase("p")) {
                IOnewPizza newPizza = new IOnewPizza();
                newPizza.indlaesNyPizza();
            }


            // Correct for wrong or random user input
            if (valg.equalsIgnoreCase("a")) {
                // Instantiate a non-existing order case
                Ordre ordre = null;
                // Catch if user wants to remove a non-existing order
                while (ordre == null) {
                    ordre = afslutHvilkenOrdre(ordreBog);
                    if (ordre == null) {
                        System.out.println("Ordre nr findes ikke");
                        // Return to new Remove order dialogue.
                    } else {
                        ordreBog.afslutOrdre(ordre);
                    }
                }
            }
        }
    }

    // End and remove order from Order log - Method
    public static Ordre afslutHvilkenOrdre(OrdreBog ordreBog) throws IOException {

        // Display current order log
        System.out.println(ordreBog);
        // Create Scanner for input
        Scanner afslutInput = new Scanner(System.in);
        System.out.println("Hvilken ordre skal afsluttes. Intast ordre nr.");

        // Initialize int variable
        int nr = 0;
        // Test id user input is an int
        if (afslutInput.hasNextInt()) {
            nr = afslutInput.nextInt();
            // Catch if user input is not an int
        } else {
            System.out.println("Fejl. Indput var ikke et tal. Prøv igen!");
            afslutHvilkenOrdre(ordreBog);
        }
        // Initialize order variable
        Ordre ordre;
        // Lookup order to remove in the order log.
        ordre = ordreBog.findOrdre(nr);
        return ordre;
    }

    // Method to take user input for model.Pizza order
    public static void indlaesOrdre(Ordre ordre, Menukort menukort) {
        String st;
        // Create Scanner
        Scanner ordreInput = new Scanner(System.in);

        // First variable in an order: model.Pizza('s)
        System.out.println("Vælg pizza nr? \nAfslut ordre med 0");

        // gør klar til ny pizza
        Pizza tmpPizza;
        // Test if user input is an int


            int valg=100;
            // sålænge valg ikke er 0...
            while (valg != 0) {
                // hvis næste indtastning er tal
                if (ordreInput.hasNextInt()) {
                    tmpPizza=new Pizza();
                    // læs tal
                    valg = ordreInput.nextInt();
                    //find piza i menu
                    tmpPizza.findIMenu(menukort, valg);
                    // Test if pizza is found in menu
                    if (tmpPizza.getNr()== valg) {
                        // tilføj funden pizza til ordre
                        ordre.tilføjPizza(tmpPizza);
                    } else {
                        if (valg>0) {
                            // pizza var ikke i menuen
                            System.out.println("Fejl. Indtast en pizza fra menuen");
                        }
                    }
                } else {
                    // der blev ikke indtatstet et tal
                    System.out.println("Fejl. Indtast en pizza fra menuen");
                    //læs det indtastede
                    st=ordreInput.nextLine();
                    st=ordreInput.nextLine();
                }
            }
        indlæsTidspunkt(ordre);
        // gem ordre i DB
        OrdreMapper om=new OrdreMapper();
        int orderID=om.createOrdre(ordre);
        ordre.setOrdreId(orderID);

    }

    // Method to get Second variable in an order, the pickup time
    public static void indlæsTidspunkt(Ordre ordre) {

        // Create Scanner object
        Scanner ordreInput = new Scanner(System.in);

        // Second variable in an order: Pickup time.
        System.out.println("Vælg afhentningtidspunkt: ");
        // Store user input in a new String variable
        String timeString = ordreInput.nextLine();

        try {
            // Parse String to LocalTime & call Method from 'ordre'.
            ordre.tilføjKlokkeSlet(LocalTime.parse(timeString));
        // Catch wrong time input, return to get new input
        } catch (DateTimeParseException e) {
            System.out.println("Indtast korrekt tidspunkt");
            indlæsTidspunkt(ordre);
        }
    }

}



