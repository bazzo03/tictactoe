package com.danielbernal.tictactoe.game;

import com.danielbernal.tictactoe.exception.BoardSizeException;

/**
 * The Board class models the game-board.
 */
public class Board {

	public static int ROWS;
	public static int COLS;

	private static Board board;

	Cell[][] cells;
	int currentRow, currentCol;

	/** 
	 * Constructor to initialize the game board 
	 */
	private Board(int rows, int cols) {
		ROWS = rows;
		COLS = cols;
		cells = new Cell[ROWS][COLS]; // allocate the array
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				cells[row][col] = new Cell(row, col); // allocate element of the array
			}
		}
	}

	/**
	 * Returns the board 
	 */
	public static Board getBoard(int rows, int cols) {

		if (board == null || COLS != cols) {
			board = new Board(rows, cols);
		}
		return board;
	}

	/** 
	 * Initialize the contents of the game board 
	 */
	public void init() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				cells[row][col].clear();
			}
		}
	}

	/** 
	 * Return true if it is a draw 
	 */
	public boolean isDraw() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (cells[row][col].content == Symbol.EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Return true if the player with the given symbol has won after placing the symbol
	 */
	public boolean checkWin(Symbol seed) {

		int size = ROWS;

		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (cells[i][j].content == seed)
					count++;
			}
			if (count == size) {
				return true;
			}
			count = 0;
		}
		count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				if (cells[j][i].content == seed)
					count++;
			}
			if (count == size) {
				return true;
			}
			count = 0;
		}
		count = 0;
		// check diagonal right
		for (int i = 0, j = 0; i < size; i++, j++) {
			if (cells[i][j].content == seed)
				count++;
		}
		if (count == size) {
			return true;
		}
		count = 0;
		// check diagonal left
		int row = 0;
		for (int i = size - 1; i >= 0; i--) {
			if (cells[row][i].content == seed)
				count++;
			row++;
		}
		if (count == size) {
			return true;
		}

		return false;

	}

	/** 
	 * Paint 
	 */
	public void paint() {
		System.out.println("\n \n");
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				cells[row][col].paint();
				if (col < COLS - 1)
					System.out.print("|");
			}
			System.out.println();
			if (row < ROWS - 1) {
				for (int r = 0; r < ROWS; r++) {
					System.out.print("----");
				}
				System.out.println();
			}
		}
	}

	/**
	 * Validates if the board size is allowed
	 */
	public void validateBoardSize(int size) throws BoardSizeException {

		if (size < 3 || size > 10) {
			throw new BoardSizeException("Board size does not meet rules");
		}
	}
}