package roles;

import effects.Action;
import java.util.HashMap;

public abstract class Role {
	
	public abstract String getType();
	
	public abstract Action[] getAllowedMoves();
	
	public void addAllowedMoves(HashMap<Action, Boolean> hm) {
		Action[] moves = getAllowedMoves();
		for(Action move: moves) {
			hm.put(move, true);
		}
	}
}
