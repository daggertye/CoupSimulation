package roles;

import effects.CallableAction;

public class Assassin extends Character{

	@Override
	public String getType() {
		return "Assassin";
	}

	@Override
	public CallableAction[] getAllowedMoves() {
		return new CallableAction[] {CallableAction.ASSASSINATE};
	}

}
