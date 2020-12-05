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

    public String displayInformationAboutSouvenirs(int id) throws SQLException {
        String query = "SELECT souvenir.name_souvenir, manufacturer.name_manufacturer, souvenir.release_date, souvenir.price, manufacturer.country from (souvenir \n" +
                "INNER JOIN manufacturer ON souvenir.id_manufacturer = manufacturer.id_manufacturer) WHERE manufacturer.id_manufacturer = ?;\n";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(id));
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String name_souvenir = resultSet.getString(1);
            String name_manufacturer = resultSet.getString(2);
            String release_date = resultSet.getString(3);
            String price = resultSet.getString(4);
            String country = resultSet.getString(5);

            result.add("\nназвание сувенира: " + name_souvenir + "; " + "производитель: " + name_manufacturer + "; " + "дату выпуска: " + release_date + "; " + "цена: " + price + "; " + "страна производителя: " + country);

        }

        return result.toString();
    }


    public String displayInformationAboutSouvenirsInTheProducedCountry(String country) throws SQLException {
        String query = "SELECT souvenir.name_souvenir, manufacturer.name_manufacturer, souvenir.release_date, souvenir.price, manufacturer.country FROM (souvenir \n" +
                "INNER JOIN manufacturer ON souvenir.id_manufacturer = manufacturer.id_manufacturer) WHERE manufacturer.country = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(country));
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String name_souvenir = resultSet.getString(1);
            String name_manufacturer = resultSet.getString(2);
            String release_date = resultSet.getString(3);
            String price = resultSet.getString(4);

            result.add("\nназвание сувенира: " + name_souvenir + "; " + "производитель: " + name_manufacturer + "; " + "дату выпуска: " + release_date + "; " + "цена: " + price);

        }

        return result.toString();
    }


    public String displayInfoAboutManufacturerWithLowerPrice(int price) throws SQLException {
        String query = "SELECT manufacturer.name_manufacturer, manufacturer.country, souvenir.price FROM (manufacturer \n" +
                "INNER JOIN souvenir ON souvenir.id_manufacturer = manufacturer.id_manufacturer) WHERE souvenir.price < ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(price));
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> result = new ArrayList<>();

        while (resultSet.next()){
            String name_manufacturer = resultSet.getString(1);
            String country = resultSet.getString(2);

            result.add("\nпроизводитель: " + name_manufacturer + "; " + "страна: " + country );

        }

        return result.toString();
    }


}
