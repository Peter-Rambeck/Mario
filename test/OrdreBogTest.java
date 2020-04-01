import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class OrdreBogTest {
    Ordre testordre1 = new Ordre();
    Ordre testordre2 = new Ordre();
    Pizza pizza1=new Pizza(1,"test","ingredienser",45);
    Pizza pizza2=new Pizza(2,"test2","ingredienser",55);
    OrdreBog denneOrdreBog =new OrdreBog();

    @Before
    public void before() throws Exception {
        testordre1.tilføjPizza(pizza1);
        testordre1.tilFøjOrdre(denneOrdreBog);
        System.out.println("setup");
        testordre2.tilføjPizza(pizza2);
        testordre2.tilFøjOrdre(denneOrdreBog);
    }


    @Test
    void findOrdre() throws IOException {
        Ordre fundet;
        System.out.println(denneOrdreBog);
        fundet=denneOrdreBog.findOrdre(1);
        System.out.println(fundet);
        assertEquals(55,fundet.samletPris);

        //fail();
    }
}