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
 * Class to represent the nodes of the binary search tree.
 * 
 * @author Weihang Guo, Jiaqi Zhang
 */
public class CampTreeNode {

  private Camper data;//store the camper's name
  private CampTreeNode leftNode;//store the left node
  private CampTreeNode rightNode;//store the right node
	
  /**
   * Constructor for an empty CampTreeNode
   */
  public CampTreeNode() {
    //initialize the camp node
    data = null;
    leftNode = null;
    rightNode = null;
  }
	
  /**
   * Constructor of CampTreeNode with the camper data. 
   * @param data a camper
   */
  public CampTreeNode(Camper data) {
    this.data = data;
    leftNode = null;
    rightNode = null;
  }
  
  /**
   * Getter for data field.
   * @return The data of this CampTreeNode
   */
  public Camper getData() {
    return data;
  }
	
  /**
   * Getter for leftNode field.
   * @return The leftNode of this CampTreeNode
   */
  public CampTreeNode getLeftNode() {
    return leftNode;
  }
	
  /**
   * Getter for rightNode field.
   * @return The rightNode of this CampTreeNode
   */
  public CampTreeNode getRightNode() {
    return rightNode;
  }
  
	
  /** 
   * Setter for data field
   * @param camper, the Camper that the data  field will be set to
   */
  public void setData(Camper camper) {
    data = camper;
  }
	
  /** 
   * Setter for leftNode field
   * @param node, the CampTreeNode that the leftNode field will be set to
   */
  public void setLeftNode(CampTreeNode node) {
    leftNode = node;
  }
	
  /** 
   * Setter for rightNode field
   * @param node, the CampTreeNode that the rightNode field will be set to
   */
  public void setRightNode(CampTreeNode node) {
    rightNode = node;
  }
	
}
