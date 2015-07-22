import java.util.LinkedList;
import java.util.List;

/**
 * Class holds the seat structure and informations
 * Work with SeatManager and Seat class
 * 
 * @author Sung Chi
 */
public class Flight {
	private Seat[][] firstClassSeats;
	private Seat[][] economyClassSeats;
	private int availableFirstClassSeat;
	private int availableEconomyClassSeat;
	
   /**
   * Constructor that initialize the seat structure of a plane
   */
	public Flight(){
		this.availableFirstClassSeat=8;
		this.availableEconomyClassSeat=120;
		firstClassSeats = new Seat[][]
		{
			{new Seat("First","1A","W",true,null),new Seat("First","1B","A",true,null),new Seat("First","1C","A",true,null),new Seat("First","1D","W",true,null)},
			{new Seat("First","2A","W",true,null),new Seat("First","2B","A",true,null),new Seat("First","2C","A",true,null),new Seat("First","2D","W",true,null)}				
		};

		economyClassSeats = new Seat[][]
				{
					{new Seat("Economy","10A","W",true,null),new Seat("Economy","10B","C",true,null),new Seat("Economy","10C","A",true,null),new Seat("Economy","10D","A",true,null),new Seat("Economy","10E","C",true,null),new Seat("Economy","10F","W",true,null)},
					{new Seat("Economy","11A","W",true,null),new Seat("Economy","11B","C",true,null),new Seat("Economy","11C","A",true,null),new Seat("Economy","11D","A",true,null),new Seat("Economy","11E","C",true,null),new Seat("Economy","11F","W",true,null)},	
					{new Seat("Economy","12A","W",true,null),new Seat("Economy","12B","C",true,null),new Seat("Economy","12C","A",true,null),new Seat("Economy","12D","A",true,null),new Seat("Economy","12E","C",true,null),new Seat("Economy","12F","W",true,null)},	
					{new Seat("Economy","13A","W",true,null),new Seat("Economy","13B","C",true,null),new Seat("Economy","13C","A",true,null),new Seat("Economy","13D","A",true,null),new Seat("Economy","13E","C",true,null),new Seat("Economy","13F","W",true,null)},	
					{new Seat("Economy","14A","W",true,null),new Seat("Economy","14B","C",true,null),new Seat("Economy","14C","A",true,null),new Seat("Economy","14D","A",true,null),new Seat("Economy","14E","C",true,null),new Seat("Economy","14F","W",true,null)},	
					{new Seat("Economy","15A","W",true,null),new Seat("Economy","15B","C",true,null),new Seat("Economy","15C","A",true,null),new Seat("Economy","15D","A",true,null),new Seat("Economy","15E","C",true,null),new Seat("Economy","15F","W",true,null)},	
					{new Seat("Economy","16A","W",true,null),new Seat("Economy","16B","C",true,null),new Seat("Economy","16C","A",true,null),new Seat("Economy","16D","A",true,null),new Seat("Economy","16E","C",true,null),new Seat("Economy","16F","W",true,null)},	
					{new Seat("Economy","17A","W",true,null),new Seat("Economy","17B","C",true,null),new Seat("Economy","17C","A",true,null),new Seat("Economy","17D","A",true,null),new Seat("Economy","17E","C",true,null),new Seat("Economy","17F","W",true,null)},	
					{new Seat("Economy","18A","W",true,null),new Seat("Economy","18B","C",true,null),new Seat("Economy","18C","A",true,null),new Seat("Economy","18D","A",true,null),new Seat("Economy","18E","C",true,null),new Seat("Economy","18F","W",true,null)},	
					{new Seat("Economy","19A","W",true,null),new Seat("Economy","19B","C",true,null),new Seat("Economy","19C","A",true,null),new Seat("Economy","19D","A",true,null),new Seat("Economy","19E","C",true,null),new Seat("Economy","19F","W",true,null)},	
					{new Seat("Economy","20A","W",true,null),new Seat("Economy","20B","C",true,null),new Seat("Economy","20C","A",true,null),new Seat("Economy","20D","A",true,null),new Seat("Economy","20E","C",true,null),new Seat("Economy","20F","W",true,null)},	
					{new Seat("Economy","21A","W",true,null),new Seat("Economy","21B","C",true,null),new Seat("Economy","21C","A",true,null),new Seat("Economy","21D","A",true,null),new Seat("Economy","21E","C",true,null),new Seat("Economy","21F","W",true,null)},	
					{new Seat("Economy","22A","W",true,null),new Seat("Economy","22B","C",true,null),new Seat("Economy","22C","A",true,null),new Seat("Economy","22D","A",true,null),new Seat("Economy","22E","C",true,null),new Seat("Economy","22F","W",true,null)},	
					{new Seat("Economy","23A","W",true,null),new Seat("Economy","23B","C",true,null),new Seat("Economy","23C","A",true,null),new Seat("Economy","23D","A",true,null),new Seat("Economy","23E","C",true,null),new Seat("Economy","23F","W",true,null)},	
					{new Seat("Economy","24A","W",true,null),new Seat("Economy","24B","C",true,null),new Seat("Economy","24C","A",true,null),new Seat("Economy","24D","A",true,null),new Seat("Economy","24E","C",true,null),new Seat("Economy","24F","W",true,null)},	
					{new Seat("Economy","25A","W",true,null),new Seat("Economy","25B","C",true,null),new Seat("Economy","25C","A",true,null),new Seat("Economy","25D","A",true,null),new Seat("Economy","25E","C",true,null),new Seat("Economy","25F","W",true,null)},	
					{new Seat("Economy","26A","W",true,null),new Seat("Economy","26B","C",true,null),new Seat("Economy","26C","A",true,null),new Seat("Economy","26D","A",true,null),new Seat("Economy","26E","C",true,null),new Seat("Economy","26F","W",true,null)},	
					{new Seat("Economy","27A","W",true,null),new Seat("Economy","27B","C",true,null),new Seat("Economy","27C","A",true,null),new Seat("Economy","27D","A",true,null),new Seat("Economy","27E","C",true,null),new Seat("Economy","27F","W",true,null)},	
					{new Seat("Economy","28A","W",true,null),new Seat("Economy","28B","C",true,null),new Seat("Economy","28C","A",true,null),new Seat("Economy","28D","A",true,null),new Seat("Economy","28E","C",true,null),new Seat("Economy","28F","W",true,null)},	
					{new Seat("Economy","29A","W",true,null),new Seat("Economy","29B","C",true,null),new Seat("Economy","29C","A",true,null),new Seat("Economy","29D","A",true,null),new Seat("Economy","29E","C",true,null),new Seat("Economy","29F","W",true,null)},	
				};
	}
	
	//mutators
	
   /** 
    * decrease the seatAvailability by 1
    * @param type class type
    */
	public void decreaseSeatAvailability(String type){
		switch(type){
		case "first":
			availableFirstClassSeat--;
			break;
		case "economy":
			availableEconomyClassSeat--;
			break;	
		}
	}
	
   /** 
    * increase the seatAvailability by 1
    * @param type class type
    */
	public void increaseSeatAvailability(String type){
		switch(type){
		case "first":
			availableFirstClassSeat++;
			break;
		case "economy":
			availableEconomyClassSeat++;
			break;	
		}
	}
	
   /** 
    * get isFull
    * @param type class type
    * @return boolean true is the plain is full
    */
	public boolean isFull(String type){
		switch(type){
		case "first":
			if (availableFirstClassSeat == 0){
				System.out.println("class is full");
				return true;
			}
			break;
		case "economy":
			if (availableEconomyClassSeat == 0){
				System.out.println("class is full");
				return true;
			}
			break;	
		}
		return false;
	}
	
   /**
    * Search for a seat with seat number
    * @param seatNumber seat number of the seat 
    * @return Seat seat object with the seat number
    */
	public Seat searchSeat(String seatNumber){
		for (int i = 0; i< firstClassSeats.length; i++){
			for(int j = 0; j<firstClassSeats[0].length; j++){
				if(firstClassSeats[i][j].getSeatNumber().equals(seatNumber)){
					return firstClassSeats[i][j];
				}
			}
		}
			for (int k = 0; k< economyClassSeats.length; k++){
				for(int l = 0; l<economyClassSeats[0].length; l++){
					if(economyClassSeats[k][l].getSeatNumber().equals(seatNumber)){
						return economyClassSeats[k][l];
					}
				}	
			}
	return null;
	}
	
   /**
    * Display availability chart
    * @param type class type
    */
	public void printAvailabilityChart(String type){
		System.out.println("\nAvailability Chart:\n");
		switch(type.toLowerCase()){
		case "first":
			System.out.println("First");
			for (int i = 0; i< firstClassSeats.length; i++){
				System.out.print(firstClassSeats[i][0].getSeatNumber().substring(0,1)+": ");
				int counter=0;
				for(int j = 0; j<firstClassSeats[0].length; j++){
					if(firstClassSeats[i][j].getAvailability()==true){
						if(counter==0){System.out.print(firstClassSeats[i][j].getSeatNumber().substring(1));
							counter++;
						}
						else System.out.print(","+ firstClassSeats[i][j].getSeatNumber().substring(1));
					}
				}
				System.out.println();
			}			
			break;
		case "economy":
			System.out.println("Economy");
			for (int i = 0; i< economyClassSeats.length; i++){
				System.out.print(economyClassSeats[i][0].getSeatNumber().substring(0,(economyClassSeats[i][0].getSeatNumber().length())-1)+": ");
				int counter=0;
				for(int j = 0; j<economyClassSeats[0].length; j++){
					if(economyClassSeats[i][j].getAvailability()==true){
						if(counter==0){System.out.print(economyClassSeats[i][j].getSeatNumber().substring(economyClassSeats[i][j].getSeatNumber().length()-1,economyClassSeats[i][j].getSeatNumber().length()));						
											counter++;}
						else System.out.print(","+economyClassSeats[i][j].getSeatNumber().substring(economyClassSeats[i][j].getSeatNumber().length()-1,economyClassSeats[i][j].getSeatNumber().length()));			
					}
				}
				System.out.println();
			}
			break;
		}
	}
	
   /**
    * search for a seat with preferred service class and seat preference
    * @param serviceClass class type
    * @param seatPreference preferred seat position
    * @return String seatnumber of the found seat
    */
	public String findPreferedPosition(String serviceClass, String seatPreference) {
		String seatNumber= " ";
		switch(serviceClass.toLowerCase()){
		case "first":
			for (int i = 0; i< firstClassSeats.length; i++){
				for(int j = 0; j<firstClassSeats[0].length; j++){
					if((firstClassSeats[i][j].getAvailability()==true)&&(firstClassSeats[i][j].getSeatPosition().equalsIgnoreCase(seatPreference)==true)){
						 seatNumber = firstClassSeats[i][j].getSeatNumber();
						 return seatNumber;
					}
				}
			}			
			break;
		case "economy":
			for (int i = 0; i< economyClassSeats.length; i++){
				for(int j = 0; j<economyClassSeats[0].length; j++){
					if(economyClassSeats[i][j].getAvailability()==true&&(economyClassSeats[i][j].getSeatPosition().equalsIgnoreCase(seatPreference)==true)){
						seatNumber = economyClassSeats[i][j].getSeatNumber();
						return seatNumber;
					}
				}
			}
		break;
		}
		System.out.println("No "+seatPreference +" seat available.");		
		return "unAvailable";
	}
	
   /**
    * search for seats with preferred service class and that are as close together as possible
    * @param serviceClass class type
    * @param groupSize number of seats that has to be found
    * @return List seat numbers of the found seats
    */
	public List<String> findMaxGroupSeats(String serviceClass, int groupSize) {
		List<String> seatNumbers = new LinkedList<String>();
		switch(serviceClass.toLowerCase()){
		case "first":
			if (availableFirstClassSeat< groupSize)
				return null;
			while(groupSize>=0){
			int[] arr;
			arr = findMaxAvailableSeatRow(firstClassSeats);
			int index= arr[0];
			int seats = arr[1];
			for(int i=0; i<firstClassSeats[index].length; i++){
				if (firstClassSeats[index][i].getAvailability()==true&& seatNumbers.size()!=groupSize){
					seatNumbers.add(firstClassSeats[index][i].getSeatNumber());
					firstClassSeats[index][i].reserveSeat();
				}
			}
			groupSize= groupSize-seats;
			}
			break;
		case "economy":
			if (availableEconomyClassSeat< groupSize) return null;
			while(groupSize>=0){
				int[] arr;
				arr = findMaxAvailableSeatRow(economyClassSeats);
				int index= arr[0];
				int seats = arr[1];
				for(int i=0; i<economyClassSeats[index].length; i++){
					if (economyClassSeats[index][i].getAvailability()==true&& seatNumbers.size()!=groupSize){
						seatNumbers.add(economyClassSeats[index][i].getSeatNumber());
						economyClassSeats[index][i].reserveSeat();
					}
				}
				groupSize= groupSize-seats;
				}
			break;
		}
		return seatNumbers;
	}
   
   /** Helper of findMaxGroupSeats method
    * Find the row with maximum number of available seats
    * @param seats a class of seats
    * @return int array contains index of the row found and number of available seats
    **/
	public int[] findMaxAvailableSeatRow(Seat[][] seats) {
		int[] arr= new int[2];
		int n=0;
		int index=0;		
		for(int i = 0; i<seats.length; i++){
			if(n<numOfAvailableSeatsInRow(seats[i])){
				n=numOfAvailableSeatsInRow(seats[i]);
				index=i;
			}
		}
		arr[0]= index;
		arr[1]= n;	
		return arr;
	}
	
   /** Helper of findMaxAvailableSeatRow method
    * Find the number of available seats in a row
    * @param row array of a row
    * @return int number of available seats
    **/
	public int numOfAvailableSeatsInRow(Seat[] row){
		int availableSeats=0;

		for(int j = 0; j<row.length; j++){
			if(row[j].getAvailability()==true){
				availableSeats++;
			}
		}
		return availableSeats;
	}
	
   /**
    * Search for a seat contains a passenger with this name
    * @param name name of the passenger
    * @return String seat number
    */
	public String findSeatNumberbyName(String name){
		String seatNumber= "DNE";
		System.out.print(name);
		for (int i = 0; i< firstClassSeats.length; i++){
			for(int j = 0; j<firstClassSeats[0].length; j++){
				if(firstClassSeats[i][j].getAvailability()==false){
					if(firstClassSeats[i][j].getPassenger().getName().equals(name)){
						firstClassSeats[i][j].setPassenger(null);
						firstClassSeats[i][j].CancelSeat();
						seatNumber= firstClassSeats[i][j].getSeatNumber();
					}
				}
			}
		}

			for (int k = 0; k< economyClassSeats.length; k++){
				for(int l = 0; l<economyClassSeats[0].length; l++){
					if(economyClassSeats[k][l].getAvailability()==false){
						if(economyClassSeats[k][l].getPassenger().getName().equals(name)==true){
							economyClassSeats[k][l].setPassenger(null);
							economyClassSeats[k][l].CancelSeat();
							seatNumber= economyClassSeats[k][l].getSeatNumber();
						}
					}	
				}
			}
		return seatNumber;
	}
	
   /**
    * Search for seats contain passengers with this groupname
    * @param groupName name of the group
    * @return List seat numbers
    */
	public List<String> findSeatNumbersbyGroupName(String groupName){
		List<String> seatNumbers = new LinkedList<>();
		for (int i = 0; i< firstClassSeats.length; i++){
			for(int j = 0; j<firstClassSeats[0].length; j++){
				if(firstClassSeats[i][j].getAvailability()==false){
					if(firstClassSeats[i][j].getPassenger().getGroupName().equals(groupName)==true){
						firstClassSeats[i][j].setPassenger(null);
						firstClassSeats[i][j].CancelSeat();
						seatNumbers.add(firstClassSeats[i][j].getSeatNumber());
				
					}
				}	
			}
		}

			for (int k = 0; k< economyClassSeats.length; k++){
				for(int l = 0; l<economyClassSeats[0].length; l++){
					if(economyClassSeats[k][l].getAvailability()==false){
						if(economyClassSeats[k][l].getPassenger().getGroupName().equals(groupName)==true){
							economyClassSeats[k][l].setPassenger(null);
							economyClassSeats[k][l].CancelSeat();
							seatNumbers.add(economyClassSeats[k][l].getSeatNumber());
						}
					}
				}	
			}
		return seatNumbers;
	}
	


}
