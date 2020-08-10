package Analise;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Front {
	static int charClass;
	static char[] lexeme = new char[100];
	static char nextChar;
	static int lexLen;
	static int token;
	static int nextToken;
	static String archiver;
	static int nextCharSelected = 0;

	final static int LETTER = 0;
	final static int DIGIT = 1;
	final static int UNKNOWN = 2;

	final static int INT_LIT = 10;
	final static int IDENT = 11;
	final static int ASSIGN_OP = 20;
	final static int ADD_OP = 21;
	final static int SUB_OP = 22;
	final static int MULT_OP = 23;
	final static int DIV_OP = 24;
	final static int LEFT_PAREN = 25;
	final static int RIGHT_PAREN = 26;
	final static int EOF = -1;

	public static void addChar() {
		if (lexLen <= 100) {
			lexeme[lexLen++] = nextChar;
			lexeme[lexLen] = 0;
		} else {
			System.out.println("Erro - Lexeme is too long!!!");
		}
	}

	public static void getChar() {
		if ((nextChar = archiver.charAt(nextCharSelected)) != EOF) {
			// System.out.println("Character a character => " + nextChar);
			nextCharSelected++;

			if (Character.isLetter(nextChar)) {
				charClass = LETTER;
			} else if (Character.isDigit(nextChar)) {
				charClass = DIGIT;
			} else {
				charClass = UNKNOWN;
			}
		} else {
			charClass = EOF;
		}
	}

	public static void getNonBlank() {
		while (Character.isSpaceChar(nextChar))
			getChar();
	}

	public static int lookup(char character) {
		switch (character) {
		case '(':
			addChar();
			nextToken = LEFT_PAREN;
			break;

		case ')':
			addChar();
			nextToken = RIGHT_PAREN;
			break;

		case '+':
			addChar();
			nextToken = ADD_OP;
			break;

		case '-':
			addChar();
			nextToken = SUB_OP;
			break;

		case '*':
			addChar();
			nextToken = MULT_OP;
			break;

		case '/':
			addChar();
			nextToken = DIV_OP;
			break;

		default:
			addChar();
			nextToken = EOF;
		}

		return nextToken;
	}

	public static int lex() {
		lexLen = 0;
		getNonBlank();

		switch (charClass) {
		case LETTER:
			addChar();
			getChar();

			while (charClass == LETTER || charClass == DIGIT) {
				addChar();
				getChar();
			}

			nextToken = IDENT;
			break;

		case DIGIT:
			addChar();
			getChar();

			while (charClass == DIGIT) {
				addChar();
				getChar();
			}

			nextToken = INT_LIT;
			break;

		case UNKNOWN:
			lookup(nextChar);
			getChar();
			break;

		case EOF:
			nextToken = EOF;
			lexeme[0] = 'E';
			lexeme[1] = 'O';
			lexeme[2] = 'F';
			lexeme[3] = 0;
			break;
		}

		if (nextToken != -1) {
			System.out.println("Next token is: " + nextToken + ", Next lexeme is " + lexeme[0] + lexeme[1] + lexeme[2] + lexeme[3] + lexeme[4]);
		} else {
			System.out.println("Next token is: " + nextToken + ", Next lexeme is EOF");
		}

		for (int i = 0; i < 100; i++) {
			lexeme[i] = ' ';
		}

		return nextToken;
	}

	public static void main(String[] args) {
		Path locate = Paths.get("C:/Users/ericr/eclipse-workspace/LIP/src/Analise/front.in");

		try {
			byte[] text = Files.readAllBytes(locate);
			archiver = new String(text);

			getChar();

			do {
				lex();
			} while (nextToken != EOF);
		} catch (Exception e) {
			System.out.println("Finishin execution the archiver!!!");
		}
	}
}