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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Use an instance of the CampManager to execute certain commands 
 * as read from a text file.
 * @author Weihang Guo, Jiaqi Zhang
 *
 */
public class CampEnrollmentApp {
  
  /**
   * Deal with different situations according to the first letter of the input
   * @param manager the campManger which handles the command
   * @param line the input command
   */
  public static void read(CampManager manager, String line) {
    
    //the first letter is "E", meaning a camper is to be enrolled
    if (line.split(" ")[0].equals("E")) {
      try {
        Camper camper = new Camper(line.split(" ")[2], line.split(" ")[1], 
            Integer.parseInt(line.split(" ")[3]));//store the name and age information in camper
        manager.enrollCamper(camper);//enroll the camper
      } catch (java.lang.IllegalArgumentException e) {//when the camper's age is invalid
        System.out.println(e.getMessage());//print the message to the console
        return;
      }
      System.out.println("Enrollment of " + line.split(" ")[2] + " " + line.split(" ")[1]
            + " Successful!");
      //when the age is within the proper range, inform the user that the enrollment is completed
    }
    
    //the first letter is "R", meaning a camper is to be unenrolled
    if (line.split(" ")[0].equals("R")) {
      Camper camper = new Camper(line.split(" ")[2], line.split(" ")[1], 10);
      //"10" is a randomly chosen number to represent a valid age
      try {
        manager.unenrollCamper(camper); 
      } catch (java.util.NoSuchElementException e) {//when the camper is not enrolled
        System.out.println(e.getMessage());//print the message to the console
        return;
      }
      System.out.println("Unenrollment of " + camper.getfarmID() + " " + camper.getweight()
          + " Successful!");
      //when a previously enrolled camper has been successfully unenrolled, 
      //inform the user that the unenrollment is completed
    }
    
    //when the first letter is "T", traverse the tree
    if (line.split(" ")[0].equals("T")) {
      String order = line.split(" ")[1];
      System.out.println("--- " + order + " TRAVERSAL ---");
      java.util.Iterator<Camper> iterator = manager.traverse(order);
      //create an iterator according to the traversal order
      while (iterator.hasNext()) {//traverse the tree
        Camper camper = iterator.next();
        System.out.println(camper.getweight() + ", " + camper.getfarmID() + " Age: "
            + camper.getAge() + " Cabin: " + camper.getCabin());
      }
      System.out.println("------------------------");
    }
    
    //when the first letter is "S", print the statistics
    if (line.split(" ")[0].equals("S")) {
      System.out.println("--- Camp Statistics ---");
      System.out.print("Number of Campers: ");
      manager.printStatistics();;
      System.out.println("------------------------");
    }
  }

  /**
   * Read from a given file and implement the command in the file.
   * @param args input arguments
   */
  public static void main(String[] args) {
    CampManager manager = new CampManager();//create a new campManager
    try {
      List <String> fileLines = Files.readAllLines(Paths.get("sim.txt"));
      for (int i = 0; i < fileLines.size(); i ++) {
        read(manager, fileLines.get(i));//execute the commands from the file line by line
      }      
    } catch (IOException e) {//test if the file exists
      e.printStackTrace();
    } 
  }
  
}
