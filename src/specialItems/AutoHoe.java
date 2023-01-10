package specialItems;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Ghoul.EasyPlanters.Main;

public class AutoHoe implements Listener {

	Main plugin;

	public AutoHoe(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	public static ItemStack onAutoHoe() {

		ItemStack is = new ItemStack(Material.IRON_HOE);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD + "Auto Hoe I" + " "
				+ ChatColor.GOLD + "[=-");
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add("" + ChatColor.GOLD + ChatColor.UNDERLINE + "Normal Hoe:");
		Lore.add(ChatColor.GRAY + "Auto-Replanting");
		im.setLore(Lore);
		im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		is.setItemMeta(im);
		return is;

	}

	public static ItemStack onAutoHoe2() {

		ItemStack is = new ItemStack(Material.GOLDEN_HOE);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("" + ChatColor.AQUA + "-=]" + " " + ChatColor.GOLD + ChatColor.BOLD + "Auto Hoe II" + " "
				+ ChatColor.AQUA + "[=-");
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add("" + ChatColor.GOLD + ChatColor.UNDERLINE + "Multiplier Hoe:");
		Lore.add(ChatColor.GRAY + "Auto-Replanting");
		Lore.add(ChatColor.GRAY + "Chance For A Big Harvest");
		im.setLore(Lore);
		im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		is.setItemMeta(im);
		return is;

	}

	public static ItemStack onAgeWand() {

		ItemStack is = new ItemStack(Material.STICK);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("" + ChatColor.AQUA + "★" + " " + ChatColor.GOLD + ChatColor.BOLD + "Age Wand" + " "
				+ ChatColor.AQUA + "★");
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add("" + ChatColor.GOLD + ChatColor.UNDERLINE + "Age Tool:");
		Lore.add(ChatColor.AQUA + "Right click Crops To Get Their Current Age.");
		Lore.add(ChatColor.AQUA + "Crop Types:");
		Lore.add(ChatColor.GRAY + "Wheat");
		Lore.add(ChatColor.GRAY + "Potato");
		Lore.add(ChatColor.GRAY + "Carrot");
		Lore.add(ChatColor.GRAY + "Beetroot");
		Lore.add(ChatColor.GRAY + "Nether Wart");
		im.setLore(Lore);
		im.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		is.setItemMeta(im);
		return is;
	}
}
