package com.minemee.mmitemaction;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MMItemActionBlockListener implements Listener {

	@EventHandler
	 public void onCreatureSpawn(CreatureSpawnEvent event)
	 {
	  if(event.getEntity() instanceof Zombie)
	  {
	   Zombie z = (Zombie)event.getEntity();
	   ((LivingEntity)z).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3));
	  }
	 }
	
	 @EventHandler
	 public void onEntityCombust(EntityCombustEvent event){
		 if(event.getEntity() instanceof Zombie){
			 event.setCancelled(true);  
		 }	  
	 } 
	
	@EventHandler(priority = EventPriority.NORMAL) 
	public void interactItem(PlayerInteractEvent event){

		final Player player = event.getPlayer();

		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{

			// Bandage

			if(player.getItemInHand().getType().equals(Material.PAPER))
			{ 
					if(player.getItemInHand().getDurability() == 23){
	
						ItemStack item = player.getItemInHand();
		
						if(item.getAmount() == 1){
							player.setItemInHand(new ItemStack(Material.AIR));
						} else {
							item.setAmount(item.getAmount() - 1);
						}
		
						if (player.getHealth() < 19) {
							player.sendMessage(ChatColor.AQUA.toString() + "This bandage healed you.");
		
							if((player.getHealth() + 2.0d) > 20.0d){
								player.setHealth(20.0d);
							}
							else{
								player.setHealth(player.getHealth() + 2.0d);
							}
		
						}
						else{
							player.sendMessage(ChatColor.AQUA.toString() + "You wasted one bandage. Your life was full.");
						}
					
					}
			}

			// eye of ender
			if(player.getItemInHand().getType().equals(Material.EYE_OF_ENDER))
			{ 
				if(player.getItemInHand().getDurability() == 23){

					event.setCancelled(true);
					final double health = player.getHealth();
	
					final Location loc = player.getLocation();
					final int x = loc.getBlockX();
	
					player.sendMessage(ChatColor.ITALIC.toString() + ChatColor.BLUE.toString() + "[ST] " + ChatColor.RESET.toString() + "Trying to redirect you to spawn. Stay still.");
	
					new Timer().schedule(new TimerTask() {          
						@Override
						public void run() {
							
							final Location new_loc = player.getLocation();
							
							 if(health > player.getHealth()){
								 player.sendMessage(ChatColor.ITALIC.toString() + ChatColor.BLUE.toString() + "[ST] " + ChatColor.RESET.toString() + "Sorry, you can't escape battles.");
							 }
							 else if(x != new_loc.getBlockX()){
								 player.sendMessage(ChatColor.ITALIC.toString() + ChatColor.BLUE.toString() + "[ST] " + ChatColor.RESET.toString() + "Sorry, you have to stay still.");
							 }
							 else{
								 player.sendMessage(ChatColor.ITALIC.toString() + ChatColor.BLUE.toString() + "[ST] " + ChatColor.RESET.toString() + "Redirecting you.");
								 World w = Bukkit.getServer().getWorld("world");
								 player.teleport(w.getSpawnLocation());
							 }
							 
						}
					}, 10000);
					
				}

			}
			
			// nether star
			if(player.getItemInHand().getType().equals(Material.NETHER_STAR))
			{ 
				if(player.getItemInHand().getDurability() == 23){

					event.setCancelled(true);
					
					if(player.getBedSpawnLocation() != null){
						
						final double health = player.getHealth();
						
						final Location loc = player.getLocation();
						final int x = loc.getBlockX();
		
						player.sendMessage(ChatColor.ITALIC.toString() + ChatColor.GREEN.toString() + "[HT] " + ChatColor.RESET.toString() + "Trying to redirect you home. Stay still.");

		
						new Timer().schedule(new TimerTask() {          
							@Override
							public void run() {
								
								final Location new_loc = player.getLocation();
								
								 if(health > player.getHealth()){
									 player.sendMessage(ChatColor.ITALIC.toString() + ChatColor.GREEN.toString() + "[HT] " + ChatColor.RESET.toString() + "Sorry, you can't escape battles.");
								 }
								 else if(x != new_loc.getBlockX()){
									 player.sendMessage(ChatColor.ITALIC.toString() + ChatColor.GREEN.toString() + "[HT] " + ChatColor.RESET.toString() + "Sorry, you have to stay still.");
								 }
								 else{
									 player.sendMessage(ChatColor.ITALIC.toString() + ChatColor.GREEN.toString() + "[HT] " + ChatColor.RESET.toString() + "Redirecting you.");
									 player.teleport(player.getBedSpawnLocation());
								 }
								 
							}
						}, 10000);
						
					} 
					else 
					{
						 player.sendMessage(ChatColor.ITALIC.toString() + ChatColor.GREEN.toString() + "[HT] " + ChatColor.RESET.toString() + "You have no bed set.");
					}					
				}
			}
			
			
			// bedrock
			
			if(player.getItemInHand().getType().equals(Material.BEDROCK))
			{
				player.setItemInHand(new ItemStack(Material.AIR));
				World w = Bukkit.getServer().getWorld("world");
				Location location = new Location(w, 1, -2, 1);
				player.teleport(location);
			}

		}	

	}

}
							

		
