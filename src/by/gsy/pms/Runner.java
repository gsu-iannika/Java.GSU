package by.gsy.pms;


import java.sql.*;

public class Runner {

    public static void main(String args[]) throws SQLException {

        String query = "select * from souvenir";

        Connection conn = new ConnectionUtils().get_connection();
        Statement statement = conn.createStatement();


        statement.executeUpdate("CREATE TABLE souvenir ( id_souvenir INT PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                "name_souvenir VARCHAR(45) NOT NULL, " +
                "id_manufacturer INT NOT NULL, " +
                "release_date DATE NOT NULL, " +
                "price DECIMAL(4,2) NOT NULL);");

        statement.executeUpdate("CREATE TABLE manufacturer ( id_manufacturer INT PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                "name_manufacturer VARCHAR(45) NOT NULL, " +
                "country VARCHAR(45) NOT NULL);");

        InsertValues addInfo = new InsertValues(conn);
        addInfo.insertValues();

        SqlCommands sqlCommands = new SqlCommands(conn);

        System.out.println(sqlCommands.displayInformationAboutSouvenirs(5));
        System.out.println(sqlCommands.displayInformationAboutSouvenirsInTheProducedCountry("Белоруссия"));


        // widget html

        HTMLWidget html = new HTMLWidget();
        html.saveWidgetHtml(sqlCommands.displayInformationAboutSouvenirs(2));


    }
}
