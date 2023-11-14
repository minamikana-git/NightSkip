package org.nandeyanenw.nightskip;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class NightSkip extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin startup logic


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (command.getName().equalsIgnoreCase("skip") && sender instanceof Player) {
            Player player = (Player)  sender;
            if (player.getWorld().getTime() >=12541 && player.getWorld().getTime() <= 23458) {
                player.getWorld().setTime(1000);
                player.sendMessage("夜をスキップしたよ");
                return true;
            } else {
                player.sendMessage("夜じゃねーよバーカ");
                return false;
            }

        }
        return false;
    }
}
