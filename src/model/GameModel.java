package model;

import roles.*;
import roles.Character;

public class GameModel {
	static final int numberofplayers = 5;
	private Player[] players = new Player[numberofplayers];

	// Class invariant:
	// Ambas -> Assass -> Contes -> Captain -> Duke
	// represented as 0, 1, 2, 3, 4 in the array respectively
	private int[] deck;

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public int[] getDeck() {
		return deck;
	}

	public void setDeck(int[] deck) {
		this.deck = deck;
	}

	public static int getNumberofplayers() {
		return numberofplayers;
	}

	// size 5; sum of 0 (when no drawn) or 2;
	private int[] drawncards;

	public GameModel() {
		deck = new int[5];
		for (int i = 0; i < deck.length; i++) {
			deck[i] = 3;
		}
		for(int i = 0; i < numberofplayers; i++) {
			players[i] = createrPlayer();
		}
		drawncards = new int[5];
	}

	/**
	 * Draws a card from the deck w/o replacing it
	 * 
	 * @return a number between 0 and 4. The card drawn is marked by a '1';
	 * @precondition the deck has at least one card
	 * @postcondition the deck has one less card (for the card selected)
	 * @throws NullPointerException when the precondition is not met
	 */
	public int drawCard() {
		int sum = 0;
		for (int i = 0; i < deck.length; i++) {
			sum += deck[i];
		}
		
		if(sum <= 0)
			throw new NullPointerException();
		
		int randint = (int) (Math.random() * sum);
		for (int i = 0; i < deck.length; i++) {
			randint -= deck[i];
			if (randint <= 0) {
				deck[i]--;
				return i;
			}
		}
		throw new NullPointerException();
	}

	/**
	 * Draws the players cards
	 * 
	 * @return an array of size 5, where each array entry represents the number of
	 *         the card in the position (see class invariant)
	 * @postcondition the sum of the array entries returned is 2
	 */
	public int[] drawPlayerCards() {
		int c1 = drawCard();
		int c2 = drawCard();
		int[] cards = new int[5];
		cards[c1]++;
		cards[c2]++;
		return cards;
	}

	/**
	 * Translator between an int representation and roles
	 * 
	 * @return a character with respect to the input array
	 * @precondition the int is between [0,5);
	 * @throws IndexOutOfBoundsException if precondition is not met
	 */
	public Character getCharacter(int num) {
		if (num < 0 || num >= 5)
			throw new IndexOutOfBoundsException();
		switch (num) {
			case 0:
				return new Ambassador();
			case 1:
				return new Assassin();
			case 2:
				return new Contessa();
			case 3:
				return new Captain();
			case 4:
				return new Duke();
			default:
				throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Creates a player (for initialization)
	 * 
	 * @return a player with the two respective characters
	 * @precondition there are at least two cards remaining in the deck
	 * @throws NullPointerException if precondition is not met
	 */
	public Player createrPlayer() {
		int[] cards = drawPlayerCards();
		Character c1 = null;
		Character c2 = null;
		for(int i = 0; i < cards.length; i++) {
			if(cards[i] > 0) {
				c1 = getCharacter(i);
				cards[i]--;
				break;
			}
		}
		
		for(int i = 0; i < cards.length; i++) {
			if(cards[i] > 0) {
				c2 = getCharacter(i);
				cards[i]--;
				break;
			}
		}
		if(c1 != null && c2 != null)
			return new Player(c1, c2);
		else 
			throw new NullPointerException();
	}
}
