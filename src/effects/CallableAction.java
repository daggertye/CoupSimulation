package effects;

public enum CallableAction {
	EXCHANGE, ASSASSINATE, BLOCKASSASSIN, BLOCKFOREIGNAID, TAX, BLOCKSTEAL, STEAL;

	public static CallableAction[] getCallableActions() {
		return new CallableAction[] { EXCHANGE, ASSASSINATE, BLOCKASSASSIN, BLOCKFOREIGNAID, TAX, BLOCKSTEAL, STEAL };
	}
}
