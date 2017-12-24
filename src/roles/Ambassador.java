package roles;

import effects.CallableAction;

public class Ambassador extends Character{

	@Override
	public String getType() {
		return "Ambassador";
	}

	@Override
	public CallableAction[] getAllowedMoves() {
		return new CallableAction[] {CallableAction.EXCHANGE, CallableAction.BLOCKSTEAL};
	}

}
