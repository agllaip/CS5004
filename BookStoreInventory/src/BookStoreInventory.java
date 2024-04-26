import java.util.*;

/**
 *  Implements a BookStoreInventory as an ArrayList of BookStoreItems
 *  <p>
 *  Uses ArrayList.sort(Comparator<BookStoreItem>) to sort by author last name
 */
public class BookStoreInventory {
   ArrayList<BookStoreItem> inventory;

   /**
    * Constructor for a new, empty inventory
    * <p>
    * An inventory is implemented as an ArrayList of BookStoreItems
    * NB: Additional List-based methods could be added as needed
    * Also relies on ArrayList.sort() for sorting with a Comparator method
    */

   // FlawFound: (Missing "this." portion of the code in the constructor, before "inventory".)
   // FlawFixToDo: (Add "this." before "inventory".)
   // FlawFixed (I added "this." before "inventory", it is now "this.inventory".)

   public BookStoreInventory() {
      this.inventory = new ArrayList<>();
   }

   /**
    * Add an item to the Library, relying on built-in ArrayList methods
    * <p>
    * @param pub1 A BookStoreItem to be added to the Library
    */
   public void addToInventory(BookStoreItem pub1) {
      inventory.add(pub1);
   }

   // FlawFound: (Missing Javadocs for the size() method.)
   // FlawFixToDo: (Add Javadocs with a sentence for what the method will do and
   // include any parameters or return values if required in Javadocs comment block.)
   // FlawFixed (Added the necessary Javadocs above the method. Included a descriptive
   // sentence and what is to be returned. No parameters necessary.)

   /**
    * Returns the number of books currently in the inventory.
    *
    * @return number of books currently in the inventory.
    */

   public int size() {
      return inventory.size();
   }

   /**
    * Get a book from the Library, relying on built-in List/ArrayList methods
    * >
    * @param index a non-negative int within the range being used
    * @return a BookStoreItem from the Inventory, such as a Book or Magazine
    * @throws IndexOutOfBoundsException if the index is out of range.
    */

   // FlawFound: (Missing code for the exception (IndexOutOfBoundsException) being thrown.)
   // FlawFixToDo: (Include the code for IndexOutOfBoundsException and include the exception in the Javadocs.)
   // FlawFixed: (Added the missing code that checks to make sure the index is not less than 0
   // and not greater than the size of the inventory list. I also added the missing Javadocs @throws line.)

   public BookStoreItem getFromInventory(int index) throws IndexOutOfBoundsException {
      if (index < 0 || index >= inventory.size()) {
         throw new IndexOutOfBoundsException("Index out of bounds.");
      }
      return inventory.get(index);
   }

   /**
    * Determine whether inventory contains a given BookStoreItem
    * <p>
    * @param pub a BookStoreItem to check for
    * @return boolean, true iff pub is in the Library
    */
   public boolean inventoryContains(BookStoreItem pub) {
      return inventory.contains(pub);
   }

   /**
    * Given existing library, sort in order determined by provided Comparator
    * <p>
    * @param comp a Class that implements Comparator<BookStoreItem>
    * inventory will be sorted in place
    */

   public void sortInventory(Comparator<BookStoreItem> comp) {
      this.inventory.sort(comp);
   }

   /**
    * Return a String representation of inventory, sorted by author
    * <p>
    * @return the String representation, with each BookStoreItem on a new line
    */
   @Override
   public String toString() {
      // Use StringBuilder to build up the final String
      StringBuilder strBuilder = new StringBuilder("Inventory:");
      for ( BookStoreItem pub : this.inventory) {
         StringBuilder append = strBuilder.append("\n-----\n" + pub.toString());
      }
      return strBuilder.toString();
   }
}
