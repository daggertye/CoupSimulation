package tests;

import static org.junit.Assert.*;
import org.junit.*;

import model.*;

public class GameTest {
	@Test
	public void InitializeTest() {
		GameModel gm = new GameModel();
		
		int[] deck = gm.getDeck();
		int sum = 0;
		for(int i = 0; i < deck.length; i++)
			sum += deck[i];
		System.out.println(sum);
		assert(sum == 5);
		
		Player[] players = gm.getPlayers();
		for(int i = 0; i < players.length; i++) {
			for(int j = 0; j < deck.length; j++) {
				deck[j] += players[i].getRepresentation()[j];
			}
		}
		
		for(int i = 0; i < deck.length; i++) {
			assert(deck[i] == 3);
		}
	} 
	
	@Test (expected = NullPointerException.class)
	public void OverDrawTest() {
		GameModel gm = new GameModel();
		for(int i = 0; i < 5; i++) {
			gm.drawCard();
		}
		
		gm.drawCard();
	}
}
