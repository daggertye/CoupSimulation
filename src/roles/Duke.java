package roles;

import effects.Action;

public class Duke extends Role{

	@Override
	public String getType() {
		return "Duke";
	}

	@Override
	public Action[] getAllowedMoves() {
		return new Action[] {Action.DRAWTHREE, Action.BLOCKFOREIGNAID};
	}
	
}
