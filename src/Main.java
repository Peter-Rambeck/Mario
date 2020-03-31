import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Menukort menuKort = new Menukort();
        menuKort.indlæsMenukort();
        Ordre ordre=new Ordre();
        IO.indlaesOrdre(ordre,menuKort);
        OrdreBog ordrebog=new OrdreBog();
        ordre.tilFøjOrdre(ordrebog);
        ordrebog.afslutOrdre(ordre);

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