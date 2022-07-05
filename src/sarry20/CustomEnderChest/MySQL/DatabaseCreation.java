package sarry20.CustomEnderChest.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseCreation {
	public static boolean createTables(Connection connection) {
		try {
			PreparedStatement statement = connection
					.prepareStatement("CREATE TABLE IF NOT EXISTS `CustomEnderChest` (\n"
							+ "	`UUID` VARCHAR(80) NOT NULL COLLATE 'utf8mb4_general_ci',\n"
							+ "	`Name` VARCHAR(40) NOT NULL COLLATE 'utf8mb4_general_ci',\n"
							+ "	`EnderChest_1` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',\n"
							+ "	`EnderChest_2` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',\n"
							+ "	`EnderChest_3` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',\n"
							+ "	`EnderChest_4` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',\n"
							+ "	`EnderChest_5` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci'\n" + ")\n"
							+ "COLLATE='utf8mb4_general_ci'\n" + "ENGINE=InnoDB\n" + ";");
			statement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}