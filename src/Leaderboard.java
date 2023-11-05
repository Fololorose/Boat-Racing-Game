import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;


public class Leaderboard {
	
	private ArrayList<Player> playerRecord = new ArrayList<Player>();
	
	public Leaderboard() {
		try {
			File myObj = new File("TopScore.txt");
			if(myObj.createNewFile()) {
				System.out.println("File created: "+myObj.getName());
			}
		}catch(IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
	}

	public ArrayList<Player> getPlayerRecord() {
		return playerRecord;
	}

	public void setPlayerRecord(ArrayList<Player> playerRecord) {
		this.playerRecord = playerRecord;
	}
	
	@SuppressWarnings("unchecked")
	//display only the top 5 players on leaderboard
	public void displayLeaderboard(){
		
		try{
		    FileInputStream readData = new FileInputStream("TopScore.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);

		    playerRecord = (ArrayList<Player>) readStream.readObject();
		    readStream.close();
		    System.out.println(" Leaderboard ");
		    int i = 1;
		    for (Player player : playerRecord) {
		    	if (playerRecord.indexOf(player) < 5) {
		    		System.out.printf("| %d | %s %d\n", i, player.getName(), player.getScore());
		    	    i++;
		    	}

		    }
		}catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	//add the winner into the leaderboard and sort it
	public void addLeaderboard(Player player) {
		
		try{
			playerRecord.add(player);
			Collections.sort(playerRecord);
			
		    FileOutputStream writeData = new FileOutputStream("TopScore.txt");
		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

		    writeStream.writeObject(playerRecord);
		    writeStream.flush();
		    writeStream.close();

		}catch (IOException e) {
			System.out.println("An error occured.");
		    e.printStackTrace();
		}
	}
}
