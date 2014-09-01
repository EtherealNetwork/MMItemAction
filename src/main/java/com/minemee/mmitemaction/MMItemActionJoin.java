package com.minemee.mmitemaction;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class MMItemActionJoin implements Listener {

	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
		
        Player player = e.getPlayer();		
		if(player.hasPlayedBefore()){ return; }
		
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
        ItemStack eyeofender = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemStack netherstar = new ItemStack(Material.NETHER_STAR, 1);
        ItemStack bandage = new ItemStack(Material.PAPER, 8);
        
        ItemMeta itemMeta = eyeofender.getItemMeta();
        itemMeta.setDisplayName(ChatColor.BLUE + "Spawn Teleporter");
        eyeofender.setItemMeta(itemMeta);
        eyeofender.setDurability((short)23);

        ItemMeta itemMeta2 = netherstar.getItemMeta();
        itemMeta2.setDisplayName(ChatColor.GREEN + "Home Teleporter");
        netherstar.setItemMeta(itemMeta2);
        netherstar.setDurability((short)23);

        ItemMeta itemMeta3 = bandage.getItemMeta();
        itemMeta3.setDisplayName(ChatColor.RED + "Bandage");
        bandage.setItemMeta(itemMeta3);
        bandage.setDurability((short)23);        
        
        BookMeta meta = (BookMeta) book.getItemMeta();
        meta.setTitle(ChatColor.GRAY + "Welcome to Minemee");
        meta.setAuthor(ChatColor.GOLD + "mkpascal");
        meta.addPage(
                ChatColor.BLACK.toString() + ChatColor.BOLD + "-*-*-*-*-*-*-*-*-\n" +
                ChatColor.BLUE.toString() + ChatColor.BOLD + "    Welcome to\n" +
                ChatColor.BLUE.toString() + ChatColor.BOLD + "  Minemee\n" +
                ChatColor.BLACK.toString() + ChatColor.BOLD + "-*-*-*-*-*-*-*-*-\n" +
                ChatColor.WHITE + "\n" +
                ChatColor.BLACK.toString() + ChatColor.UNDERLINE + "Contents:\n" +
                ChatColor.BLACK + "• Chapter 1\n" +
                ChatColor.BLACK + "• Chapter 2\n" +
                ChatColor.BLACK + "• Chapter 3\n" +
                ChatColor.WHITE + "\n" +
                ChatColor.BLACK + "Website:\n" +
                ChatColor.DARK_RED + "http://www.minemee.com");

        book.setItemMeta(meta);
 
        e.getPlayer().getInventory().addItem(book);
        e.getPlayer().getInventory().addItem(eyeofender);
        e.getPlayer().getInventory().addItem(netherstar);
        e.getPlayer().getInventory().addItem(bandage);

    }
}

