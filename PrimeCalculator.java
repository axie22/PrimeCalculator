public class PrimeCalculator {
    public void primesTo(int n) throws IllegalArgumentException {
        if (n < 2) {
            throw new IllegalArgumentException("", null);
        }

        System.out.println("Printing primes up to " + n + ":");

        ArrayQueue<Integer> numbers = new ArrayQueue<>(n - 1);
        ArrayQueue<Integer> primes = new ArrayQueue<>(n - 1);

        for (int i = 2; i < n + 1; i++) {
            numbers.enqueue(i);
        }

        // int size = numbers.size();
        // for (int i = 0; i < size; i++) {
        // System.out.println(numbers.dequeue());
        // }

        while (!numbers.isEmpty()) {
            int p = numbers.dequeue();
            primes.enqueue(p);
            int numbersSize = numbers.size();
            for (int i = 0; i < numbersSize; i++) {
                if ((numbers.first() % p) == 0) {
                    numbers.dequeue();
                } else {
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
