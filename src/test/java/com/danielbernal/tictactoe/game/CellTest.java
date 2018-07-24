package com.danielbernal.tictactoe.game;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CellTest {

	@Test
	public void clear() {
		
		Cell cell = mock(Cell.class);
		doNothing().when(cell).clear();
		
		cell.clear();
		
		verify(cell, times(1)).clear();
	}
	
	@Test
	public void paint() {
		
		Cell cell = mock(Cell.class);
		doNothing().when(cell).paint();
		
		cell.paint();
		
		verify(cell, times(1)).paint();
	}

}
