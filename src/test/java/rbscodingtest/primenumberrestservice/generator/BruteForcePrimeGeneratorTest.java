package rbscodingtest.primenumberrestservice.generator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BruteForcePrimeGeneratorTest {

    private final List<Integer> PRIMES_UP_TO_FIFTY = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);

    private final Integer NUMBER_OF_PRIMES_BELOW_ONE_THOUSAND = 168;

    private static BruteForcePrimeGenerator testee;

    @BeforeAll
    static void setUp(){
        testee = new BruteForcePrimeGenerator();
    }

    @Test
    void primesOfOneShouldReturnNoPrimes(){
        final int input = 1;
        final List<Integer> listOfPrimes = testee.generatePrimesList(input);

        assertEquals(listOfPrimes.size(), 0);
    }

    @Test
    void primesOfTwoShouldReturnOnePrime(){
        final int input = 2;
        final List<Integer> listOfPrimes = testee.generatePrimesList(input);

        assertEquals(1, listOfPrimes.size());
        assertEquals(PRIMES_UP_TO_FIFTY.get(0), listOfPrimes.get(0));
    }

    @Test
    void primesOfThreeShouldReturnTwoPrimes(){
        final int input = 3;
        final List<Integer> listOfPrimes = testee.generatePrimesList(input);

        assertEquals(2, listOfPrimes.size());
        assertEquals(PRIMES_UP_TO_FIFTY.get(0), listOfPrimes.get(0));
        assertEquals(PRIMES_UP_TO_FIFTY.get(1), listOfPrimes.get(1));

    }

    @Test
    void primesOfFourShouldReturnTwoPrimes(){
        final int input = 4;
        final List<Integer> listOfPrimes = testee.generatePrimesList(input);

        assertEquals(2, listOfPrimes.size());
        assertEquals(PRIMES_UP_TO_FIFTY.get(0), listOfPrimes.get(0));
        assertEquals(PRIMES_UP_TO_FIFTY.get(1), listOfPrimes.get(1));
    }

    @Test
    void primesOfFiftyShouldReturnFifteenPrimes(){
        final int input = 50;
        final List<Integer> listOfPrimes = testee.generatePrimesList(input);

        assertEquals(15, listOfPrimes.size());
        assertEquals(PRIMES_UP_TO_FIFTY, listOfPrimes);
    }

    @Test
    void primesOfOneThousandShouldReturn168Numbers(){
        final int input = 1000;
        final List<Integer> listOfPrimes = testee.generatePrimesList(input);

        assertEquals(NUMBER_OF_PRIMES_BELOW_ONE_THOUSAND, listOfPrimes.size());
    }

}
