package effects;

public enum UncallableAction {
	INCOME, FOREIGNAID, CALL;
	public UncallableAction[] getUncallableActions() {
		return new UncallableAction[] {INCOME, FOREIGNAID, CALL};
	}
}
