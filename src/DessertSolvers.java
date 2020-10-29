//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Creates a Queue of Guest objects to be served in a certain order
// Files: ServingQueue.java, Guest.java, QueueTests.java
// Course: CS 300, Spring, 2019
//
// Author: Maxwell Johnson
// Email: mkjohnson9@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * Methods that serve the Guest objects in the ServingQueue in a certain order depending on their
 * implementation
 * 
 * @author Maxwell Johnson
 *
 */
public class DessertSolvers {

  // methods
  /**
   * Creates a Queue of people to be served and serves the first, then skips the next given amount
   * of waiting people before serving the next person.
   * 
   * @param numberOfGuests number of guests to be added to the queue (at the table).
   * @param guestsSkipped  number of guests to skip.
   * @return Guest the last guest to be served at the table.
   * @throws IllegalArgumenException if the arguments inputed are negative
   */
  public static Guest firstDessertVariableSkips(int numberOfGuests, int guestsSkipped) throws IllegalArgumentException {
      if (numberOfGuests < 0 || guestsSkipped < 0) {// checks if either arguments are negative
        throw (new IllegalArgumentException("ERROR: The input arguments cannot be negative."));// throws an exception if so
      }
      ServingQueue table = new ServingQueue(numberOfGuests);// creates a new ServingQueue of
                                                            // numberOfGuests size
      for (int i = 0; i < numberOfGuests; i++) {// loops through total number of spots in queue and
                                                // adds a new guest to each one
        table.add(new Guest());
      }
      Guest holder = null;// creates a holder pointer to a Guest object
      while (!table.isEmpty()) {// loops while the ServingQueue is not empty
        holder = table.remove();// removes the first person in the queue to be served and sets them
                                // equal to the holder
        if (!table.isEmpty()) {// checks if the table is empty after the previous command is called
          for (int j = 0; j < guestsSkipped; j++) {// loops the number of guests to skip and adds
                                                   // them to the end of the array
            table.add(table.remove());
          }
        }
      }
      return holder;// returns the holder (last object in the queue).
  }

  /**
   * Determines which guest will be served first for dessert for a given amount of courses, given
   * that every other waiting guest is skipped and set at a new table in the order they were served
   * in for each new course.
   * 
   * @param numberOfGuests number of Guests to be sat at a table
   * @param coursesServed  the number of courses served to all the guests
   * @return Guest the first guest served for dessert
   * @throws IllegalArgumentException if the input arguments are negative
   */
  public static Guest firstDessertVariableCourses(int numberOfGuests, int coursesServed) throws IllegalArgumentException {
      // checks if the argument inputs are negative and throws an exception if so
      if (numberOfGuests < 0 || coursesServed < 0) {
        throw (new IllegalArgumentException("ERROR: The input arguments cannot be negative"));
      }

      // creates two ServingQueues, one for the current table, and one that holds the order of which
      // the people were served in.
      ServingQueue table = new ServingQueue(numberOfGuests);
      ServingQueue tableHold = new ServingQueue(numberOfGuests);

      // loops through the number of guests and adds them to the queue
      for (int i = 0; i < numberOfGuests; i++) {
        table.add(new Guest());
      }

      // checks if there is only one course served, and returns the first person in the array if
      // thats the case
      if (coursesServed == 1) {
        return table.peek();
      }


      Guest holder = null;// creates a holder Guest object

      // loops throught the number of courses served - 1. This simulates serving every other person
      // at each table for each given course
      for (int i = 0; i < coursesServed - 1; i++) {

        // loops while the table object isn't empty and adds each person in the order they are
        // served in to the holder table
        while (!table.isEmpty()) {
          holder = table.peek();// sets the holder to the first person currently at the table
          tableHold.add(table.remove());// serves the first person in the queue then removes them
                                        // and adds them to the holding table

          if (!table.isEmpty()) { // checks if the table is empty after the previous action
            for (int j = 0; j < 1; j++) {// skips each person after the current person served and
                                         // adds them to the end of the queue
              table.add(table.remove());

            }
          }
        }
        // changes the table to reference the tableHold which has the people ordered in the way they
        // were served
        table = tableHold;
        tableHold = new ServingQueue(numberOfGuests);

        // sets the last person in the new table array to be at the front.
        for (int k = 1; k < numberOfGuests; k++) {
          table.add(table.remove());
        }

      }
      return holder;// returns the first person to be served for dessert
  }
}

