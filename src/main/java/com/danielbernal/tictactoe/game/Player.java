package com.danielbernal.tictactoe.game;

public enum Player {
	PLAYER_1, PLAYER_2, COMPUTER;
	
	private Symbol symbol;
	
	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	
	public Symbol getSymbol() {
		return this.symbol;
	}
	
	private Player(Symbol symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		if (this.equals(COMPUTER)) {
			return "Computer";
		} else if (this.equals(PLAYER_1)) {
			return "Player 1";
		} else if (this.equals(PLAYER_2)) {
			return "Player 2";
		} else {
			return "";
		}
 	}
	
	private Player() {}
}
