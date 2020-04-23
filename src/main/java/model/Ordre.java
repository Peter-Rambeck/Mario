package model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;


public class Ordre implements Comparable<Ordre>{

   // static int ordreCounter = 1;

    public ArrayList<Pizza> getPizzaer() {
        return pizzaer;
    }

    ArrayList<Pizza> pizzaer=new ArrayList<Pizza>();

    public LocalTime getAfhentningsTidspunkt() {
        return afhentningsTidspunkt;
    }

    LocalTime afhentningsTidspunkt;
    int ordreId;
    int samletPris = 0;

    public void setOrdreId(int ordreId) {
        this.ordreId = ordreId;
    }

    public int getOrdreId() {
        return ordreId;
    }

    // Constructor
    public Ordre() {
        ordreId = 0;
    }

    // Add model.Pizza order to ArrayList + sum the price variable
    public void tilføjPizza(Pizza pizza) {
        pizzaer.add(pizza);
        samletPris = samletPris + pizza.getPris();
    }

    // Sort Orderlist by pickup time.
    @Override
    public int compareTo(Ordre ordre) {
        return this.afhentningsTidspunkt.compareTo(ordre.afhentningsTidspunkt);
    }

    // Method to add Pickup time in right format
    public void tilføjKlokkeSlet(LocalTime time) {
        afhentningsTidspunkt = time;
    }

    // Method to add order to orderlist and sort output.
    public void tilFøjOrdre(OrdreBog ordreBog){
        ordreBog.ordreListe.add(this);
        Collections.sort(ordreBog.ordreListe);
    }

    // Display full order with Pizzas and pickup time.
    public void visOrdre() {
        System.out.println("ordrenummer: " + this.ordreId+"  Klokken:"+this.afhentningsTidspunkt+" pris:"+this.samletPris);
        for (Pizza pizza : this.pizzaer) {
            System.out.println(pizza);
        }
    }

    @Override
    public String toString() {
        return "model.Ordre{" +
                "pizzaer=" + pizzaer +
                ", afhentningsTidspunkt=" + afhentningsTidspunkt +
                ", ordreId=" + ordreId +
                ", samletPris=" + samletPris +
                '}';
    }
}