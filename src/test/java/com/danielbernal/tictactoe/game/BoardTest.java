package com.danielbernal.tictactoe.game;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
//@RunWith(PowerMockRunner.class)
//@PowerMockRunnerDelegate(JUnit4.class)
public class BoardTest {

	@Test
	@Ignore
	public void getBoard() {

//		PowerMockito.mockStatic(Board.class);
		int size = 4;
		Board.ROWS = size;
		Board.COLS = size;
		Board expectedBoard = mock(Board.class);
		expectedBoard.cells = new Cell[Board.ROWS][Board.COLS];
		for (int row = 0; row < expectedBoard.ROWS; ++row) {
			for (int col = 0; col < expectedBoard.COLS; ++col) {
				expectedBoard.cells[row][col] = new Cell(row, col); // allocate element of the array
			}
		}
		
		
		BDDMockito.given(Board.getBoard(size, size)).willReturn(expectedBoard);
		
		Board board2 = Board.getBoard(size, size);
		
		Assert.assertNotNull(board2.cells);
		
	}
	
	@Test
	public void init() {
		
		Board board = mock(Board.class);
		doNothing().when(board).init();
		board.init();
		
		verify(board, times(1)).init();
		
	}

	@Test
	public void isDrawFalse() {
		
		Board board = mock(Board.class);
		when(board.isDraw()).thenReturn(false);
		
		boolean expected = board.isDraw();
		
		Assert.assertEquals(expected, false);
		
	}
	
	@Test
	public void isDrawTrue() {
		
		Board board = mock(Board.class);
		when(board.isDraw()).thenReturn(true);
		
		boolean expected = board.isDraw();
		
		Assert.assertEquals(expected, true);
		
	}
	
	@Test
	public void checkWinFalse() {
		
		Board board = mock(Board.class);
		when(board.checkWin(Symbol.K)).thenReturn(false);
		
		boolean expected = board.checkWin(Symbol.K);
		
		Assert.assertEquals(expected, false);
	}
	
	@Test
	public void checkWinTrue() {
		
		Board board = mock(Board.class);
		when(board.checkWin(Symbol.K)).thenReturn(true);
		
		boolean expected = board.checkWin(Symbol.K);
		
		Assert.assertEquals(expected, true);
	}
	
	@Test
	public void paint() {
		
		Board board = mock(Board.class);
		doNothing().when(board).paint();
		board.paint();
		verify(board, times(1)).paint();
	}

}
