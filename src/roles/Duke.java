package roles;

import effects.CallableAction;

public class Duke extends Character{

	@Override
	public String getType() {
		return "Duke";
	}

	@Override
	public CallableAction[] getAllowedMoves() {
		return new CallableAction[] {CallableAction.TAX, CallableAction.BLOCKFOREIGNAID};
	}
	
}
