import java.util.Scanner;

public class Boat_Racing {
	
	Scanner input = new Scanner(System.in);
	
	private Player player1 = new Player();
	private Player player2 = new Player();
	private River river = new River();
	private static int round = 0;
	private static int turn = 1;
	private Dice dice = new Dice();
	private Leaderboard leaderboard = new Leaderboard();
	
	public River getRiver() {
		return river;
	}

	public void setRiver(River river) {
		this.river = river;
	}

	public static int getRound() {
		return round;
	}

	public static void setRound(int round) {
		Boat_Racing.round = round;
	}

	public static int getTurn() {
		return turn;
	}

	public static void setTurn(int turn) {
		Boat_Racing.turn = turn;
	}
	
	//overall game flow for 2 player
	public void gameStart() {
		leaderboard.displayLeaderboard();
		welcomeMessage(player1, player2);
		river.riverImage();
		while (player2.positionChecker() == false) {
			setRound(getRound()+1);
			System.out.printf("Round: %d\n", getRound());
			System.out.printf("%s please roll the dice. \n", player1.getName());
			System.out.println("Insert any key to roll dice and 0 to quite the game.");
			String respond1 = input.next();
			if (respond1.equals("0")) {
				break;
			}
			else {
				moveMessage(player1, player2);
			}
			if (player1.positionChecker() == true) {
				player1.setScore(round);
				leaderboard.addLeaderboard(player1);
				break;
			}
			else {
				System.out.printf("%s please roll the dice. \n", player2.getName());
				System.out.println("Insert any key to roll dice and 0 to quite the game.");
				String respond2 = input.next();
				if (respond2.equals("0")) {
					break;
				}
				else {
					moveMessage(player2, player1);
				}
				if (player2.positionChecker() == true) {
					player2.setScore(round);
					leaderboard.addLeaderboard(player2);
					break;
				}
			}
		}
	}
	
	//introduction & prompt players to insert their names
	public void welcomeMessage(Player player1, Player player2) {
		System.out.println("Welcome to Boat Racing Game !!!");
		System.out.println("Please insert your name (short name with 1 word).");
		System.out.println("Player 1:");
		String p1_name= input.next();
		player1.setName(p1_name);
		System.out.println("Player 2:");
		String p2_name = input.next();
		player2.setName(p2_name);	
	}
	
	//game flow for a round
	public void moveMessage(Player player, Player anotherPlayer) {
		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("Dice is rolling......");
		System.out.println("------------------------------------------------------------------------------------------------------");
		dice.setDice(dice.rollDice());
		System.out.println(dice);
		dice.bonusDice();
		if (player.getCurrentPosition() != anotherPlayer.getCurrentPosition()) {
			river.newTrackTypeGenerator(player);
		}
		player.setCurrentPosition(player.currentPositionUpdater(dice.getDice()));
		System.out.println(player.currentPositionToString());
		player.positionChecker();
		river.riverImage(player, anotherPlayer);
		do {
			player.trackType_detector(river, player);
			System.out.println(player.currentPositionToString());
			player.positionChecker();
			river.riverImage(player, anotherPlayer);
		}while ((river.getRiver().get(player.getCurrentPosition()-1).getSymbol() == '#')
				|| (river.getRiver().get(player.getCurrentPosition()-1).getSymbol() == 'C'));	
		setTurn(getTurn()+1);
	}
	
	
}
