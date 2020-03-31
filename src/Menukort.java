import java.util.ArrayList;

public class Menukort {

    public static ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();

    public Menukort() {
    }

    public void indlæsMenukort() {

        Pizza pizza1 = new Pizza(1,
                "Vesuvio",
                "Tomatsauce, ost, skinke og oregano",
                57);
        pizzaList.add(pizza1);

        Pizza pizza2 = new Pizza(2,
                "Amerikaner",
                "Tomatsauce, ost, oksefars og oregano",
                53);
        pizzaList.add(pizza2);

        Pizza pizza3 = new Pizza(3,
                "Cacciatore",
                "Tomatsauce, ost, peperoni, origano",
                57);
        pizzaList.add(pizza3);

        Pizza pizza4 = new Pizza(4,
                "Carbona",
                "Tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano",
                63);
        pizzaList.add(pizza4);

        Pizza pizza5 = new Pizza(5,
                "Dennis",
                "Tomatsauce, ost, skinke pepperoni, cocktailpølser og oregano",
                65);
        pizzaList.add(pizza5);

        Pizza pizza6 = new Pizza(6,
                "Bertil",
                "Tomatsauce, ost, bacon og oregano",
                57);
        pizzaList.add(pizza6);

        Pizza pizza7 = new Pizza(7,
                "Silvia",
                "Tomatsauce, ost, pepproni, rød peber, løg, oliven og oregano",
                61);
        pizzaList.add(pizza7);

        Pizza pizza8 = new Pizza(8,
                "Victoria",
                "Tomatsauce, ost, skinke, ananas, champignon, løg og oregano",
                61);
        pizzaList.add(pizza8);

        Pizza pizza9 = new Pizza(9,
                "Toronfo",
                "Tomatsauce, ost, skinke, bacon, kebab, chili og oregano",
                61);
        pizzaList.add(pizza9);

        Pizza pizza10 = new Pizza(10,
                "Capricciosa",
                "Tomatsauce, ost, skinke, champignon og oregano",
                61);
        pizzaList.add(pizza10);

        Pizza pizza11 = new Pizza(11,
                "Hawaii",
                "Tomatsauce, ost, skinke, ananas og oregano",
                61);
        pizzaList.add(pizza11);

        Pizza pizza12 = new Pizza(12,
                "Le Blissola",
                "Tomatsauce, ost, skinke, rejer og oregano",
                61);
        pizzaList.add(pizza12);

        Pizza pizza13 = new Pizza(13,
                "Venezia",
                "Tomatsauce, ost, skinke, bacon og oregano",
                61);
        pizzaList.add(pizza13);

        Pizza pizza14 = new Pizza(14,
                "Mafia",
                "Tomatsauce, ost, pepperoni, bacon, løg og oregano",
                61);
        pizzaList.add(pizza14);

        // System.out.println(pizzaList);

    }

    @Override
    public String toString() {
       String retString;
       retString="Menukort Marios Pizza\n";
       for(Pizza pizza:pizzaList){
           retString=retString+"Nr "+pizza.getNr();
           retString=retString+" "+pizza.getNavn()+": ";
           retString=retString+" "+pizza.getIngredienser();
           retString=retString+" Pris "+pizza.getPris()+" Kr";
           retString=retString+"\n";

       }
        return retString;

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

