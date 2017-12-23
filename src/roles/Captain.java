package roles;

import effects.Action;

public class Captain extends Character{

	@Override
	public String getType() {
		return "Captain";
	}

	@Override
	public Action[] getAllowedMoves() {
		return new Action[] {Action.STEAL, Action.BLOCKSTEAL};
	}

}
