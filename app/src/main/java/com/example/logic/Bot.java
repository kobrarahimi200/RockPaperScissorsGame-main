package com.example.logic;

import java.util.Random;

public class Bot extends Player{

	Bot(String name, boolean isBot) {
		super(name, isBot);
	}
	/*
	 * bot chooses randomly a value between o to 2 according to the Symbols indexes. 
	 */
	public Symbols AI() {
		
		Random rn = new Random();
		int rand = rn.nextInt(2 - 0 + 1) + 0;
		return Symbols.values()[rand];
	}
}
