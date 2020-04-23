package model;
import DataMapper.PizzaMapper;
import model.Pizza;

import java.util.ArrayList;

public class Menukort {

    public static ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }

    public static ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();

    // model.Menukort contructor
    public Menukort() {
    }

    // Read in new Pizzaer to a model.Menukort list
    public void indlæsMenukort() {
        PizzaMapper pm=new PizzaMapper();
        pizzaList=pm.getAllPizza();

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
