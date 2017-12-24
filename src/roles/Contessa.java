package roles;

import effects.CallableAction;

public class Contessa extends Character{

	@Override
	public String getType() {
		return "Contessa";
	}
	
	@Override
	public CallableAction[] getAllowedMoves() {
		return new CallableAction[] {CallableAction.BLOCKASSASSIN};
	}
}
