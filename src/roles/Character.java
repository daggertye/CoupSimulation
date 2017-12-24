package roles;

import effects.Action;
import java.util.HashMap;

public abstract class Character {
	
	private boolean dead = false;
	
	public abstract String getType();
	
	public abstract Action[] getAllowedMoves();
	
	public void addAllowedMoves(HashMap<Action, Boolean> hm) {
		Action[] moves = getAllowedMoves();
		for(Action move: moves) {
			hm.put(move, true);
		}
	}
	
	public void removeAllowedMoves(HashMap<Action, Boolean> hm) {
		Action[] moves = getAllowedMoves();
		for(Action move: moves) {
			if(hm.get(move) == false)
				throw new IllegalArgumentException();
			hm.put(move, false);
		}
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}
}
