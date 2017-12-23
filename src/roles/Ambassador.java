package roles;

import effects.Action;

public class Ambassador extends Character{

	@Override
	public String getType() {
		return "Ambassador";
	}

	@Override
	public Action[] getAllowedMoves() {
		return new Action[] {Action.EXCHANGE, Action.BLOCKSTEAL};
	}

}
