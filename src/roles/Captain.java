package roles;

import effects.Action;

public class Captain extends Role{

	@Override
	public String getType() {
		return "Captain";
	}

	@Override
	public Action[] getAllowedMoves() {
		return new Action[] {Action.STEAL, Action.BLOCKSTEAL};
	}

}
