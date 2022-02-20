package com.example.logic;

public class Player {

	private final String name; // name of the player
	private final boolean isBot;

	/*
	 * main constructor to create player
	 */
	Player(String name, boolean isBot) {
		this.name = name;
		this.isBot = isBot;
	}

	public String getName() {
		return name;
	}

	public boolean isBot() {
		return isBot;
	}

	public Symbols AI() {
		return Symbols.PAPER;
	}

}
