package generic;

public class PrimeNumberCheck {

    //given a number , check if its a prime number

    //loop from 2 up to just before the number
    //do a modulo calculation the number by the current i (loop counter)
    //if result is zero at any point, that number is not a prime number
    //

    public boolean primeNumberCheck(int n){

        boolean isPrime = true;

        for(int i = 2 ; i < n; i++){
            if(n % i == 0){
                return isPrime = false;
            }
        }
        return  isPrime;
    }
}
