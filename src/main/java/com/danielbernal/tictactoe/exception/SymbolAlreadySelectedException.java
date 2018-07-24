package com.danielbernal.tictactoe.exception;

public class SymbolAlreadySelectedException extends Exception {

	private static final long serialVersionUID = -1035066819459570741L;

	public SymbolAlreadySelectedException() {
		super();
	}
	public SymbolAlreadySelectedException(String msg) {
		super(msg);
	}
}
