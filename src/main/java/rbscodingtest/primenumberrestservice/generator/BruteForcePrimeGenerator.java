package rbscodingtest.primenumberrestservice.generator;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BruteForcePrimeGenerator implements PrimeGenerator{

    //Just checking if each number from 2 -> initial is prime...
    public List<Integer> generatePrimesList(final int initial) {
        ArrayList<Integer> listOfPrimes = new ArrayList<>();
        for(int i = 2; i <= initial; i++){
            if(isPrime(i)){
                listOfPrimes.add(i);
            }
        }
        return listOfPrimes;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


}
