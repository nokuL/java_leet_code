package arrays;

import java.util.Arrays;

public class MaxValueOfEachSubArray {

    //given an array of numbers, find the maximum value in each subarray
    //constraints: what is the usual length of the array
    //are there negative values ?
    //is the array ever empty and what is the expected behaviour for such a scenario ?(return 0, throw error ?)
    //

    //sudo code:
    //have two pointers , left to keep track of the start of the array (subarray too)
    //loop throgh the array, start with right = k -1
    //at a particular point (value of right,), get the subarray
    //get the max value and add it to result array
    //when you increment right, increment left by 1
    //return the result array

    public static int [] maxValOfSubArray(int  [] inputArray, int k){

        int [] resultArray = new int[inputArray.length];
        int left = 0;
        for(int right = k -1; right < inputArray.length; right++){
             int [] subArray = Arrays.copyOfRange(inputArray, left, right +1);
             int max =  Arrays.stream(subArray).max().getAsInt();
             resultArray[left] = max;
             left++;
        }
        return resultArray;

    }
}
