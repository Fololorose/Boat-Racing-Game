import java.util.ArrayList;

public class River {
	private ArrayList<Track> river = new ArrayList<Track>(); //ArrayList for storing the track inside the river
	
	public River() {
  		for (int i = 0; i < 100; i++) {
  			if ((i == 0) || (i == 99)) {
	  		    river.add(new Normal_Track(i));
	  		}
	  		else {
	  			int track = (int)(Math.floor(Math.random() * 5) + 1);
	  			switch (track) {
	  			 	case 1:
	  					river.add(new Trap(i));
	  				   	break;
	  			    case 5:
	  			    	river.add(new Current(i));
	  			    	break;
	 				default:
	 					river.add(new Normal_Track(i));
	  				    break;
	  	        }
	  	    }
  		}
	}

	public ArrayList<Track> getRiver() {
		return river;
	}

	public void setRiver(ArrayList<Track> river) {
		this.river = river;
	}
	
	//display the visualisation of the river
	public void riverImage() {
		for (int row = 0; row < 10; row++) {
			System.out.println(" -----------------------------------------------------------------------------------------------------");
		    for (int col = 0; col < 10; col++) {
		        if (col == 0) {
		           	System.out.print(" | " + getRiver().get(row*10+col).trackTypeToString()+" | ");
		        }
		        else {
		            System.out.print(getRiver().get(row*10+col).trackTypeToString() + " | " );
		        }
		    }
		    System.out.println();
		}
		System.out.println("------------------------------------------------------------------------------------------------------");	
    }
	
	//visualisation of river including the positioning of players
	public void riverImage(Player player, Player anotherPlayer) {
		for (int row = 0; row < 10; row++) {
			System.out.println(" -----------------------------------------------------------------------------------------------------");
		    for (int col = 0; col < 10; col++) {
		    	if ((row == (player.getCurrentPosition()-1)/10) && (col == ((player.getCurrentPosition()-1)%10))) {
		    		if (col == 0) {
		    			if (player.getCurrentPosition() == anotherPlayer.getCurrentPosition()){
		    				System.out.print(" | \\p1p2_/ | ");
		    			}
		    		    else if (Boat_Racing.getTurn()%2 == 1){
			    			String s1 = "\\_p1_/" + (getRiver().get(row*10+col).getSymbol());
			    			System.out.print(" | "+s1+" | ");
			    		}
			    		else {
			    			String s1 = "\\_p2_/" + (getRiver().get(row*10+col).getSymbol());
			    			System.out.print(" | "+s1+" | ");
			    		}
		    		}
		    		else {
		    			if (player.getCurrentPosition() == anotherPlayer.getCurrentPosition()){
		    				System.out.print("\\p1p2_/ | ");
		    			}
		    			else if (Boat_Racing.getTurn()%2 == 1) {
			    			String s1 = "\\_p1_/" + (getRiver().get(row*10+col).getSymbol());
			    			System.out.print(s1+" | ");
			    		}
			    		else {
			    			String s1 = "\\_p2_/" + (getRiver().get(row*10+col).getSymbol());
			    			System.out.print(s1+" | ");
			    		}
		    		}
		    	}
		    	else if ((row == (anotherPlayer.getCurrentPosition()-1)/10) && (col == ((anotherPlayer.getCurrentPosition()-1)%10))) {
		    		if (col == 0) {
		    		    if (Boat_Racing.getTurn()%2 == 1){
			    			String s1 = "\\_p2_/" + (getRiver().get(row*10+col).getSymbol());
			    			System.out.print(" | "+s1+" | ");
			    		}
			    		else {
			    			String s1 = "\\_p1_/" + (getRiver().get(row*10+col).getSymbol());
			    			System.out.print(" | "+s1+" | ");
			    		}
		    		}
		    		else {
		    			if (Boat_Racing.getTurn()%2 == 1) {
			    			String s1 = "\\_p2_/" + (getRiver().get(row*10+col).getSymbol());
			    			System.out.print(s1+" | ");
			    		}
			    		else {
			    			String s1 = "\\_p1_/" + (getRiver().get(row*10+col).getSymbol());
			    			System.out.print(s1+" | ");
			    		}
		    		}
		    	}
		    	else if (col == 0) {
		           	System.out.print(" | " + getRiver().get(row*10+col).trackTypeToString()+" | ");
		        }
		        else {
		            System.out.print(getRiver().get(row*10+col).trackTypeToString() + " | " );
		        }
		    }
		    System.out.println();
		}
		System.out.println("------------------------------------------------------------------------------------------------------");
	}
	
	public void newTrackTypeGenerator(Player player) {
		if (player.getCurrentPosition() > 1) {
			int track = (int)(Math.floor(Math.random() * 5) + 1);
  			switch (track) {
  				case 1:
  				   	river.set(player.getCurrentPosition()-1,new Trap(player.getCurrentPosition()-1));
  				   	break;
  			    case 5:
  			    	river.set(player.getCurrentPosition()-1,new Current(player.getCurrentPosition()-1));
  			    	break;
 				default:
 					river.set(player.getCurrentPosition()-1,new Normal_Track(player.getCurrentPosition()-1));
  				    break;
  	        }  
		}
	}
	
	
}
