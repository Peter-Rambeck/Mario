package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalTime;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdreBogTest {
    Pizza pizza1;
    Pizza pizza2;
    Ordre testordre1 = new Ordre();
    Ordre testordre2 = new Ordre();
    OrdreBog denneOrdreBog;
    @BeforeEach
    void setUp() {
        pizza1=new Pizza(1,"test","ingredienser",45);
        pizza2=new Pizza(2,"test2","ingredienser",55);
        denneOrdreBog=new model.OrdreBog();
        testordre1.tilføjPizza(pizza1);
        testordre1.tilføjKlokkeSlet(LocalTime.parse("12:00"));
        testordre1.setOrdreId(1);
        testordre1.tilFøjOrdre(denneOrdreBog);

        testordre2.tilføjPizza(pizza2);
        testordre2.tilføjKlokkeSlet(LocalTime.parse("11:00"));
        testordre1.setOrdreId(2);
        testordre2.tilFøjOrdre(denneOrdreBog);

    }




    @Test
    void findOrdre() throws IOException {

        //tjekker at ordrebogen: den første ordre der blev lagt ind har nummer et og rette pris
        Ordre fundet=denneOrdreBog.findOrdre(testordre1.ordreId);
        assertEquals(45,fundet.samletPris);


        //tjekker at ordrebogen er sorteret, testordre2 ligger på plads 0

        assertEquals(denneOrdreBog.ordreListe.get(0).ordreId,testordre2.ordreId);



    }
}