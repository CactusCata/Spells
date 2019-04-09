package com.gmail.cactuscata.spells.list;

import org.bukkit.entity.Player;

public class SoinDeMasse {

	private String name;
	private long timer;
	private int removeXP;

	public SoinDeMasse(String name, long timer, int removeXP) {

		this.name = name;
		this.timer = timer;
		this.removeXP = removeXP;

	}

	public String getName() {

		return name;

	}

	public long getTimer() {

		return timer;

	}

	public int getRemovedXp() {

		return removeXP;

	}

	public void RemoveXp(Player player){
		
		player.setLevel(player.getLevel() - removeXP);
		player.updateInventory();
		
	}

	public boolean HaveManyXP(Player player) {

		if (player.getLevel() < removeXP)
			return false;
		return true;

	}

}
