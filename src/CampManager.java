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


/**
 * A class with methods to implement different command in a CamperBST.
 * 
 * @author Weihang Guo, Jiaqi Zhang
 *
 */
public class CampManager {
  
  private CamperBST campers;//a binary search tree that contains some campers
  private final static String [] CABIN_NAMES = new String[]{"Otter Overpass", "Wolverine Woodland", 
      "Badger Bunkhouse"};//the names of cabins
  
  /**
   * Constructor for the CampManager by initializing the campers field.
   */
  public CampManager() {
    campers = new CamperBST();
  }
  
  /**
   * "Enrolls" a camper by determining their cabin and adding them to the tree.
   * @param newCamper the camper to be enrolled into the camp
   */
  public void enrollCamper(Camper newCamper) {
    if (newCamper.getAge() < 10) {
      newCamper.assignCabin(CABIN_NAMES[0]);
      //Campers of the ages 8-9 should be in ”Otter Overpass”
    }
    if (newCamper.getAge() > 9 && newCamper.getAge() < 13) {
      newCamper.assignCabin(CABIN_NAMES[1]);
      //Campers of the ages 10-12 should be in ”Wolverine Woodland”
    } else {
      newCamper.assignCabin(CABIN_NAMES[2]);
      //Campers of the ages 13-14 should be in ”Badger Bunkhouse”
    }
    campers.insert(newCamper);//insert the camper in the campers tree
  }

  /**
   * Prints statistics based on the current "state" of the camp. The statistics to be printed is 
   * the total number of campers.
   */
  public void printStatistics() {
    System.out.println(campers.size());
  }

  /**
   * Traverses the tree in the designated order by calling it through the CamperBST class.
   * @param order the type of traversal for the tree to perform
   * @return the Iterator of Campers from CampBST.traverse()
   */
  public java.util.Iterator<Camper> traverse(java.lang.String order){
    return campers.traverse(order);
  }
  
  /**
   * "Unenrolls" a camper by removing them from the tree.
   * @param delCamper the camper to be unenrolled the camp
   * @throws java.util.NoSuchElementException if CamperBST.delete throws NoSuchElementException
   */
  public void unenrollCamper(Camper delCamper) throws java.util.NoSuchElementException{
    campers.delete(delCamper);
  }
}
