package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.lineSeparator;
import DataMapper.*;

public class OrdreBog {
    //Ordrebogen indeholder en liste af ordrer og dagens omsætning
    ArrayList<Ordre> ordreListe;
    int dagensOmsætning = 0;

    // konstruktor af tom ordrebog
    public OrdreBog(){
        ordreListe = new ArrayList<Ordre>();
    }

    public void afslutOrdre(Ordre ordre) throws IOException {

        // læg ordrens pris til dagens omsætning
        dagensOmsætning = dagensOmsætning + ordre.samletPris;

        // skriv ordre til fil(ordre);
        /*FileWriter fw = null;
        try {
            fw = new FileWriter("model.OrdreBog\\ordrebog.csv",true);
        } catch (IOException e) {
            System.out.println("File dosen't exsist");;
        }
            try {
                fw.write(ordre +lineSeparator() );
            } catch (IOException e) {
                System.out.println("Writing went wrong");
            }
        fw.flush();
        fw.close();*/
        OrdreMapper om=new OrdreMapper();
        om.afslutOrdre(ordre);
        ordreListe.remove(ordre);
    }

    public Ordre findOrdre(int nr) throws IOException {
        //find ordre i ordrebog vha ordrenr
        // gennemløb ordrelisten
        for (Ordre ordre : ordreListe) {
            if (ordre.ordreId == nr){
                //hvis ordrnr fundet returner ordren
                return ordre;
            }
        }
        //returner null hvis ordrnr ikke findes i rdrebog
        return null;
    }

    @Override
    public String toString() {
        String retString="model.OrdreBog\n";

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

