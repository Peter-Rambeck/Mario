import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;


public class Ordre implements Comparable<Ordre>{

    static int ordreCounter = 1;
    ArrayList<Pizza> pizzaer=new ArrayList<Pizza>();
    LocalTime afhentningsTidspunkt;
    int ordreId;
    int samletPris = 0;

    // Constructor
    public Ordre() {
        ordreId = ordreCounter;
        ordreCounter++;
    }

    // Add Pizza order to ArrayList + sum the price variable
    public void tilføjPizza(Pizza pizza) {
        pizzaer.add(pizza);
        samletPris = samletPris + pizza.getPris();
    }
    @Override
    public int compareTo(Ordre ordre) {

        return this.afhentningsTidspunkt.compareTo(ordre.afhentningsTidspunkt);
    }

    public void tilføjKlokkeSlet(LocalTime time) {
        afhentningsTidspunkt = time;
    }
    public void tilFøjOrdre(OrdreBog ordreBog){
        ordreBog.ordreListe.add(this);
        Collections.sort(ordreBog.ordreListe);

    }

    public void visOrdre() {
        System.out.println("ordrenummer: " + this.ordreId+"  Klokken:"+this.afhentningsTidspunkt+" pris:"+this.samletPris);
        for (Pizza pizza : this.pizzaer) {
            System.out.println(pizza);
        }
    }

    @Override
    public String toString() {
        return "Ordre{" +
                "pizzaer=" + pizzaer +
                ", afhentningsTidspunkt=" + afhentningsTidspunkt +
                ", ordreId=" + ordreId +
                ", samletPris=" + samletPris +
                '}';
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