
public class Track {
	private char symbol;
	private int location;
	private int strength;
	
	public Track(char symbol, int i) {
		this.symbol = symbol;
		location = ++i;
		strength = (int)(Math.floor(Math.random() * 3) + 1);
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	
	
	@Override
	public String toString() {
		return "Track [symbol=" + symbol + ", location=" + location + ", strength=" + strength + "]";
	}

	public String trackTypeToString() {
		return String.format("   %s   ", getSymbol());
	}
	

}
