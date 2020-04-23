package DataMapper;

import Util.DBConnector;
import model.Ordre;
import model.Pizza;
import model.Menukort;
import model.OrdreBog;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class OrdreMapper {

    public int createOrdre(Ordre ordre) {
        int ordreID = 0;
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();

        LocalDate dato = LocalDate.now();
        LocalTime afhentningstidspunkt = ordre.getAfhentningsTidspunkt();
        int aaben=1;

        sqlQuery = "Insert into ordre (dato,afhentningstidspunkt,aaben) " +
                "Values(\"" + dato + "\",\"" + afhentningstidspunkt + "\",\""+ aaben + "\")";
        // lave statement
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet res = stmt.getGeneratedKeys();
            res.next();
            ordreID = res.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        /* læg pizzaer og ordre i sammenføjningstabel*/
        ArrayList<Pizza> pizzaer = new ArrayList<>();
        pizzaer = ordre.getPizzaer();
        for (int j = 0; j < pizzaer.size(); j++) {
            sqlQuery = "Insert into ordrepizza (ordreID,pizzaID) " +
                    "Values(\"" + ordreID + "\",\"" + pizzaer.get(j).getNr() + "\")";
            try {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sqlQuery);

            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }

        }
        return ordreID;
    }

    public void afslutOrdre(Ordre ordre){
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();

        /*
        UPDATE table_name
            SET column1 = value1, column2 = value2, ...
               WHERE condition;
         */




        int aaben=0;

        sqlQuery = "UPDATE ordre SET aaben =0 WHERE ordreID="+ordre.getOrdreId();

        // lave statement
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlQuery);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }






    }

    public void indlaesAabneOrdrer(OrdreBog ordreBog) {
        String query = "";
        Ordre tmpOrdre = null;
        ArrayList<Ordre> ordrer = new ArrayList<>();
        // TODO: The JDBC-cycle
        Connection conn = DBConnector.getInstance().getConnection();
        try {
            query = "SELECT * FROM ordre WHERE aaben=1";
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()) {
                // laver en ordre per iteration og gemmer i listen
               int ordreID=res.getInt("OrdreID");
               Date dato=res.getDate("dato");
               Time afhentningsTidspunkt = res.getTime("afhentningstidspunkt");
               tmpOrdre = new Ordre();
               tmpOrdre.setOrdreId(ordreID);
               tmpOrdre.tilføjKlokkeSlet(afhentningsTidspunkt.toLocalTime());
                try {
                    query = "SELECT * FROM ordrepizza WHERE ordreID="+tmpOrdre.getOrdreId();

                    while(res.next()) {
                        // laver en ordre per iteration og gemmer i listen
                        int pizzaID=res.getInt("pizzaID");
                        Pizza tmpPizza=new Pizza();
                        Menukort menu=new Menukort();
                        tmpPizza.findIMenu(menu,pizzaID);
                        tmpOrdre.tilføjPizza(tmpPizza);

                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
               tmpOrdre.tilFøjOrdre(ordreBog);
             }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            query = "SELECT * FROM ordrepizza WHERE ordreID="+tmpOrdre.getOrdreId();
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()) {
                // laver en ordre per iteration og gemmer i listen
                int pizzaID=res.getInt("pizzaID");
                Pizza tmpPizza=new Pizza();
                Menukort menu=new Menukort();
                tmpPizza.findIMenu(menu,pizzaID);
                tmpOrdre.tilføjPizza(tmpPizza);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }





    }




}
