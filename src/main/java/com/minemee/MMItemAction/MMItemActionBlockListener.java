package com.minemee.MMItemAction;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
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
					   			
	                ItemStack item = player.getItemInHand();
	                
	                if(item.getAmount() == 1){
	                    player.setItemInHand(new ItemStack(Material.AIR));
	                } else {
	                    item.setAmount(item.getAmount() - 1);
	                }
	                 
					if (player.getHealth() < 19) {
						player.sendMessage("This bandage is working well!");
						
						if((player.getHealth() + 5.0d) > 20.0d){
							player.setHealth(20.0d);
						}
						else{
							player.setHealth(player.getHealth() + 5.0d);
						}
						
					}
					else{
						player.sendMessage("You wasted one bandage. You were already fine.");
					}
         
				}
				
				
				if(player.getItemInHand().getType().equals(Material.EYE_OF_ENDER))
				{ 
					event.setCancelled(true);
					player.sendMessage("Redirecting you to a safe haven in 10 seconds!");
					   			
					new Timer().schedule(new TimerTask() {          
					    @Override
					    public void run() {
							World w = Bukkit.getServer().getWorld("world");
							player.teleport(w.getSpawnLocation());      
					    }
					}, 10000);
					         
				}
				
			}	
			
        }
		
}