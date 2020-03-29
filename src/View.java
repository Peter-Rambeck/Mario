import java.util.Scanner;


public class View {

    // Create Scanner
    static Scanner ordreInput = new Scanner(System.in);

    // Start 2 step order dialouge

    /*
    getPizzaer() skal tage et pizza nr.,
    hente pizzaen fra menuen via nr
    og per-indput gemme alle bestilte pizzaer i en Array.
    ex. 1. Margaritha Kr. 50, 2. Caprichosa kr. 60
    ordren afsluttes ved at taste "0".
     */
    // 1. Get order of Pizza's
    public int getPizzaer() {
        int retPizzaer = 0;
        System.out.println("Vælg pizza nr? \nAfslut ordre med 0");
//        showMenukort();
        int pizzaNr = ordreInput.nextInt();
        if (pizzaNr > 0 ) {
            System.out.println("Vælg pizza nr? \nafslut ordre med 0");
//            retPizzaer.add(pizzaNr);
        } if (pizzaNr == 0) {
            return retPizzaer;
        }
        return retPizzaer;
    }

    /*
   afhentningsTidspunkt() skal tage et tidspunkt,
   og gemme det.
   Bestingelse er: 'Nu' + 20 min.
    */
    // 2. Get order pickup time
    public String afhentningsTidspunkt() {
        String retAfhentning = "";
        System.out.println("Hvornår afhentes ordren?");
        retAfhentning = ordreInput.nextLine();
        return retAfhentning;
    }

    /*
  showMenukort skal udskrive 'Menukort'
   */
    public void showMenukort() {
//        TODO: Method that display all Pizza's ny nr. to select from
    }


}
