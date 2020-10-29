
/**
 * Represents a person that can be added to a table in a certain order.
 * 
 * @author Maxwell Johnson
 *
 */
public class Guest {
  // instance fields
  private static int nextIndex = 1;// the nextIndex to be given to a newly created Guest
  private int index;// the index of the guest created
  private String dietaryRestriction;// the guests dietary restriction

  // methods
  /**
   * Resets the counting of newly constructed guest indexes, so that the next new Guest that is
   * created will be associated with the guest index of one.
   * 
   * Note: that this will be helpful when running several tests, or solving solving several dessert
   * simulation problems. And that this should never be called from ServingQueue.java
   */
  public static void resetNextGuestIndex() {
    nextIndex = 1;
  }

  /**
   * Constructs a new guest with no dietary restrictions. This guest should be associated with an
   * index that is one larger than the previously constructed guest (or 1, if no prior guest, or if
   * resetNextGuestIndex() was called more recently).
   */
  public Guest() {
    this.index = nextIndex;
    nextIndex++;
    dietaryRestriction = "";
  }

  /**
   * Constructs a new guest with the specified dietary restrictions. This guest should be associated
   * with an index that is one larger than the previously constructed guest (or 1, if no prior
   * guest, or if resetNextGuestIndex() was called more recently).
   * 
   * @param dietaryRestriction describes requirements for what this guest can and cannot eat
   */
  public Guest(String dietaryRestriction) {
    this.index = nextIndex;
    nextIndex++;
    this.dietaryRestriction = dietaryRestriction;
  }

  /**
   * Access whether this guest has any dietary restrictions or not
   * 
   * @return true for guests constructed using new Guest(String), false otherwise
   */
  public boolean hasDietaryRestriction() {
    if (dietaryRestriction.contentEquals(""))
      return false;
    return true;
  }

  /**
   * The string representation of a Guest should be formatted as, for examples: #3(no dairy) for a
   * guest with a guest index of 3 and the dietary restriction of "no dairy", or: #4 for a guest
   * with a guest index of 4 and no dietary restriction
   * 
   * @return string representing the guest index and any dietary restriction they might have
   * @see java.lang.Object#toString()
   */
  public String toString() {
    if (hasDietaryRestriction()) {
      return "#" + index + "(" + dietaryRestriction + ")";
    }
    return "#" + index;
  }
}
