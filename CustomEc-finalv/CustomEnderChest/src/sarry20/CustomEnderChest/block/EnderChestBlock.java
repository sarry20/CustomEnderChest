package sarry20.CustomEnderChest.block;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.EnderChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

import sarry20.CustomEnderChest.Main;
import sarry20.CustomEnderChest.Inventory.InventoryManager;

public class EnderChestBlock implements Listener {
	private Main plugin;
	
	public EnderChestBlock(Main plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void openEc(InventoryOpenEvent event) {
		Player target = (Player) event.getPlayer();
	    if (event.getInventory().getType().equals(InventoryType.ENDER_CHEST)){

	    	event.setCancelled(true);

			InventoryManager inv = new InventoryManager(plugin);

	    	inv.createInventory(target, plugin.getConfig().getString("Inventory.first_name"),
					Material.GREEN_SHULKER_BOX, Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
					Material.GRAY_SHULKER_BOX, Material.GRAY_SHULKER_BOX);
	    	
	    }
	}
	
}
