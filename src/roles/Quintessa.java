package roles;

import effects.Action;

public class Quintessa extends Role{

	@Override
	public String getType() {
		return "Quintessa";
	}
	
	@Override
	public Action[] getAllowedMoves() {
		return new Action[] {Action.BLOCKASSASSIN};
	}
}
