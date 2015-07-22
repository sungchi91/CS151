import java.util.Comparator;

/**
 * Class contains comparator for event sort by date
 * @author Sung Chi
 */
public class eventComparatorByDate implements Comparator<String>{
	/**
	 * overrides compare 
	 * @param s1 line 1
	 * @param s2 line 2
	 * @return int if 1 is bigger return 1,if smaller -1,if same return 0
	 */
	public int compare(String s1, String s2){
		s1= s1.substring(6,10)+s1.substring(0,2)+s1.substring(3,5);
		s2= s2.substring(6,10)+s2.substring(0,2)+s2.substring(3,5);		
		return s1.compareTo(s2);
	}
}
