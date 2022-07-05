package sarry20.CustomEnderChest.Inventory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import sarry20.CustomEnderChest.Main;
import sarry20.CustomEnderChest.Commands.EnderChestCommand;
import sarry20.CustomEnderChest.MySQL.SQLPlayerData;

public class InventoryManager implements Listener {
	private Main plugin;

	public InventoryManager(Main plugin) {
		this.plugin = plugin;
	}

	public void createInventory(Player jugador, String name, Material first, Material second, Material third,
			Material fourth, Material fifth) {
		// inventory main
		FileConfiguration config = plugin.getConfig();
		if (name == "" || name == null) {
			name = config.getString("Inventory.first_ec_name");
		}
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', name));

		// Create first enderchest

		ItemStack item = new ItemStack(first);
		ItemMeta meta = item.getItemMeta();
		String ec1name = config.getString("Inventory.first_ec_name");
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ec1name));
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', ec1name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(45, item);

		// Create second enderchest

		item = new ItemStack(second);
		meta = item.getItemMeta();
		String ec2name = config.getString("Inventory.second_ec_name");
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ec2name));
		lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', ec2name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(47, item);

		// Create third enderchest

		item = new ItemStack(third);
		meta = item.getItemMeta();
		String ec3name = config.getString("Inventory.third_ec_name");
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ec3name));
		lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', ec3name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(49, item);

		// Create fourth enderchest

		item = new ItemStack(fourth);
		meta = item.getItemMeta();
		String ec4name = config.getString("Inventory.fourth_ec_name");
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ec4name));
		lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', ec4name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(51, item);

		// Create fifth enderchest

		item = new ItemStack(fifth);
		meta = item.getItemMeta();
		String ec5name = config.getString("Inventory.fifth_ec_name");
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ec5name));
		lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', ec5name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(53, item);


		jugador.openInventory(inv);

	}

	public void createDiffInventory(OfflinePlayer pdiff, Player jugador, String name, Material first, Material second,
			Material third, Material fourth, Material fifth) {
		// inventory main
		FileConfiguration config = plugin.getConfig();
		if (name == "" || name == null) {
			name = config.getString("Inventory.first_ec_name_edit");
		}
		Inventory inv = Bukkit.createInventory(null, 54, ChatColor.translateAlternateColorCodes('&', name));
		// Create first enderchest

		ItemStack item = new ItemStack(first);
		ItemMeta meta = item.getItemMeta();
		String ec1name = config.getString("Inventory.first_ec_name_edit");
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ec1name));
		List<String> lore = new ArrayList<String>();
		 lore.add(ChatColor.translateAlternateColorCodes('&', ec1name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(45, item);

		// Create second enderchest

		item = new ItemStack(second);
		meta = item.getItemMeta();
		String ec2name = config.getString("Inventory.second_ec_name_edit");
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ec2name));
		lore = new ArrayList<String>();
		 lore.add(ChatColor.translateAlternateColorCodes('&', ec2name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(47, item);

		// Create third enderchest

		item = new ItemStack(third);
		meta = item.getItemMeta();
		String ec3name = config.getString("Inventory.third_ec_name_edit");
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ec3name));
		lore = new ArrayList<String>();
		// lore.add(ChatColor.translateAlternateColorCodes('&', ec3name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(49, item);

		// Create fourth enderchest

		item = new ItemStack(fourth);
		meta = item.getItemMeta();
		String ec4name = config.getString("Inventory.fourth_ec_name_edit");
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ec4name));
		lore = new ArrayList<String>();
		 lore.add(ChatColor.translateAlternateColorCodes('&', ec4name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(51, item);

		// Create fifth enderchest

		item = new ItemStack(fifth);
		meta = item.getItemMeta();
		String ec5name = config.getString("Inventory.fifth_ec_name_edit");
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ec5name));
		lore = new ArrayList<String>();
		 lore.add(ChatColor.translateAlternateColorCodes('&', ec5name));
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(53, item);

		// ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		// inv.setItem(46, glass);
		// inv.setItem(48, glass);
		// inv.setItem(50, glass);
		// inv.setItem(52, glass);

		jugador.openInventory(inv);

	}

	// Handles clicks in the enderchests
	@EventHandler
	public void ClickInventory(InventoryClickEvent event) {
		// inventory Main
		Player jugador = (Player) event.getWhoClicked();
		FileConfiguration config = plugin.getCustomConfig();
		String first = config.getString("Inventory.first_ec_name");
		String second = config.getString("Inventory.second_ec_name");
		String third = config.getString("Inventory.third_ec_name");
		String fourth = config.getString("Inventory.fourth_ec_name");
		String fifth = config.getString("Inventory.fifth_ec_name");

		String name1 = ChatColor.translateAlternateColorCodes('&', first);
		String name2 = ChatColor.translateAlternateColorCodes('&', second);
		String name3 = ChatColor.translateAlternateColorCodes('&', third);
		String name4 = ChatColor.translateAlternateColorCodes('&', fourth);
		String name5 = ChatColor.translateAlternateColorCodes('&', fifth);

		String first_edit = config.getString("Inventory.first_ec_name_edit");
		String second_edit = config.getString("Inventory.second_ec_name_edit");
		String third_edit = config.getString("Inventory.third_ec_name_edit");
		String fourth_edit = config.getString("Inventory.fourth_ec_name_edit");
		String fifth_edit = config.getString("Inventory.fifth_ec_name_edit");

		String name1_edit = ChatColor.translateAlternateColorCodes('&', first_edit);
		String name2_edit = ChatColor.translateAlternateColorCodes('&', second_edit);
		String name3_edit = ChatColor.translateAlternateColorCodes('&', third_edit);
		String name4_edit = ChatColor.translateAlternateColorCodes('&', fourth_edit);
		String name5_edit = ChatColor.translateAlternateColorCodes('&', fifth_edit);

		if (event.getView().getTitle().equals(name1) || event.getView().getTitle().equals(name2)
				|| event.getView().getTitle().equals(name3) || event.getView().getTitle().equals(name4)
				|| event.getView().getTitle().equals(name5)) {

			if (event.getSlot() == 45) {
				createInventory(jugador, first, Material.GREEN_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
						Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX);

				event.setCancelled(true);
				return;
			} else if (event.getSlot() == 47) {
				if (jugador.hasPermission("CustomEnderChest_1.44") || jugador.hasPermission("CustomEnderChest.*")) {

					createInventory(jugador, second, Material.GRAY_SHULKER_BOX, Material.GREEN_SHULKER_BOX,
							Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX);
				}
				event.setCancelled(true);
				return;
			} else if (event.getSlot() == 49) {
				if (jugador.hasPermission("CustomEnderChest_2.44") || jugador.hasPermission("CustomEnderChest.*")) {

					createInventory(jugador, third, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
							Material.GREEN_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX);

				}
				event.setCancelled(true);
				return;
			} else if (event.getSlot() == 51) {
				if (jugador.hasPermission("CustomEnderChest_3.44") || jugador.hasPermission("CustomEnderChest.*")) {

					createInventory(jugador, fourth, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
							Material.GRAY_SHULKER_BOX, Material.GREEN_SHULKER_BOX, Material.GRAY_SHULKER_BOX);
				}
				event.setCancelled(true);
				return;
			} else if (event.getSlot() == 53) {
				if (jugador.hasPermission("CustomEnderChest_5")) {
					createInventory(jugador, fifth, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
							Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GREEN_SHULKER_BOX);
				}
				event.setCancelled(true);
				return;
			} 
		}

		else if (event.getView().getTitle().equals(name1_edit) || event.getView().getTitle().equals(name2_edit)
				|| event.getView().getTitle().equals(name3_edit) || event.getView().getTitle().equals(name4_edit)
				|| event.getView().getTitle().equals(name5_edit)) {
			String[] args = EnderChestCommand.getArgs();
			@SuppressWarnings("deprecation")
			OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);
			if (event.getSlot() == 45) {
				createDiffInventory(p, jugador, first_edit, Material.GREEN_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
						Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX);

				event.setCancelled(true);
				return;

			} else if (event.getSlot() == 47) {
				if (jugador.hasPermission("CustomEnderChest_1.44") || jugador.hasPermission("CustomEnderChest.*")) {

					createDiffInventory(p, jugador, second_edit, Material.GRAY_SHULKER_BOX, Material.GREEN_SHULKER_BOX,
							Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX);
				}
				event.setCancelled(true);
				return;
			} else if (event.getSlot() == 49) {
				if (jugador.hasPermission("CustomEnderChest_2.44") || jugador.hasPermission("CustomEnderChest.*")) {

					createDiffInventory(p, jugador, third_edit, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
							Material.GREEN_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX);

				}
				event.setCancelled(true);
				return;
			} else if (event.getSlot() == 51) {
				if (jugador.hasPermission("CustomEnderChest_3.44") || jugador.hasPermission("CustomEnderChest.*")) {

					createDiffInventory(p, jugador, fourth_edit, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
							Material.GRAY_SHULKER_BOX, Material.GREEN_SHULKER_BOX, Material.GRAY_SHULKER_BOX);
				}
				event.setCancelled(true);
				return;
			} else if (event.getSlot() == 53) {
				if (jugador.hasPermission("CustomEnderChest_5") || jugador.hasPermission("CustomEnderChest.*")) {
					createDiffInventory(p, jugador, fifth_edit, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
							Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GREEN_SHULKER_BOX);
				}
				event.setCancelled(true);
				return;
			} 

			
			
		}
	}

	static ItemStack[] items_1;
	static ItemStack[] items_2;
	static ItemStack[] items_3;
	static ItemStack[] items_4;
	static ItemStack[] items_5;
	static int number;

	@EventHandler
	public void CloseInventory(InventoryCloseEvent event) {
		Player player = (Player) event.getPlayer();
		FileConfiguration config = plugin.getCustomConfig();

		String first = config.getString("Inventory.first_ec_name");
		String second = config.getString("Inventory.second_ec_name");
		String third = config.getString("Inventory.third_ec_name");
		String fourth = config.getString("Inventory.fourth_ec_name");
		String fifth = config.getString("Inventory.fifth_ec_name");

		String name1 = ChatColor.translateAlternateColorCodes('&', first);
		String name2 = ChatColor.translateAlternateColorCodes('&', second);
		String name3 = ChatColor.translateAlternateColorCodes('&', third);
		String name4 = ChatColor.translateAlternateColorCodes('&', fourth);
		String name5 = ChatColor.translateAlternateColorCodes('&', fifth);

		String first_edit = config.getString("Inventory.first_ec_name_edit");
		String second_edit = config.getString("Inventory.second_ec_name_edit");
		String third_edit = config.getString("Inventory.third_ec_name_edit");
		String fourth_edit = config.getString("Inventory.fourth_ec_name_edit");
		String fifth_edit = config.getString("Inventory.fifth_ec_name_edit");

		String name1_edit = ChatColor.translateAlternateColorCodes('&', first_edit);
		String name2_edit = ChatColor.translateAlternateColorCodes('&', second_edit);
		String name3_edit = ChatColor.translateAlternateColorCodes('&', third_edit);
		String name4_edit = ChatColor.translateAlternateColorCodes('&', fourth_edit);
		String name5_edit = ChatColor.translateAlternateColorCodes('&', fifth_edit);

		if (event.getView().getTitle().equals(name1)) {
			number = 1;
			try {
				items_1 = event.getInventory().getStorageContents();

				SQLPlayerData.setInventory(plugin.getMySQL(), player.getUniqueId(), number, items_1, items_2, items_3,
						items_4, items_5);

			} catch (NullPointerException e) {
				Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred");

			}

		} else if (event.getView().getTitle().equals(name2)) {
			number = 2;
			try {
				items_2 = event.getInventory().getStorageContents();

				SQLPlayerData.setInventory(plugin.getMySQL(), player.getUniqueId(), number, items_1, items_2, items_3,
						items_4, items_5);
			} catch (NullPointerException e) {
				Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred");

			}

		} else if (event.getView().getTitle().equals(name3)) {
			number = 3;
			try {
				items_3 = event.getInventory().getStorageContents();

				SQLPlayerData.setInventory(plugin.getMySQL(), player.getUniqueId(), number, items_1, items_2, items_3,
						items_4, items_5);
			} catch (NullPointerException e) {
				Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred");

			}

		} else if (event.getView().getTitle().equals(name4)) {
			number = 4;
			try {
				items_4 = event.getInventory().getStorageContents();

				SQLPlayerData.setInventory(plugin.getMySQL(), player.getUniqueId(), number, items_1, items_2, items_3,
						items_4, items_5);
			} catch (NullPointerException e) {
				Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred ");

			}

		} else if (event.getView().getTitle().equals(name5)) {
			number = 5;
			try {
				items_5 = event.getInventory().getStorageContents();

				SQLPlayerData.setInventory(plugin.getMySQL(), player.getUniqueId(), number, items_1, items_2, items_3,
						items_4, items_5);
			} catch (NullPointerException e) {
				Bukkit.getConsoleSender().sendMessage(plugin.nombre+ " An error ocurred");

			}

		}

		else if (event.getView().getTitle().equals(name1_edit) || event.getView().getTitle().equals(name2_edit)
				|| event.getView().getTitle().equals(name3_edit) || event.getView().getTitle().equals(name4_edit)
				|| event.getView().getTitle().equals(name5_edit)) {
			String[] args = EnderChestCommand.getArgs();
			@SuppressWarnings("deprecation")
			OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);
			if (event.getView().getTitle().equals(name1_edit)) {
				number = 1;
				try {
					if (player.hasPermission("CustomEnderChest.edit")) {

						items_1 = event.getInventory().getStorageContents();

						SQLPlayerData.setInventory(plugin.getMySQL(), p.getUniqueId(), number, items_1, items_2,
								items_3, items_4, items_5);
					}
				} catch (NullPointerException e) {
					Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred ");

				}

			} else if (event.getView().getTitle().equals(name2_edit)) {
				number = 2;
				try {
					if (player.hasPermission("CustomEnderChest.edit")) {

						items_2 = event.getInventory().getStorageContents();

						SQLPlayerData.setInventory(plugin.getMySQL(), p.getUniqueId(), number, items_1, items_2,
								items_3, items_4, items_5);
					}
				} catch (NullPointerException e) {
					Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred");

				}

			} else if (event.getView().getTitle().equals(name3_edit)) {
				number = 3;
				try {
					if (player.hasPermission("CustomEnderChest.edit")) {

						items_3 = event.getInventory().getStorageContents();

						SQLPlayerData.setInventory(plugin.getMySQL(), p.getUniqueId(), number, items_1, items_2,
								items_3, items_4, items_5);
					}
				} catch (NullPointerException e) {
					Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred");

				}

			} else if (event.getView().getTitle().equals(name4_edit)) {
				number = 4;
				try {
					if (player.hasPermission("CustomEnderChest.edit")) {

						items_4 = event.getInventory().getStorageContents();

						SQLPlayerData.setInventory(plugin.getMySQL(), p.getUniqueId(), number, items_1, items_2,
								items_3, items_4, items_5);
					}
				} catch (NullPointerException e) {
					Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred");

				}

			} else if (event.getView().getTitle().equals(name5_edit)) {
				number = 5;
				try {
					if (player.hasPermission("CustomEnderChest.edit")) {

						items_5 = event.getInventory().getStorageContents();

						SQLPlayerData.setInventory(plugin.getMySQL(), p.getUniqueId(), number, items_1, items_2,
								items_3, items_4, items_5);
					}
				} catch (NullPointerException e) {
					Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred");

				}

			}
		}
	}

	@EventHandler
	public void OpenInventory(InventoryOpenEvent event) {
		Player player = (Player) event.getPlayer();
		FileConfiguration config = plugin.getConfig();
		String first = config.getString("Inventory.first_ec_name");
		String second = config.getString("Inventory.second_ec_name");
		String third = config.getString("Inventory.third_ec_name");
		String fourth = config.getString("Inventory.fourth_ec_name");
		String fifth = config.getString("Inventory.fifth_ec_name");

		String name1 = ChatColor.translateAlternateColorCodes('&', first);
		String name2 = ChatColor.translateAlternateColorCodes('&', second);
		String name3 = ChatColor.translateAlternateColorCodes('&', third);
		String name4 = ChatColor.translateAlternateColorCodes('&', fourth);
		String name5 = ChatColor.translateAlternateColorCodes('&', fifth);

		String first_edit = config.getString("Inventory.first_ec_name_edit");
		String second_edit = config.getString("Inventory.second_ec_name_edit");
		String third_edit = config.getString("Inventory.third_ec_name_edit");
		String fourth_edit = config.getString("Inventory.fourth_ec_name_edit");
		String fifth_edit = config.getString("Inventory.fifth_ec_name_edit");

		String name1_edit = ChatColor.translateAlternateColorCodes('&', first_edit);
		String name2_edit = ChatColor.translateAlternateColorCodes('&', second_edit);
		String name3_edit = ChatColor.translateAlternateColorCodes('&', third_edit);
		String name4_edit = ChatColor.translateAlternateColorCodes('&', fourth_edit);
		String name5_edit = ChatColor.translateAlternateColorCodes('&', fifth_edit);

		if (event.getView().getTitle().equals(name1)) {
			number = 1;
			try {

				items_1 = SQLPlayerData.getInventory(plugin.getMySQL(), player.getUniqueId(), number);

				if (!(items_1 == null)) {
					event.getInventory().setStorageContents(items_1);

				}

			} catch (NullPointerException e) {
				Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred");
				e.printStackTrace();
			} catch (Exception e) {
				Bukkit.getConsoleSender()
						.sendMessage(plugin.nombre+" An unreachable error occured or a player tried to fill his enderchest with null");
			}

		} else if (event.getView().getTitle().equals(name2)) {
			number = 2;
			try {

				items_2 = SQLPlayerData.getInventory(plugin.getMySQL(), player.getUniqueId(), number);

				if (!(items_2 == null)) {
					event.getInventory().setStorageContents(items_2);

				}

			} catch (NullPointerException e) {
				Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred");
				e.printStackTrace();
			} catch (Exception e) {
				Bukkit.getConsoleSender()
						.sendMessage(plugin.nombre+" An unreachable error occured or a player tried to fill his enderchest with null");
			}

		} else if (event.getView().getTitle().equals(name3)) {
			number = 3;
			try {

				items_3 = SQLPlayerData.getInventory(plugin.getMySQL(), player.getUniqueId(), number);

				if (!(items_3 == null)) {
					event.getInventory().setStorageContents(items_3);

				}

			} catch (NullPointerException e) {
				Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred");
				e.printStackTrace();
			} catch (Exception e) {
				Bukkit.getConsoleSender()
						.sendMessage(plugin.nombre+" An unreachable error occured or a player tried to fill his enderchest with null");
			}

		} else if (event.getView().getTitle().equals(name4)) {
			number = 4;
			try {

				items_4 = SQLPlayerData.getInventory(plugin.getMySQL(), player.getUniqueId(), number);

				if (!(items_4 == null)) {
					event.getInventory().setStorageContents(items_4);

				}

			} catch (NullPointerException e) {
				Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred ");
				e.printStackTrace();
			} catch (Exception e) {
				Bukkit.getConsoleSender()
						.sendMessage(plugin.nombre+" An unreachable error occured or a player tried to fill his enderchest with null");
			}

		} else if (event.getView().getTitle().equals(name5)) {
			number = 5;
			try {

				items_5 = SQLPlayerData.getInventory(plugin.getMySQL(), player.getUniqueId(), number);

				if (!(items_5 == null)) {
					event.getInventory().setStorageContents(items_5);

				}

			} catch (NullPointerException e) {
				Bukkit.getConsoleSender().sendMessage(plugin.nombre+" An error ocurred");
				e.printStackTrace();
			} catch (Exception e) {
				Bukkit.getConsoleSender()
						.sendMessage(plugin.nombre+" An unreachable error occured or a player tried to fill his enderchest with null");
			}

		}

		else if (event.getView().getTitle().equals(name1_edit) || event.getView().getTitle().equals(name2_edit)
				|| event.getView().getTitle().equals(name3_edit) || event.getView().getTitle().equals(name4_edit)
				|| event.getView().getTitle().equals(name5_edit)) {
			String[] args = EnderChestCommand.getArgs();
			@SuppressWarnings("deprecation")
			OfflinePlayer p = Bukkit.getOfflinePlayer(args[0]);
			if (event.getView().getTitle().equals(name1_edit)) {
				number = 1;
				try {
					if (player.hasPermission("CustomEnderChest.view")
							|| player.hasPermission("CustomEnderChest.edit")) {
						items_1 = SQLPlayerData.getInventory(plugin.getMySQL(), p.getUniqueId(), number);

						if (!(items_1 == null)) {
							event.getInventory().setStorageContents(items_1);

						}
					} else {
						player.closeInventory();
					}
				} catch (NullPointerException e) {
					Bukkit.getConsoleSender()
							.sendMessage(plugin.nombre+" An error ocurred ");
					e.printStackTrace();
				} catch (Exception e) {
					Bukkit.getConsoleSender().sendMessage(
							plugin.nombre+" An unreachable error occured or a player tried to fill his enderchest with null");
				}

			} else if (event.getView().getTitle().equals(name2_edit)) {
				number = 2;
				try {
					if (player.hasPermission("CustomEnderChest.view")
							|| player.hasPermission("CustomEnderChest.edit")) {

						items_2 = SQLPlayerData.getInventory(plugin.getMySQL(), p.getUniqueId(), number);

						if (!(items_2 == null)) {
							event.getInventory().setStorageContents(items_2);

						}
					} else {
						player.closeInventory();

					}

				} catch (NullPointerException e) {
					Bukkit.getConsoleSender()
							.sendMessage(plugin.nombre+" An error ocurred");
					e.printStackTrace();
				} catch (Exception e) {
					Bukkit.getConsoleSender().sendMessage(
							plugin.nombre+" An unreachable error occured or a player tried to fill his enderchest with null");
				}

			} else if (event.getView().getTitle().equals(name3_edit)) {
				number = 3;
				try {
					if (player.hasPermission("CustomEnderChest.view")
							|| player.hasPermission("CustomEnderChest.edit")) {

						items_3 = SQLPlayerData.getInventory(plugin.getMySQL(), p.getUniqueId(), number);

						if (!(items_3 == null)) {
							event.getInventory().setStorageContents(items_3);

						}
					} else {
						player.closeInventory();

					}

				} catch (NullPointerException e) {
					Bukkit.getConsoleSender()
							.sendMessage(plugin.nombre+" An error ocurred");
					e.printStackTrace();
				} catch (Exception e) {
					Bukkit.getConsoleSender().sendMessage(
							plugin.nombre+" An unreachable error occured or a player tried to fill his enderchest with null");
				}

			} else if (event.getView().getTitle().equals(name4_edit)) {
				number = 4;
				try {
					if (player.hasPermission("CustomEnderChest.view")
							|| player.hasPermission("CustomEnderChest.edit")) {

						items_4 = SQLPlayerData.getInventory(plugin.getMySQL(), p.getUniqueId(), number);

						if (!(items_4 == null)) {
							event.getInventory().setStorageContents(items_4);

						}
					} else {
						player.closeInventory();

					}

				} catch (NullPointerException e) {
					Bukkit.getConsoleSender()
							.sendMessage(plugin.nombre+" An error ocurred");
					e.printStackTrace();
				} catch (Exception e) {
					Bukkit.getConsoleSender().sendMessage(
							plugin.nombre+" An unreachable error occured or a player tried to fill his enderchest with null");
				}

			} else if (event.getView().getTitle().equals(name5_edit)) {
				number = 5;
				try {
					if (player.hasPermission("CustomEnderChest.view")
							|| player.hasPermission("CustomEnderChest.edit")) {

						items_5 = SQLPlayerData.getInventory(plugin.getMySQL(), p.getUniqueId(), number);

						if (!(items_5 == null)) {
							event.getInventory().setStorageContents(items_5);

						}
					} else {
						player.closeInventory();

					}

				} catch (NullPointerException e) {
					Bukkit.getConsoleSender()
							.sendMessage(plugin.nombre+" An error ocurred");
					e.printStackTrace();
				} catch (Exception e) {
					Bukkit.getConsoleSender().sendMessage(
							plugin.nombre+" An unreachable error occured or a player tried to fill his enderchest with null");
				}

			}
		}
	}

	public static ItemStack[] getItems_1() {
		return items_1;
	}

	public static ItemStack[] getItems_2() {
		return items_2;
	}

	public static ItemStack[] getItems_3() {
		return items_3;
	}

	public static ItemStack[] getItems_4() {
		return items_4;
	}
}