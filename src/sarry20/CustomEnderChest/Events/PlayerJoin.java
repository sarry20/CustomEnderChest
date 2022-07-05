package sarry20.CustomEnderChest.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import sarry20.CustomEnderChest.Main;
import sarry20.CustomEnderChest.MySQL.SQLPlayerData;

public class PlayerJoin implements Listener {
	private Main plugin;

	public PlayerJoin(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void atJoin(PlayerJoinEvent event) {
		Player jugador = event.getPlayer();
		if(!SQLPlayerData.playerExist(plugin.getMySQL(), jugador.getUniqueId())) {
			SQLPlayerData.createPlayer(plugin.getMySQL(), jugador.getUniqueId(), jugador.getName());
		}
	} 
}