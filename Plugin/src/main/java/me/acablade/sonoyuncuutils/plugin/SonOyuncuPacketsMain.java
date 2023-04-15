package me.acablade.sonoyuncuutils.plugin;

import lombok.SneakyThrows;
import me.acablade.sonoyuncuutils.plugin.objects.KaptanMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SonOyuncuPacketsMain extends JavaPlugin {

    private KaptanMenu kaptanMenu;

    @Override
    public void onEnable() {
        // Plugin startup logic

        kaptanMenu = new KaptanMenu();

        kaptanMenu.setTitle("MENU AKTIF DEGIL.");

        kaptanMenu.getGames().add(KaptanMenu.Game.builder().displayName("Menu Aktif Degil").textureID("survival").id("test").online(-1).build());

        SonOyuncuPackets.init(this);
        getCommand("soutils").setExecutor(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    // todo: more flexible.
    @SneakyThrows
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!sender.hasPermission("soutils.admin")){
            sender.sendMessage(ChatColor.RED + "Yetkin yok.");
            return true;
        }

        if(args.length != 3){
            sendHelp(sender);
            return true;
        }

        if(!args[0].equalsIgnoreCase("menu")){
            sendHelp(sender);
            return true;
        }

        Player player = Bukkit.getPlayer(args[2]);

        if(player == null){
            sender.sendMessage(ChatColor.RED + "Oyuncu aktif olmalı.");
            return true;
        }

        if(args[1].equalsIgnoreCase("kaptan")){
            SonOyuncuPackets.getInstance().openKaptanMenu(player, this.kaptanMenu);
        }else if(args[1].equalsIgnoreCase("login")){
            SonOyuncuPackets.getInstance().openLoginMenu(player);
        }

        return true;
    }

    private void sendHelp(CommandSender sender){
        sender.sendMessage(ChatColor.RED + "/soutils menu <kaptan/login> <oyuncu>");
    }

}
