import java.util.ArrayList;

public class Menukort {

    static ArrayList<Pizza> pizzaList;

    public Menukort(ArrayList<Pizza> pizzaList) {
        Menukort.pizzaList = pizzaList;
    }

    public static ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(ArrayList<Pizza> pizzaList) {
        Menukort.pizzaList = pizzaList;
    }

    @Override
    public String toString() {
        String str;
        str = "Menukort: " + "\n";
        for (Pizza pizza: pizzaList) {
            str = str + pizza + "\n";
        }
        return str;
    }
    /*

        return "Menukort{" +
                "pizzaList=" + pizzaList +
                '}';

     */
}



