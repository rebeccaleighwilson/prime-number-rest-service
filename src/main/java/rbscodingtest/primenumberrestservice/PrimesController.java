package rbscodingtest.primenumberrestservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rbscodingtest.primenumberrestservice.response.PrimesResponse;

@RestController
public class PrimesController {

    private final PrimesService primesService;

    public PrimesController(PrimesService primesService) {
        this.primesService = primesService;
    }

    @GetMapping(value = "/primes/{prime}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PrimesResponse generate(@PathVariable int prime, @RequestParam(defaultValue = "sieve") String algorithm) {
        if(("bruteforce").equalsIgnoreCase(algorithm)){
            return primesService.getPrimesResponse(prime, true);
        }
        return primesService.getPrimesResponse(prime, false);

    }


}
