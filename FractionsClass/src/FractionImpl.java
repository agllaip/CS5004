public class FractionImpl implements Fraction {

    private int numerator;
    private int denominator;

/** Construct a Fraction object that has the provided numerator and denominator.
 * @param numerator the integer value of the numerator of fraction
 * @param denominator the integer value of the denominator of fraction
 */

public FractionImpl(int numerator, int denominator) throws IllegalArgumentException {

    // Checks if the denominator is negative or 0
    if (denominator <= 0) {
        throw new IllegalArgumentException("Denominator must be a positive value and greater than 0.");
    }

    this.numerator = numerator;
    this.denominator = denominator;
}
// Getter
@Override
public int getNumerator() {
    return numerator;
}

// Setter
@Override
public void setNumerator(int numerator) {
    this.numerator = numerator;
}

// Getter
@Override
public int getDenominator() {
    return denominator;
}

// Setter
@Override
public void setDenominator(int denominator) {

    if (denominator < 0) {
        numerator = -numerator;
        denominator = -denominator;
    }

    this.denominator = denominator;
}

@Override
public double toDouble() {
    return (double) numerator / denominator;
}

// Calculate the greatest common divisor (GCD) of two numbers using the Euclidean algorithm
public static int gcd(int numerator, int denominator) {

    if (denominator == 0) {
        return numerator;
    }

    return gcd(denominator, numerator % denominator);
}

@Override
public String toString() {
    // Call gcd function to find the common factor
    // Use Math.abs to ensure finding the GCD based on the positive value of the numerator
    int commonFactor = gcd(Math.abs(numerator), denominator);
    // Simplify the fraction and return the simplified fraction
    return numerator / commonFactor + " / " + denominator / commonFactor;
}

@Override
public Fraction reciprocal() throws IllegalArgumentException {

    if (numerator <= 0) {
        throw new IllegalArgumentException("Reciprocal cannot be calculated if the numerator is 0.");
    }

    return new FractionImpl(denominator, numerator);
}

@Override
public Fraction add(Fraction other) {
    // Calculate common denominator (= product of two denominators)
    int commonDenominator = denominator * other.getDenominator();

    if (commonDenominator == 0) {
        throw new IllegalArgumentException("Common denominator cannot be 0.");
    }

    // Calculate the new numerator (cross multiplication and then add the numerators)
    int newNumerator = (numerator * other.getDenominator()) + (other.getNumerator() * denominator);
    // Result of the addition of two fractions
    return new FractionImpl(newNumerator, commonDenominator);
}

// Returns: - int if (this < other), + int if (this > other), 0 if (this = other)
@Override
public int compareTo(Fraction other) {
    double thisFraction = this.toDouble();
    double otherFraction = other.toDouble();

    if (thisFraction < otherFraction) {
        return -1;
    }
    else if (thisFraction > otherFraction) {
        return 1;
    }
    else {
        return 0;
    }
    }
}