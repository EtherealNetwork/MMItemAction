package com.minemee.mmitemaction;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MMItemAction extends JavaPlugin {

	Logger log = Logger.getLogger("Minecraft");

	public final MMItemActionBlockListener blockListener = new MMItemActionBlockListener();
	public final MMItemActionJoin joinAction = new MMItemActionJoin();
	public final MMItemActionRespawn respawnAction = new MMItemActionRespawn();

	public void onEnable(){
		log.info("MMItemAction enabled!");

		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(this.blockListener, this);
		pm.registerEvents(this.joinAction, this);
		pm.registerEvents(this.respawnAction, this);
	}

	public void onDisable(){
		log.info("MMItemAction disabled.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("book")) {

	        ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);

			Player player = (Player) sender;
			
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
	 
	        player.getInventory().addItem(book);

			return true;
		} 

		return false;
	}


}
