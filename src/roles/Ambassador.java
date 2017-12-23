package roles;

import effects.Action;

public class Ambassador extends Role{

	@Override
	public String getType() {
		return "Ambassador";
	}

	@Override
	public Action[] getAllowedMoves() {
		return new Action[] {Action.AMBASSADOR, Action.BLOCKSTEAL};
	}

}
