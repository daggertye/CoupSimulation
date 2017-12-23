package roles;

import effects.Action;

public class Assassin extends Role{

	@Override
	public String getType() {
		return "Assassin";
	}

	@Override
	public Action[] getAllowedMoves() {
		return new Action[] {Action.ASSASSINATE};
	}

}
