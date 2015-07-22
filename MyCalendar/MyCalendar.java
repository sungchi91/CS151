import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/**
 * Class holds the calendar structure and event
 * Work with EventManager and Event class
 * @author Sung Chi
 */
public class MyCalendar {
 private HashMap <String, ArrayList<Event>> myCalendar;
 
 //constructor
 /**
 * Constructor
 */
 public MyCalendar(){
	 myCalendar = new HashMap<>();
 }
 //mutator
 /**
  * adds an event to existing date or non-exiting date
  * @param event Event object that contains event info
  */
 public void add(Event event){
	 
	 if(exist(event.getEventDate())==true)
	 {
		 (myCalendar.get(event.getEventDate())).add(event);
		 sortEvent((myCalendar.get(event.getEventDate())));
	 }
	 else
	 { 
		 myCalendar.put(event.getEventDate(), new ArrayList<Event>(Arrays.asList(event)));
	 }
 }
 /**
  * removes a date from calendar
  * @param date date to remove
  */
 public void remove(String date){
	 if(exist(date)==true)
	 {
		 myCalendar.remove(date);
			System.out.println("All the Events on selected date has been deleted");
	 }
	 else
	 { 
		 System.out.println("there is no event exist");
	 }
 }
 //geter
 /**
  * search for a specific date's events
  * @param date date to get events from
  * @return ArrayList list of event objects on that date
  */
 public ArrayList<Event> get(String date){
	 if(exist(date)==true)
	 {
		 return myCalendar.get(date);
	 }
	 else
	 { 
		 System.out.println("there is no event exist");
		 return null;
	 }
 }
 
 /**
  * checks if certain date exist in the calendar
  * @param date date to check
  * @return boolean true if exist
  */
 public boolean exist (String date){
		// Get keys.
		Set<String> keys = myCalendar.keySet();

		// Loop over String keys.
		for (String key : keys) {
		    if (key.equals(date))
		    	return true;
		}
		return false;
 }
 
 /**
  * iterate through the calendar and return all the events
  * @return List array of Event list in String
  */
 public List<String> EventList (){
	 	List<String> arr= new ArrayList<String>();
		Collection<ArrayList<Event>> values = myCalendar.values();
		for (ArrayList<Event> value : values) {
		    for (int i=0; i<value.size();i++){
		    	String date = value.get(i).getEventDate();		    	
		    	String start = value.get(i).getEventStartingTime();
		    	String end = value.get(i).getEventEndingTime();
		    	String title = value.get(i).getEventTitle();
		    	if(end!=null){
		    	arr.add(date+", "+start+", "+end+", "+title);
		    	}
		    	else arr.add(date+", "+start+", "+title);    	
		    }
		}
		sortEventByDate(arr);
		return arr;
}
 
 /**
  * iterate through the calendar and prints all the events
  */
 public void printEventList (){
	 	List<String> arr= new ArrayList<String>();
		Collection<ArrayList<Event>> values = myCalendar.values();
		for (ArrayList<Event> value : values) {
		    for (int i=0; i<value.size();i++){
		    	String date = value.get(i).getEventDate();
		    	int year=Integer.parseInt(dateSpliter(date).get(2));
		    	int dayOfMonth=Integer.parseInt(dateSpliter(date).get(1));
		    	int month=Integer.parseInt(dateSpliter(date).get(0))-1;
		    	Calendar day= new GregorianCalendar();
		    	day.set(Calendar.YEAR, year);
		    	day.set(Calendar.MONTH, month);
		    	day.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		    	
		    	 MONTHS[] arrayOfMonths = MONTHS.values();
		  	    DAYS[] arrayOfDays = DAYS.values();
		    	
		    	String start = value.get(i).getEventStartingTime();
		    	String end = value.get(i).getEventEndingTime();
		    	if(end!=null){
		    	arr.add(day.get(Calendar.YEAR)+" "+arrayOfDays[day.get(Calendar.DAY_OF_WEEK)-1]+", "+arrayOfMonths[day.get(Calendar.MONTH)]+" "+day.get(Calendar.DAY_OF_MONTH)+" "+start+" - "+end+" "+value.get(i).getEventTitle());
		    	}
		    	else arr.add(day.get(Calendar.YEAR)+" "+arrayOfDays[day.get(Calendar.DAY_OF_WEEK)-1]+", "+arrayOfMonths[day.get(Calendar.MONTH)]+" "+day.get(Calendar.DAY_OF_MONTH)+" "+start+" "+value.get(i).getEventTitle());
		    	
		    }
		}
		sortEventList(arr);
		for (int i=0; i<arr.size(); i++){
			System.out.println(arr.get(i));
		}
}
 /** Helper method
  * parses month, date, year from a line
  * @param eventDate String date in mm/dd/yyyy format
  * @return List - list contains month date and year
  */
 public List<String> dateSpliter(String eventDate){
		List<String> dateArr = Arrays.asList(eventDate.split("/"));
		return dateArr; 

	}
 //destructor
 /**
  * remove all the dates and events
  */
 public void clear(){
	 myCalendar.clear();
		System.out.println("All the Events has been deleted");
 }
 /**
  * sort events on one day by starting time
  * @param events ArrayList list of events to sort
  */
 public void sortEvent(ArrayList<Event> events){
	 Comparator<Event> comp = new eventComparator();
	 Collections.sort(events, comp);
 }
 /**
  * sort events on a event list by date and then starting time
  * @param arr List list of events to sort
  */
 public void sortEventByDate(List<String> arr){
	 Comparator<String> comp = new eventComparatorByDate();
	 Collections.sort(arr, comp);
 }
 /**
  * sort events on a event list by date and then starting time
  * @param arr List list of events to sort
  */
public void sortEventList(List<String> arr){
	 Comparator<String> comp = new eventListComparator();
	 Collections.sort(arr, comp);
 }
}

