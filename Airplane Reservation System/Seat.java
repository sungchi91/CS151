/**
 * Class contains data structure of each seat in the flight
 * @author Sung Chi
 */
public class Seat {
	private String classType;
	private String seatNumber;
	private String seatPosition;
	private boolean isAvailable;
	private Passenger passenger; 
	 
   /**
    * Full constructor
    * @param classType class of seat expected (first or economy)
    * @param seatNumber seat name 
    * @param seatPosition position of seat ([W]indow, [C]enter, [A]isle)
    * @param isAvailable availability of seat true if available
    * @param passenger passenger information
    */
	public Seat(String classType, String seatNumber, String seatPosition, boolean isAvailable, Passenger passenger) {
		this.classType = classType;
		this.seatNumber = seatNumber;
		this.seatPosition = seatPosition;
		this.isAvailable = isAvailable;
		this.passenger = passenger;
	 	}   
	
	//accessors
   /**
    * Get the seat number
    * @return String seat number
    */
	public String getSeatNumber(){
		return this.seatNumber;
	}
	
   /**
    * Get the seat position
    * @return String seat position (W,C or A)
    */
	public String getSeatPosition(){
		return this.seatPosition;
	}
	
	
   /**
    * Get the passenger information
    * @return Passenger passenger information
    */
	public Passenger getPassenger(){
		return this.passenger;
	}
	
   /**
    * Get the availability information of the seat
    * @return boolean true if available
    */
	
	public boolean getAvailability() {
		return this.isAvailable;
	}
	
	//mutators
   /**
    * set passenger Information
    * @param passenger passenger information who is being added
    */
	public void setPassenger(Passenger passenger){
		this.passenger = passenger;
	}
   /**
    * set availability of seats false
    */
	public void reserveSeat(){
		this.isAvailable = false;
	}
   /**
    * set availability of seats true
    */
	public void CancelSeat(){
		this.isAvailable = true;
	}
}
