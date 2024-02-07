/**
 * This interface contains all operations that all fractions should support.
 */

public interface Fraction extends Comparable<Fraction> {

    /**
     * Returns the integer value of the numerator
     * @return value of numerator
     */
    int getNumerator();

    /**
     * Sets the numerator of the fraction
     * @param numerator
     */
    void setNumerator(int numerator);

    /**
     * Returns the integer value of the denominator
     * @return value of denominator
     */
    int getDenominator();

    /**
     * Sets the denominator of the fraction
     * @param denominator
     */
    void setDenominator(int denominator);

    /**
     * Returns the scientific value (decimal) of the fraction
     * @return decimal value
     */
    double toDouble();

    /**
     * Returns the simplest form of the fraction
     * @return string of the fraction in simplest form
     */
    String toString();

    /**
     * Returns the reciprocal (denominator / numerator) of the fraction
     * @return reciprocal fraction
     */
    Fraction reciprocal();

    /**
     * Compares two fractions with each other
     * @param other fraction
     * @return -1, 1, or 0
     */
    Fraction add(Fraction other);


    /**
     * Compares two fractions
     * if (this < other) return a negative number
     * if (this == other) return 0
     * if (this > other) return a positive number
     * @param other
     * @return the result of the comparison
     */
    int compareTo(Fraction other);
}