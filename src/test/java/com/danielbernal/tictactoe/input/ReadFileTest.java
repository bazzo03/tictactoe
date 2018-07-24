package com.danielbernal.tictactoe.input;


import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ReadFileTest {

//	ReadFile readFile = new ReadFile();
	ReadFile readFile = mock(ReadFile.class);

	@Test
	public void obtainBoardSize() {
		int size = readFile.obtainBoardSize();

		Assert.assertEquals(size, 3);
	}

	@Test
	public void obtainComputerCharacter() {
		String s = readFile.obtainComputerCharacter();

		Assert.assertEquals(s, "Y");
	}

	@Test
	public void obtainPlayerOneCharacter() {
		String s = readFile.obtainPlayerOneCharacter();

		Assert.assertEquals(s, "L");
	}

	@Test
	public void obtainPlayerTwoCharacter() {
		String s = readFile.obtainPlayerTwoCharacter();

		Assert.assertEquals(s, "X");
	}

}
