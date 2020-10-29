
/**
 * Tester class for all source files classes and methods
 * 
 * @author Maxwell Johnson
 *
 */
public class QueueTests {

  /**
   * Runs each test method and prints the result
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("testServingQueueAdd(): " + testServingQueueAdd());
    System.out.println("testServingQueueRemove(): " + testServingQueueRemove());
    System.out.println("testServingQueueToString(): " + testServingQueueToString());
    System.out.println("testDessertSolversSkips(): " + testDessertSolversSkips());
    System.out.println("testDessertSolversCourses(): " + testDessertSolversCourses());
  }

  /**
   * Tests the add method of the ServingQueue
   * 
   * @return boolean true if the test works correctly, false otherwise
   */
  public static boolean testServingQueueAdd() {
    ServingQueue test = new ServingQueue(2);// creates a new ServingQueue object
    test.add(new Guest());
    test.add(new Guest());// adds two new guests

    // checks if the first guest in the array exists and has the correct toString and returns true
    // if that is the case
    if (test.peek().toString().contentEquals("#1")) {
      Guest.resetNextGuestIndex();// resets the nextGuestIndex
      return true;
    }

    // prints an error message otherwise and rests the nextGuestIndex and returns false
    System.out.println("ERROR: The add method did not work correctly.");
    Guest.resetNextGuestIndex();
    return false;
  }

  /**
   * Tests the remove() method of the ServingQueue class
   * 
   * @return
   */
  public static boolean testServingQueueRemove() {
    ServingQueue test = new ServingQueue(2);// creates a new ServingQueue
    test.add(new Guest());// adds a guest to the ServingQueue
    Guest holder = test.remove();// removes the added guest and another object points to it

    // tests if the holder is null, or if the queue is empty and returns false if so
    if (holder == null || !test.isEmpty()) {
      System.out.println("ERROR: The remove method did not work correctly.");// prints error message
                                                                             // if so
      Guest.resetNextGuestIndex();// resets the index of the guestIndex
      return false;
    }

    // otherwise returns true
    Guest.resetNextGuestIndex();
    return true;
  }

  public static boolean testServingQueueToString() {
    ServingQueue test = new ServingQueue(2);
    test.add(new Guest());
    test.add(new Guest());
    if (!test.toString().contentEquals("[#1,#2,]")) {
      System.out.println("ERROR: the toString() method did not work correctly.");
      Guest.resetNextGuestIndex();
      return false;
    }
    Guest.resetNextGuestIndex();
    return true;
  }

  /**
   * Tests the first method of the DessertSolvers class works that skips a given number of waiting
   * Guests after the first is served
   * 
   * @return boolean true if the output of the method matches the expected, false otherwise.
   */
  public static boolean testDessertSolversSkips() {
    if (!DessertSolvers.firstDessertVariableSkips(8, 3).toString().contentEquals("#3")) {// tests
                                                                                         // the
                                                                                         // output
                                                                                         // with the
                                                                                         // expected
                                                                                         // output
      System.out.println("ERROR: The firstDessertVariableSkips method did not work as intended.");// prints
                                                                                                  // an
                                                                                                  // error
                                                                                                  // message
                                                                                                  // if
                                                                                                  // false
      Guest.resetNextGuestIndex();
      return false;
    }

    // returns true if output matches
    Guest.resetNextGuestIndex();
    return true;
  }

  /**
   * Checks if the second method of the DessertSolvers class works correctly by checking if the
   * expected output of the first person to be served for dessert is equal to the actual output
   * 
   * @return boolean true if the output matches, false otherwise
   */
  public static boolean testDessertSolversCourses() {
    if (!DessertSolvers.firstDessertVariableCourses(8, 3).toString().contentEquals("#4")) {// checks
                                                                                           // if the
                                                                                           // output
                                                                                           // matches
      System.out.println("ERROR: The firstDessertVariableCourses method did not work as intended.");// prints
                                                                                                    // error
                                                                                                    // messag
                                                                                                    // if
                                                                                                    // false
      Guest.resetNextGuestIndex();
      return false;
    }

    // returns true if output matches
    Guest.resetNextGuestIndex();
    return true;
  }

}
