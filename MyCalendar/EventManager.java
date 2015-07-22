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
 * and work with MyCalendar to handle certain responsibilities
 * @author Sung Chi
 */
public class EventManager {
	
	private File file;
    private BufferedWriter fileOut;
    private BufferedReader fileIn; 

    private MyCalendar myCalendar;
    
    /**
     * constructor with ability to access text file or create new file
     */
	 public EventManager(){
		   this.myCalendar = new MyCalendar();
		   this.file = new File("events.txt");
	}
	
	    
    /**
     * access text file or create new file
     * @throws IOException program will make one 
     */
	 public void loadCalendar() throws IOException {
		   try {
		  	 this.fileIn = new BufferedReader(new FileReader(file));      
		  	 populateCalendar();
				System.out.println("Events Successfully Loaded");
		   }
		   catch (IOException ex) {
			System.out.println("This first run");
			file.createNewFile();
		   }
	}
    /**
     * Helper method of constructor
     * populates the Calendar with the data contained in the events.txt
     * @throws  IOException connection failed, possible cause is FileNotFoundException
     */
	 public void populateCalendar()throws IOException{
			while(fileIn.ready()){
				String line =  fileIn.readLine();
				List<String> lineArr = parser(line);
				String date =lineArr.get(0);
				String startTime = lineArr.get(1);
				
				if(doesEnd(lineArr)){
					String endTime = lineArr.get(2);
					String title = lineArr.get(3);
					Event event= new Event(title, date, startTime, endTime);	
					createEvent(event);
				}
				else{
					String endTime = "N";
					String title = lineArr.get(2);
					Event event= new Event(title, date, startTime, endTime);	
					createEvent(event);
				}			
			}	
		}
   /** Helper of populateCalendar method
    * parses strings divided by comma and space in to a list
    * @param line- String that contains data divided my commma and a space
    * @return arr - array list that contains data
    */
	 public List<String> parser(String line) {
		    List<String> arr = Arrays.asList(line.split(", "));
			return arr; 
		}
   /** Helper of populateCalendar method
    * checks if an event ends
    * @param line- String that contains data divided my commma and a space
    * @return boolean true is event has end time
    */
	 public boolean doesEnd (List<String> line) {
			if (line.size()==3){
				return false;
			}
			else return true;
		}
   /**
    * create an event
    * @param event- Event that contains event information
    */
	 public void createEvent (Event event){
		 	myCalendar.add(event);
	 }
   /**
    * prints event for a specific date
    * @param date- String that contains date
    */
	 public void eventPrinter (String date){
		 
		 ArrayList<Event> events= new ArrayList<Event>();
		 events=myCalendar.get(date);
		 if(events!=null){
		 for(int i= 0; i<events.size(); i++){
			 if(events.get(i).getEventEndingTime()!=null){
			 System.out.println(events.get(i).getEventTitle()+" "+events.get(i).getEventStartingTime()+" - "+events.get(i).getEventEndingTime());
			 }
			 else  System.out.println(events.get(i).getEventTitle()+" "+events.get(i).getEventStartingTime());
		 	}
		 }
	 }
   /**
    * print Event List
    */
	 public void eventList(){
		 myCalendar.printEventList();
	 }
   /**
    * checks if any event exist on certain date
    * @return boolean true if any event exist
    */
	 public boolean eventExist(String date){
		 return myCalendar.exist(date);
	 }
   /**
    * remove Events on a certain date
    * @param date a date to remove
    */
	 public void removeEvents(String date){
		 myCalendar.remove(date);
	 }
	   /**
	    * remove all the events and empty the calendar
	    */
	 public void clearEvents(){
		 myCalendar.clear();
	 }
	   /**
	    * Save newly performed request before quitting
	    * @throws IOException connection failed, possible cause is FileNotFoundException
	    */
	 public void updateFile() throws IOException{
		 try {
			fileOut = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			file.createNewFile();
		}   
	       List<String> arr = myCalendar.EventList();
	       for(int i=0; i<arr.size();i++){
		       String line = arr.get(i);
		       fileOut.write(line);
		       fileOut.newLine();
	       }
	       fileOut.close();  
	
	 }
		 
}
