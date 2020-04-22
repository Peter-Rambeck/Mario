package model;
import DataMapper.PizzaMapper;
import model.Pizza;

import java.util.ArrayList;

public class Menukort {

    public static ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();

    // model.Menukort contructor
    public Menukort() {
    }

    // Read in new Pizzaer to a model.Menukort list
    public void indlæsMenukort() {
        PizzaMapper pm=new PizzaMapper();
        pizzaList=pm.getAllPizza();
/*
        model.Pizza pizza1 = new model.Pizza(1,
                "Vesuvio",
                "Tomatsauce, ost, skinke og oregano",
                57);
        pizzaList.add(pizza1);

        model.Pizza pizza2 = new model.Pizza(2,
                "Amerikaner",
                "Tomatsauce, ost, oksefars og oregano",
                53);
        pizzaList.add(pizza2);

        model.Pizza pizza3 = new model.Pizza(3,
                "Cacciatore",
                "Tomatsauce, ost, peperoni, origano",
                57);
        pizzaList.add(pizza3);

        model.Pizza pizza4 = new model.Pizza(4,
                "Carbona",
                "Tomatsauce, ost, kødsauce, spaghetti, cocktailpølser og oregano",
                63);
        pizzaList.add(pizza4);

        model.Pizza pizza5 = new model.Pizza(5,
                "Dennis",
                "Tomatsauce, ost, skinke pepperoni, cocktailpølser og oregano",
                65);
        pizzaList.add(pizza5);

        model.Pizza pizza6 = new model.Pizza(6,
                "Bertil",
                "Tomatsauce, ost, bacon og oregano",
                57);
        pizzaList.add(pizza6);

        model.Pizza pizza7 = new model.Pizza(7,
                "Silvia",
                "Tomatsauce, ost, pepproni, rød peber, løg, oliven og oregano",
                61);
        pizzaList.add(pizza7);

        model.Pizza pizza8 = new model.Pizza(8,
                "Victoria",
                "Tomatsauce, ost, skinke, ananas, champignon, løg og oregano",
                61);
        pizzaList.add(pizza8);

        model.Pizza pizza9 = new model.Pizza(9,
                "Toronfo",
                "Tomatsauce, ost, skinke, bacon, kebab, chili og oregano",
                61);
        pizzaList.add(pizza9);

        model.Pizza pizza10 = new model.Pizza(10,
                "Capricciosa",
                "Tomatsauce, ost, skinke, champignon og oregano",
                61);
        pizzaList.add(pizza10);

        model.Pizza pizza11 = new model.Pizza(11,
                "Hawaii",
                "Tomatsauce, ost, skinke, ananas og oregano",
                61);
        pizzaList.add(pizza11);

        model.Pizza pizza12 = new model.Pizza(12,
                "Le Blissola",
                "Tomatsauce, ost, skinke, rejer og oregano",
                61);
        pizzaList.add(pizza12);

        model.Pizza pizza13 = new model.Pizza(13,
                "Venezia",
                "Tomatsauce, ost, skinke, bacon og oregano",
                61);
        pizzaList.add(pizza13);

        model.Pizza pizza14 = new model.Pizza(14,
                "Mafia",
                "Tomatsauce, ost, pepperoni, bacon, løg og oregano",
                61);
        pizzaList.add(pizza14);*/
    }

    @Override
    public String toString() {
       String retString;
       retString="model.Menukort Marios model.Pizza\n";
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
