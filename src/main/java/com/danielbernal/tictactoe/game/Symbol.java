package com.danielbernal.tictactoe.game;

/**
 * Enumerations for the seeds and cell contents
 */
public enum Symbol {
   EMPTY(""), L("L"), X("X"), Y("Y"), T("T"), O("O"), K("K");
	
	private Symbol(String text) {
		this.text = text;
	}
	
	private String text;

	public String getNumber() {
		return text;
	}

	public void setNumber(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		switch (this) {
		case L:
			return " L ";
		case X:
			return " X ";
		case Y:
			return " Y ";
		case T:
			return " T ";
		case O:
			return " O ";
		case K:
			return " K ";
		case EMPTY:
			return "   ";
		default:
			return "";
		}
	}
	
}