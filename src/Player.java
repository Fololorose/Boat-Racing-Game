import java.io.Serializable;

public class Player implements Serializable, Comparable<Player> {
	
	private static final long serialVersionUID = 5913935791098290815L;
	private String name;
	private int score;
	private int currentPosition;
	
	public Player() {
		this.name = "player";
		this.score = 0;
		this.currentPosition = 0;
	}
	
	public Player(String name, int score, int currentPosition) {
		this.name = name;
		this.score = score;
		this.currentPosition = currentPosition;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int currentPosition) {
		if (currentPosition < 1) {
			this.currentPosition = 1;
		}
		else {
			this.currentPosition = currentPosition;
		}
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", score=" + score + "]";
	}

	public String currentPositionToString() {
		return String.format("Current Position: %d", getCurrentPosition());
	}
	
	public int compareTo(Player p) {
		if (score == p.score) {
			return 0;
		}
		else if (score > p.score) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public int currentPositionUpdater(int step) {
		return currentPosition += step;
	}
	
	//push the players back if they go beyond the end track
	//check whether the player has exactly reach the end track 
	public boolean positionChecker() {
		if (getCurrentPosition() > 100) {
			System.out.println("Oops, you steps over the river boundary !!! You are now being pushed back.");
			int extraStep = 100 - getCurrentPosition();
			setCurrentPosition(currentPositionUpdater(extraStep*2));
			return false;
		}
		else if (getCurrentPosition() == 100) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//compare the current position to the track type and give feedback
	public void trackType_detector(River river, Player player) {
		if ((river.getRiver().get(player.getCurrentPosition()-1).getSymbol() == '#')) {
			System.out.println("Oops. You step on a trap !!!");
			river.newTrackTypeGenerator(player);
			if (river.getRiver().get(player.getCurrentPosition()-1).getStrength()==1) {
				System.out.println("It's okay, it's just a low level trap !!!");
				player.setCurrentPosition(player.currentPositionUpdater((-river.getRiver().get(player.getCurrentPosition()-1).getStrength())));
			}
			else if (river.getRiver().get(player.getCurrentPosition()-1).getStrength()==2) {
				System.out.println("Be careful, it's a medium level trap !!!");
				player.setCurrentPosition(player.currentPositionUpdater((-river.getRiver().get(player.getCurrentPosition()-1).getStrength())));
			}
			else {
				System.out.println("Oh no, it's a high level trap !!!");
				player.setCurrentPosition(player.currentPositionUpdater((-river.getRiver().get(player.getCurrentPosition()-1).getStrength())));
			}
		}
		else if ((river.getRiver().get(player.getCurrentPosition()-1).getSymbol() == 'C')) {
			System.out.println("Hooray. You step on a current !!!");
			river.newTrackTypeGenerator(player);
			if (river.getRiver().get(player.getCurrentPosition()-1).getStrength()==1) {
				System.out.println("Waooo, it's a weak current !!!");
				player.setCurrentPosition(player.currentPositionUpdater((river.getRiver().get(player.getCurrentPosition()-1).getStrength())));
			}
			else if (river.getRiver().get(player.getCurrentPosition()-1).getStrength()==2) {
				System.out.println("Woooo, it's a normal current !!!");
				player.setCurrentPosition(player.currentPositionUpdater((river.getRiver().get(player.getCurrentPosition()-1).getStrength())));
			}
			else {
				System.out.println("Yeayy, it's a strong current !!!");
				player.setCurrentPosition(player.currentPositionUpdater((river.getRiver().get(player.getCurrentPosition()-1).getStrength())));
			}
		}
		else {
			System.out.println("Everything is under control.");
		}
	}
}
