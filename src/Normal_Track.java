
public class Normal_Track extends Track {
	private int strength;
	
	//normal track always has zero strength
	public Normal_Track(int i) {
		super(' ', i);
		this.strength = 0;
	}

	@Override
	public String toString() {
		return String.format("Normal track [%s]", super.toString());
	}

}
