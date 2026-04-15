package arrays;

public class MaxSubArrayOfK {

    //given array find the maximum sum subarray of  size k
    //constraints:
    //input: what is the length range of the input , are they all positive numbers ? is the array ever empty ? is the array ever smaller than k ?
    //output: return length of subarray or subarray itself ?
    //performance: should length be

    //sudo code
    //to find max sum of subarray with size k
    //first find the first sum value by looping from 0 up to k, we will then subtract values from this (shrink and expand based on this value)
    //after getting the first sum,
    //loop through reminder array, starting right at k-1 u
    //subtract value at left , increment left
    //add value at right +1

    public static int maxSumOfArray(int [] input, int k){

        int sum = 0;
        int left = 0;
        int maxSUm = 0;
       //building first window
        for(int i = 0; i < k; i++){
            sum += input[i];
            maxSUm = sum;
        }

        for(int right = k ; right < input.length; right++){
             sum-= input[left];
             sum+=input[right];
             left++;

             maxSUm = Math.max(sum, maxSUm );
        }


     return  maxSUm;
    }


}
