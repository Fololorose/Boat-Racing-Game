import java.util.Scanner;

public class Dice {
	
	Scanner input = new Scanner(System.in);
	
	private int dice;
	

	public Dice(){
		this.dice = 0;
	}
	
	public Dice(int dice) {
		this.dice = dice;
	}

	public int getDice() {
		return dice;
	}

	public void setDice(int dice) {
		this.dice = dice;
	}
	
	public String toString() {
		return String.format("Step(s) Generated: %d", getDice());
	}
	
	//randomly roll the dice from 1 to 6
	public int rollDice() {
		return (int)(Math.floor(Math.random() * 6) + 1);
	}
	
	//extra bonus for player who roll a 6 
	public void bonusDice() {
		if (getDice() == 6) {
			System.out.println("Congratulations! You roll a 6 !!! Now, you get a bonus roll.\nInsert any key to roll again or insert 0 to give up the chance.");
			String respond = input.next();
			if (respond.equals("0")) {
				System.out.println("Nothing happens...");
			}
			else {
				int extraStep = rollDice();
				System.out.printf("Extra Step(s) Generated: %d\n", extraStep);
				System.out.printf("Total Step(s) Generated: %d\n", getDice()+extraStep);
				setDice(getDice()+extraStep);
			}
		}
	}
}
