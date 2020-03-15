package rbscodingtest.primenumberrestservice.generator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SievePrimeGeneratorTest {

    private final List<Integer> PRIMES_UP_TO_FIFTY = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);

    private final Integer NUMBER_OF_PRIMES_BELOW_ONE_THOUSAND = 168;

    private static SievePrimeGenerator testee;

    @BeforeAll
    static void setUp(){
        testee = new SievePrimeGenerator();
    }

    @Test
    void primesOfOneShouldReturnNoPrimes(){
        final int initial = 1;
        final List<Integer> listOfPrimes = testee.generatePrimesList(initial);

        assertEquals(listOfPrimes.size(), 0);
    }

    @Test
    void primesOfTwoShouldReturnOnePrime(){
        final int initial = 2;
        final List<Integer> listOfPrimes = testee.generatePrimesList(initial);

        assertEquals(1, listOfPrimes.size());
        assertEquals(PRIMES_UP_TO_FIFTY.get(0), listOfPrimes.get(0));
    }

    @Test
    void primesOfThreeShouldReturnTwoPrimes(){
        final int initial = 3;
        final List<Integer> listOfPrimes = testee.generatePrimesList(initial);

        assertEquals(2, listOfPrimes.size());
        assertEquals(PRIMES_UP_TO_FIFTY.get(0), listOfPrimes.get(0));
        assertEquals(PRIMES_UP_TO_FIFTY.get(1), listOfPrimes.get(1));

    }

    @Test
    void primesOfFourShouldReturnTwoPrimes(){
        final int initial = 4;
        final List<Integer> listOfPrimes = testee.generatePrimesList(initial);

        assertEquals(2, listOfPrimes.size());
        assertEquals(PRIMES_UP_TO_FIFTY.get(0), listOfPrimes.get(0));
        assertEquals(PRIMES_UP_TO_FIFTY.get(1), listOfPrimes.get(1));
    }

    @Test
    void primesOfFiftyShouldReturnFifteenPrimes(){
        final int initial = 50;
        final List<Integer> listOfPrimes = testee.generatePrimesList(initial);

        assertEquals(15, listOfPrimes.size());
        assertEquals(PRIMES_UP_TO_FIFTY, listOfPrimes);
    }

    @Test
    void primesOfOneThousandShouldReturn168Primes(){
        final int initial = 1000;
        final List<Integer> listOfPrimes = testee.generatePrimesList(initial);

        assertEquals(NUMBER_OF_PRIMES_BELOW_ONE_THOUSAND, listOfPrimes.size());
    }

}
