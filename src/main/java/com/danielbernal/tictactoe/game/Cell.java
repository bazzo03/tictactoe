package com.danielbernal.tictactoe.game;

/**
 * The Cell class models each individual cell of the game board.
 */
public class Cell {

	Symbol content;
	private int row;
	private int col;

	/** 
	 * Constructor to initialize this cell 
	 */
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		clear();
	}

	/** 
	 * Clear the cell content 
	 */
	public void clear() {
		content = Symbol.EMPTY;
	}

	/** 
	 * Paint
	 */
	public void paint() {
		System.out.print(content.toString());
	}
}