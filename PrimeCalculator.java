/*
 * Submitted by Alex Xie, anx201
 * October 10, 2023
 * The PrimeCalculator class uses an ArrayQueue to calculate all primes from 2 to a given integer n
 */

public class PrimeCalculator {

    /**
     * Prints out primes from 2 to n
     * Raises an exception if n is less than 2
     * 
     * @param n represents what number to calculate primes up to
     * @throws IllegalArgumentException throws an exception if n is less than 2
     */
    public void primesTo(int n) throws IllegalArgumentException {
        if (n < 2) {
            throw new IllegalArgumentException("", null);
        }
        System.out.println("Printing primes up to " + n + ":");

        // Declare an Queue of size n - 1 since 1 will not be considered
        ArrayQueue<Integer> numbers = new ArrayQueue<>(n - 1);
        // never more primes than numbers so make them the same size
        ArrayQueue<Integer> primes = new ArrayQueue<>(n - 1);

        for (int i = 2; i < n + 1; i++) {
            numbers.enqueue(i);
        }

        // while numbers is not empty, check and dequeue numbers that are divisible
        while (!numbers.isEmpty()) {
            int p = numbers.dequeue();
            primes.enqueue(p);
            int numbersSize = numbers.size();
            for (int i = 0; i < numbersSize; i++) {
                // if the first number divides p
                if ((numbers.first() % p) == 0) {
                    numbers.dequeue();
                } else {
                    // put it back in the back of the queue
                    numbers.enqueue(numbers.dequeue());
                }

            }
        }

        int sz = primes.size();
        for (int i = 0; i < sz; i++) {
            if (i != (sz - 1)) {
                System.out.print(primes.dequeue() + ", ");
            } else {
                System.out.println(primes.dequeue() + ".");
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        try {
            new PrimeCalculator().primesTo(20);
            new PrimeCalculator().primesTo(2);
            new PrimeCalculator().primesTo(0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: Input must be a number greater than or equal to 2.");
        }
    }
}
