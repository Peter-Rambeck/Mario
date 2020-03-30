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
        return "OrdreBog{" +
                "ordreListe=" + ordreListe +
                ", dagensOmsætning=" + dagensOmsætning +
                '}';
    }
}
