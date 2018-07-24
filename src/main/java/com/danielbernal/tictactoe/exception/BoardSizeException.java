package com.danielbernal.tictactoe.exception;

public class BoardSizeException extends Exception {

	private static final long serialVersionUID = -1035066819459570741L;

	public BoardSizeException() {
		super();
	}
	public BoardSizeException(String msg) {
		super(msg);
	}
}
