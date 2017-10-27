import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LabNumber5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int diceSide = 0;
		int diceAmount = 0;
		char reroll = 'Y';

		// validation loop and prompts for number of dice and the number
		// of sides the dice have
		do {
			System.out.println("Enter the number of dice: ");
			while (!scan.hasNextInt()) {
				System.out.println("Please enter a whole number: ");
				scan.next();
			}
			diceAmount = scan.nextInt();
		} while (diceAmount <= 0);

		do {
			System.out.println("Enter the number of sides to the dice: ");
			while (!scan.hasNextInt()) {
				System.out.println("Please enter a whole number: ");
				scan.next();
			}
			diceSide = scan.nextInt();
		} while (diceSide <= 0);

		// loop to continue to re-roll while calling the method
		while (reroll == 'y' || reroll == 'Y') {

			DiceRollerApp(diceSide, diceAmount);

			System.out.println("Would you like to roll again?(Y/N)");
			while (!scan.hasNext("[yYnN]")) {
				System.out.println("Enter y to reroll or n to stop");
				scan.next();
			}
			reroll = scan.next().charAt(0);
		}
		System.out.println("GoodBye!");
		scan.close();
	}

	// method for random dice with a variable for sides
	public static int DiceRollerApp(int sides, int dice) {
		Random random = new Random();
		int rolledNumber = 0;
		int diceCheck = 0;
		List<Integer> diceStore = new ArrayList<Integer>();

		// System.out.println(number1 + " " + number2);

		for (int i = 1; i <= dice; i++) {
			rolledNumber = (random.nextInt(sides) + 1);
			System.out.print(rolledNumber + " ");
			diceStore.add(rolledNumber);
		}
		System.out.println();
		// switch statement for special cases
		if ((dice == 2) && (sides == 6)) {
			diceCheck = (diceStore.get(0) + (diceStore.get(1)));
			switch (diceCheck) {
			case 2:
				System.out.println("Sssssssssnake Eyes!");
				break;
			case 7:
				System.out.println("Oh Craps!");
				break;
			case 12:
				System.out.println("BOX CARS!");
				break;
			default:
				;
			}
		}
		return sides;

	}
}
