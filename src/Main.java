import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        // Create a
        // new Menukort object
        Menukort menuKort = new Menukort();
        // Call and display the menu of Pizza's
        menuKort.indlæsMenukort();

        // Create new Ordre object
        Ordre ordre = new Ordre();

//        IO.indlaesOrdre(ordre, menuKort);

     ordre.visOrdre();
      ordre=new Ordre();
        IO.indlaesOrdre(ordre,menuKort);
        ordre.visOrdre();

        OrdreBog ordrebog=new OrdreBog();
        ordre.tilFøjOrdre(ordrebog);
        System.out.println(ordrebog);
        ordrebog.afslutOrdre(ordre);
        System.out.println(ordrebog);


    }
}








/*


        Pizza pizza1 = new Pizza(1,
                "Margaritha",
                "Tomast & Ost",
                50);

        Pizza pizza2 = new Pizza(2,
                "Carpri",
                "Tomast, Ost & Ged",
                60);

//        System.out.println(pizza1);

        ArrayList <Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(pizza1);
        pizzaList.add(pizza2);

        Menukort menukort = new Menukort(pizzaList);
        System.out.println(menukort);

        View view = new View();
        view.getPizzaer();

 */