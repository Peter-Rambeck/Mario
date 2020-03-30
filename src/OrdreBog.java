import java.sql.Array;
import java.util.ArrayList;

public class OrdreBog {
    ArrayList<Ordre> ordreListe;
    int dagensOmsætning=0;
    public OrdreBog(){
        ordreListe=new ArrayList<Ordre>();
    }

    public void afslutOrdre(Ordre ordre){
        dagensOmsætning=dagensOmsætning+ordre.samletPris;
        // skriv ordre til fil(ordre);
        ordreListe.remove(ordre);

    }

    @Override
    public String toString() {
        String retString="OrdreBog\n";

        for(Ordre ordre:this.ordreListe){
            retString=retString+"Odrenr: "+ordre.ordreId+" Klokken: "+ordre.afhentningsTidspunkt+" Pizzaer: ";
            for(Pizza pizza:ordre.pizzaer){
                retString=(retString+pizza.getNr()+", ");
            }
            retString=(retString+" pris: "+ordre.samletPris+"\n");

        }
        return retString;
    }
}
