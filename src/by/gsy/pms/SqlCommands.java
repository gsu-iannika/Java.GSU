package by.gsy.pms;


import java.sql.*;
import java.util.ArrayList;

public class SqlCommands {
    Connection connection;
    Statement statement;

    public SqlCommands(Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    public String displayInformationAboutSouvenirs(int id_manufacturer) throws SQLException {
        String query = "SELECT souvenirs.name_souvenir, manufacturers.name_manufacturer, souvenirs.release_date, souvenirs.price, manufacturers.country from (souvenirs \n" +
                "INNER JOIN manufacturers ON souvenirs.id_manufacturer = manufacturers.id_manufacturer) WHERE id_manufacturer = ?;\n";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(id_manufacturer));
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String id = resultSet.getString(1);
//            String name_souvenir = resultSet.getString(1);
//            String name_manufacturer = resultSet.getString(2);
//            String release_date = resultSet.getString(3);
//            String price = resultSet.getString(4);
//            String country = resultSet.getString(5);

//            result.add(name_souvenir + "; " + name_manufacturer + "; " + release_date + "; " + price + "; " + country);
            result.add(id);

        }

        return result.toString();
    }


    public String displayInformationAboutSouvenirsInTheProducedCountry(String country) throws SQLException {
        String query = "SELECT souvenirs.name_souvenir, manufacturers.name_manufacturer, souvenirs.release_date, souvenirs.price, manufacturers.country FROM (souvenirs \n" +
                "INNER JOIN manufacturers ON souvenirs.id_manufacturer = manufacturers.id_manufacturer) WHERE country = '?'";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(country));
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String name_souvenir = resultSet.getString(1);
            String name_manufacturer = resultSet.getString(2);
            String release_date = resultSet.getString(3);
            String price = resultSet.getString(4);


            result.add(name_souvenir + "; " + name_manufacturer + "; " + release_date + "; " + price );

        }

        return result.toString();
    }



}
