package net.hotamachisubaru.nightskip;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class NightSkip extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("skip").setExecutor(this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("skip") && sender instanceof Player) {
            Player player = (Player) sender;
            long currentTime = player.getWorld().getTime();

            // 現在が夜の場合
            if (currentTime >= 12541 && currentTime <= 23458) {
                // 翌日の同じ時刻に設定
                long nextDayTime = currentTime + (24000 - currentTime);
                player.getWorld().setTime(nextDayTime);
                player.sendMessage("夜をスキップして、翌日の同じ時間に設定しました。");
                return true;
            } else {
                player.sendMessage("夜ではありません。コマンドの利用はできません。");
                return false;
            }
        }
        return false;
    }
}