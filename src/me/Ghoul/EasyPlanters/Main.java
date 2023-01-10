package me.Ghoul.EasyPlanters;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import specialItems.AutoHoe;
import utils.Metrics;
import utils.UpdateChecker;

public class Main extends JavaPlugin {

	public static String prefix = ChatColor.WHITE + "[" + ChatColor.GOLD + "EP" + ChatColor.WHITE + "]";
	public static Plugin instance;
	public double v = 1.5;

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.AQUA + "[-------------------------]");
		Bukkit.getConsoleSender()
				.sendMessage(Main.prefix + ChatColor.AQUA + getName() + ":" + " " + ChatColor.GOLD + "Was Enabled!");
		Bukkit.getConsoleSender()
				.sendMessage(Main.prefix + ChatColor.AQUA + "Plugin Version" + ":" + " " + ChatColor.GOLD + v);
		Bukkit.getConsoleSender()
				.sendMessage(Main.prefix + ChatColor.AQUA + "Author:" + " " + ChatColor.GOLD + "MythicGhoul");
		Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.AQUA + "[-------------------------]");

		instance = this;
		new HarvestEvent(this);

		new UpdateChecker(this, 106994).getVersion(version -> {
			if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
				Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "[---------------------------]");
				Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.AQUA + " ");
				Bukkit.getConsoleSender()
						.sendMessage(Main.prefix + " " + ChatColor.GRAY + "[" + ChatColor.GREEN + "SUCCESS"
								+ ChatColor.GRAY + "]" + " " + ChatColor.GOLD + this.getName() + ChatColor.AQUA + " "
								+ "Is Up To Date!");
				Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.AQUA + " ");
				Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "[---------------------------]");
			} else {
				Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "[---------------------------]");
				Bukkit.getConsoleSender()
						.sendMessage(Main.prefix + " " + ChatColor.GRAY + "[" + ChatColor.RED + "ERROR" + ChatColor.GRAY
								+ "]" + " " + ChatColor.GOLD + this.getName() + ChatColor.AQUA + " "
								+ "Is Out Of Date! Update Now!");
				Bukkit.getConsoleSender().sendMessage(Main.prefix + ChatColor.GOLD + "[---------------------------]");
			}
		});

		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadConfig();

		int pluginId = 17195;
		new Metrics(this, pluginId);
	}

	public static Plugin getInstance() {
		return instance;
	}

	public List<String> onTabComplete(CommandSender sender, Command cmd, String CommandLable, String[] args) {
		if (args.length == 1) {
			List<String> args1 = new ArrayList<String>();
			args1.add("rl");
			args1.add("hoe1");
			args1.add("hoe2");
			args1.add("wand");
			return args1;
		}
		return null;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String CommandLable, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only Players Can Send This Command!");
			return true;
		}
		Player p = (Player) sender;
		if (args.length == 0) {
			if (cmd.getName().equalsIgnoreCase("ep")) {
			}
			return true;
		}

		if ((args.length == 1) && (args[0].equalsIgnoreCase("rl"))) {
			if (p.hasPermission("ep.admin")) {
				Bukkit.getScheduler().runTaskLater(this,
						() -> p.sendMessage(
								prefix + " " + ChatColor.AQUA + "Reloading config:" + " " + ChatColor.GOLD + "25%"),
						20L);
				Bukkit.getScheduler().runTaskLater(this,
						() -> p.sendMessage(
								prefix + " " + ChatColor.AQUA + "Reloading config:" + " " + ChatColor.GOLD + "37%"),
						40L);
				Bukkit.getScheduler().runTaskLater(this,
						() -> p.sendMessage(
								prefix + " " + ChatColor.AQUA + "Reloading config:" + " " + ChatColor.GOLD + "54%"),
						60L);
				Bukkit.getScheduler().runTaskLater(this,
						() -> p.sendMessage(
								prefix + " " + ChatColor.AQUA + "Reloading config:" + " " + ChatColor.GOLD + "76%"),
						80L);
				Bukkit.getScheduler().runTaskLater(this,
						() -> p.sendMessage(
								prefix + " " + ChatColor.AQUA + "Reloading config:" + " " + ChatColor.GOLD + "92%"),
						100L);
				Bukkit.getScheduler().runTaskLater(this,
						() -> p.sendMessage(
								prefix + " " + ChatColor.AQUA + "Reloading config:" + " " + ChatColor.GOLD + "100%"),
						120L);
				Bukkit.getScheduler().runTaskLater(this, () -> p.sendMessage(prefix + " " + ChatColor.AQUA
						+ "Reloading config:" + " " + ChatColor.GOLD + "Reload Successful"), 140L);
				Bukkit.getScheduler().runTaskLater(this, () -> this.reloadConfig(), 140L);
				return true;
			}
		}

		if ((args.length == 1) && (args[0].equalsIgnoreCase("hoe1"))) {
			if (p.hasPermission("ep.admin")) {
				p.getInventory().addItem(AutoHoe.onAutoHoe());
				return true;
			}
		}

		if ((args.length == 1) && (args[0].equalsIgnoreCase("hoe2"))) {
			if (p.hasPermission("ep.admin")) {
				p.getInventory().addItem(AutoHoe.onAutoHoe2());
				return true;
			}
		}

		if ((args.length == 1) && (args[0].equalsIgnoreCase("wand"))) {
			if (p.hasPermission("ep.admin")) {
				p.getInventory().addItem(AutoHoe.onAgeWand());
				return true;
			}
		}

		return false;
	}
}