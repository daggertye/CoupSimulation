package model;

public class GameModel {
	static final int numberofplayers = 5;
	private Player[] players;
	//Ambas -> Assass -> Contes -> Captain -> Duke
	private int[] charactersremaining;
	
	public GameModel() {
		charactersremaining = new int[5];
		for(int i = 0; i < charactersremaining.length; i++) {
			charactersremaining[i] = 3;
		}
	}
}
