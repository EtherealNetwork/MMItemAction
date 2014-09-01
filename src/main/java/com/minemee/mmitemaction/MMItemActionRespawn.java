package com.minemee.mmitemaction;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MMItemActionRespawn implements Listener {

	  @EventHandler(priority = EventPriority.HIGHEST)   
	    public void onPlayerRespawn(PlayerRespawnEvent e) {

	        ItemStack eyeofender = new ItemStack(Material.EYE_OF_ENDER, 1);
	        ItemStack netherstar = new ItemStack(Material.NETHER_STAR, 1);
	        
	        ItemMeta itemMeta = eyeofender.getItemMeta();
	        itemMeta.setDisplayName(ChatColor.BLUE + "Spawn Teleporter");
	        eyeofender.setItemMeta(itemMeta);
	        eyeofender.setDurability((short)23);

	        ItemMeta itemMeta2 = netherstar.getItemMeta();
	        itemMeta2.setDisplayName(ChatColor.GREEN + "Home Teleporter");
	        netherstar.setItemMeta(itemMeta2);
	        netherstar.setDurability((short)23);
	        
	        e.getPlayer().getInventory().addItem(eyeofender);
	        e.getPlayer().getInventory().addItem(netherstar);
	 
	    }
}

