package me.TypicalBruhh.Doctor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class Doctor implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("doctor")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You cant heal console");
				return true;
				}
				Player p = (Player) sender;
				if (!p.hasPermission("doctor.use")) {
					p.sendMessage(ChatColor.RED + "You dont have permission to use this command!");
					return true;
				}
				if (args.length == 0) {
					// /doctor
					TextComponent message = new TextComponent("Would you like to be healed?");
					message.setColor(ChatColor.GOLD);
					message.setBold(true);
					message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/doctor healme"));
					message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
							new ComponentBuilder("Click here to be healed!").color(ChatColor.GREEN).italic(true).create()));
					p.spigot().sendMessage(message);
					return true;
				}
				//doctor healme
				if (args[0].equalsIgnoreCase("healme")) {
					p.setHealth(20);
					p.sendMessage(ChatColor.GRAY + "You've been healed");
					return true;
				}
				p.sendMessage(ChatColor.RED + "Usage: Doctor");
				return true;
		}
		return false;
	}
	

}
