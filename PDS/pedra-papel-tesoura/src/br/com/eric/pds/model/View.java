package br.com.eric.pds.model;

import java.util.Scanner;

public class View {
	static private Scanner read = new Scanner(System.in);
	private Control control;
	private boolean finishi;

	public View () {
		super();
		this.control = null;
		this.finishi = false;
	}

	public Control getControl () {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}
	
	public boolean isFinishi() {
		return finishi;
	}

	public void setFinishi(boolean finishi) {
		this.finishi = finishi;
	}

	public void startGame () {
		System.out.println("######## BEM VINDO AO JOGO!!! ########");
		System.out.print("Digite o seu nome jogador: ");
		String namePlayer = read.nextLine();
		
		Player player = new Player(namePlayer);
		
		Game game = new Game(player, new Player("Computer"));
		
		this.control = new Control(game);
		
		this.actionGame();
	}
	
	public void actionGame () {
		do {
			this.readMovePlayer();
			
			switch (this.control.winnerMatch()) {
				case -1:
					System.out.println("EMPATE!!!");
					break;
				
				case 1:
					System.out.println(this.control.getNamePlayer() + " VOCÊ GANHOU DO COMPUTADOR!!!");
					break;
				
				case 2:
					System.out.println("VOCÊ FOI DERROTADO PELO COMPUTADOR :(");
					break;
					
				default:
					System.out.println("HOUVE ALGUEM ERRO!!!");
					break;
			}
			
			System.out.println(this.control.getNamePlayer() + " JOGOU: " + ((this.control.getMovePlayer() == 0) ? "Pedra" : this.control.getMovePlayer() == 1 ? "Papel" : this.control.getMovePlayer() == 2 ? "Tesoura" : "N/A"));
			System.out.println("Computer JOGOU: " + ((this.control.getMoveComputer() == 0) ? "Pedra" : this.control.getMoveComputer() == 1 ? "Papel" : this.control.getMoveComputer() == 2 ? "Tesoura" : "N/A"));
			
			System.out.println("######## PLACAR A ATUAL ########");
			System.out.println(this.control.infoScoreboard());
			this.control.resetNextMatch();
			
			this.readFinish();
		} while (!finishi);
	}
	
	public void readMovePlayer () {
		System.out.println("Digite sua jogada: 0) Pedra 1) Papel 2) Tesoura");
		int chooseMovePlayer = Integer.parseInt(read.nextLine());
		
		while (chooseMovePlayer <= -1 || chooseMovePlayer >= 3) {
			System.out.println("Digite sua jogada: 0) Pedra 1) Papel 2) Tesoura");
			chooseMovePlayer = Integer.parseInt(read.nextLine());
		}
		
		this.control.setMovePlayer(chooseMovePlayer);
	}
	
	public void readFinish () {
		System.out.println("VOCÊ DESEJA PARAR DE JOGAR: 1) SIM OU 0) NÃO:");
		int chooseFinishi = Integer.parseInt(read.nextLine());
		
		if (chooseFinishi == 1) {
			this.setFinishi(true);
		}
	}

	@Override
	public String toString() {
		return "####### View #######\nControl: " + this.getControl() + "\nFinishi: " + this.isFinishi();
	}
}
