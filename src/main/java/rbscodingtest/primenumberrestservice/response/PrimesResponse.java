package rbscodingtest.primenumberrestservice.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import rbscodingtest.primenumberrestservice.generator.PrimeGenerator;

import java.util.List;

@JacksonXmlRootElement(localName = "primesResponse")
//@XmlRootElement
public class PrimesResponse {

    private int initial;

    private String algorithm;

    @JacksonXmlElementWrapper(localName = "primesList")
    @JacksonXmlProperty(localName = "prime")
    private List<Integer> primesList;

    public PrimesResponse() {
    }

    public PrimesResponse(final int initial, final PrimeGenerator primeGenerator, final String algorithm) {
        this.initial = initial;
        this.primesList = primeGenerator.generatePrimesList(initial);
        this.algorithm = algorithm;
    }

    public int getInitial() {
        return initial;
    }

    public List<Integer> getPrimesList() {
        return primesList;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setInitial(final int initial) {
        this.initial = initial;
    }

    public void setPrimesList(final List<Integer> primesList) {
        this.primesList = primesList;
    }

    public void setAlgorithm(final String algorithm) {
        this.algorithm = algorithm;
    }
}
