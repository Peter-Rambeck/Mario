package DataMapper;

import Util.DBConnector;
import model.Pizza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewPizzaMapper {

    public static int createNewPizza(String pizzaNavn, String pizzaIngredienser, int pizzaPris) {

        int pizzaID = 0;
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();

        String navn = pizzaNavn;
        String ingredienser = pizzaIngredienser;
        int pris = pizzaPris;

        //laver ny ordre..
        sqlQuery = "Insert into pizza (navn,ingredienser,pris) " +
                "Values(\"" + navn + "\",\"" + ingredienser + "\",\""+ pris + "\")";
        // lave statement
        try {
            Statement stmt = conn.createStatement();
            //opret i DB
            stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            // modtag ordreID fr DB
            ResultSet res = stmt.getGeneratedKeys();
            res.next();
            pizzaID = res.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pizzaID;
    }

}
