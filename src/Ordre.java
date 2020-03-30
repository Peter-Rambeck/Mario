import java.sql.Time;
import java.util.ArrayList;

public class Ordre {
    static int ordreCounter = 1;
    ArrayList<Pizza> pizzaer=new ArrayList<Pizza>();
    Time afhentningsTidspunkt;
    int ordreId;
    int samletPris = 0;

    public Ordre() {
        ordreId = ordreCounter;
        ordreCounter++;
    }

    public void tilføjPizza(Pizza pizza) {
        pizzaer.add(pizza);
        samletPris = samletPris + pizza.getPris();
    }

    public void tilføjKlokkeSlet(Time time) {
        afhentningsTidspunkt = time;
    }


    public void visOrdre() {
        System.out.println("ordrenummer: " + this.ordreId);
        for (Pizza pizza : this.pizzaer) {
            System.out.println(pizza);
        }
    }
}
/*



    static int ordreCounter = 1;
    ArrayList<Pizza> pizzaer;
    Time afhentningsTidspunkt;
    int ordreId;

    // New variable
    int pris;

    public Ordre (ArrayList<Pizza> pizzaer, Time afhentningsTidspunkt) {
        this.afhentningsTidspunkt = afhentningsTidspunkt;
        this.ordreId = ordreCounter;
        ordreCounter++;

//        for (Pizza arrayList : this.pizzaer = pizzaer) {

        }


 visOrdrePris skal udregne ordre prisen

public void setPris() {
    int tmpPris = 0;
    // TODO: Calculate orderprice
    // tmpPris = pizza.getPris();
    // tmpPris =
}

    public int visOrdrePris() {
        int pris = 0;
        return pris;
    }


  visOrdre skal udskrive den fulde ordre: getPizzaer + afhentningsTidspunkt + pris

    public void visOrdre() {
    }

 */