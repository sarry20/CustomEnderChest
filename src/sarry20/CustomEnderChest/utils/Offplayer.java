package sarry20.CustomEnderChest.utils;

import org.bukkit.OfflinePlayer;

public class Offplayer {

	public static String getUUID(OfflinePlayer p) {
		if(!p.hasPlayedBefore()) {
			return "";
		}else {
		return p.getUniqueId().toString();
		}
	}
}