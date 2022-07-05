package sarry20.CustomEnderChest.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.ChatColor;

public class Connect {
	private Connection connection;

	private String host;
	private int port;
	private String database;
	private String username;
	private String password;

	public Connect(String host, int port, String database, String username, String password) {
		this.host = host;
		this.port = port;
		this.database = database;
		this.username = username;
		this.password = password;

		try {
			synchronized (this) {
				if (connection != null && !connection.isClosed()) {
					Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[CustomEnderChest] " + ChatColor.WHITE
							+ "Error Connecting with the database.");
					Bukkit.getConsoleSender().sendMessage(
							ChatColor.RED + "[CustomEnderChest] " + ChatColor.WHITE + ChatColor.WHITE + "");
				}
			}
			Class.forName("com.mysql.cj.jdbc.Driver");
			 this.connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + 
			          this.database + 
			          "?useUnicode=yes&characterEncoding=UTF-8&failOverReadOnly=false&maxReconnects=10&autoReconnect=true", 
			          this.username, this.password);
			Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[CustomEnderChest] " + ChatColor.WHITE
					+ "Sucessfully connected with the database.");
			Bukkit.getConsoleSender()
					.sendMessage(ChatColor.RED + "[CustomEnderChest] " + ChatColor.WHITE + ChatColor.WHITE + "");

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
}