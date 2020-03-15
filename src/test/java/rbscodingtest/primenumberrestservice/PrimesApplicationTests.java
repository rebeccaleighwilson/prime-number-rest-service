package rbscodingtest.primenumberrestservice;

import org.hamcrest.Matchers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PrimesApplicationTests {

    public static final String SIEVE_ALGORITHM = "SieveOfEratosthenes";

    public static final String BRUTE_FORCE_ALGORITHM = "BruteForce";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void givenPrimesCallParamOneAcceptJSONVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/primes/1")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.initial", Matchers.is(1)))
                .andExpect(jsonPath("$.primesList", Matchers.empty()))
                .andExpect(jsonPath("$.algorithm", Matchers.is(SIEVE_ALGORITHM)));
    }

    @Test
    public void givenPrimesCallParamOneAcceptXMLVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/primes/1")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML))
                .andExpect(xpath("primesResponse/initial").number(equalTo((double) 1)))
                .andExpect(xpath("primesResponse/primesList").exists())
                .andExpect(xpath("primesResponse/primesList/prime").nodeCount(0))
                .andExpect(xpath("primesResponse/algorithm").string(SIEVE_ALGORITHM));
    }

    @Test
    public void givenPrimesCallParamTwoAcceptJSONVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/primes/2")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.initial", Matchers.is(2)))
                .andExpect(jsonPath("$.primesList", hasItem(2)))
                .andExpect(jsonPath("$.algorithm", Matchers.is(SIEVE_ALGORITHM)));
    }

    @Test
    public void givenPrimesCallParamTwoAcceptXMLVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/primes/2")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML))
                .andExpect(xpath("primesResponse/initial").number(equalTo((double) 2)))
                .andExpect(xpath("primesResponse/primesList/prime").nodeCount(1))
                .andExpect(xpath("primesResponse/primesList/prime[1]").number(equalTo((double) 2)))
                .andExpect(xpath("primesResponse/algorithm").string(SIEVE_ALGORITHM));
    }

    @Test
    public void givenPrimesCallParamTenAcceptJSONVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/primes/10")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.initial", Matchers.is(10)))
                .andExpect(jsonPath("$.primesList", hasItem(2)))
                .andExpect(jsonPath("$.primesList", hasItem(3)))
                .andExpect(jsonPath("$.primesList", hasItem(5)))
                .andExpect(jsonPath("$.primesList", hasItem(7)))
                .andExpect(jsonPath("$.algorithm", Matchers.is(SIEVE_ALGORITHM)));
    }

    @Test
    public void givenPrimesCallParamTenAcceptXMLVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/primes/10")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_XML))
                .andExpect(xpath("primesResponse/initial").number(equalTo((double) 10)))
                .andExpect(xpath("primesResponse/primesList/prime").nodeCount(4))
                .andExpect(xpath("primesResponse/primesList/prime[1]").number(equalTo((double) 2)))
                .andExpect(xpath("primesResponse/primesList/prime[2]").number(equalTo((double) 3)))
                .andExpect(xpath("primesResponse/primesList/prime[3]").number(equalTo((double) 5)))
                .andExpect(xpath("primesResponse/primesList/prime[4]").number(equalTo((double) 7)))
                .andExpect(xpath("primesResponse/algorithm").string(SIEVE_ALGORITHM));
    }

    @Test
    public void givenPrimesCallNoAcceptHeaderVerifyResponseJSON() throws Exception {

        this.mockMvc.perform(get("/primes/1")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.algorithm", Matchers.is(SIEVE_ALGORITHM)));
    }


    @Test
    public void givenPrimesCallParamsOneAndBruteForceVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/primes/1?algorithm=bruteforce")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.algorithm", Matchers.is(BRUTE_FORCE_ALGORITHM)));
    }

    @Test
    public void givenPrimesCallParamTwoAndBruteForceVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/primes/2?algorithm=bruteforce")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.initial", Matchers.is(2)))
                .andExpect(jsonPath("$.primesList", hasItem(2)))
                .andExpect(jsonPath("$.algorithm", Matchers.is(BRUTE_FORCE_ALGORITHM)));;
    }

    @Test
    public void givenPrimesCallParamTenAndBruteForceVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/primes/10?algorithm=bruteforce")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.initial", Matchers.is(10)))
                .andExpect(jsonPath("$.primesList", hasItem(2)))
                .andExpect(jsonPath("$.primesList", hasItem(3)))
                .andExpect(jsonPath("$.primesList", hasItem(5)))
                .andExpect(jsonPath("$.primesList", hasItem(7)))
                .andExpect(jsonPath("$.algorithm", Matchers.is(BRUTE_FORCE_ALGORITHM)));;
    }

}
