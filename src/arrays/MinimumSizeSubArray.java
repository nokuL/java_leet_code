package arrays;

public class MinimumSizeSubArray {

    //Given an array of positive integers and a target,
    // find the shortest subarray whose sum is greater than or equal to the target. Return the length. If none exists, return 0.
    //constraints:
    //input: expected max length or array ? Are there negative numbers ? is the array ever empty ? can the target be zero or negative
    //output: return the length or the subarray or the array itself ?
    //performance: acceptable time complexity ? can i use extra space ?


    //sudo code
    //given an array, find the shortest subarray whose sum is greater than or equal to the target
    //initialise minlength to Integer.max
    //initialise sum = 0
    //initialise left and right both to start at 0
    //loop the array , incrementing right
    //for each item, calculate sum
    //while sum greater than equal target
    //calculate minLength = min(minlength , right - left +1)
    //shrink but subtracting element at left
    //subtract element of left from the sum
    //increment left
    //return minLength == Integer.max ? 0:  minLength


    public static int minSizeSubArray(int [] input, int target){
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for(int right = 0; right < input.length; right++){

            sum += input[right];
            while (sum >= target){
                //shrink by subtracting left element from
                minLength = Math.min(minLength, (right - left)+1);
                sum -= input[left];
                left++;

            }

        }
        return minLength == Integer.MAX_VALUE ? 0: minLength;

    }

}
