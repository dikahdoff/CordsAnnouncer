package com.dikahdoff.cords;

import com.dikahdoff.cords.commands.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Cords extends JavaPlugin {
    @Override
    public void onEnable() {
        CommandHandler commandHandler = new CommandHandler();
        getCommand("cords").setExecutor(commandHandler);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "["+getPlugin(this.getClass()).getDescription().getName().toString()+"] Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "["+getPlugin(this.getClass()).getDescription().getName().toString()+"] Plugin disabled!");
    }

    public static String capitalizeWord(String str){
        String words[]=str.split("\\s");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        return capitalizeWord.trim();
    }
}
