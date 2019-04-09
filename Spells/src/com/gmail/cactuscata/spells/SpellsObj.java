package com.gmail.cactuscata.spells;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpellsObj {

	public ItemStack getItem(PlayerInteractEvent event, ArrayList<String> spellsNames) {

		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {

			ItemStack itemInHand = event.getPlayer().getInventory().getItemInMainHand();

			if (itemInHand != null && event.getHand() != EquipmentSlot.OFF_HAND) {

				ItemMeta itemInHandM = itemInHand.getItemMeta();

				if (itemInHandM != null && spellsNames.contains(itemInHandM.getDisplayName())
						&& itemInHand.getType() == Material.BOOK) {

					return itemInHand;

				}
			}

		} else if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {

			ItemStack itemInOffHand = event.getPlayer().getInventory().getItemInOffHand();

			if (itemInOffHand != null) {

				ItemMeta itemInOffHandM = itemInOffHand.getItemMeta();

				if (itemInOffHandM != null && spellsNames.contains(itemInOffHandM.getDisplayName())
						&& itemInOffHand.getType() == Material.BOOK) {

					return itemInOffHand;

				}

			}
		}

		return null;

	}

}
