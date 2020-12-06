	package br.com.eric.pds.model;

import java.util.Scanner;

public class View {
	static private Scanner in = new Scanner(System.in);
	private Force force;
	private char letter;
	
	public View() {
		super();
	}

	public Force getForce() {
		return force;
	}

	public void setForce(Force force) {
		this.force = force;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}
	
	public void startGame () {
		this.force = new Force();
		
		do {
			this.readLetter();
			this.force.checkLetterRead(letter);
			
			System.out.println("Suas chances: " + this.force.countTotalError() + "/" + this.force.getTotalAttempt());
			this.force.printForce();
			System.out.println("Acertou: " + this.force.getLetteSuccessWord());
			System.out.println("Errou: " + this.force.getLetterErrorWord());
			
			if (this.force.isSuccessGame()) {
				break;
			}
		} while (!this.force.isFinishiGame());
		
		if (this.force.isFinishiGame()) {
			System.out.println("Você não acertou a palavra!");
		}
		
		if (this.force.isSuccessGame()) {
			System.out.println("Você acertou a palavra!");
		}
		
		this.newGame();
	}
	
	private void readLetter () {
		System.out.println("Digite a letra que deseja testar: ");
		letter = in.nextLine().charAt(0);
	}
	
	private void newGame () {
		System.out.println("Você deseja jogar novamente: (s) para sim ou (n) para não");
		String choose = in.nextLine();
		
		if (choose.equals("s")) {
			this.startGame();
		}
	}
	
	@Override
	public String toString() {
		return "View force: " + this.getForce() + "\nletter: " + this.getLetter();
	}
}
