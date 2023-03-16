package me.Ghoul.EasyPlanters;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import utils.SeedsRemoval;

public class QuickGrow implements Listener {

	Main plugin;

	public QuickGrow(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block b = e.getBlockPlaced();

		if (p.hasPermission("ep.quick")) {
			if (plugin.getConfig().getBoolean("QuickGrow") == true) {

				if (b.getBlockData() == null)
					return;
				if (((Ageable) b.getBlockData()).getAge() == ((Ageable) b.getBlockData()).getMaximumAge()) {
					return;

				} else if (b.getType() == Material.WHEAT) {
					if (p.getInventory().contains(Material.WHEAT_SEEDS)) {
						if (b.getBlockData() instanceof Ageable) {
							Ageable ag = (Ageable) b.getBlockData();
							SeedsRemoval.consumeItem(p, 1, Material.WHEAT_SEEDS);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(1);
								b.setBlockData(ag);

							}, 20L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(2);
								b.setBlockData(ag);

							}, 40L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(3);
								b.setBlockData(ag);

							}, 60L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(4);
								b.setBlockData(ag);

							}, 80L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(5);
								b.setBlockData(ag);

							}, 100L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(6);
								b.setBlockData(ag);

							}, 120L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(7);
								b.setBlockData(ag);

							}, 140L);
							return;

						}
					} else {
						return;
					}
				} else if (b.getType() == Material.CARROTS) {
					if (p.getInventory().contains(Material.CARROT)) {
						if (b.getBlockData() instanceof Ageable) {
							Ageable ag = (Ageable) b.getBlockData();
							SeedsRemoval.consumeItem(p, 1, Material.CARROT);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(1);
								b.setBlockData(ag);

							}, 20L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(2);
								b.setBlockData(ag);

							}, 40L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(3);
								b.setBlockData(ag);

							}, 60L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(4);
								b.setBlockData(ag);

							}, 80L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(5);
								b.setBlockData(ag);

							}, 100L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(6);
								b.setBlockData(ag);

							}, 120L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(7);
								b.setBlockData(ag);
							}, 140L);
							return;

						}
					} else {
						return;
					}
				} else if (b.getType() == Material.POTATOES) {
					if (p.getInventory().contains(Material.POTATO)) {
						if (b.getBlockData() instanceof Ageable) {
							Ageable ag = (Ageable) b.getBlockData();
							SeedsRemoval.consumeItem(p, 1, Material.POTATO);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(1);
								b.setBlockData(ag);

							}, 20L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(2);
								b.setBlockData(ag);

							}, 40L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(3);
								b.setBlockData(ag);

							}, 60L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(4);
								b.setBlockData(ag);

							}, 80L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(5);
								b.setBlockData(ag);

							}, 100L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(6);
								b.setBlockData(ag);

							}, 120L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(7);
								b.setBlockData(ag);

							}, 140L);
							return;

						}
					} else {
						return;
					}
				} else if (b.getType() == Material.BEETROOTS) {
					if (p.getInventory().contains(Material.BEETROOT_SEEDS)) {
						if (b.getBlockData() instanceof Ageable) {
							Ageable ag = (Ageable) b.getBlockData();
							SeedsRemoval.consumeItem(p, 1, Material.BEETROOT_SEEDS);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(1);
								b.setBlockData(ag);

							}, 20L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(2);
								b.setBlockData(ag);

							}, 40L);
							Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
								ag.setAge(3);
								b.setBlockData(ag);

							}, 80L);
							return;
						}
					}
				} else {
					return;
				}

			} else if (b.getType() == Material.NETHER_WART) {
				if (p.getInventory().contains(Material.NETHER_WART)) {
					if (b.getBlockData() instanceof Ageable) {
						Ageable ag = (Ageable) b.getBlockData();
						SeedsRemoval.consumeItem(p, 1, Material.NETHER_WART);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(1);
							b.setBlockData(ag);

						}, 20L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(2);
							b.setBlockData(ag);

						}, 60L);
						Bukkit.getScheduler().runTaskLater(Main.instance, () -> {
							ag.setAge(3);
							b.setBlockData(ag);

						}, 120L);
						return;

					}
				} else {
					return;

				}

			}
		}
	}
}
