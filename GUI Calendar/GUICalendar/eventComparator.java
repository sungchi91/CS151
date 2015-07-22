import java.util.Comparator;

/**
 * Class contains comparator for event sort
 * @author Sung Chi
 */
public class eventComparator implements Comparator<Event>{
	/**
	 * overrides compare 
	 * @param e1 line 1
	 * @param e2 line 2
	 * @return int if 1 is bigger return 1,if smaller -1,if same return 0
	 */
	public int compare(Event e1, Event e2){
		return e1.getEventStartingTime().compareTo(e2.getEventStartingTime());
	}
	
}

