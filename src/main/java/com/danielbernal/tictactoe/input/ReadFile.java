package com.danielbernal.tictactoe.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class to read from file
 */
public class ReadFile {

	private static final String FILE = "config.properties";
	private static final String SIZE = "size";
	private static final String PLAYER_1 = "player1";
	private static final String PLAYER_2 = "player2";
	private static final String COMPUTER = "computer";

	public int obtainBoardSize() {
		return Integer.parseInt(obtainProperty(SIZE));
	}

	public String obtainPlayerOneCharacter() {
		return obtainProperty(PLAYER_1);
	}

	public String obtainPlayerTwoCharacter() {
		return obtainProperty(PLAYER_2);
	}

	public String obtainComputerCharacter() {
		return obtainProperty(COMPUTER);
	}

	private String obtainProperty(String key) {

		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = this.getClass().getClassLoader().getResourceAsStream(FILE);
			prop.load(input);
			return (prop.getProperty(key));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}