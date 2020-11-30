package br.com.eric.pds.model;

public class Player {
	private String name;
	private int totalWins;
	private int totalLoses;
	private int myMove;
	
	public Player () {
		super ();
	}

	public Player (String name) {
		super ();
		this.name = name;
		this.totalWins = 0;
		this.totalLoses = 0;
		this.myMove = -1;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public int getTotalWins () {
		return totalWins;
	}

	public void setTotalWins (int totalWins) {
		this.totalWins = totalWins;
	}

	public int getTotalLoses () {
		return totalLoses;
	}

	public void setTotalLoses (int totalLoses) {
		this.totalLoses = totalLoses;
	}

	public int getMyMove () {
		return myMove;
	}

	public void setMyMove (int myMove) {
		this.myMove = myMove;
	}
	
	public void countWin () {
		this.setTotalWins(this.getTotalWins() + 1);
	}
	
	public void countLoser () {
		this.setTotalLoses(this.getTotalLoses() + 1);
	}

	@Override
	public String toString () {
		return "Player: " + this.getName() + "\ntotalWins: " + this.getTotalWins() + "\ntotalLoses: " + this.getTotalLoses();
	}
}
