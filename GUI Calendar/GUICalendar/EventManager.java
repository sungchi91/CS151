import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Class responsible to processing request from Connection,
 * and work with MyCalendar to handle certain responsibilities
 * @author Sung Chi
 */
public class EventManager {
	
	private File file;
    private BufferedWriter fileOut;
    private BufferedReader fileIn; 
	private ArrayList<ChangeListener> listeners;
    private MyCalendar myCalendar;
    
    
    /**
     * constructor with ability to access text file or create new file
     */
	 public EventManager(){
		   this.myCalendar = new MyCalendar();
		   this.file = new File("events.txt");
			listeners = new ArrayList<ChangeListener>();

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
			System.out.println("This is first run");
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
					populateEvent(event);
				}
				else{
					String endTime = "N";
					String title = lineArr.get(2);
					Event event= new Event(title, date, startTime, endTime);	
					populateEvent(event);
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
	 public void populateEvent (Event event){
		 myCalendar.add(event);
	 }
   /**
    * create an event
    * @param event- Event that contains event information
    */
	 public void createEvent (Event event){
		 if(timeConflict(event)){
		 throw new IllegalArgumentException("Please enter other time slot");}	
		 myCalendar.add(event);
	 }
   /**
    * prints event for a specific date
    * @param date- String that contains date
 * @return 
    */
	 public ArrayList<String> eventPrinter (String date){
		 
		 ArrayList<Event> events= new ArrayList<Event>();
		 events=myCalendar.get(date);
		 ArrayList<String> eventList = new ArrayList<String>();
		 if(events!=null){
		 for(int i= 0; i<events.size(); i++){
			 if(events.get(i).getEventEndingTime()!=null){
			 eventList.add(events.get(i).getEventStartingTime()+" - "+events.get(i).getEventEndingTime()+" "+events.get(i).getEventTitle());
			 }
			 else{
				 eventList.add(events.get(i).getEventStartingTime()+" "+events.get(i).getEventTitle());
			 }
		 	}
		 return eventList;
		 }
		 else{
		 eventList.add("there is no event exist");
		 return eventList;
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
	    * checks if any event exist on same timeslot
	    * @return boolean true if any event exist
	    */
	 public boolean timeConflict(Event event){
		 return myCalendar.timeConflict(event);
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
	 public Calendar getCalendar(){
		 return myCalendar.getCalendar();
	 }
	 public void setCalendar(int n){
		 myCalendar.setCalendar(n);
		 somethingChanged();
	 }
	 public void setDate(int n){
		 myCalendar.setDate(n);
		 somethingChanged();
	 }
		public void addChangeListener(ChangeListener listener)
		   {
		      listeners.add(listener);
				/* Update the newly added Controller */
			//	somethingChanged();
		   }


		private void somethingChanged() {
			for (ChangeListener listener : listeners)
		      {
		         listener.stateChanged(new ChangeEvent(this));
		      }
			
		}
		 
}
