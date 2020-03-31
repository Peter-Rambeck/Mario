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
            fw = new FileWriter("C:\\Users\\peter\\Creative Cloud Files\\CPHB\\Assignments\\Mario\\OrdreBog\\ordrebog.csv");
        } catch (IOException e) {
            System.out.println("File dosen't exsist");;
        }
            try {
                fw.write(ordre + lineSeparator());
            } catch (IOException e) {
                System.out.println("Writing went wrong");
                ;
            }
        fw.flush();
        fw.close();

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
