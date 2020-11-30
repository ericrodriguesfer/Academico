package br.com.eric.pds.model;

import java.util.Random;

public class Game {
	private Player player;
	private Player computer;
	
	public Game () {
		super ();
	}
	
	public Game (Player player, Player computer) {
		super ();
		this.player = player;
		this.computer = computer;
	}

	public Player getPlayer () {
		return player;
	}

	public void setPlayer (Player player) {
		this.player = player;
	}

	public Player getComputer () {
		return computer;
	}

	public void setComputer (Player computer) {
		this.computer = computer;
	}
	
	public void setChooseMovePlayer (int move) {
		this.player.setMyMove(move);
	}
	
	public void setChooseMoveComputer () {
		Random sort = new Random();
		this.computer.setMyMove(sort.nextInt(3));
	}
	
	public String getNamePlayer () {
		return this.player.getName();
	}
	
	public String scoreboard () {
		return (this.player.getName() + " " + this.player.getTotalWins() + " X " + this.computer.getTotalWins() + " " + this.computer.getName());
	}
	
	public void resetMatch () {
		this.player.setMyMove(-1);
		this.computer.setMyMove(-1);
	}
	
	public int infoMovePlayer () {
		return this.player.getMyMove();
	}
	
	public int infoMoveComputer () {
		return this.computer.getMyMove();
	}
	
	public int checkWin () {
		if (this.player.getMyMove() == this.computer.getMyMove()) {
			return -1;
		} else {
			if (this.player.getMyMove() == 0 && this.computer.getMyMove() == 2 || this.player.getMyMove() == 1 && this.computer.getMyMove() == 0 || this.player.getMyMove() == 2 && this.computer.getMyMove() == 1) {
				this.player.countWin();
				this.computer.countLoser();
				
				return 1;
			} else {
				this.computer.countWin();
				this.player.countLoser();
				
				return 2;
			}
		}
	}

	@Override
	public String toString() {
		return "####### Game #######\nPlayer: " + this.getPlayer() + "\nComputer: " + this.getComputer();
	}
}
