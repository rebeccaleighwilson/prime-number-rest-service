package rbscodingtest.primenumberrestservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import rbscodingtest.primenumberrestservice.generator.BruteForcePrimeGenerator;
import rbscodingtest.primenumberrestservice.generator.SievePrimeGenerator;

import static org.mockito.Mockito.times;

public class PrimesServiceTest {

    private PrimesService testee;

    private BruteForcePrimeGenerator bruteForcePrimeGenerator;

    private SievePrimeGenerator sievePrimeGenerator;

    @BeforeEach
    void setUp(){
        bruteForcePrimeGenerator = Mockito.mock(BruteForcePrimeGenerator.class);
        sievePrimeGenerator = Mockito.mock(SievePrimeGenerator.class);
        testee = new PrimesService(bruteForcePrimeGenerator, sievePrimeGenerator);
    }

    @Test
    public void whenUseBruteForceAlgorithmIsFalseUseSieveGenerator() {
        testee.getPrimesResponse(1, false);

        Mockito.verify(sievePrimeGenerator, times(1)).generatePrimesList(Mockito.anyInt());
        Mockito.verify(bruteForcePrimeGenerator, times(0)).generatePrimesList(Mockito.anyInt());
    }

    @Test
    public void whenBruteForceAlgorithmIsTrueUseBruteForceGenerator() {
        testee.getPrimesResponse(1, true);

        Mockito.verify(bruteForcePrimeGenerator, times(1)).generatePrimesList(Mockito.anyInt());
        Mockito.verify(sievePrimeGenerator, times(0)).generatePrimesList(Mockito.anyInt());
    }

}
