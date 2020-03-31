import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

import static java.lang.System.lineSeparator;
import static java.lang.System.setOut;

public class OrdreBog {

    ArrayList<Ordre> ordreListe;
    int dagensOmsætning = 0;

    public OrdreBog(){
        ordreListe = new ArrayList<Ordre>();
    }

    public void afslutOrdre(Ordre ordre) throws IOException {
        dagensOmsætning=dagensOmsætning+ordre.samletPris;

        // skriv ordre til fil(ordre);
        FileWriter fw = null;
        try {
            fw = new FileWriter("OrdreBog\\ordrebog.csv",true);
        } catch (IOException e) {
            System.out.println("File dosen't exsist");;
        }
            try {
                fw.write(ordre + "\n");//lineSeparator()
            } catch (IOException e) {
                System.out.println("Writing went wrong");
                ;
            }
        fw.flush();
        fw.close();

        ordreListe.remove(ordre);

    }

    public Ordre findOrdre(int nr) {
        for (Ordre ordre : ordreListe) {
            if (ordre.ordreId == nr){
                return ordre;
            }
        }
        System.out.println("Ordre findes ikke! - Tast igen");
        return null;
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
