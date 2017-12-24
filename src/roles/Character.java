package roles;

import effects.CallableAction;
import java.util.HashMap;

public abstract class Character {
	
	private boolean dead = false;
	
	public abstract String getType();
	
	public abstract CallableAction[] getAllowedMoves();
	
	public void addAllowedMoves(HashMap<CallableAction, Boolean> hm) {
		CallableAction[] moves = getAllowedMoves();
		for(CallableAction move: moves) {
			hm.put(move, true);
		}
	}
	
	public void removeAllowedMoves(HashMap<CallableAction, Boolean> hm) {
		CallableAction[] moves = getAllowedMoves();
		for(CallableAction move: moves) {
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
