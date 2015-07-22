/**
 * Class contains data structure of each passenger
 * @author Sung Chi
 */

public class Passenger {
	protected boolean isGroup;
	private String name;
	private String groupName;

   /**
    * constructor
    */
	public Passenger(){
		isGroup = false;
		name = " ";
		groupName= " ";
	}
	
	//accessors
	
	/** 
    * check if the passenger is a member of a group
    * @return boolean isGroup true if this passenger is part of a group
    */
	public boolean getIsGroup(){
		return this.isGroup;
	}
	
	/** 
    * get passenger's name
    * @return String name 
    */
	public String getName(){
		return this.name;
	}
	
	/** 
    * get passenger's groupName
    * @return String group name 
    */
	public String getGroupName(){
		return this.groupName;
	}
	
	//mutators
	/** 
    * set Isgroup true
    */	
	public void setIsGroup(){
		this.isGroup= true;
	}
	/** 
    * set passenger name
    * @param name name of the passenger
    */
	public void setName(String name){
		this.name = name;  
	}
	/** 
    * set passenger's group name
    * @param groupName name of the group
    */
	public void setGroupName(String groupName){
		this.groupName=groupName;
	}
}
