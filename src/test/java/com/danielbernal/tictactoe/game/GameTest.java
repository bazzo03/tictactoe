package com.danielbernal.tictactoe.game;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.danielbernal.tictactoe.exception.NoSymbolCreatedException;
import com.danielbernal.tictactoe.exception.SymbolAlreadySelectedException;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

	@Test
	public void selectSymbols() throws SymbolAlreadySelectedException, NoSymbolCreatedException {
	
		Game game = mock(Game.class);
		Symbol symbol = Symbol.Y;
		
		Player player = Player.COMPUTER;
		player.setSymbol(symbol);
		
		game.selectSymbols(player);
		
		Assert.assertTrue(player.getSymbol().equals(Symbol.Y));
	}
	
	@Test
	public void isSymbolTakenExpectFalse() {
		
		Game game = mock(Game.class);
		Player player1 = Player.PLAYER_1;
		Player player2 = Player.PLAYER_2;
		Player computer = Player.COMPUTER;
		
		player1.setSymbol(Symbol.K);
		player2.setSymbol(Symbol.L);

		when(game.isSymbolTaken(computer, Symbol.O)).thenReturn(false);
		boolean expected = game.isSymbolTaken(computer, Symbol.O);
		
		Assert.assertEquals(expected, false);
		
				
	}
	
	@Test
	public void isSymbolTakenExpectTrue() {
		
		Game game = mock(Game.class);
		Player player1 = Player.PLAYER_1;
		Player player2 = Player.PLAYER_2;
		Player computer = Player.COMPUTER;
		
		player1.setSymbol(Symbol.K);
		player2.setSymbol(Symbol.O);
		
		when(game.isSymbolTaken(computer, Symbol.O)).thenReturn(true);
		
		boolean expected = game.isSymbolTaken(computer, Symbol.O);
		
		Assert.assertEquals(expected, true);
				
	}
	
	@Test
	public void verifyGameIsFinished() {
		
		Game game = mock(Game.class);
		
		doNothing().when(game).verifyGameIsFinished();
	}

}
