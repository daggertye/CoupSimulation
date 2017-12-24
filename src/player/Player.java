package player;

import java.util.HashMap;
import effects.Action;
import roles.Character;

public class Player {
	private HashMap<Action, Boolean> possiblerules;
	private Character c1;
	private Character c2;

	/**
	 * Initializes a character with the characters
	 * 
	 * @precondition card1 and card2 {@code isDead()} == false;
	 * @param card1 
	 * @param card2
	 */
	public Player(Character card1, Character card2) {
		card1.setDead(false);
		card2.setDead(false);
		possiblerules = new HashMap<Action, Boolean>();
		Action[] rules = Action.getActions();
		for (Action rule : rules) {
			possiblerules.put(rule, false);
		}
		card1.addAllowedMoves(possiblerules);
		card2.addAllowedMoves(possiblerules);

		c1 = card1;
		c2 = card2;
	}

	/**
	 * Removes a life based on character
	 * 
	 * @param c
	 */
	public void removeLife(Character c) {
		if (c1.getType().equals(c2.getType()) && c1.getType().equals(c.getType())) {
			c1.setDead(true);
		} else if (c1.getType().equals(c.getType())) {
			c1.removeAllowedMoves(possiblerules);
			c1.setDead(true);
		} else {
			c2.removeAllowedMoves(possiblerules);
			c2.setDead(true);
		}
	}

	/**
	 * Removes a life based on index
	 * 
	 * @precondition i == 1 or i == 2;
	 * @param i
	 *            the character/life to die
	 */
	public void removeLife(int i) {
		if (i == 1) {
			c1.setDead(true);
			if (!c1.getType().equals(c2.getType()))
				c1.removeAllowedMoves(possiblerules);
		} else if (i == 2) {
			c2.setDead(true);
			if (!c1.getType().equals(c2.getType()))
				c2.removeAllowedMoves(possiblerules);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/** Setters and getters **/
	public HashMap<Action, Boolean> getRules() {
		return possiblerules;
	}

	public Character getFirstCharacter() {
		return c1;
	}

	public Character getSecondCharacter() {
		return c2;
	}
}
