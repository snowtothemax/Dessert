
/**
 * A Queue of Guest objects that are to be served in a given order.
 * 
 * @author Maxwell Johnson
 *
 */
public class ServingQueue {
  // instance fields
  private Guest[] array;// the array of Guest objects
  private int size;// the amount of guest objects in the queue
  private int front;// the front of the queue
  private int rear;// the back of the queue
  private int enqueueTo;// the position to add an object to the queue

  // methods
  /**
   * Creates a new array based queue with a capacity of "seatsAtTable" guests. This queue should be
   * initialized to be empty.
   * 
   * @param seatsAtTable the size of the array holding this queue data
   */
  public ServingQueue(int seatsAtTable) {
    array = new Guest[seatsAtTable];
    size = 0;
    enqueueTo = 0;
    front = 0;
    rear = 0;
  }

  /**
   * Checks whether there are any guests in this serving queue.
   * 
   * @return true when this queue contains zero guests, and false otherwise.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Adds a single new guest to this queue (to be served after the others that were previously added
   * to the queue).
   * 
   * @param newGuest is the guest that is being added to this queue.
   * @throws IllegalStateException when called on a ServingQueue with an array that is full
   */
  public void add(Guest newGuest) {
    try {
      if (size + 1 > array.length) {// tests to see if adding one more object would make it longer
                                    // than the current array length
        throw (new IllegalStateException());// throws an IllegalStateException if thats the case
      }
      array[enqueueTo] = newGuest;// assigns the enqueueTo index to the new Guest
      size++;
      rear = enqueueTo;// assigns the rear index to enqueueTo
      enqueueTo = (enqueueTo + 1) % array.length;// increments the enqueueTo index

    } catch (IllegalStateException e) {
      System.out.println("ERROR: List is already full.");// Prints an error message if the exception
                                                         // is caught
    }
  }

  /**
   * Accessor for the guest that has been in this queue for the longest. This method does not add or
   * remove any guests.
   * 
   * @return a reference to the guest that has been in this queue the longest.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest peek() {
    try {
      if (isEmpty()) {// checks if the list is empty
        throw (new IllegalStateException());// throws an IllegalStateException if so
      }
      return array[front];// returns the Guest at the front of the queue
    } catch (IllegalStateException e) {
      System.out.println("ERROR: The list is empty.");// prints error message if excepetion caught
    }
    return null;// returns null if exception caught

  }

  /**
   * Removes the guest that has been in this queue for the longest.
   * 
   * @return a reference to the specific guest that is being removed.
   * @throws IllegalStateException when called on an empty ServingQueue
   */
  public Guest remove() {
    try {
      if (isEmpty()) {// checks if the array is empty
        throw (new IllegalStateException());// throws an IllegalStateException if so.
      }
      Guest ret = array[front];// the Guest to return at the front of the array
      array[front] = null;// removes the front object
      front = (front + 1) % array.length;// increments the front of the array
      size--;
      return ret;
    } catch (IllegalStateException e) {
      System.out.println("ERROR: The list is empty.");// prints error message if exception caught
    }
    return null;// returns null in the case an argument is thrown.
  }

  /**
   * The string representation of the guests in this queue should display each of the guests in this
   * queue (using their toString() implementation), and should display them in a comma separated
   * list that is surrounded by a set of square brackets. (this is similar to the formatting of
   * java.util.ArrayList.toString()). The order that these guests are presented in should be (from
   * left to right) the guest that has been in this queue the longest, to the guest that has been in
   * this queue the shortest. When called on an empty ServingQueue, returns "[]".
   * 
   * @return string representation of the ordered guests in this queue
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    String ret = "";// initializes a string to return
    if (isEmpty()) {// checks if the array is empty
      return "[]";
    }
    int count = 0;// initializes a counter to count the amount of object printed
    for (int i = front; count < size; i = (i + 1) % array.length) {// iterates through the indexes
                                                                   // of the circular array a given
                                                                   // amount of times
      ret += array[i].toString() + ",";// adds the tostring of each Guest object to the string to
                                       // return
      count++;
    }
    ret = "[" + ret + "]";// puts the return string in brackets.
    return ret;
  }
}
