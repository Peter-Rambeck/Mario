import java.util.ArrayList;

public class Menukort {

    public static ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();

    public Menukort() {
    }

    public void indlæsMenukort() {

        Pizza pizza1 = new Pizza(1,
                "Margaritha",
                "Tomatsauce & Ost",
                50);
        pizzaList.add(pizza1);

        Pizza pizza2 = new Pizza(2,
                "Carpri",
                "Tomatsauce, Ost & Ged",
                60);
        pizzaList.add(pizza2);

        Pizza pizza3 = new Pizza(3,
                "Cacciattio",
                "Tomatsauce, ost, peperoni, origano",
                70);
        pizzaList.add(pizza3);

        Pizza pizza4 = new Pizza(4,
                "Carpri",
                "Tomast, Ost & Ged",
                80);
        pizzaList.add(pizza4);

        Pizza pizza5 = new Pizza(5,
                "Margaritha",
                "Tomast & Ost",
                90);
        pizzaList.add(pizza5);

        Pizza pizza6 = new Pizza(6,
                "Carpri",
                "Tomast, Ost & Ged",
                30);
        pizzaList.add(pizza6);

        Pizza pizza7 = new Pizza(7,
                "Margaritha",
                "Tomast & Ost",
                55);
        pizzaList.add(pizza7);

        Pizza pizza8 = new Pizza(8,
                "Carpri",
                "Tomast, Ost & Ged",
                65);
        pizzaList.add(pizza8);

        Pizza pizza9 = new Pizza(9,
                "Margaritha",
                "Tomast & Ost",
                78);
        pizzaList.add(pizza9);

        Pizza pizza10 = new Pizza(10,
                "Carpri",
                "Tomast, Ost & Ged",
                72);
        pizzaList.add(pizza10);

        Pizza pizza11 = new Pizza(11,
                "Margaritha",
                "Tomast & Ost",
                92);
        pizzaList.add(pizza11);

        Pizza pizza12 = new Pizza(12,
                "Carpri",
                "Tomast, Ost & Ged",
                69);
        pizzaList.add(pizza12);

        Pizza pizza13 = new Pizza(13,
                "Margaritha",
                "Tomast & Ost",
                72);
        pizzaList.add(pizza13);

        Pizza pizza14 = new Pizza(14,
                "Carpri",
                "Tomast, Ost & Ged",
                64);
        pizzaList.add(pizza14);

        System.out.println(pizzaList);

    }

    @Override
    public String toString() {
        return "Menukort{" +
                "pizzaList=" + pizzaList +
                '}';
    }
}


    /*
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
        return str;     */

