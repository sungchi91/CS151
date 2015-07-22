import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Class contains data structure of each event
 * @author Sung Chi
 */
public class Event {
private String eventTitle;
private String eventDate;
private String eventStartingTime;
private String eventEndingTime;
private boolean doesEnd;
//constructor
/**
 * constructor
 */
public Event (String eventTitle, String eventDate, String eventStartingTime, String eventEndingTime) {
	
	this.eventTitle= eventTitle;
	
	//set eventDate
	this.eventDate= eventDate;

	this.eventStartingTime= eventStartingTime;
	if (!eventEndingTime.toUpperCase().equals("N")){
		this.eventEndingTime= eventEndingTime;
		this.doesEnd = true;
	}
	else {
		this.eventEndingTime= null;	
		this.doesEnd = false;
	}
}

//constructor helpers
/** Helper method
 * parses month, date, year from a line
 * @param eventDate String date in mm/dd/yyyy format
 * @return List - list contains month date and year
 */
public List<String> dateSpliter(String eventDate){
	List<String> dateArr = Arrays.asList(eventDate.split("/"));
	return dateArr; 

}
/** Helper method
 * parses hour and minute from a line
 * @param eventTime String time in hh:mmformat
 * @return List - list contains hour and min
 */
public List<String> timeSpliter(String eventTime){
	List<String> timeArr = Arrays.asList(eventTime.split(":"));
	return timeArr; 
}

//accessors
/** 
 * get event title
 * @return String event title 
 */
public String getEventTitle(){
	return this.eventTitle;
}
/** 
 * get event date
 * @return String event date
 */
public String getEventDate(){

	return this.eventDate;
}
/** 
 * get event staring time
 * @return String event staring time
 */
public String getEventStartingTime(){
	return this.eventStartingTime;
}
/** 
 * get event ending time
 * @return String  event ending time
 */
public String getEventEndingTime(){
	return this.eventEndingTime;
}
/** 
 * check if the passenger is a member of a group
 * @return boolean doesEnd true if event has end time
 */
public boolean doesEnd(){
	return this.doesEnd;
}

}
