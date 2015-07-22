import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class responsible to processing request from Connection,
 * and work with Flight to handle certain responsibilities
 * such as manifest and available seats
 * @author Sung Chi
 */
public class SeatManager {
	 private File file;
    private BufferedWriter fileOut;
    private BufferedReader fileIn; 
    private List<String> firstManifestChart;
    private List<String> economyManifestChart;
    private static Flight flight;
    
    //
    /**
     * constructor with ability to access text file or create new file
     * @param fileName - the filename
     * @throws FileNotFoundException program will make one 
     */
	 public SeatManager(String fileName) throws FileNotFoundException {
       this.file = new File(fileName + ".txt");
       this.firstManifestChart = new ArrayList<String>();
       this.economyManifestChart = new ArrayList<String>();
       this.flight = new Flight();
       try {
      	 this.fileIn = new BufferedReader(new FileReader(file));      
      	 readFile();
       }catch (IOException ex) {
      	 try {
				this.file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}         
       }      
   }
	 //Accessor
    /**
     * Get the Flight
     * @return Flight flight object the SeatManager is referring to
     */
	public static Flight getFlight(){
		return flight;
	}
	
    /**
     * Helper method of constructor
     * fill the Flight with the data contained in the file
     * @throws  IOException connection failed, possible cause is FileNotFoundException
     */
	public void readFile() throws IOException{
		fileIn.readLine();
		while(fileIn.ready()){
			Passenger passenger = new Passenger();
			String line =  fileIn.readLine();
			List<String> lineArr = parser(line);
			String seatNumber =lineArr.get(0);
			if(lineArr.get(1).equals("G")){
				passenger.setIsGroup();
				passenger.setGroupName(lineArr.get(2));
				passenger.setName(lineArr.get(3));
				makeReservation(seatNumber,passenger);
			}
			else{
				passenger.setName(lineArr.get(2));
				makeReservation(seatNumber,passenger);
			}			
		}	
	}
   /** Helper of readFile method
    * parses strings divided by comma and space in to a list
    * @param line- String that contains data divided my commma and a space
    * @return arr - array list that contains names
    */
	private List<String> parser(String line) {
		List<String> arr = Arrays.asList(line.split(", "));
		return arr; 
	}
	
   /**
    * Add passenger's seat to a manifest chart 
    * search for a seat with seat number and set the passenger information 
    * @param seatNumber seatNumber that the passenger is making reservation
    * @param passenger passenger information 
    */
	public void makeReservation(String seatNumber, Passenger passenger){
		Seat seat = flight.searchSeat(seatNumber);
		seat.setPassenger(passenger);
		seat.reserveSeat();
		
	   writeManifest(seatNumber,passenger);
	}
	
   /**
    * Cancel individual passenger reservation
    * @param name name of the passenger
    */
	public void cancelIndividualReservation(String name){
		String seatNumber=flight.findSeatNumberbyName(name);
		if (seatNumber.equals("DNE"))
			System.out.println("name does not exist");
		else removeManifest(seatNumber);
	}
	
   /**
    * Cancel group reservation
    * @param groupName name of group
    */
	public void cancelGroupReservation(String groupName){
		List<String> seatNumbers=flight.findSeatNumbersbyGroupName(groupName);
		if (seatNumbers.size()==0)
			System.out.println("name does not exist");
		else
		for(int i=0; i< seatNumbers.size(); i++){
			removeManifest(seatNumbers.get(i));
		}
	}
	
   /**
    * add newly added passenger reservation into the manifest chart
    * @param seatNumber seatNumber of the seat that is being reserved    
    * @param passenger passenger information
    */
	public void writeManifest(String seatNumber, Passenger passenger){
		String type = classType(seatNumber);
		String line = seatNumber+": "+passenger.getName();
		flight.decreaseSeatAvailability(type);
		if(type =="economy"){
		this.economyManifestChart.add(line);}
		if(type =="first"){
		this.firstManifestChart.add(line);}
	}
   /**
    * remove newly canceled passenger reservation from the manifest chart
    * @param seatNumber seatNumber of the seat that is being removed  
    */
	public void removeManifest(String seatNumber){
		String type = classType(seatNumber);
		flight.increaseSeatAvailability(type);
		if(type =="economy"){
			for(int i=0; i<economyManifestChart.size(); i++){
				if((economyManifestChart.get(i).substring(0,economyManifestChart.get(i).indexOf(":"))).equals(seatNumber)){
					economyManifestChart.remove(i);
					break;
				}
			}
		}
		if(type =="first"){
			for(int i=0; i<firstManifestChart.size(); i++){
				if((firstManifestChart.get(i).substring(0,firstManifestChart.get(i).indexOf(":"))).equals(seatNumber)){
					firstManifestChart.remove(i);
					break;
				}
			}
		}
	}
	
   /** Helper of writeManifest and removeManifest method
    *  determine Class type from seatNumber
    * @param seatNumber seat number that is being categorized
    * @return String class type
    */
	public String classType (String seatNumber){
		String classType= "economy";
		if(seatNumber.equals("1A")|seatNumber.equals("1B")|seatNumber.equals("1C")|seatNumber.equals("1D")|
				seatNumber.equals("2A")|seatNumber.equals("2B")|seatNumber.equals("2C")|seatNumber.equals("2D"))
		{
			classType= "first";
		}
	return classType;	
	}
	
   /**
    * Display the manifest list
    * @param type Class type
    */
	public void printManifestChart(String type) {
		System.out.println("\nManifest Chart:\n");
		switch(type.toLowerCase()){
		case "first":
			System.out.println("First");
			for(int i=0; i<firstManifestChart.size(); i++){
			System.out.println(firstManifestChart.get(i));}
			break;
		case "economy":
			System.out.println("Economy");
			for(int i=0; i<economyManifestChart.size(); i++){
			System.out.println(economyManifestChart.get(i));}
			break;
		}	
	}
	
   /**
    * Save newly performed request before quitting
    * @throws IOException connection failed, possible cause is FileNotFoundException
    */
	public void updateFile() throws IOException
   {
       fileOut = new BufferedWriter(new FileWriter(file));   
       fileOut.write("First 1-2, Left: A-B, Right: C-D; Economy 10-29, Left: A-C, Right: D-F");
       fileOut.newLine();
       for(int i=0; i<firstManifestChart.size();i++){
	       String line = firstManifestChart.get(i);
	       String seatNumber = line.substring(0,(line.indexOf(" ")-1));
	    	 Passenger passenger = new Passenger();
	       passenger = flight.searchSeat(seatNumber).getPassenger();
	       String name = passenger.getName(); 
	       String group;
	       String outLine;
	       if(passenger.getIsGroup()){
	      	 group= "G"; 
	          String groupName = passenger.getGroupName(); 
	          outLine=seatNumber+", "+group+", "+ groupName+", "+ name;
	       }
	       else {group= "I";
	       	outLine=seatNumber+", "+group+", "+ name;
	       }    
	       fileOut.write(outLine);
	       fileOut.newLine();
       }
       
       for(int i=0; i<economyManifestChart.size();i++){
	       String line = economyManifestChart.get(i);
	       String seatNumber = line.substring(0,(line.indexOf(" ")-1));
	    	 Passenger passenger = new Passenger();
	       passenger = flight.searchSeat(seatNumber).getPassenger();
	       String name = passenger.getName(); 
	       String group;
	       String outLine;
	       if(passenger.getIsGroup()){
	      	 group= "G"; 
	          String groupName = passenger.getGroupName(); 
	          outLine=seatNumber+", "+group+", "+ groupName+", "+ name;
	       }
	       else {group= "I";
	       	outLine=seatNumber+", "+group+", "+ name;
	       }    
	       fileOut.write(outLine);
	       fileOut.newLine();
       }
       fileOut.close();    
   }	 
}
