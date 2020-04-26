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
        // ordre oprettes med dato som dags dato
        LocalDate dato = LocalDate.now();
        LocalTime afhentningstidspunkt = ordre.getAfhentningsTidspunkt();
        // ordren er åben
        int aaben=1;

        //laver ny ordre..
        sqlQuery = "Insert into ordre (dato,afhentningstidspunkt,aaben) " +
                "Values(\"" + dato + "\",\"" + afhentningstidspunkt + "\",\""+ aaben + "\")";
        // lave statement
        try {
            Statement stmt = conn.createStatement();
            //opret i DB
            stmt.executeUpdate(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            // modtag ordreID fr DB
            ResultSet res = stmt.getGeneratedKeys();
            res.next();
            ordreID = res.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        /* læg pizzaer og ordre i sammenføjningstabel*/
        // hent pizzaer fr ordre over i arraylist
        ArrayList<Pizza> pizzaer = new ArrayList<>();
        pizzaer = ordre.getPizzaer();

        // for alle pizzaer i listen tilføjes pizzaID og OrdreID til sammenføjningstabel
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
        //returner ordre i fra DB
        return ordreID;
    }

    public void afslutOrdre(Ordre ordre){
        // Afslut ordre ændrer kun staus fra åben til lukket
        String sqlQuery = "";
        Connection conn = DBConnector.getInstance().getConnection();
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
        //  The JDBC-cycle
        Connection conn = DBConnector.getInstance().getConnection();
        try {
            query = "SELECT * FROM ordre WHERE aaben=1;";
            Statement stmt = conn.createStatement();
            ResultSet resOrdre = stmt.executeQuery(query);
            while(resOrdre.next()) {
                // laver en ordre per iteration og gemmer i ordrebog
               int ordreID=resOrdre.getInt("OrdreID");
               Time afhentningsTidspunkt = resOrdre.getTime("afhentningstidspunkt");
               tmpOrdre = new Ordre();
               tmpOrdre.setOrdreId(ordreID);
               tmpOrdre.tilføjKlokkeSlet(afhentningsTidspunkt.toLocalTime());

               try {//find pizzaer i ordrepizza hvor ordrID er den fundne
                    stmt = conn.createStatement();
                    query = "SELECT * FROM ordrepizza WHERE ordreID="+tmpOrdre.getOrdreId()+";";
                    ResultSet res = stmt.executeQuery(query);
                    while(res.next()) {
                        // laver en ordre per iteration og gemmer i listen
                        int pizzaID=res.getInt("PizzaID");
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
    }
}
