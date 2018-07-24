package com.danielbernal.tictactoe.exception;

public class OutOfBoardException extends Exception {

	private static final long serialVersionUID = -1035066819459570741L;

	public OutOfBoardException() {
		super();
	}
	public OutOfBoardException(String msg) {
		super(msg);
	}
}
