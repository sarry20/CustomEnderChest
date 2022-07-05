package sarry20.CustomEnderChest.Inventory;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.milkbowl.vault.economy.Economy;
import sarry20.CustomEnderChest.Main;

public class thirdInventory implements Listener {
	private Main plugin;

	public thirdInventory(Main plugin) {
		this.plugin = plugin;
	}

	int start_price = 16000;
	int accumulator = 500;
	int finalprice = 0;
	ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

	@EventHandler
	public void ClickInventory(InventoryClickEvent event) {

		// inventory Main
		Player jugador = (Player) event.getWhoClicked();
		FileConfiguration config = plugin.getCustomConfig();
		String name = config.getString("Inventory.third_ec_name");

		String name1 = ChatColor.translateAlternateColorCodes('&', name);
		Economy econ = plugin.getEconomy();
		double money = econ.getBalance(jugador);
		if (event.getView().getTitle().equals(name1)) {
			for (int i = 0; i < 45; i++) {
				ItemStack air = new ItemStack(Material.AIR);
				ItemStack firework = new ItemStack(Material.FIREWORK_STAR);
				ItemMeta meta = firework.getItemMeta();
				meta.setDisplayName("Slot " + i);
				firework.setItemMeta(meta);
				if (event.getRawSlot() == i) {
					if (!jugador.hasPermission("CustomEnderChest_3." + i)) {
//					if(event.getInventory().first(firework)) {
						finalprice = start_price + accumulator * i;
						if (money >= finalprice) {

							if (i == event.getView().getTopInventory().first(Material.FIREWORK_STAR)) {
								if (event.getView().getItem(i).getItemMeta().getDisplayName()
										.equals("Slot " + i)) {

									econ.withdrawPlayer(jugador, start_price + accumulator * i);

									Bukkit.dispatchCommand(console,
											"pex user " + jugador.getName() + " add CustomEnderChest_3." + i);
									jugador.sendMessage("Has comprado el slot: " + i);
									if (i != 0) {
										i = i - 1;
										event.getInventory().setItem(i, air);
										Bukkit.dispatchCommand(console, "pex user " + jugador.getName()
												+ " remove CustomEnderChest_3." + i);
										i = i + 1;
									}

									event.getInventory().setItem(i, air);
									event.setCancelled(true);
								}
							} else {
								finalprice = 0;
								for (int j = i; 0 <= j; j--) {
									finalprice = finalprice + start_price + (accumulator * j);

									if (j == event.getView().getTopInventory().first(Material.FIREWORK_STAR)) {
										if (event.getView().getItem(i).getItemMeta().getDisplayName()
												.equals("Slot " + i)) {
											if (money >= finalprice) {
												int x = j;
												econ.withdrawPlayer(jugador, finalprice);

												j = i - j;
												if (j == 1) {

													Bukkit.dispatchCommand(console, "pex user " + jugador.getName()
															+ " add CustomEnderChest_3." + i);
													event.getInventory().setItem(x, air);
													event.getInventory().setItem(i, air);
													x = x - 1;
													Bukkit.dispatchCommand(console, "pex user " + jugador.getName()
															+ " remove CustomEnderChest_3." + x);
													// x = x + 1;
												} else {

													for (int r = x; i >= r; i--) {

														event.getInventory().setItem(i, air);
													}
													i = i + (j + 1);
													Bukkit.dispatchCommand(console, "pex user " + jugador.getName()
															+ " admin CustomEnderChest_3." + i);

													for (int a = i; a >= 0;) {
														a--;
														if (jugador.hasPermission("CustomEnderChest_3." + a)) {
															Bukkit.dispatchCommand(console,
																	"pex user " + jugador.getName()
																			+ " remove CustomEnderChest_3."
																			+ a);
														}
													}
												}

												j = j + 1;
												jugador.sendMessage("Has comprado: " + j + " slots");
												event.setCancelled(true);
											} else {
												jugador.sendMessage("No tienes suficiente dinero para comprar esto.");
												event.setCancelled(true);
											}

											return;
										}
									}

								}

							}

						} else {

							jugador.sendMessage("No tienes suficiente dinero para comprar el slot.");
							event.setCancelled(true);

						}
//				}
						return;
					}
					// posible provocador de error
					return;
				}
			}

		}
	}

	@EventHandler
	public void OpenInventory(InventoryOpenEvent event) {
		Player player = (Player) event.getPlayer();
		FileConfiguration config = plugin.getConfig();
		String name = config.getString("Inventory.third_ec_name");
		Boolean hasBought = false;

		String name1 = ChatColor.translateAlternateColorCodes('&', name);

		if (event.getView().getTitle().equals(name1)) {
			for (int i = 0; i < 45; i++) {
				if (player.hasPermission("CustomEnderChest_3." + i)) {
					for (int x = i; x >= 45;) {
						finalprice = start_price + accumulator * x;
						ItemStack firework = new ItemStack(Material.FIREWORK_STAR);
						ItemMeta meta = firework.getItemMeta();
						meta.setDisplayName("Slot " + i);
						List<String> lore = new ArrayList<String>();
						lore.add("$" + finalprice);
						meta.setLore(lore);
						firework.setItemMeta(meta);
						x++;
						event.getView().getTopInventory().setItem(x, firework);

					}
					hasBought = true;
					return;
				}

			}
			if (hasBought == false) {

				for (int a = 0; a < 45; a++) {

					finalprice = start_price + accumulator * a;
					ItemStack firework = new ItemStack(Material.FIREWORK_STAR);
					ItemMeta meta = firework.getItemMeta();
					meta.setDisplayName("Slot " + a);
					List<String> lore = new ArrayList<String>();
					lore.add("$" + finalprice);
					meta.setLore(lore);
					firework.setItemMeta(meta);
					event.getView().getTopInventory().setItem(a, firework);

				}
				return;
			}
		}
	}
}