import model.Pizza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdreTest {



    public Ordre testordre = new Ordre();
    public Pizza pizza1=new Pizza(1,"test","ingredienser",45);
    public Pizza pizza2=new Pizza(2,"test2","ingredienser",55);


    @Test
    public void tilføjPizza() {
        //tester om samlet pris på ordren er rigtig 45
        testordre.tilføjPizza(pizza1);
        assertEquals(45,testordre.samletPris);
        //tester om samlet pris på ordren er rigtig 45+55
        testordre.tilføjPizza(pizza2);
        assertEquals(100,testordre.samletPris);

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