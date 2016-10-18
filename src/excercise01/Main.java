package excercise01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Returns a string that contains all prims in the sieve.
	 * Output formats to, e.g. "2 - 3 - 5 - 7"
	 * @param sieve
	 * @return
	 */
	private static String printPrims(boolean[] sieve) {
		String prims = "";
		for(int i=2; i<sieve.length; i++){
			if(sieve[i]) {
				prims += i + " - ";
			}
		}
		return prims.substring(0, prims.length()-3);
	}
	
	private static int readUsersInput(String errorMessage) {
		int input = 0;
		boolean isValidInput = false;
		int[] numbers = new int[2];
		while(!isValidInput) {
			try {
				input = Integer.parseInt(reader.readLine());
				if(input != 0) {
					isValidInput = true;
				}
				else {
					System.err.println(errorMessage);
				}
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return input;
	}
	
	/**
	 * Asks the user for two numbers. Zero is not allowed.
	 * @return int[]
	 */
	private static int[] askForTwoNumbers() {
		String errorMessage = "Bitte geben Sie eine ganze Zahl ungleich 0 ein.";
		int[] numbers = new int[2];

		System.out.println("Bitte geben Sie eine erste Zahl zur Berechnung des ggT ein: ");
		numbers[0] = readUsersInput(errorMessage);

		System.out.println("Bitte geben Sie eine zweite Zahl ein: ");
		numbers[1] = readUsersInput(errorMessage);

		return numbers;
	}
	
	/**
	 * Asks the user for a number, bigger than 1.
	 * @return int
	 */
	static int askForANumber() {
		String errorMessage = "Bitte geben Sie eine natürliche Zahl größer 1 ein: ";
		System.out.println("Bitte geben Sie einen Grenzwert ein: ");
		
		int input = 0;
		boolean isValidInput = false;
		while(!isValidInput) {
			try {
				input = Integer.parseInt(reader.readLine());
				if(input >= 2) {
					isValidInput = true;
				}
				else {
					System.err.println(errorMessage);
				}
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return input;
	}
	
	static String printUserMenu() {
		return "(1) ggT (mit Rekursion)\n"
				+ "(2) ggT (ohne Rekursion)\n"
				+ "(3) Sieb des Eratosthenes\n"
				+ "(4) Programm beenden";
	}

	public static void main(String[] args) {

		System.out.println("Was möchten Sie berechnen?");
		System.out.println(printUserMenu());
		System.out.println("Bitte geben Sie für Ihre Auswahl die entsprechende Nummer ein: ");

		boolean isValidInput = false;
		int input = 4;
		String errorMessage = "Bitte geben Sie eine 1, 2, 3 oder 4 ein: ";
		while(!isValidInput) {
			try {
				input = Integer.parseInt(reader.readLine());
				if(input >= 1 && input <= 4) {
					isValidInput = true;
				}
				else {
					System.out.println(errorMessage);
				}
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		
		if(isValidInput) {
			switch(input) {
			case 1:
				int[] numbers1 = askForTwoNumbers();
				System.out.printf("Der größte gemeinsame Teiler von %d und %d ist %d.", 
						numbers1[0], numbers1[1], Algorithm.ggtWithRecursion(numbers1[0], numbers1[1]));
				break;
			case 2:
				int[] numbers2 = askForTwoNumbers();
				System.out.printf("Der größte gemeinsame Teiler von %d und %d ist %d.", 
						numbers2[0], numbers2[1], Algorithm.ggtWithoutRecursion(numbers2[0], numbers2[1]));
				break;
			case 3:
				int number = askForANumber();
				System.out.printf("Dies sind die Primzahlen bis %d:%n%s", 
						number, printPrims(Algorithm.sieveOfEratosthenes(number)));
				break;
			case 4:
				return;
			}
		}

	}
}
