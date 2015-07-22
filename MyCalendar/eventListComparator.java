import java.util.Comparator;

/**
 * Class contains comparator for event sort by date
 * @author Sung Chi
 */
public class eventListComparator implements Comparator<String>{
	/**
	 * overrides compare 
	 * @param s1 line 1
	 * @param s2 line 2
	 * @return int if 1 is bigger return 1,if smaller -1,if same return 0
	 */
	public int compare(String s1, String s2){
		

		String tmp= s1.substring(s1.indexOf(", ")+2,s1.indexOf(":")-6);
		int n=replaceMonth(tmp);
		String tmp2= s1.substring(s1.indexOf(":")-5,s1.indexOf(":")-3);
		String tmp3= s2.substring(s2.indexOf(", ")+2,s2.indexOf(":")-6);
		int n2=replaceMonth(tmp);
		String tmp4= s2.substring(s2.indexOf(":")-5,s2.indexOf(":")-3);
		
		s1= s1.substring(0,5)+n+tmp2;
		s2= s2.substring(0,5)+n2+tmp4;

		return s1.compareTo(s2);
	}
	/**
	 * replace month in number to English
	 * @param s month
	 * @return int month in English
	 */
	public int replaceMonth(String s){
		if (s.equals("January")){
			return 1;
		}
		else if (s.equals("Faburary")){
			return 2;
		}
		else if (s.equals("March")){
			return 3;
		}
		else if (s.equals("April")){
			return 4;
		}
		else if (s.equals("May")){
			return 5;
		}
		else if (s.equals("Jun")){
			return 6;
		}
		else if (s.equals("July")){
			return 7;
		}
		else if (s.equals("August")){
			return 8;
		}
		else if (s.equals("September")){
			return 9;
		}
		else if (s.equals("October")){
			return 10;
		}
		else if (s.equals("November")){
			return 11;
		}
		else{
			return 12;
		}
		
	}
}