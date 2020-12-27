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
			//コマンドを入力したのがプレイヤーかどうかチェック
			if(!(sender instanceof Player)) return false;
			//上に飛ばすために座標取得
			Player player = (Player)sender;
			Location y = player.getLocation();
			y.add(0,dis,0);
			//飛ばす(20固定)
			player.teleport(y, PlayerTeleportEvent.TeleportCause.PLUGIN);

			break;

		case 1:
			//コマンドを入力したのがプレイヤーかどうかチェック
			if(!(sender instanceof Player)) return false;
			//文字列として入力された数値をdoubleに変換(例外処理)、代入
			double input = -1;
			try {
				input = Double.parseDouble(args[0]);
			}
			catch (NumberFormatException ex) {
				sender.sendMessage(" "+args[0]+" は無効です。正しい数字を指定してください。");
				return true;
			}
			if(input <= 0) {
				sender.sendMessage("0以下の数字は指定できません。正の数を指定して下さい。");
				return true;
			}
			dis = input;
			//上に飛ばすために座標取得
			player = (Player)sender;
			y = player.getLocation();
			y.add(0,dis,0);
			//飛ばす(入力値によって変わる)
			player.teleport(y, PlayerTeleportEvent.TeleportCause.PLUGIN);
			break;

		default:
			sender.sendMessage("コマンドが不正です。確認してください。");
			break;

		}
		return true;
	}
}
