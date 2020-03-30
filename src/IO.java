import java.sql.Time;
import java.time.LocalTime;
import java.util.Scanner;

public class IO {
    public static void indlaesOrdre(Ordre ordre, Menukort menukort) {
        // Create Scanner
        Scanner ordreInput = new Scanner(System.in);
        Pizza tmpPizza;
        System.out.println("Vælg pizza nr? \nAfslut ordre med 0");
        int valg = ordreInput.nextInt();
        while (valg > 0) {
            tmpPizza = new Pizza();
            tmpPizza.findIMenu(menukort, valg);
            ordre.tilføjPizza(tmpPizza);
            valg = ordreInput.nextInt();
        }
        System.out.println("Vælg afhentningtidspunkt: ");
        String timeString;
        timeString=ordreInput.nextLine();
        timeString=ordreInput.nextLine();
        ordre.tilføjKlokkeSlet(LocalTime.parse(timeString));





    /*        int retPizzaer = 0;
            System.out.println("Vælg pizza nr? \nAfslut ordre med 0");
//        showMenukort();
            int pizzaNr = ordreInput.nextInt();
            if (pizzaNr > 0 ) {
                System.out.println("Vælg pizza nr? \nafslut ordre med 0");
//            retPizzaer.add(pizzaNr);
            } if (pizzaNr == 0) {
                Pizza dennepizza=new Pizza();
                dennepizza.findIMenu(menukort,4);

            }

        }
    }*/
    }
}
