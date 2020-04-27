package DataMapper;

import Util.DBConnector;
import model.Menukort;
import model.Pizza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class NewPizzaMapperTest {
    Menukort menu=new Menukort();
    @BeforeEach
    void setUp() {
        menu.indlæsMenukort();
    }



    @Test
    void createNewPizza() {
        //anatl pizzaer i menukort
        int antalPizzaerInden=menu.pizzaList.size();
        String pizzanavn="ny Pizza";
        String ingredienser="alt godt fra skuffen";
        int pris=123;

        // tilføjer en pizza til menukort
        int pizzaID =NewPizzaMapper.createNewPizza(pizzanavn,ingredienser,pris);
        //opdater menukort
        menu=new Menukort();
        menu.indlæsMenukort();
        //antal pizzaer efter
        int antalPizzaerefter=menu.pizzaList.size();

        // er der en pizza mere i menuen
        assertEquals(1,antalPizzaerefter-antalPizzaerInden);

        //er den nye pizza i menuen
        Pizza pizza=new Pizza();
        pizza.findIMenu( menu, pizzaID);
        assertEquals(pizza.getNavn(),"ny Pizza");


        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();



        //slet oprettet pizza fra menukort igen
        sqlQuery = "DELETE FROM pizza WHERE pizzaID="+pizzaID+";";
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}// public int createNewPizza(String pizzaNavn, String pizzaIngredienser, int pizzaPris)