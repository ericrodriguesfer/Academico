package br.com.eric.pds.model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
	
public class BankWord {
	private List <String> bank;
	private String chooseWord;
	
	public BankWord () {
		this.bank = new ArrayList<String>();
		
		this.populateBankWords();
	}

	public List<String> getBank () {
		return bank;
	}

	public void setBank (List <String> bank) {
		this.bank = bank;
	}

	public String getChooseWord () {
		return chooseWord;
	}

	public void setChooseWord (String chooseWord) {
		this.chooseWord = chooseWord;
	}
	
	private void addWordBank (String word) {
		bank.add(word);
	}
	
	private void selectionWord (int indexWord) {
		this.setChooseWord(this.bank.get(indexWord));
	}
	
	private void sortWord () {
		Random sort = new Random();
		this.selectionWord(sort.nextInt(this.bank.size()));
	}
	
	private void populateBankWords () {
		String input = null;
		Path locate = Paths.get("C:\\Users\\ericr\\eclipse-workspace\\FORCA\\src\\br\\com\\eric\\pds\\utils\\words.in");
		
		try {
			byte [] bankWords = Files.readAllBytes(locate);
			input = new String(bankWords);
			
			String [] separatorWords = input.split("@");
			
			for (String wordInput : separatorWords) {
				this.addWordBank(wordInput);
			}
			
			this.sortWord();
		} catch (Exception e) {
			System.out.println("Finishin read the archiver!!!");
		}
	}

	@Override
	public String toString() {
		return "BankWord: " + this.getBank();
	}
}
