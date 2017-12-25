//Need to fix this!
package model;

import java.util.HashMap;
import effects.CallableAction;
import roles.*;
import roles.Character;

public class Player {
	private HashMap<CallableAction, Boolean> possiblerules;
	private Character c1;
	private Character c2;

	/**
	 * Initializes a character with the characters
	 * 
	 * @precondition card1 and card2 {@code isDead()} == false;
	 * @param card1 First role
	 * @param card2 Second role
	 */
	public Player(Character card1, Character card2) {
		card1.setDead(false);
		card2.setDead(false);
		possiblerules = new HashMap<CallableAction, Boolean>();
		CallableAction[] rules = CallableAction.getCallableActions();
		for (CallableAction rule : rules) {
			possiblerules.put(rule, false);
		}
		card1.addAllowedMoves(possiblerules);
		card2.addAllowedMoves(possiblerules);

		c1 = card1;
		c2 = card2;
	}

	/**
	 * Removes a life based on index
	 * 
	 * @precondition i == 1 or i == 2 and the ith character is alive
	 * @param i
	 *            the character/life to die
	 * @throws IndexOutOfBoundsException if precondition not met
	 */
	public void removeLife(int i) {
		if (i == 1 && !c1.isDead()) {
			c1.setDead(true);
			if (!c1.getType().equals(c2.getType()) || c2.isDead())
				c1.removeAllowedMoves(possiblerules);
		} else if (i == 2 && !c2.isDead()) {
			c2.setDead(true);
			if (!c1.getType().equals(c2.getType()) || c1.isDead())
				c2.removeAllowedMoves(possiblerules);
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	/** Setters and getters **/
	public HashMap<CallableAction, Boolean> getRules() {
		return possiblerules;
	}

	public Character getFirstCharacter() {
		return c1;
	}

	public Character getSecondCharacter() {
		return c2;
	}
	
	/**
	 * Return a representation of the characters
	 * 
	 * @return an int[] of size 5. See {@code GameModel} invariant
	 */
	public int[] getRepresentation() {
		int[] rep = new int[5];
		if(c1 instanceof Ambassador) {
			rep[0] ++;
		} else if (c1 instanceof Assassin) {
			rep[1] ++;
		} else if (c1 instanceof Contessa) {
			rep[2] ++;
		} else if (c1 instanceof Captain) {
			rep[3] ++;
		} else if (c1 instanceof Duke) {
			rep[4] ++;
		}
		
		if(c2 instanceof Ambassador) {
			rep[0] ++;
		} else if (c2 instanceof Assassin) {
			rep[1] ++;
		} else if (c2 instanceof Contessa) {
			rep[2] ++;
		} else if (c2 instanceof Captain) {
			rep[3] ++;
		} else if (c2 instanceof Duke) {
			rep[4] ++;
		}
		
		return rep;
	}
}
