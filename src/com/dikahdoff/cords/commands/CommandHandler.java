package com.dikahdoff.cords.commands;

import com.dikahdoff.cords.Cords;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) { return true; }
        Player player = (Player) sender;
        // Handle /cords
        if(cmd.getName().equalsIgnoreCase("cords") || cmd.getName().equalsIgnoreCase("cord") || cmd.getName().equalsIgnoreCase("loc") || cmd.getName().equalsIgnoreCase("location") || cmd.getName().equalsIgnoreCase("pos") || cmd.getName().equalsIgnoreCase("position")) {
            if(args.length != 0) {
                if (args[0].toString().equalsIgnoreCase("version") || args[0].toString().equalsIgnoreCase("ver") ) {
                    player.sendMessage(ChatColor.GREEN + "> " + ChatColor.GRAY + Cords.getPlugin(Cords.class).getDescription().getName() + " | Version: " + Cords.getPlugin(Cords.class).getDescription().getVersion().toString());
                } else if (args[0].toString().equalsIgnoreCase("info")) {
                    player.sendMessage(ChatColor.GOLD + "> " + ChatColor.GRAY + "This server is using " + Cords.getPlugin(Cords.class).getDescription().getName() + " by dikahdoff (Version: " + Cords.getPlugin(Cords.class).getDescription().getVersion().toString() + ")");
                    player.sendMessage(ChatColor.GOLD + "> " + ChatColor.GRAY + "Download here: https://github.com/dikahdoff/CordsAnnouncer");
                } else {
                    player.sendMessage(ChatColor.RED + "> " + ChatColor.GRAY + "Invalid argument.");
                }
            } else {
                if(player.hasPermission("cords.send")) {
                    Location playerLoc = player.getLocation();
                    getServer().broadcastMessage(ChatColor.BLUE + "> " + ChatColor.GRAY + player.getName() + " is at " + ChatColor.BOLD + Math.round(playerLoc.getX()) + " / " + Math.round(playerLoc.getY()) + " / " + Math.round(playerLoc.getZ()) + "");
                } else {
                    player.sendMessage(ChatColor.RED + "> " + ChatColor.GRAY + "Permission denied.");
                }
            }
        }
        return true;
    }
}
