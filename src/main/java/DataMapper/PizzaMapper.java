package DataMapper;
import Util.DBConnector;
import model.Pizza;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PizzaMapper {
    public ArrayList<Pizza> getAllPizza() {
        String query = "";
        Pizza tmpPizza = null;
        ArrayList<Pizza> pizzaer = new ArrayList<>();
        // TODO: The JDBC-cycle
        Connection conn = DBConnector.getInstance().getConnection();
        try {
            query = "SELECT * FROM pizza";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()) {
                // laver en pizza per iteration og gemmer i listen
                int id = res.getInt("PizzaID");
                String navn = res.getString("navn");
                String ingredienser = res.getString("ingredienser");
                int pris = res.getInt("pris");

                tmpPizza = new Pizza(id,navn,ingredienser,pris);
                pizzaer.add(tmpPizza);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pizzaer;
    }


}
