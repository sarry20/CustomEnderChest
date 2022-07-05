package sarry20.CustomEnderChest;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;
import sarry20.CustomEnderChest.Commands.EnderChestCommand;
import sarry20.CustomEnderChest.Events.PlayerJoin;
import sarry20.CustomEnderChest.Inventory.FirstInventory;
import sarry20.CustomEnderChest.Inventory.FourthInventory;
import sarry20.CustomEnderChest.Inventory.InventoryManager;
import sarry20.CustomEnderChest.Inventory.secondInventory;
import sarry20.CustomEnderChest.Inventory.thirdInventory;
import sarry20.CustomEnderChest.MySQL.Connect;
import sarry20.CustomEnderChest.MySQL.DatabaseCreation;
import sarry20.CustomEnderChest.block.EnderChestBlock;

public class Main extends JavaPlugin {
	private File customConfigFile;
	private FileConfiguration customConfig;
	PluginDescriptionFile pdffile = getDescription();
	public String version = pdffile.getVersion();
	private static Economy econ = null;
	public String nombre = ChatColor.RED + "[" + ChatColor.RED + pdffile.getName() + ChatColor.RED + "] ";
	public FileConfiguration config = this.getCustomConfig();
	private Connect connection;

	// Run on Enable
	@Override
	public void onEnable() {
		startupMessages();
		createCustomConfig();
		customConfig = this.getConfig();
		String host = this.getCustomConfig().getString("MySQL.host");
		int port = customConfig.getInt("MySQL.port");
		String database = customConfig.getString("MySQL.database");
		String username = customConfig.getString("MySQL.username");
		String password = customConfig.getString("MySQL.password");
		this.connection = new Connect(host, port, database, username, password);
		DatabaseCreation.createTables(getMySQL());
		if (setupEconomy()) {
			Bukkit.getConsoleSender()
					.sendMessage(nombre + ChatColor.GRAY + "Vault Plugin: " + ChatColor.GREEN + "Found");
			// Bukkit.getConsoleSender().sendMessage(nombre + ChatColor.WHITE + "");
		} else {
			Bukkit.getConsoleSender()
					.sendMessage(nombre + ChatColor.GRAY + "Vault Plugin: " + ChatColor.RED + "Not found");
			// Bukkit.getConsoleSender().sendMessage(nombre + ChatColor.WHITE + "");
		}
		registerEvents();
		registerCommands();
	}

	// Run on Disable
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(nombre + ChatColor.WHITE + "Plugin deactivated");
		Bukkit.getConsoleSender().sendMessage(nombre + ChatColor.WHITE + "Version: " + ChatColor.RED + version);
	}

	// Commands
	public void registerCommands() {
		this.getCommand("enderchest").setExecutor(new EnderChestCommand(this));
	}

	// Vault Plugin Setup
	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	// Vault warning suppression
	@SuppressWarnings("static-access")
	public Economy getEconomy() {
		return this.econ;
	}

	// Event Handler
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new InventoryManager(this), this);
		pm.registerEvents(new FirstInventory(this), this);
		pm.registerEvents(new secondInventory(this), this);
		pm.registerEvents(new thirdInventory(this), this);
		pm.registerEvents(new FourthInventory(this), this);
		pm.registerEvents(new EnderChestBlock(this), this);

//		pm.registerEvents(new fifthInventory(this),this);
	}

	// MySQL Connection Status
	public Connection getMySQL() {
		return this.connection.getConnection();
	}

	// Config Settings
	public FileConfiguration getCustomConfig() {
		return this.customConfig;
	}

	// Create Config if it doesen't exist
	private void createCustomConfig() {
		customConfigFile = new File(getDataFolder(), "config.yml");
		if (!customConfigFile.exists()) {
			customConfigFile.getParentFile().mkdirs();
			saveResource("config.yml", false);
		}

		customConfig = new YamlConfiguration();
		try {
			customConfig.load(customConfigFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	// Startup Console Spam
	public void startupMessages() {
		Bukkit.getConsoleSender()
				.sendMessage(nombre + ChatColor.WHITE + "--------------------------------------------------------");
		Bukkit.getConsoleSender()
				.sendMessage(nombre + ChatColor.WHITE + ".__          __   ___   __    _   _       __    __     |");
		Bukkit.getConsoleSender()
				.sendMessage(nombre + ChatColor.WHITE + "|    |   |  |__    |   |  |  | |_| |     |__   |       |");
		Bukkit.getConsoleSender()
				.sendMessage(nombre + ChatColor.WHITE + "|__  |___|   __|   |   |__|  |     |     |__   |__     |");
		Bukkit.getConsoleSender()
				.sendMessage(nombre + ChatColor.WHITE + "                                                       |");
		Bukkit.getConsoleSender()
				.sendMessage(nombre + ChatColor.WHITE + "--------------------------------------------------------");
		Bukkit.getConsoleSender().sendMessage(nombre + ChatColor.WHITE + "");
		Bukkit.getConsoleSender()
				.sendMessage(nombre + ChatColor.WHITE + "Version: " + ChatColor.RED + version + ChatColor.WHITE + "");
		Bukkit.getConsoleSender().sendMessage(nombre + ChatColor.WHITE + "");
		Bukkit.getConsoleSender()
				.sendMessage(nombre + ChatColor.WHITE + "--------------------------------------------------------");
		Bukkit.getConsoleSender().sendMessage(nombre + ChatColor.WHITE + "");
	}
}