package com.gmail.cactuscata.spells;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.cactuscata.spells.list.BouclierEnergie;
import com.gmail.cactuscata.spells.list.SoinDeMasse;

public class Test implements Listener {

	private SoinDeMasse soinDeMasse = new SoinDeMasse("§6§l[Soin de Masse]", 10L, 10);
	private BouclierEnergie bouclierEnergie = new BouclierEnergie("§6§l[Bouclier d'énergie]", 15L, 15);
	private ArrayList<String> spellsName = new ArrayList<>();
	@SuppressWarnings("unused")
	private Main main;

	public Test(Main main) {
		this.main = main;
	}

	@EventHandler
	public void activeSpell(PlayerInteractEvent event) {

		spellsName.add(soinDeMasse.getName());
		spellsName.add(bouclierEnergie.getName());
		SpellsObj spellsObj = new SpellsObj();
		ItemStack item = spellsObj.getItem(event, spellsName);
		Player player = event.getPlayer();

		if (item == null)
			return;	

		switch (item.getItemMeta().getDisplayName()) {
		case "§6§l[Soin de Masse]":
			if (!soinDeMasse.HaveManyXP(player)) {
				player.sendMessage("Vous n'avez pas assez de niveaux !");
				return;
			}
			
			soinDeMasse.RemoveXp(player);
			player.sendMessage("Vous avez assez d'xp !");
			player.sendMessage("Vous avez activé " + soinDeMasse.getName() + " avec utilisation de "
					+ soinDeMasse.getRemovedXp() + " xp !");

			break;

		case "§6§l[Bouclier d'énergie]":
			if (!bouclierEnergie.HaveManyXP(player)) {
				player.sendMessage("Vous n'avez pas assez de niveaux !");
				return;
			}

			bouclierEnergie.RemoveXp(player);
			player.sendMessage("Vous avez assez d'xp !");
			event.getPlayer().sendMessage("Vous avez activé " + bouclierEnergie.getName() + " avec utilisation de "
					+ bouclierEnergie.getRemovedXp() + " xp !");
			break;
		default:
			break;
		}

	}

}
