package rbscodingtest.primenumberrestservice.generator;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SievePrimeGenerator implements PrimeGenerator{

    //using this algorithm to find primes...
    //https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    public List<Integer> generatePrimesList(final int initial) {
        //whether a number n is prime or not is represented by the boolean at primes[n - 2];
        Boolean[] primes = constructArrayOfTrues(initial);

        //Once we've removed multiples of all numbers <= sqrt(initial) the result won't change
        final double maxIndexToCheck = Math.sqrt(initial) - 2;

        //start with the number 2 (the smallest prime), represented by primes[0]
        for(int i = 0; i <= maxIndexToCheck; i++){
            setMultiplesToFalse(i + 2, primes);
        }
        return condenseTrueNumbers(primes);
    }

    private void setMultiplesToFalse(final int number, Boolean[] primesList){
        //remember, the number n is represented by the boolean value at index n - 2
        //if the number is already marked as false then all its multiples will have been marked too
        int indexOfNumber = number - 2;
        if(primesList[indexOfNumber]) {
            int indexOfFirstMultiple = indexOfNumber + number;
            for (int i = indexOfFirstMultiple; i < primesList.length; i += number) {
                primesList[i] = false;
            }
        }
    }

    private List<Integer> condenseTrueNumbers(final Boolean[] primes) {
        ArrayList<Integer> condensedList = new ArrayList<>();
        for(int i = 0; i < primes.length; i++){
            if(primes[i]){
                //adding two here to convert index to number
                condensedList.add(i + 2);
            }
        }
        return condensedList;
    }

    private Boolean[] constructArrayOfTrues(final int initial) {
        //array will represent possible prime numbers from [2, ... initial]
        //array indexes will be from [0, ... initial - 2]
        Boolean[] trueValues = new Boolean[initial - 1];
        for(int i = 0; i < initial - 1; i++){
            trueValues[i] = true;
        }
        return trueValues;
    }
}
