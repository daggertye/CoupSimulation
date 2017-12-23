package roles;

import effects.Action;

public class Duke extends Character{

	@Override
	public String getType() {
		return "Duke";
	}

	@Override
	public Action[] getAllowedMoves() {
		return new Action[] {Action.TAX, Action.BLOCKFOREIGNAID};
	}
	
}
