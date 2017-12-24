package roles;

import effects.CallableAction;

public class Captain extends Character{

	@Override
	public String getType() {
		return "Captain";
	}

	@Override
	public CallableAction[] getAllowedMoves() {
		return new CallableAction[] {CallableAction.STEAL, CallableAction.BLOCKSTEAL};
	}

}
