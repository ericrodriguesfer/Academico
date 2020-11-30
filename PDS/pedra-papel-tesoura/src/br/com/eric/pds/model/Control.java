package br.com.eric.pds.model;

public class Control {
	private Game game;

	public Control () {
		super ();
	}

	public Control (Game game) {
		super ();
		this.game = game;
	}

	public Game getGame () {
		return game;
	}

	public void setGame (Game game) {
		this.game = game;
	}
	
	public void setMovePlayer (int move) {
		this.game.setChooseMovePlayer(move);
		
		this.setMoveComputer();
	}
	
	private void setMoveComputer () {
		this.game.setChooseMoveComputer();
	}
	
	public int winnerMatch () {
		return this.game.checkWin();
	}
	
	public String getNamePlayer () {
		return this.game.getNamePlayer();
	}
	
	public String infoScoreboard () {
		return this.game.scoreboard();
	}
	
	public void resetNextMatch () {
		this.game.resetMatch();
	}
	
	public int getMovePlayer () {
		return this.game.infoMovePlayer();
	}
	
	public int getMoveComputer () {
		return this.game.infoMoveComputer();
	}

	@Override
	public String toString() {
		return "####### Control #######\nGame: " + this.getGame();
	}
}
