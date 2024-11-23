package me.furyloxx.hypixelpunishments;

import me.furyloxx.hypixelpunishments.events.Ban;
import me.furyloxx.hypixelpunishments.events.JoinLeaveEvent;
import me.furyloxx.hypixelpunishments.events.Kick;
import me.furyloxx.hypixelpunishments.events.Mute;
import me.furyloxx.hypixelpunishments.events.PlayerChat;
import me.furyloxx.hypixelpunishments.events.TempBan;
import me.furyloxx.hypixelpunishments.events.Unban;
import me.furyloxx.hypixelpunishments.events.Unmute;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Punishments extends JavaPlugin {
   public void onEnable() {
      this.loadConfig();
      System.out.println("[HypixelPunishments] Plugin Loaded...");
      Bukkit.getPluginManager().registerEvents(new JoinLeaveEvent(), this);
      Bukkit.getPluginManager().registerEvents(new PlayerChat(), this);
      this.getCommand("mute").setExecutor(new Mute());
      this.getCommand("unmute").setExecutor(new Unmute());
      this.getCommand("kick").setExecutor(new Kick());
      this.getCommand("tempban").setExecutor(new TempBan());
      this.getCommand("ban").setExecutor(new Ban());
      this.getCommand("unban").setExecutor(new Unban());
   }

   public void loadConfig() {
      this.getConfig().options().copyDefaults(true);
      this.saveConfig();
   }
}
