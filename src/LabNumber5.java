import java.util.Scanner;
import java.util.Random;

public class LabNumber5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int diceSide = 0;
		char reroll = 'Y';
		// validation loop and prompts
		do {
			System.out.println("Enter the number of sides to the dice: ");
			while (!scan.hasNextInt()) {
				System.out.println("Please enter a whole number: ");
				scan.next();
			}
			diceSide = scan.nextInt();
		} while (diceSide <= 0);
		//loop to continue to re-roll while calling the method
		while (reroll == 'y' || reroll == 'Y') {

			DiceRollerApp(diceSide);

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
	public static int DiceRollerApp(int sides) {
		Random random = new Random();
		int Number1 = (random.nextInt(sides) + 1);
		int Number2 = (random.nextInt(sides) + 1);
		int diceCheck = Number1 + Number2;
		System.out.println(Integer.toString(Number1) + " " + Integer.toString(Number2));
		// switch statement for special cases
		switch (diceCheck) {
        case 2:  System.out.println("Sssssssssnake Eyes!");
                break;
        case 7:  System.out.println("Oh Craps!");
               	break;
        case 12:  System.out.println("BOX CARS!");
        		break;
        default: break;
		}
		return sides;
	}
}
