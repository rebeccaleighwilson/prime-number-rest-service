package rbscodingtest.primenumberrestservice;

import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

public class PrimesControllerTest {

    final int INTITIAL = 1;

    private PrimesService primesService;

    private PrimesController testee;


    @BeforeEach
    void setUp() {
        primesService = Mockito.mock(PrimesService.class);
        Mockito.when(primesService.getPrimesResponse(Mockito.anyInt(), Mockito.anyBoolean())).thenReturn(null);
        testee = new PrimesController(primesService);
    }

    @Test
    public void whenRequestParamBruteForceVerifyServiceInvocation() {
        testee.generate(INTITIAL, "bruteForce");
        Mockito.verify(primesService, times(1)).getPrimesResponse(INTITIAL, true);
    }

    @Test
    public void whenRequestParamNotBruteForceVerifyServiceInvocation() {
        testee.generate(INTITIAL, "notbruteForce");
        Mockito.verify(primesService, times(1)).getPrimesResponse(INTITIAL, false);
    }

    @Test
    public void whenRequestParamSieveVerifyServiceInvocation() {
        testee.generate(INTITIAL, "sieve");
        Mockito.verify(primesService, times(1)).getPrimesResponse(INTITIAL, false);
    }

}
