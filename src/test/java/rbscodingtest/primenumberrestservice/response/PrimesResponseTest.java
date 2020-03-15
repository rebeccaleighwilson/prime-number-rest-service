package rbscodingtest.primenumberrestservice.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rbscodingtest.primenumberrestservice.generator.PrimeGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static rbscodingtest.primenumberrestservice.PrimesApplicationTests.BRUTE_FORCE_ALGORITHM;
import static rbscodingtest.primenumberrestservice.PrimesApplicationTests.SIEVE_ALGORITHM;


public class PrimesResponseTest {

    private final int INITIAL = 4;

    private PrimeGenerator primeGenerator;

    @BeforeEach
    void setUp(){
        primeGenerator = Mockito.mock(PrimeGenerator.class);
    }

    @Test
    void ifInitialFourThenVerifyInitial(){
        Mockito.when(primeGenerator.generatePrimesList(INITIAL)).thenReturn(Collections.emptyList());
        final PrimesResponse testee = new PrimesResponse(INITIAL, primeGenerator, SIEVE_ALGORITHM);

        assertEquals(INITIAL, testee.getInitial());
    }

    @Test
    void ifGeneratorReturnsEmptyListThenVerifyPrimesList(){
        Mockito.when(primeGenerator.generatePrimesList(INITIAL)).thenReturn(Collections.emptyList());
        final PrimesResponse testee = new PrimesResponse(INITIAL, primeGenerator, SIEVE_ALGORITHM);

        assertTrue(testee.getPrimesList().isEmpty());
    }

    @Test
    void ifGeneratorReturnsListThenVerifyPrimesList(){
        List<Integer> generatedPrimes = Arrays.asList(1, 2, 3);
        Mockito.when(primeGenerator.generatePrimesList(INITIAL)).thenReturn(generatedPrimes);
        final PrimesResponse testee = new PrimesResponse(INITIAL, primeGenerator, SIEVE_ALGORITHM);

        assertEquals(generatedPrimes.size(), testee.getPrimesList().size());
        assertEquals(generatedPrimes, testee.getPrimesList());
    }

    @Test
    void ifAlgorithmSieveThenVerifyObject(){
        List<Integer> generatedPrimes = Arrays.asList(1, 2, 3);
        Mockito.when(primeGenerator.generatePrimesList(INITIAL)).thenReturn(generatedPrimes);
        final PrimesResponse testee = new PrimesResponse(INITIAL, primeGenerator, SIEVE_ALGORITHM);

        assertEquals(SIEVE_ALGORITHM, testee.getAlgorithm());
    }

    @Test
    void ifAlgorithmBruteForceThenVerifyObject(){
        List<Integer> generatedPrimes = Arrays.asList(1, 2, 3);
        Mockito.when(primeGenerator.generatePrimesList(INITIAL)).thenReturn(generatedPrimes);
        final PrimesResponse testee = new PrimesResponse(INITIAL, primeGenerator, BRUTE_FORCE_ALGORITHM);

        assertEquals(BRUTE_FORCE_ALGORITHM, testee.getAlgorithm());
    }

    @Test
    void ifUseDefaultConstructorAndSetterMethodsThenVerifyObject(){
        PrimesResponse testee = new PrimesResponse();

        List<Integer> generatedPrimes = Arrays.asList(1, 2, 3);
        testee.setPrimesList(generatedPrimes);
        testee.setInitial(INITIAL);
        testee.setAlgorithm(SIEVE_ALGORITHM);

        assertEquals(INITIAL, testee.getInitial());
        assertEquals(generatedPrimes, testee.getPrimesList());
        assertEquals(SIEVE_ALGORITHM, testee.getAlgorithm());
    }

}
