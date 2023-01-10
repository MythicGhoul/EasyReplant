package me.Ghoul.EasyPlanters;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class HarvestEvent implements Listener {

	Main plugin;

	public HarvestEvent(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onGetAge(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();
		Action a = e.getAction();
		EquipmentSlot h = e.getHand();

		if (p.getInventory().getItemInMainHand() == null)
			return;

		if (a == Action.RIGHT_CLICK_BLOCK) {
			if (h.equals(EquipmentSlot.HAND)) {
				if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("" + ChatColor.AQUA + "★"
						+ " " + ChatColor.GOLD + ChatColor.BOLD + "Age Wand" + " " + ChatColor.AQUA + "★")) {

					if (b.getType() == Material.WHEAT) {
						p.sendMessage(
								Main.prefix + " " + ChatColor.AQUA + "Crop Type:" + " " + ChatColor.GOLD + b.getType());
						p.sendMessage(Main.prefix + " " + ChatColor.AQUA + "Crop Age:" + " " + ChatColor.GOLD
								+ ((Ageable) b.getBlockData()).getAge() + ChatColor.AQUA + "/" + ChatColor.GOLD
								+ ((Ageable) b.getBlockData()).getMaximumAge());
						return;
					} else if (b.getType() == Material.NETHER_WART) {
						p.sendMessage(
								Main.prefix + " " + ChatColor.AQUA + "Crop Type:" + " " + ChatColor.GOLD + b.getType());
						p.sendMessage(Main.prefix + " " + ChatColor.AQUA + "Crop Age:" + " " + ChatColor.GOLD
								+ ((Ageable) b.getBlockData()).getAge() + ChatColor.AQUA + "/" + ChatColor.GOLD
								+ ((Ageable) b.getBlockData()).getMaximumAge());
						return;
					} else if (b.getType() == Material.CARROTS) {
						p.sendMessage(
								Main.prefix + " " + ChatColor.AQUA + "Crop Type:" + " " + ChatColor.GOLD + b.getType());
						p.sendMessage(Main.prefix + " " + ChatColor.AQUA + "Crop Age:" + " " + ChatColor.GOLD
								+ ((Ageable) b.getBlockData()).getAge() + ChatColor.AQUA + "/" + ChatColor.GOLD
								+ ((Ageable) b.getBlockData()).getMaximumAge());
						return;
					} else if (b.getType() == Material.BEETROOTS) {
						p.sendMessage(
								Main.prefix + " " + ChatColor.AQUA + "Crop Type:" + " " + ChatColor.GOLD + b.getType());
						p.sendMessage(Main.prefix + " " + ChatColor.AQUA + "Crop Age:" + " " + ChatColor.GOLD
								+ ((Ageable) b.getBlockData()).getAge() + ChatColor.AQUA + "/" + ChatColor.GOLD
								+ ((Ageable) b.getBlockData()).getMaximumAge());
						return;
					} else if (b.getType() == Material.POTATOES) {
						p.sendMessage(
								Main.prefix + " " + ChatColor.AQUA + "Crop Type:" + " " + ChatColor.GOLD + b.getType());
						p.sendMessage(Main.prefix + " " + ChatColor.AQUA + "Crop Age:" + " " + ChatColor.GOLD
								+ ((Ageable) b.getBlockData()).getAge() + ChatColor.AQUA + "/" + ChatColor.GOLD
								+ ((Ageable) b.getBlockData()).getMaximumAge());
						return;
					}
				}
			}
		}
	}

	@EventHandler
	public void onDoubleDropWheat(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		int mindrop = plugin.getConfig().getInt("Crops.Wheat.Min-Drop");
		int maxdrop = plugin.getConfig().getInt("Crops.Wheat.Max-Drop");
		int r2 = (int) Math.floor(Math.random() * (maxdrop - mindrop + 1) + mindrop);
		ItemStack drop = new ItemStack(b.getType(), r2);

		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("" + ChatColor.AQUA + "-=]" + " "
				+ ChatColor.GOLD + ChatColor.BOLD + "Auto Hoe II" + " " + ChatColor.AQUA + "[=-")) {
			if (b.getType().equals(Material.WHEAT)) {
				e.setDropItems(false);
				b.getLocation().getWorld().dropItem(b.getLocation(), drop);
				b.getLocation().getWorld().dropItem(b.getLocation(), new ItemStack(Material.WHEAT_SEEDS, 2));
				return;
			}
		}

	}

	@EventHandler
	public void onDoubleDropCarrot(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		int mindrop = plugin.getConfig().getInt("Crops.Wheat.Min-Drop");
		int maxdrop = plugin.getConfig().getInt("Crops.Wheat.Max-Drop");
		int r2 = (int) Math.floor(Math.random() * (maxdrop - mindrop + 1) + mindrop);
		ItemStack drop = new ItemStack(Material.CARROT, r2);

		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("" + ChatColor.AQUA + "-=]" + " "
				+ ChatColor.GOLD + ChatColor.BOLD + "Auto Hoe II" + " " + ChatColor.AQUA + "[=-")) {

			if (b.getType().equals(Material.CARROTS)) {
				e.setDropItems(false);
				b.getLocation().getWorld().dropItem(b.getLocation(), drop);
				return;
			}
		}

	}

	@EventHandler
	public void onDoubleDropPotato(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		int mindrop = plugin.getConfig().getInt("Crops.Wheat.Min-Drop");
		int maxdrop = plugin.getConfig().getInt("Crops.Wheat.Max-Drop");
		int r2 = (int) Math.floor(Math.random() * (maxdrop - mindrop + 1) + mindrop);
		ItemStack drop = new ItemStack(Material.POTATO, r2);

		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("" + ChatColor.AQUA + "-=]" + " "
				+ ChatColor.GOLD + ChatColor.BOLD + "Auto Hoe II" + " " + ChatColor.AQUA + "[=-")) {
			if (b.getType().equals(Material.POTATOES)) {

				e.setDropItems(false);
				b.getLocation().getWorld().dropItem(b.getLocation(), drop);

				return;
			}
		}

	}

	@EventHandler
	public void onDoubleDropBeetroot(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		int mindrop = plugin.getConfig().getInt("Crops.Wheat.Min-Drop");
		int maxdrop = plugin.getConfig().getInt("Crops.Wheat.Max-Drop");
		int r2 = (int) Math.floor(Math.random() * (maxdrop - mindrop + 1) + mindrop);
		ItemStack drop = new ItemStack(Material.BEETROOT, r2);

		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("" + ChatColor.AQUA + "-=]" + " "
				+ ChatColor.GOLD + ChatColor.BOLD + "Auto Hoe II" + " " + ChatColor.AQUA + "[=-")) {
			if (b.getType().equals(Material.BEETROOTS)) {

				e.setDropItems(false);
				b.getLocation().getWorld().dropItem(b.getLocation(), drop);
				b.getLocation().getWorld().dropItem(b.getLocation(), new ItemStack(Material.BEETROOT_SEEDS, 2));

				return;
			}
		}

	}

	@EventHandler
	public void onDoubleDropNetherWart(BlockBreakEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlock();
		int mindrop = plugin.getConfig().getInt("Crops.Wheat.Min-Drop");
		int maxdrop = plugin.getConfig().getInt("Crops.Wheat.Max-Drop");
		int r2 = (int) Math.floor(Math.random() * (maxdrop - mindrop + 1) + mindrop);
		ItemStack drop = new ItemStack(b.getType(), r2);

		if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("" + ChatColor.AQUA + "-=]" + " "
				+ ChatColor.GOLD + ChatColor.BOLD + "Auto Hoe II" + " " + ChatColor.AQUA + "[=-")) {
			if (b.getType().equals(Material.NETHER_WART)) {

				e.setDropItems(false);
				b.getLocation().getWorld().dropItem(b.getLocation(), drop);

				return;
			}
		}

	}

	@EventHandler
	public static void onHarvestWheat(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {
				if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD
								+ "Auto Hoe I" + " " + ChatColor.GOLD + "[=-")) {

					if (b.getType() == Material.WHEAT) {
						cropBlockType = Material.WHEAT;

					}

					if (cropBlockType != null && isFullyGrown(b)) {
						replantCrop(b, b.getLocation(), cropBlockType);
					}
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestWheat2(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;

		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {
				if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("" + ChatColor.AQUA + "-=]" + " " + ChatColor.GOLD + ChatColor.BOLD
								+ "Auto Hoe II" + " " + ChatColor.AQUA + "[=-")) {

					if (b.getType() == Material.WHEAT) {
						cropBlockType = Material.WHEAT;

					}

					if (cropBlockType != null && isFullyGrown(b)) {
						replantCrop(b, b.getLocation(), cropBlockType);
					}
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestNetherWart(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;
		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD
								+ "Auto Hoe I" + " " + ChatColor.GOLD + "[=-"))
					return;
				{

					if (b.getType() == Material.NETHER_WART) {
						cropBlockType = Material.NETHER_WART;

					}

					if (cropBlockType != null && isFullyGrown(b)) {
						replantCrop(b, b.getLocation(), cropBlockType);
					}
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestNetherWart2(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;
		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("" + ChatColor.AQUA + "-=]" + " " + ChatColor.GOLD + ChatColor.BOLD
								+ "Auto Hoe II" + " " + ChatColor.AQUA + "[=-"))
					return;
				{

					if (b.getType() == Material.NETHER_WART) {
						cropBlockType = Material.NETHER_WART;

					}

					if (cropBlockType != null && isFullyGrown(b)) {
						replantCrop(b, b.getLocation(), cropBlockType);
					}
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestBeetRoot(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;
		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD
								+ "Auto Hoe I" + " " + ChatColor.GOLD + "[=-"))
					return;
				{

					if (b.getType() == Material.BEETROOTS) {
						cropBlockType = Material.BEETROOTS;

					}

					if (cropBlockType != null && isFullyGrown(b)) {
						replantCrop(b, b.getLocation(), cropBlockType);
					}
				}
			}

		}
	}

	@EventHandler
	public static void onHarvestBeetRoot2(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;
		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("" + ChatColor.AQUA + "-=]" + " " + ChatColor.GOLD + ChatColor.BOLD
								+ "Auto Hoe II" + " " + ChatColor.AQUA + "[=-"))
					return;
				{

					if (b.getType() == Material.BEETROOTS) {
						cropBlockType = Material.BEETROOTS;

					}

					if (cropBlockType != null && isFullyGrown(b)) {
						replantCrop(b, b.getLocation(), cropBlockType);
					}
				}
			}

		}
	}

	@EventHandler
	public static void onHarvestPotato(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;
		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD
								+ "Auto Hoe I" + " " + ChatColor.GOLD + "[=-"))
					return;
				{

					if (b.getType() == Material.POTATOES) {
						cropBlockType = Material.POTATOES;

					}

					if (cropBlockType != null && isFullyGrown(b)) {
						replantCrop(b, b.getLocation(), cropBlockType);
					}
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestPotato2(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;
		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("" + ChatColor.AQUA + "-=]" + " " + ChatColor.GOLD + ChatColor.BOLD
								+ "Auto Hoe II" + " " + ChatColor.AQUA + "[=-"))
					return;
				{

					if (b.getType() == Material.POTATOES) {
						cropBlockType = Material.POTATOES;

					}

					if (cropBlockType != null && isFullyGrown(b)) {
						replantCrop(b, b.getLocation(), cropBlockType);
					}
				}
			}
		}
	}

	@EventHandler
	public static void onHarvestCarrot(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;
		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("" + ChatColor.GOLD + "-=]" + " " + ChatColor.AQUA + ChatColor.BOLD
								+ "Auto Hoe I" + " " + ChatColor.GOLD + "[=-"))
					return;
				{

					if (b.getType() == Material.CARROTS) {
						cropBlockType = Material.CARROTS;

					}

					if (cropBlockType != null && isFullyGrown(b)) {
						replantCrop(b, b.getLocation(), cropBlockType);
					}

				}
			}
		}
	}

	@EventHandler
	public static void onHarvestCarrot2(BlockBreakEvent e) {
		Block b = e.getBlock();
		Player p = e.getPlayer();

		Material cropBlockType = null;
		if (p.isSneaking() == false) {
			if (p.hasPermission("ep.auto")) {

				if (p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()
						.equalsIgnoreCase("" + ChatColor.AQUA + "-=]" + " " + ChatColor.GOLD + ChatColor.BOLD
								+ "Auto Hoe II" + " " + ChatColor.AQUA + "[=-"))
					return;
				{

					if (b.getType() == Material.CARROTS) {
						cropBlockType = Material.CARROTS;

					}

					if (cropBlockType != null && isFullyGrown(b)) {
						replantCrop(b, b.getLocation(), cropBlockType);
					}

				}
			}
		}
	}

	public static void replantCrop(Block b, Location loc, Material cropBlockType) {
		Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
			loc.getBlock().setType(cropBlockType);
			loc.getBlock().getWorld().spawnParticle(Particle.WATER_WAKE, b.getLocation(), 100, 0.5, 0.06, 0.5, 0.02);
		}, 20L);
	}

	public static boolean isFullyGrown(Block block) {
		Ageable age = (Ageable) block.getBlockData();
		int max = age.getMaximumAge();

		return age.getAge() == max;
	}

}
