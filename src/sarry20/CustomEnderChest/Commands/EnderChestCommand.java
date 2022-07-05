package sarry20.CustomEnderChest.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import sarry20.CustomEnderChest.Main;
import sarry20.CustomEnderChest.Inventory.InventoryManager;

public class EnderChestCommand implements CommandExecutor {
	private Main plugin;
	private static String[] savedArgs;

	public static String[] getArgs() {
		return savedArgs;
	}

	public EnderChestCommand(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player jugador = (Player) sender;
			InventoryManager inv = new InventoryManager(plugin);
			int num = 0;
			try {
				savedArgs = args;
				if (jugador.hasPermission("CustomEnderChest.view") || jugador.hasPermission("CustomEnderChest.edit")) {
					@SuppressWarnings("deprecation")
					OfflinePlayer pdiff = Bukkit.getOfflinePlayer(args[0]);

					inv.createDiffInventory(pdiff, jugador, plugin.getConfig().getString("Inventory.first_name_edit"),
							Material.GREEN_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
							Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX);
				} else if (jugador.hasPermission("CustomEnderChest.enderchest")) {
					num = 1;
					inv.createInventory(jugador, plugin.getConfig().getString("Inventory.first_name"),
							Material.GREEN_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
							Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX);

				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				if (num == 0) {
					if (jugador.hasPermission("CustomEnderChest.enderchest")) {
						inv.createInventory(jugador, plugin.getConfig().getString("Inventory.first_name"),
								Material.GREEN_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
								Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX);
					}
				}
			}
			return true;
		} else {
			FileConfiguration config = plugin.getConfig();
			String msg = config.getString("Command.ConsoleSender");
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			return false;
		}
	}
}