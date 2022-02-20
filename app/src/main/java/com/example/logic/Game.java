package com.example.logic;

import java.util.LinkedList;
import java.util.List;

/*
 * main class of the game which is responsible for the 
 */
public class Game {

	private int player;
	private Player[] players;
	private List<Player> winners;
	private Symbols humanChoice;
	private Symbols botChoice;
	private Winner winner;

	public Game() {
		this.player = 0; // index of the current player
		this.players = new Player[2];// we have two players

		this.humanChoice = Symbols.ROCK;
		this.botChoice = Symbols.ROCK;

		this.players[0] = new Human("You", false);
		this.players[1] = new Bot("Bot", true);

		this.winners = new LinkedList<>();
		this.winner = new Winner();
	}

	/**
	 * go to the next player and then checks if the next player is bot then call the
	 * getBotChoice()
	 */
	private void nextPlayer() {
		player = (player + 1) % 2;
		if (this.players[player].isBot()) {
			getBotChoice();
		}
	}

	/**
	 * checks if both player have the same choice then winner value is 2, otherwise
	 * according to the each player choice (ordinal of the symbol) they calculated.
	 * 
	 * @return
	 */
	private int winner() {
		int winner = 0;// 0 is the human and 1 is bot
		if (humanChoice == botChoice) {
			winner = 2;
		} else if (humanChoice == Symbols.PAPER) {
			if (botChoice == Symbols.ROCK) {
				winner = 0;
			} else if (botChoice == Symbols.SCISSORS) {
				winner = 1;
			}
		} else if (humanChoice == Symbols.ROCK) {
			if (botChoice == Symbols.PAPER) {
				winner = 1;
			} else if (botChoice == Symbols.SCISSORS) {
				winner = 0;
			}
		} else if (humanChoice == Symbols.SCISSORS) {
			if (botChoice == Symbols.ROCK) {
				winner = 1;
			} else if (botChoice == Symbols.PAPER) {
				winner = 0;
			}
		}
		if (winner != 2) {
			winners.add(players[winner]);
		}
		return winner;
	}

	/**
	 * call the AI method for the current player then again call the next player
	 */
	private void getBotChoice() {
		botChoice = players[player].AI();
		nextPlayer();
	}

	/**
	 * set the human choice that is passed from the frontend into a variable of
	 * symbol.
	 * 
	 * @param choice
	 */
	public void doPlay(String choice) {
		if(choice.toUpperCase().equals("ROCK")){
			humanChoice = Symbols.ROCK;
		}else if(choice.toUpperCase().equals("PAPER")){
			humanChoice = Symbols.PAPER;
		}else if(choice.toUpperCase().equals("SCISSORS")){
			humanChoice = Symbols.SCISSORS;
		}
		nextPlayer();
	}

	/**
	 * return an array which contains of winner id, bot choice index, how many times
	 * human wins and how many times bot wins.
	 * 
	 * @return
	 */
	public Winner getResult() {
		
		String winnerName = "";
		int winnerNumber = winner();
		if (winnerNumber == 0) {
			winnerName = "Human";

		} else if (winnerNumber == 1) {
			winnerName = "Bot";
		} else {
			winnerName = "Nobody";
		}
		this.winner.setWinnerName(winnerName);
		this.winner.setBotChoice(botChoice.toString().toLowerCase());
		int[] count = countWins();
		this.winner.setHumanWins(count[0]);
		this.winner.setBotWins(count[1]);
		return this.winner;
	}

	/**
	 * counts the number of each player that wins the game.
	 */
	private int[] countWins() {
		int[] counts = new int[2];
		for (int i = 0; i < winners.size(); i++) {
			if (winners.get(i).isBot()) {
				counts[1]++;
			} else {
				counts[0]++;
			}
		}
		return counts;
	}

	public void reset(){
		this.winners.clear();
		System.out.println("reset" + this.winner.getBotWins() + " , " + this.winner.getHumanWins());
	}
}
