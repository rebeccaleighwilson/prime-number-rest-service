package rbscodingtest.primenumberrestservice;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import rbscodingtest.primenumberrestservice.generator.BruteForcePrimeGenerator;
import rbscodingtest.primenumberrestservice.generator.SievePrimeGenerator;
import rbscodingtest.primenumberrestservice.response.PrimesResponse;

@Service
public class PrimesService {

    private final BruteForcePrimeGenerator bruteForcePrimeGenerator;

    private final SievePrimeGenerator sievePrimeGenerator;

    public PrimesService(BruteForcePrimeGenerator bruteForcePrimeGenerator, SievePrimeGenerator sievePrimeGenerator) {
        this.bruteForcePrimeGenerator = bruteForcePrimeGenerator;
        this.sievePrimeGenerator = sievePrimeGenerator;
    }

    @Cacheable("primesResponse")
    public PrimesResponse getPrimesResponse(final int initial, final boolean useBruteForceAlgorithm) {
        if(useBruteForceAlgorithm){
            return new PrimesResponse(initial, bruteForcePrimeGenerator, "BruteForce");
        }
        return new PrimesResponse(initial, sievePrimeGenerator, "SieveOfEratosthenes");
    }

}
