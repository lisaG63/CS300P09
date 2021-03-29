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

import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * A class that represents a binary serach tree that contains some campers.
 * 
 * @author Weihang Guo, Jiaqi Zhang
 *
 */
public class CamperBST {
  public CampTreeNode root;//store the root of the camp tree
  private int size;//store the number of nodes in the tree
  private LinkedList<Camper> traversedLList;//LinkedList to maintain current traversal
  
  /**
   * The constructor of CamperBST. Create an empty binary search tree.
   */
  public CamperBST() {
    root = null;
    size = 0;
  }
 
  /**
   * returns the current size of the CamperBST
   * @return the current size of the CamperBST
   */
  public int size() {
    return size;
  }
  
  /**
   * returns true if the tree is empty, false otherwise
   * @return true if the tree is empty, false otherwise
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }

  //starts tree insertion by calling insertHelp() on the root and
  //assigning root to be the subtree returned by that method
  public void insert(Camper newCamper) {
    root = insertHelp(root, newCamper);
    size ++;
  }
  
  /** Recursive helper method to insert.
   * @param current, The "root" of the subtree we are inserting into,
   * ie the node we are currently at.
   * @param newCamper, the camper to be inserted into the tree
   * @return the root of the modified subtree we inserted into
   */
  private CampTreeNode insertHelp(CampTreeNode current, Camper newCamper) { 
    if (current == null) {//if the current node is null, insert the new node with no children
      current = new CampTreeNode(newCamper);
      return current;
    } else if (current.getData().compareTo(newCamper) < 0) {
      //if the new camper is larger than the current node' data
      current.setRightNode(insertHelp(current.getRightNode(), newCamper)); 
      //insert the camper in the right subtree
    } else if (current.getData().compareTo(newCamper) > 0) {
      //if the new camper is smaller than the current node's data
      current.setLeftNode(insertHelp(current.getLeftNode(), newCamper));
      //insert the camper in the left subtree
    }
    return current;
  }

  /**
   * Prints the contents of this tree in alphabetical order based on the string 
   * "weight, farmID"
   */
  public void print() {
    printHelp(root); 
  }
  
  /**
   * Recursive helper method to print.
   * @param current the current node
   */
  private void printHelp(CampTreeNode current){
    if(current==null) {
      return;
    }
    printHelp(current.getLeftNode());
    System.out.println(current.getData());
    printHelp(current.getRightNode());
  }
  
  /** Deletes a Camper into the binary search tree if it exists.
  * @param key, the camper to be deleted from the tree
  * @throws NoSuchElementException if it is thrown by deleteHelp
  */
  public void delete (Camper key) throws NoSuchElementException {
    root = deleteHelp(root, key);
    size --;
  }
  /** Recursive helper method to delete.
  * @param current, The "root" of the subtree we are deleting from,
  * ie the node we are currently at.
  * @param key, the camper to be deleted from the tree
  * @return the root of the modified subtree we deleted from
  * @throws NoSuchElementException if the camper is not in the tree
  */
  private CampTreeNode deleteHelp(CampTreeNode current, Camper key) {
    if (current == null) {//if current root is null, the key is not found
      throw new NoSuchElementException("That camper is not enrolled.");//throw exception
    }
    //if the current root is not null
    if (current.getData().compareTo(key) == 0) {//if the key is found at the current root
      if (current.getLeftNode() == null) {
        //if the current root has one right node child or no children
        return current.getRightNode();//replace the current root with the right child
      } else if (current.getRightNode() == null) {//if the current root has only the left child
        return current.getLeftNode();//replace the current root with the left child
      } else {
        //if the current root has both children
        CampTreeNode leftmost = leftmost(current.getRightNode());
        current.setData(leftmost.getData());
        //replace the current root with the leftmost node in the right subtree
        current.setRightNode(deleteHelp(current.getRightNode(), leftmost.getData()));
        //remove the leftmost node
      }     
    } else if (current.getData().compareTo(key) < 0){//if the key is larger than the current root
      current.setRightNode(deleteHelp(current.getRightNode(), key));//recur down the right subtree
    } else {
      //if the key is smaller than the current root
      current.setLeftNode(deleteHelp(current.getLeftNode(), key));//recur down the left subtree
    }
    return current;
    
    
  }
  
  /**
   * The helper method to find the leftmost node
   * @param current the root of the current subtree
   * @return the leftmost node
   */
  private CampTreeNode leftmost(CampTreeNode current) {
    if (current.getLeftNode() == null) {
      return current;
      //the base case: when the current node has no left child, return the current node
    } 
    //when the current node has a left child, recur down
    return leftmost(current.getLeftNode());
  }
  

  /**
   * returns an iterator of camper in the correct order as designated
   * @param order the traversal order(PREORDER, POSTORDER, or INORDER)
   * @return an iterator of camper in the correct order as designated
   */
  public Iterator<Camper> traverse(String order) {
    //first time traversing need to initialize LinkedList
    if(traversedLList==null){
      traversedLList = new LinkedList<Camper>();
    }
    else{
      //clear the list to start over for a new traversal
      traversedLList.clear();
    }
    traverseHelp(root, order);
    return traversedLList.listIterator();
  }
  
  /** 
   * Recursive helper method to traverse. Will take the current CampTreeNode’s data
   * and add it to traversedLList based on the given order. Then continue to recurse on
   * the correct subtree.
   * @param current, the root of the current subtree we are traversing
   * @param order, the type of traversal to perform
   */
  private void traverseHelp (CampTreeNode current, String order) {
    if (current !=null) {//when the current root is not null
      
      //preorder traverse
      if (order.equals("PREORDER")) {
        traversedLList.add(current.getData());//add the current root
        traverseHelp(current.getLeftNode(), order);//recur down the left subtree
        traverseHelp(current.getRightNode(), order);//recur down the right subtree
      } 
      
      //postorder traverse
      if (order.equals("POSTORDER")) {
          traverseHelp(current.getLeftNode(), order);//recur down the left subtree
          traverseHelp(current.getRightNode(), order);//recur down the right subtree
          traversedLList.add(current.getData());//add the parent node
      }
      
      //inorder traverse
      if (order.equals("INORDER")) {
          traverseHelp(current.getLeftNode(), order);//recur down the left subtree
          traversedLList.add(current.getData());//add the parent node
          traverseHelp(current.getRightNode(), order);//recur down the right subtree      
      }
       
    
    }
    
  }
  
  
}
