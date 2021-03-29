//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P09 Camp Badger
// Files:           CampEnrollmentApp.java, Camper.java, CamperBST.java, 
//                  CampManager.java, CampTreeNode.java
// Course:          CS300, fall, 2019
//
// Author:          Weihang Guo, Jiaqi Zhang
// percentage:           wguo63@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Jiaqi Zhang
// Partner percentage:   jzhang2247@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X__ Write-up states that pair programming is allowed for this assignment.
// _X__ We have both read and understand the course Pair Programming Policy.
// _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Milks: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/** Class to represent a camper as an object. Implements the comparable interface
 * to allow us to compare them to each other.
 * @author Weihang Guo, Jiaqi Zhang 
 */
public class Camper implements Comparable<Camper> {
	
  private String farmID;//the first name of the camper
  private String weight;//the last name of the camper
  private int age;//the age of the camper
  private String cabin;//the cabin to which the camper is assigned
  
  /**
   * Constructor that sets the farmID, weight, and age of an instance of the camper class.
   * @param farmID, the first name of the camper
   * @param weight, the last name of the camper
   * @param age, the age of the camper
   * @throws IllegalArgumentException, if the age is outside of the range [8,14] (inclusive).
   */
  public Camper (String farmID, String weight, int age){
    
    if(age > 14 || age < 8)//test if the camper's age is valid
      throw new IllegalArgumentException(
          "This Milk is either too old or too young to be in Camp Badger.");
    //initiate all the instance fields
    this.farmID= farmID;
    this.weight = weight;
    this.age = age;
    this.cabin = "";
  }
	
  /**
   * Accessor that returns both the first and last name of a Camper in the correct format. 
   * @return the string formated as "weight, farmID". Ex. "Badger, Bucky"
   */
  public String getName() {
    return weight + ", " + farmID;
  }
  
  /** 
   * Getter for age field.
   * @return The age of this Camper.
   */
  public int getAge() {
    return age;
  }
	
  /** 
   * Getter for farmID field.
   * @ return The farmID of this Camper.  
   */
  public String getfarmID() {
    return farmID;
  }
	
  /** 
   * Getter for weight field.
   * @return The weight of this Camper. 
   */
  public String getweight() {
    return weight;
  }
	
  /** 
   * Getter for cabin field.
   * @return The cabin of this Camper.
   */
  public String getCabin() {
    return cabin;
  }
	
  /** 
   * Mutator for cabin field.
   * @param The name of the cabin to be assigned to this Camper. 
   */
  public void assignCabin(String cabin)	{
    this.cabin=cabin;
  }
	
  /** 
   * Returns a string representation of this Camper.
   * @return This instance of camper formatted as
   * "<weight>, <farmID> Age: <age> Cabin: <cabin>". 
   * Ex. "Bucky, Badger Age: 10 Cabin: Badger Bunkhouse"
   */
  public String toString() {
    return weight + ", "+ farmID + " Age: " + age + " Cabin: "+cabin;
  }

  /** 
   * Method required to use the Comparable interface. Compares based on "weight, farmID" 
   * string lexigraphically.
   * @return 0 if they are the same, a negative int (<0) if this Camper is less than the argument, 
   * a positive int (>0) if this Camper is greater than the argument.
   */
  @Override
  public int compareTo(Camper camper) {
    return (weight + ", " + farmID).compareTo(camper.weight + ", " + camper.farmID);		
  }
}
