package rbscodingtest.primenumberrestservice;


import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PrimesIT {

    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void getPrimesWithPathParamAndVerifyJSONResponse() throws Exception {
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/primes/10"), HttpMethod.GET, entity, String.class);
        String actual = response.getBody();
        String expected = "{\"initial\":10,\"algorithm\":\"SieveOfEratosthenes\",\"primesList\":[2,3,5,7]}";
        assertEquals(expected, actual);
    }

    @Test
    public void getPrimesWithPathParamAndVerifyXMLResponse() throws Exception {
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML.toString());
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/primes/2"), HttpMethod.GET, entity, String.class);
        String actual = response.getBody();
        String expected = "<primesResponse><initial>2</initial><algorithm>SieveOfEratosthenes</algorithm><primesList><prime>2</prime></primesList></primesResponse>";
        assertEquals(expected, actual);
    }

    @Test
    public void getPrimesWithQueryParamAndVerifyJSONResponse() throws Exception {
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/primes/2?algorithm=bruteForce"), HttpMethod.GET, entity, String.class);
        String actual = response.getBody();
        String expected = "{\"initial\":2,\"algorithm\":\"BruteForce\",\"primesList\":[2]}";
        assertEquals(expected, actual);
    }

    @Test
    public void getPrimesWithQueryParamAndVerifyXMLResponse() throws Exception {
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_XML.toString());
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/primes/2?algorithm=sieve"), HttpMethod.GET, entity, String.class);
        String actual = response.getBody();
        String expected = "<primesResponse><initial>2</initial><algorithm>SieveOfEratosthenes</algorithm><primesList><prime>2</prime></primesList></primesResponse>";
        assertEquals(expected, actual);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
