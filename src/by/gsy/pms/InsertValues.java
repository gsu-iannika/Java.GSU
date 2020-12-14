package by.gsy.pms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class InsertValues {
	Connection connection;

	public InsertValues(Connection connection){
		this.connection = connection;
	}

	// create method for INSERT 
	public void insertValues() throws SQLException {

		Statement statement = connection.createStatement();

		try {
			// creating INSERT request into DB
			statement.executeUpdate("INSERT INTO souvenir (name_souvenir, id_manufacturer, release_date, price) VALUES ('Шар предсказаний', 1, '2020-10-25', 15.36)");
			statement.executeUpdate("INSERT INTO souvenir (name_souvenir, id_manufacturer, release_date, price) VALUES ('Брелок Авокадо', 2, '2020-09-28', 5.95)");
			statement.executeUpdate("INSERT INTO souvenir (name_souvenir, id_manufacturer, release_date, price) VALUES ('Подставка под кружку', 4, '2020-10-15', 5.90)");
			statement.executeUpdate("INSERT INTO souvenir (name_souvenir, id_manufacturer, release_date, price) VALUES ('Игрушка-антистресс Скользун', 3, '2020-11-08', 4.73)");
			statement.executeUpdate("INSERT INTO souvenir (name_souvenir, id_manufacturer, release_date, price) VALUES ('Матрёшка \\\"Колобок\\\"', 5, '2020-11-23', 33.84)");
			statement.executeUpdate("INSERT INTO souvenir (name_souvenir, id_manufacturer, release_date, price) VALUES ('Матрёшка \\\"Курочка Ряба\\\"', 5, '2020-11-26', 26.03)");


			statement.executeUpdate("INSERT INTO manufacturer (name_manufacturer, country) VALUES ('ООО \"Новая Идея\"', 'Российская Империя')");
			statement.executeUpdate("INSERT INTO manufacturer (name_manufacturer, country) VALUES ('СООО \"Волшебный остров\"', 'Беларусь')");
			statement.executeUpdate("INSERT INTO manufacturer (name_manufacturer, country) VALUES ('ChuangHeng Toys Co. LTD.', 'Китай')");
			statement.executeUpdate("INSERT INTO manufacturer (name_manufacturer, country) VALUES ('ИП Давыдова Е.А', 'Беларусь')");
			statement.executeUpdate("INSERT INTO manufacturer (name_manufacturer, country) VALUES ('ООО ТД \"Бэмби\"', 'Российская Империя')");
			

			


		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("EXEPTION: " + e);
		}
		
		
	}
}
