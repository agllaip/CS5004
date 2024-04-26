/**
 * Represents a Magazine, which has title, author, year, month, price.
 * <p>
 * Also has Kind "Magazine" computed by method in AbstractBookStoreItem.
 */
public class Magazine extends AbstractBookStoreItem {
  // title, author, year, price are protected fields from parent
  // Only Magazines have a month field, though (an Enum type)
  private Month month;

  /**
   * Construct a Magazine with provided title, author, year, month, price
   * <p>
   * @param title  the title to be given to this book
   * @param author the author to be given to this book
   * @param year   the year of publication of the Magazine
   * @param month  the month of publication of the Magazine
   * @param price  the price to be assigned to this book
   * Unlike Books, Magazines also have a month of publication (an enum)
   */
  public Magazine(String title, Person author, int year, Month month, double price) {
    super(title,author,year,price);
    this.month = month;
  }

  /**
   * Method getMonth gets the month of this Magazine as constructed
   * <p>
   * @return Month, an enum representing the month of publication
   * NB: This method is NOT part of the interface for BookStoreItem!
   */
  public Month getMonth() {
    return this.month;
  }

  /**
   * Checks if two Magazines have the same author
   * <p>
   * @param other, the other author
   * @return boolean, true iff the authors are equal
   */

  // DON'T COUNT
  // FlawFound: (@param in Javadocs. It says the parameter other is "the other Publication"
  // but it is not another publication is another author we are comparing.)
  // FlawFixToDo: (Change "publication" to "author")
  // FlawFixed: (Changed "publication" to "author" in the Javadocs.)

  @Override
  public boolean sameAuthor(BookStoreItem other) {
    // Get the two authors and hand to equals
    Person author1 = this.getAuthor();
    Person author2 = other.getAuthor();
    return author1.equals(author2);
  }

  /**
   * Method toString() returns a formatted String about this Magazine.
   * <p>
   * The resulting String should be in the following format:
   *     Kind: the Kind of Publication ("Magazine")
   *     Title: title of the magazine
   *     Author: first-name last-name
   *     Year: four digit year
   *     Month: valueOf month (in title case)
   *     Price: in dollars, as decimal number, w 2 digits after decimal point
   * <p>
   * @return the String, formatted as shown
   */

  // DON'T COUNT
  // FlawFound: (@Override included above toString method. toString method is not defined
  // in the Interface and so it does not need @Override.)
  // FlawFixToDo: (Remove @Override)
  // FlawFixed: (Removed @Override from the line above the start of the toString method)

  public String toString() {
    String str;
    str = "Kind: " + this.kind() +
          "\nTitle: " + this.title +
          "\nAuthor: " + this.author.toString() +
          "\nYear: " + this.year +
          "\nMonth: " + this.month.toString();
    str = str + String.format("\nPrice: %.2f", price);
    return str;
  }

  /**
   * Check if two magazines are equal based on all fields except price
   * <p>
   * @param other, the other object to compare this to
   * @return true iff they are considered equal
   */

  // FlawFound: (The Javadocs specifically says to check equality based on all fields
  // "except price" yet price is included in the equals method code.)
  // FlawFixToDo: (Remove the line that is comparing the prices in the equals method)
  // FlawFixed: (Removed the code: "Math.abs(this.price - otherMag.price) < 0.001" because this
  // is comparing the price and the Javadocs explicitly say no price comparison.)

  @Override
  public boolean equals(Object other) {
    // Check if identical
    if (this == other)
      return true;
    // Check if null
    if (other == null)
      return false;
    // Check type compatibility
    if (!(other instanceof Magazine))
      return false;
    // Cast to Magazine type
    Magazine otherMag = (Magazine) other;
    // Compare fields
    return this.title.equals(otherMag.title)
        && this.author.equals(otherMag.author)
        && this.year == otherMag.year;
  }
}
