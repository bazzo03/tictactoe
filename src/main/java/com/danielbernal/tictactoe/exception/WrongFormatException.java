package com.danielbernal.tictactoe.exception;

public class WrongFormatException extends Exception {

	private static final long serialVersionUID = -1035066819459570741L;

	public WrongFormatException() {
		super();
	}

	public WrongFormatException(String msg) {
		super(msg);
	}
}
