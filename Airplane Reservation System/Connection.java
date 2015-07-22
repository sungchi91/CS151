import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Class is responsible for displaying prompt,
 * and communicate with the airplane
 * @author Sung Chi
 */
public class Connection {
	public SeatManager seatManager;
	
   /**
    * Full constructor
    * @param fileName name of file required to save data
    * @throws FileNotFoundException
    */
   public Connection(String fileName) throws FileNotFoundException
   {
       seatManager = new SeatManager(fileName);
   }
   
   /**
    * Display menu in console
    * @param scan Scanner object used to get user input
    * @return String the user selection from the menu
    */
   public String displayMenu(Scanner scan){
   	System.out.println("\n\n<    MENU    >");
   	System.out.println("Add [P]asseser");
		System.out.println("Add [G]roup");
		System.out.println("[C]ancel a reservation");
		System.out.println("Print [A]vaillability Chart");
		System.out.println("Print [M]anifest Chart");
		System.out.println("[Q]uit");
		return scan.next();
   }
   
   /**
    * Initiate service according to user input
    * @param scan Scanner object used to get user input
    * @param request userInput must be String
    * @return boolean whether the user input is valid
    * @throws  IOException connection failed, possible cause is FileNotFoundException
    */
   public boolean initiateService(String request, Scanner scan) throws IOException{
   	switch (request.toUpperCase()) {
   			case "P":
   				scan.nextLine();
   				Passenger passenger = new Passenger();
   				System.out.print("Name: ");
   				passenger.setName(scan.nextLine());
   				String serviceClass;
   				do{
			   		System.out.print("Service Class: ");
			   		serviceClass= scan.next().toLowerCase();
			   		}while((seatManager.getFlight().isFull(serviceClass))==true);
   				boolean unAvailable;
   				String seatNumber;
   				do{
   				unAvailable=false;
   				System.out.print("Seat Preference: ");
   				String seatPreference = scan.next().toUpperCase();	
   				seatNumber  = SeatManager.getFlight().findPreferedPosition(serviceClass, seatPreference);
   			   if(seatNumber.equals("unAvailable")) {unAvailable = true;} 
   				}while(unAvailable == true);
   			   
   				seatManager.makeReservation(seatNumber, passenger);
   				break;
   				
   			case "G":
   				System.out.print("Group Name: ");
   				String groupName = scan.next();
   				System.out.print("Names: ");
   				scan.nextLine(); 
   				String names= scan.nextLine();
   				List<String>nameList = parseNames(names);
   				System.out.print("Service Class: ");
   				String serviceClass2 = scan.next().toLowerCase();
   				Passenger[] groupPassenger = new Passenger[nameList.size()];
   				for ( int i=0; i<groupPassenger.length; i++) {
   					groupPassenger[i]=new Passenger();
   					}

   				for(int i=0; i<nameList.size(); i++){
   					groupPassenger[i].setGroupName(groupName);
   					groupPassenger[i].setName(nameList.get(i));
   					groupPassenger[i].setIsGroup();		 					
   				}							
   				List<String> seatNumber2 = SeatManager.getFlight().findMaxGroupSeats(serviceClass2,nameList.size());
   				if (seatNumber2==null){
   					System.out.print(serviceClass2 +" is full");
   					return false;
   					}
   				for(int j=0; j<nameList.size(); j++){
   				seatManager.makeReservation(seatNumber2.get(j), groupPassenger[j]);
   				}
   				
   				break;

   			case "C":
   				boolean checkValid = true;
   				do{
   					checkValid = true;
   				System.out.print("Cancel [I]ndividual or [G]roup? ");
   				String choice2 = scan.next().toUpperCase();
   				String name;
   				switch(choice2){
   				case "I":
   					System.out.print("Name: ");
   					scan.nextLine();
   					name = scan.nextLine();
   					seatManager.cancelIndividualReservation(name);
   					break;
   				case "G":
   					scan.nextLine(); 
   					System.out.print("Group Name: ");
   					String groupName2= scan.nextLine();
   					seatManager.cancelGroupReservation(groupName2);
   					break;
   				default:
   					System.out.println("Wrong Entry"); 
   					checkValid= false;
   					break;  				
   				}
   				}while(checkValid == false);
   				break;
   			
   			case "A":
   				checkValid= true;
   				do{
   					checkValid= true;
   				System.out.print("Service Class: ");
   				String choice3 = scan.next().toUpperCase();
   				String type;
   				switch(choice3){
   				case "FIRST":
   					type= "first";
      				seatManager.getFlight().printAvailabilityChart(type);
   					break;
   				case "ECONOMY":
   					type= "economy";
   					seatManager.getFlight().printAvailabilityChart(type);
   					break;
   				default:
   					System.out.println("Wrong Entry"); 
   					checkValid= false;
   					break;
   				}
   				}while(checkValid ==false);
   				break;
   			
   			case "M":
   				checkValid= true;
   				do{
   					checkValid= true;
   				System.out.print("Service Class: ");
   				String choice4 = scan.next().toUpperCase();
   				String type2;
   				switch(choice4){
   				case ("FIRST"):
   					type2= "first";
      				seatManager.printManifestChart(type2);
   					break;
   				case "ECONOMY":
   					type2= "economy";
      				seatManager.printManifestChart(type2);
   					break;
   				default:
   					System.out.println("Wrong Entry"); 
   					checkValid= false;
   					break;
   				}
   				}while(checkValid ==false);
   				break;

   			case "Q":
   				seatManager.updateFile();
   				System.out.println("Thank you for using Airline Reservation System");
   				return true;

   			default:
   				System.out.println("Wrong Entry \n ");
   				break;
   		}
   return false;	
   }
   
   /** Helper of initiateService method
    * parses strings divided by comma and space in to a list
    * @param namesLine - String that contains names divided my commma and a space
    * @return namesArr - array list that contains names
    */
	private List<String> parseNames(String namesLine) {
		List<String> namesArr = Arrays.asList(namesLine.split(", "));
		return namesArr; 
	}	
}
