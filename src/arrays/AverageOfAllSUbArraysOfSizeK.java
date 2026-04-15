package arrays;

public class AverageOfAllSUbArraysOfSizeK {


    //sudo
    //given an array, get an average of all the average of the arrays of range k
    //

    public static int maxAverageOfSubArrays(int []input , int k){
        int currentAv = 0;
        int maxAve = 0;
        int left = 0;
        int sum = 0;
        //build first window
        for(int i = 0; i < k; i++){
            sum+= input[i];
            currentAv = (sum/k);
            maxAve = Math.max(currentAv, maxAve);


        }

        //iterating from k to end
        for(int right = k; right < input.length -1 ; right++){
            sum += input[right];
            sum-=input[left];
            currentAv = (sum/k);
            maxAve = Math.max(currentAv, maxAve);
        }
        return  maxAve;

    }

}
