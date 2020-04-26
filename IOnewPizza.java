import DataMapper.NewPizzaMapper;
import DataMapper.PizzaMapper;
import model.Pizza;

import java.util.Scanner;

public class IOnewPizza {

    // static String pizzaNavn;
    // static String pizzaIngredienser;
    // static int pizzaPris;

    public static void indlaesNyPizza() {

        // Create Scanner object
        Scanner ordreInput = new Scanner(System.in);
        // First variable in a new Pizza: Name.
        System.out.println("Vælg navn til ny Pizza: ");
        // Store user input in a new String variable
        String pizzaNavn = ordreInput.nextLine();
        // Second variable in a new Pizza: Ingredience.
        System.out.println("Vælg ingrediencer til: "+pizzaNavn);
        // Store user input in a new String variable
        String pizzaIngredienser = ordreInput.nextLine();
        // Third variable in a new Pizza: Price.
        System.out.println("Vælg pris til: "+pizzaNavn);
        // Store user input in a new String variable
        int pizzaPris = ordreInput.nextInt();

        NewPizzaMapper npm = new NewPizzaMapper();
        Pizza newPizza = npm.createNewPizza(pizzaNavn, pizzaIngredienser, pizzaPris);

    }

}
