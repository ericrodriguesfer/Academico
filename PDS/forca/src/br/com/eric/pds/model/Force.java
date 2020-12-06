package br.com.eric.pds.model;

import java.util.ArrayList;
import java.util.List;

public class Force {
	private char [] forceWord;
	private List <String> letterErrorWord;
	private List <String> letterSuccessWord;
	private int totalAttempt;
	private String secretWord;
	private BankWord bank;
	private boolean finishiGame;
	private boolean successGame;
	
	public Force () {
		this.letterErrorWord = new ArrayList<String>();
		this.letterSuccessWord = new ArrayList<String>();
		this.totalAttempt = 6;
		this.finishiGame = false;
		this.successGame = false;
		bank = new BankWord();
		this.secretWord = bank.getChooseWord();
		this.forceWord = new char[this.secretWord.length()];
		
		for (int i = 0; i < this.secretWord.length(); i++) {
			forceWord[i] = '_';
		}
	}

	public char[] getForceWord() {
		return forceWord;
	}

	public void setForceWord(char[] forceWord) {
		this.forceWord = forceWord;
	}

	public List<String> getLetterErrorWord() {
		return letterErrorWord;
	}

	public void setLetterErrorWord(List<String> letterErrorWord) {
		this.letterErrorWord = letterErrorWord;
	}

	public List<String> getLetteSuccessWord() {
		return letterSuccessWord;
	}

	public void setLetteSuccessWord(List<String> letteSuccessWord) {
		this.letterSuccessWord = letteSuccessWord;
	}

	public int getTotalAttempt() {
		return totalAttempt;
	}

	public void setTotalAttempt(int totalAttempt) {
		this.totalAttempt = totalAttempt;
	}

	public String getSecretWord() {
		return secretWord;
	}

	public void setSecretWord(String secretWord) {
		this.secretWord = secretWord;
	}

	public BankWord getBank() {
		return bank;
	}

	public void setBank(BankWord bank) {
		this.bank = bank;
	}

	public boolean isFinishiGame() {
		return finishiGame;
	}

	public void setFinishiGame(boolean finishiGame) {
		this.finishiGame = finishiGame;
	}
	
	public boolean isSuccessGame() {
		return successGame;
	}

	public void setSuccessGame(boolean successGame) {
		this.successGame = successGame;
	}

	private void addLetterError (String letter) {
		for (int i = 0; i < this.letterErrorWord.size(); i++) {
			if (this.letterErrorWord.get(i).equals(letter)) {
				return;
			}
		}
		
		this.letterErrorWord.add(letter);
	}
	
	private void addLetterSuccess (String letter) {
		for (int i = 0; i < this.letterSuccessWord.size(); i++) {
			if (this.letterSuccessWord.get(i).equals(letter)) {
				return;
			}
		}
		
		this.letterSuccessWord.add(letter);
	}
	
	public int countTotalError () {
		return this.letterErrorWord.size();
	}
	
	public int countTotalSuccess () {
		return this.letterSuccessWord.size();
	}
	
	public void checkLetterRead (char letter) {
		boolean addLetter = false;
		
		
		for (int i = 0; i < this.secretWord.length(); i++)  {
			if (this.secretWord.charAt(i) == letter) {
				this.forceWord[i] = letter;
				addLetter = true;
			}
		}
		
		
		if (addLetter) {
			this.addLetterSuccess(String.valueOf(letter));
		} else {
			this.addLetterError(String.valueOf(letter));
		}
		
		this.checkFinishi();
	}
	
	private void checkFinishi () {
		if (this.countTotalError() >= this.getTotalAttempt()) {
			this.setFinishiGame(true);
		} 
		
		this.setSuccessGame(this.checkSuccess());
	}

	private boolean checkSuccess () {
		for (int i = 2; i < this.secretWord.length(); i++) {
			if (this.secretWord.charAt(i) != this.forceWord[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public void printForce () {
		for (int i = 2; i < this.secretWord.length(); i++) {
			System.out.print(forceWord[i] + " ");
		}
		
		System.out.println(" ");
	}
}
