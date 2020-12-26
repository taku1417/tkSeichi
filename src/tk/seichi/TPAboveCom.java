package tk.seichi;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;



public class TPAboveCom implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		//飛ばす距離の初期化
		double dis = 20;
		switch(args.length) {
		case 0:
			if(!(sender instanceof Player)) return false;
			//上に飛ばすために座標取得
			Player player = (Player)sender;
			Location y = player.getLocation();
			y.add(0,dis,0);
			player.teleport(y, PlayerTeleportEvent.TeleportCause.PLUGIN);
		}
		//case 1 で使う
		/*int i = Integer.parseInt(args[0]);
		int dis = i;*/

		return true;
	}

}
