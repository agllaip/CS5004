/**
 * Interface Specification for various BookStoreItems such as Books and Magazines
 */
public interface BookStoreItem {

  /**
   * Getter for the title of the BookStoreItem
   * <p>
   * @return String, the title of the BookStoreItem
   */
  String getTitle();

  /** Getter for the year of the BookStoreItem
   * <p>
   * @return int, the year of BookStoreItem
   */
  int getYear();

  /**
   * Getter for the author of the BookStoreItem, a Person
   * <p>
   * @return Person, the author of the BookStoreItem
   */
  Person getAuthor();

  /**
   * Getter for the retail price of the BookStoreItem
   * <p>
   * @return double, the retail price of the BookStoreItem
   */
  double getPrice();

  /**
   * Method to determine if two BookStoreItems have the same author
   * <p>
   * @param other, the other Publication whose author might be same as this
   * @return boolean, true if the authors are the same Person, else false
   */

  // FlawFound: (There is no semi-colon(;) at the end of the method signature. Syntax error.)
  // FlawFixToDo: (Add a semi-colon(;) after "(BookStoreItem other)")
  // FlawFixed (I added a semi-colon(;) to the end of the method signature.)

  boolean sameAuthor(BookStoreItem other);

  /**
   * Method to return the kind of BookStoreItem as a String
   * <p>
   * @return String, the kind of BookStoreItem (eg "Book" or "Magazine")
   */
  String kind();
}
