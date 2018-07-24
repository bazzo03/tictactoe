package com.danielbernal.tictactoe.exception;

public class NoSymbolCreatedException extends Exception {

	private static final long serialVersionUID = -1035066819459570741L;

	public NoSymbolCreatedException() {
		super();
	}
	public NoSymbolCreatedException(String msg) {
		super(msg);
	}
}
