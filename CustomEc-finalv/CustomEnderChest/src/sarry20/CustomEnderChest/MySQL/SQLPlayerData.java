package sarry20.CustomEnderChest.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.inventory.ItemStack;

import sarry20.CustomEnderChest.utils.Convert;

public class SQLPlayerData {

	public static boolean playerExist(Connection connection, UUID uuid) {
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM CustomEnderChest WHERE (UUID=?)");
			statement.setString(1, uuid.toString());
			ResultSet resultado = statement.executeQuery();
			if (resultado.next()) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static void createPlayer(Connection connection, UUID uuid, String name) {
		String gap = "";
		try {
			if (!playerExist(connection, uuid)) {
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO CustomEnderChest VALUE(?,?,?,?,?,?,?)");
				statement.setString(1, uuid.toString());
				statement.setString(2, name);
				statement.setString(3, gap);
				statement.setString(4, gap);
				statement.setString(5, gap);
				statement.setString(6, gap);
				statement.setString(7, gap);

				statement.executeUpdate();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static void setInventory(Connection connection, UUID uuid, int number, ItemStack[] items_1,
			ItemStack[] items_2, ItemStack[] items_3, ItemStack[] items_4, ItemStack[] items_5) {
		String a = "";
		try {
			switch (number) {
			case 1:

//				Bukkit.getConsoleSender().sendMessage(items_1.length + "");
				a = Convert.ConvertItemStack2ByteArray(items_1);

				PreparedStatement statement1 = connection
						.prepareStatement("UPDATE CustomEnderChest SET EnderChest_1 = ? WHERE (UUID = ?)");
				statement1.setString(1, a);
				statement1.setString(2, uuid.toString());
				statement1.execute();
				break;
			case 2:
				a = Convert.ConvertItemStack2ByteArray(items_2);

				PreparedStatement statement2 = connection
						.prepareStatement("UPDATE CustomEnderChest SET EnderChest_2 = ? WHERE (UUID = ?)");
				statement2.setObject(1, a);
				statement2.setString(2, uuid.toString());
				statement2.execute();
				break;
			case 3:
				a = Convert.ConvertItemStack2ByteArray(items_3);

				PreparedStatement statement3 = connection
						.prepareStatement("UPDATE CustomEnderChest SET EnderChest_3 = ? WHERE (UUID = ?)");
				statement3.setObject(1, a);
				statement3.setString(2, uuid.toString());
				statement3.execute();
				break;
			case 4:
				a = Convert.ConvertItemStack2ByteArray(items_4);

				PreparedStatement statement4 = connection
						.prepareStatement("UPDATE CustomEnderChest SET EnderChest_4 = ? WHERE (UUID = ?)");
				statement4.setObject(1, a);
				statement4.setString(2, uuid.toString());
				statement4.execute();
				break;
			case 5:
				a = Convert.ConvertItemStack2ByteArray(items_5);

				PreparedStatement statement5 = connection
						.prepareStatement("UPDATE CustomEnderChest SET EnderChest_5 = ? WHERE (UUID = ?)");
				statement5.setObject(1, a);
				statement5.setString(2, uuid.toString());
				statement5.execute();
				break;

			}
//			PreparedStatement statement = connection.prepareStatement("UPDATE CustomEnderChest SET EnderChest_1 = ?, EnderChest_2 = ?, EnderChest_3 = ?, EnderChest_4 = ? WHERE (UUID = ?)");
//			statement.setString(1, uuid.toString());
//			statement.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static ItemStack[] getInventory(Connection connection, UUID uuid, int number) {
		String devolver = "";
		ItemStack[] stack = null;
		try {
			switch (number) {
			case 1:
				PreparedStatement statement1 = connection
						.prepareStatement("SELECT * FROM CustomEnderChest WHERE (UUID = ?)");
				statement1.setString(1, uuid.toString());
				ResultSet resultado1 = statement1.executeQuery();

				if (resultado1.next()) {
					devolver = resultado1.getString("EnderChest_1").toString();
					// Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"--AL LEER: " + devolver
					// + "$$");
					// Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"-----");

				}
				break;

			case 2:
				PreparedStatement statement2 = connection
						.prepareStatement("SELECT * FROM CustomEnderChest WHERE (UUID = ?)");
				statement2.setString(1, uuid.toString());
				ResultSet resultado2 = statement2.executeQuery();
				if (resultado2.next()) {
					devolver = resultado2.getString("EnderChest_2").toString();
					// Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"--AL LEER: " + devolver
					// + "$$");
					// Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"-----");

				}
				break;

			case 3:
				PreparedStatement statement3 = connection
						.prepareStatement("SELECT * FROM CustomEnderChest WHERE (UUID = ?)");
				statement3.setString(1, uuid.toString());
				ResultSet resultado3 = statement3.executeQuery();
				if (resultado3.next()) {
					devolver = resultado3.getString("EnderChest_3").toString();
					// Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"--AL LEER: " + devolver
					// + "$$");
					// Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"-----");

				}
				break;

			case 4:
				PreparedStatement statement4 = connection
						.prepareStatement("SELECT * FROM CustomEnderChest WHERE (UUID = ?)");
				statement4.setString(1, uuid.toString());
				ResultSet resultado4 = statement4.executeQuery();
				if (resultado4.next()) {
					devolver = resultado4.getString("EnderChest_4").toString();
					// Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"--AL LEER: " + devolver
					// + "$$");
					// Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"-----");

				}
				break;
			case 5:
				PreparedStatement statement5 = connection
						.prepareStatement("SELECT * FROM CustomEnderChest WHERE (UUID = ?)");
				statement5.setString(1, uuid.toString());
				ResultSet resultado5 = statement5.executeQuery();
				if (resultado5.next()) {
					devolver = resultado5.getString("EnderChest_5").toString();
					// Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"--AL LEER: " + devolver
					// + "$$");
					// Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"-----");
				}
				break;

			}
//			PreparedStatement statement = connection.prepareStatement("UPDATE CustomEnderChest SET EnderChest_1 = ?, EnderChest_2 = ?, EnderChest_3 = ?, EnderChest_4 = ? WHERE (UUID = ?)");
//			statement.setString(1, uuid.toString());
//			statement.executeQuery();
//			Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"--ANTES DE ENTRAR: " + devolver + "$$");
//			Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"-----");

			stack = Convert.ConvertByteArray2ItemStack(devolver);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return stack;
	}
}