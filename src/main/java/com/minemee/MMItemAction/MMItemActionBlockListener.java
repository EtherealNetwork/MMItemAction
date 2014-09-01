package com.minemee.mmitemaction;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class MMItemActionBlockListener implements Listener {

	@EventHandler(priority = EventPriority.NORMAL) 
	public void interactFood(PlayerInteractEvent event){

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
							player.sendMessage("This bandage is working well!");
		
							if((player.getHealth() + 2.0d) > 20.0d){
								player.setHealth(20.0d);
							}
							else{
								player.setHealth(player.getHealth() + 2.0d);
							}
		
						}
						else{
							player.sendMessage("You wasted one bandage. You were already fine.");
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
	
					player.sendMessage("Trying to redirect you to a safe haven!");
	
					new Timer().schedule(new TimerTask() {          
						@Override
						public void run() {
							
							final Location new_loc = player.getLocation();
							
							 if(health > player.getHealth()){
								 player.sendMessage("Sorry, you can't escape battles.");
							 }
							 else if(x != new_loc.getBlockX()){
								 player.sendMessage("Sorry, you have to stay still.");
							 }
							 else{
								 player.sendMessage("Redirecting you now!");
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
		
						player.sendMessage("Trying to redirect you to your home!");
		
						new Timer().schedule(new TimerTask() {          
							@Override
							public void run() {
								
								final Location new_loc = player.getLocation();
								
								 if(health > player.getHealth()){
									 player.sendMessage("Sorry, you can't escape battles.");
								 }
								 else if(x != new_loc.getBlockX()){
									 player.sendMessage("Sorry, you have to stay still.");
								 }
								 else{
									 player.sendMessage("Redirecting you now!");
									 player.teleport(player.getBedSpawnLocation());
								 }
								 
							}
						}, 10000);
						
					} 
					else 
					{
						player.sendMessage("You have no bed set!");
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
							

		
