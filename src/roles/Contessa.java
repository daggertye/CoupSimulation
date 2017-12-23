package roles;

import effects.Action;

public class Contessa extends Character{

	@Override
	public String getType() {
		return "Contessa";
	}
	
	@Override
	public Action[] getAllowedMoves() {
		return new Action[] {Action.BLOCKASSASSIN};
	}
}
