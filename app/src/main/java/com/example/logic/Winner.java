package com.example.logic;

public class Winner {
	private String winnerName;
	private String botChoice;
	private int humanWins;
	private int botWins;
	
	public String getWinnerName() {
		return winnerName;
	}
	public String getBotChoice() {
		return botChoice;
	}
	public int getHumanWins() {
		return humanWins;
	}
	public int getBotWins() {
		return botWins;
	}
	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}
	public void setBotChoice(String botChoice) {
		this.botChoice = botChoice;
	}
	public void setHumanWins(int humanWins) {
		this.humanWins = humanWins;
	}
	public void setBotWins(int botWins) {
		this.botWins = botWins;
	}
	
	
}
