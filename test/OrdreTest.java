import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class OrdreTest {



    public Ordre testordre = new Ordre();
    public Pizza pizza1=new Pizza(1,"test","ingredienser",45);
    public Pizza pizza2=new Pizza(2,"test2","ingredienser",55);


    @Test
    void tilføjPizza() {
        testordre.tilføjPizza(pizza1);
        assertEquals(45,testordre.samletPris);
        testordre.tilføjPizza(pizza2);
        assertEquals(100,testordre.samletPris);

        //fail();
    }

    @Test
    void tilFøjOrdre() {
        //fail();
    }

    @Test
    void visOrdre() {
        //fail();
    }
}