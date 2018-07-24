package com.danielbernal.tictactoe.game;

import java.util.Random;
import java.util.Scanner;

import com.danielbernal.tictactoe.exception.BoardSizeException;
import com.danielbernal.tictactoe.exception.NoSymbolCreatedException;
import com.danielbernal.tictactoe.exception.OutOfBoardException;
import com.danielbernal.tictactoe.exception.SymbolAlreadySelectedException;
import com.danielbernal.tictactoe.exception.WrongFormatException;
import com.danielbernal.tictactoe.input.ReadFile;

/**
 * Game of the class
 */
public class Game {
	private Board board;
	private GameState currentState;
	private Player currentPlayer;

	private static Scanner in = new Scanner(System.in); // input Scanner

	/** 
	 * Constructor to setup the game 
	 */
	public Game() {

		ReadFile readFile = new ReadFile();
		int	size = readFile.obtainBoardSize();
		board = Board.getBoard(size, size);
		System.out.println("Board size: " + size);
		try {
			board.validateBoardSize(size);
			initGame();
			selectSymbols(Player.PLAYER_1);
			selectSymbols(Player.PLAYER_2);
			selectSymbols(Player.COMPUTER);
			do {
				playerMove(currentPlayer);
				board.paint();
				updateGame(currentPlayer);
				verifyGameIsFinished();
				switchPlayer();
			} while (currentState == GameState.PLAYING);
		} catch (BoardSizeException | SymbolAlreadySelectedException | NoSymbolCreatedException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Select the symbol to a player
	 */
	public void selectSymbols(Player player) throws SymbolAlreadySelectedException, NoSymbolCreatedException {

		boolean isTaken = true;
		Symbol selection = Symbol.EMPTY;
		ReadFile readFile = new ReadFile();
		switch(player) {
		case COMPUTER:
			try {
				selection = Symbol.valueOf(readFile.obtainComputerCharacter());
			} catch (IllegalArgumentException iae) {
				throw new NoSymbolCreatedException("Player one symbol is not available to play with ");
			}
			break;
		case PLAYER_1:
			try {
				selection = Symbol.valueOf(readFile.obtainPlayerOneCharacter());
			} catch (IllegalArgumentException iae) {
				throw new NoSymbolCreatedException("Player two symbol is not available to play with ");
			}
			break;
		case PLAYER_2:
			try {
				selection = Symbol.valueOf(readFile.obtainPlayerTwoCharacter());
			}  catch (IllegalArgumentException iae) {
				throw new NoSymbolCreatedException("Computer symbol is not available to play with ");
			}
			break;
		default:
			break;
		}
		isTaken = isSymbolTaken(player, selection);
		if (isTaken) {
			throw new SymbolAlreadySelectedException("Sorry, symbol of player" + player.toString() + " already selected, please select another one");
		}
		player.setSymbol(selection);
		System.out.println("\n" + player.toString() + " plays with symbol: " + player.getSymbol());
	}

	/**
	 * Checks whether the symbols is already taken by another player
	 */
	public boolean isSymbolTaken(Player player, Symbol selection) {

		boolean isTaken = false;
		Player[] allPlayers = Player.values();
		for (int i = 0; i < allPlayers.length; i++) {
			if (player != allPlayers[i] && allPlayers[i].getSymbol() != null
					&& allPlayers[i].getSymbol() == selection) {
				isTaken = true;
			}
		}

		return isTaken;
	}

	/**
	 * Verifies if the game is finished
	 */
	public void verifyGameIsFinished() {
		
		switch (currentState) {
		case PLAYER_ONE_WON:
			System.out.println("\n" + Player.PLAYER_1.toString() + " won! Bye!");
			break;
		case PLAYER_TWO_WON:
			System.out.println("\n" + Player.PLAYER_2.toString() + " won! Bye!");
			break;
		case COMPUTER_WON:
			System.out.println("\n" + Player.COMPUTER.toString() + " won! Bye!");
			break;
		case DRAW:
			System.out.println("\nIt's Draw! No player wins! Bye!");
			break;
		default:
			break;
		}
	}

	/**
	 * Switches the player turn to play
	 */
	public void switchPlayer() {

		if (currentPlayer == Player.COMPUTER) {
			currentPlayer = Player.PLAYER_1;
		} else if (currentPlayer == Player.PLAYER_2) {
			currentPlayer = Player.COMPUTER;
		} else if (currentPlayer == Player.PLAYER_1) {
			currentPlayer = Player.PLAYER_2;
		}
	}

	/**
	 * Lets the computer play when it is its turn	
	 */
	public void computerPlays() {
		
		System.out.println("\nComputer moves...");
		System.out.println("--------------------");
		Computer.play();
	}

	/** Initialize the game-board contents and the current states */
	public void initGame() {

		board.init();
		randomInit();
	}

	/**
	 * Selects randomly who starts
	 */
	public void randomInit() {

		Random random = new Random();
		int randomNumber = random.nextInt(Player.values().length - 1);
		Player[] seeds = Player.values();
		currentPlayer = seeds[randomNumber];
		System.out.println("\nPlayer who starts: " + currentPlayer.toString() + "\n");
		currentState = GameState.PLAYING;
	}

	/**
	 * The player makes a move
	 */
	public void playerMove(Player player) {

		if (Player.COMPUTER.equals(player)) {
			computerPlays();
		} else {
			boolean validInput = false;
			do {
				System.out.print("\n" + player.toString() + ":" + player.getSymbol().toString() +  ": enter your move in format #,#");
				String input = in.next();
				int[] inputNumbers;
				int row = -1;
				int col = -1;
				try {
					inputNumbers = validateInputFormat(input);
					row = inputNumbers[0];
					col = inputNumbers[1];
					validateBoardSizeMove(row, col, player);
					validInput = true;
				} catch (WrongFormatException | OutOfBoardException e) {
					System.out.println(e.getMessage());
				}
				
			} while (!validInput);
		}
	}
	
	/**
	 * Validates the input of the user 
	 */
	public int[] validateInputFormat(String input) throws WrongFormatException {
		
		int[] numbers = new int[2];
		if (input != null && input.contains(",")) {
			input = input.trim();
			String inputArray[] = input.split(",");
			try {
				numbers[0] = Integer.parseInt(inputArray[0]);
				numbers[1] = Integer.parseInt(inputArray[1]);
			} catch (Exception ex) {
				throw new WrongFormatException("\nFormat of move is not valid, expected format: \"#,#\"");
			}
		} else {
			throw new WrongFormatException("\nFormat of move is not valid, expected format: \"#,#\"");
		}
		return numbers;
	}
	
	/**
	 * Validates the movement inside the board
	 */
	public void validateBoardSizeMove(int row, int col, Player player) throws OutOfBoardException {
		
		if (row > 0 && row <= Board.ROWS && col > 0 && col <= Board.COLS
				&& board.cells[row-1][col-1].content == Symbol.EMPTY) {
			board.cells[row-1][col-1].content = player.getSymbol();
			board.currentRow = row;
			board.currentCol = col;
		} else {
			throw new OutOfBoardException("This move at (" + row + "," + col + ") is not valid. Try again...");
		}
	}

	/** 
	 * Update the currentState after the player has moved 
	 */
	public void updateGame(Player player) {

		if (board.checkWin(Player.PLAYER_1.getSymbol()) || board.checkWin(Player.PLAYER_2.getSymbol())
				|| board.checkWin(Player.COMPUTER.getSymbol())) {
			if (player == Player.PLAYER_1) {
				currentState = GameState.PLAYER_ONE_WON;
			} else if (player == Player.PLAYER_2) {
				currentState = GameState.PLAYER_TWO_WON;
			} else {
				currentState = GameState.COMPUTER_WON;
			}
		} else if (board.isDraw()) {
			currentState = GameState.DRAW;
		}
	}
	
}