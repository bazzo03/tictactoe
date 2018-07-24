package com.danielbernal.tictactoe.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Works as the AI of the computer player
 */
class Computer {

	/**
	 * Returns the board size
	 */
	public static int getBoardSize() {
		
		return Board.COLS;
	}

	/**
	 * Makes a move
	 */
	public static void play() {

		int size= getBoardSize();
		Board board = Board.getBoard(size, size);
		boolean moved = false;
		
		Symbol playerOneSymbol = Player.PLAYER_1.getSymbol();
		Symbol playerTwoSymbol = Player.PLAYER_2.getSymbol();
		
		int countPlayerOne = 0;
		int countPlayerTwo = 0;
		List<Integer> possibleX = new ArrayList<>();
		List<Integer> possibleY = new ArrayList<>();
		
		//verify each column
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board.cells[i][j].content == playerOneSymbol) {
					countPlayerOne++;
				}
				if (board.cells[i][j].content == playerTwoSymbol) {
					countPlayerTwo++;
				}
				if (board.cells[i][j].content == Symbol.EMPTY) {
					possibleX.add(i);
					possibleY.add(j);
				}
			}
			if ((countPlayerOne > size/2 || countPlayerTwo > size/2) && !moved) {
				board.cells[possibleX.get(0)][possibleY.get(0)].content = Player.COMPUTER.getSymbol();
				moved = true;
			}
			countPlayerOne=0;
			countPlayerTwo=0;
		}
		
		countPlayerOne=0;
		countPlayerTwo=0;
		possibleX.clear();
		possibleY.clear();
		
		//verify each row
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				if (board.cells[i][j].content == playerOneSymbol) {
					countPlayerOne++;
				}
				if (board.cells[i][j].content == playerTwoSymbol) {
					countPlayerTwo++;
				}
				if (board.cells[i][j].content == Symbol.EMPTY) {
					possibleX.add(i);
					possibleY.add(j);
				}
			}
			if ((countPlayerOne > size/2 || countPlayerTwo > size/2) && !moved) {
				board.cells[possibleX.get(0)][possibleY.get(0)].content = Player.COMPUTER.getSymbol();
				moved = true;
			}
			countPlayerOne=0;
			countPlayerTwo=0;
		}
		
		countPlayerOne=0;
		countPlayerTwo=0;
		possibleX.clear();
		possibleY.clear();
		
		// check diagonal right

		for (int i = 0, j = 0; i < size; i++, j++) {
			if (board.cells[i][j].content == Player.PLAYER_1.getSymbol()) {
				countPlayerOne++;
			}
			if (board.cells[i][j].content == Player.PLAYER_2.getSymbol()) {
				countPlayerTwo++;
			}

			if (board.cells[i][j].content == Symbol.EMPTY) {
				possibleX.add(i);
				possibleY.add(j);
			}
		}
		if ((countPlayerOne > size/2 || countPlayerTwo > size/2) && !moved) {
			board.cells[possibleX.get(0)][possibleY.get(0)].content = Player.COMPUTER.getSymbol();
			moved = true;
		}

		countPlayerOne=0;
		countPlayerTwo=0;
		possibleX.clear();
		possibleY.clear();

		// check diagonal left
		int row = 0;
		for (int i = size - 1; i >= 0; i--) {
			if (board.cells[row][i].content == Player.PLAYER_1.getSymbol()) {
				countPlayerOne++;
			}
			if (board.cells[row][i].content == Player.PLAYER_2.getSymbol()) {
				countPlayerTwo++;
			}
			if (board.cells[row][i].content == Symbol.EMPTY) {
				possibleX.add(row);
				possibleY.add(i);
			}
			row++;
		}
		if ((countPlayerOne > size/2 || countPlayerTwo > size/2) && !moved) {
			board.cells[possibleX.get(0)][possibleY.get(0)].content = Player.COMPUTER.getSymbol();
			System.out.println("4");
			moved = true;
		}
		
	      // make random move if above rules dont apply
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (board.cells[i][j].content == Symbol.EMPTY && !moved) {
					board.cells[i][j].content = Player.COMPUTER.getSymbol();
					moved = true;
				}
			}
		}
		
	}
}