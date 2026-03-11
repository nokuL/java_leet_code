import java.util.Arrays;

public class MaximumSumOfSubArray {

    //given an array of elements , find the mazimum sum of a subarray
    //inititae currentSum = array[0] because we will have to sum first element
    //initiate tempStart = 0 , to track our starting points of our arrays
    //initiate maxSum = array[0] thats where we are starting
    //initiate startIndex , endIndex  = 0
    //loop through the array, checking is if current is still worth keeping i.e is currentsum less than 0
    //if currentSum less than 0, reset i.e currentSum = array[i], update the tempStart variable to i
    //else continue i.e currentsum += array[i]
    //if currentSum greater than maxSum , assign currentSum to maxSum
    //endIndex is i , because thats the point we have reached with the endIndex so far
    //return a subArray starting from start to end

    public static int [] maximumSubArraySum(int [] inputArray){

        int currentSum = inputArray[0];
        int maxSum = inputArray[0];
        int tempStart = 0;
        int startIndex = 0;
        int endIndex = 0;

        for(int i = 0; i < inputArray.length; i++){
            if(currentSum < 0 ){
                //reset
                currentSum = inputArray[i];
                tempStart = i;
            }else{
                currentSum += inputArray[i];
            }

            if(currentSum > maxSum){
                maxSum = currentSum;
                startIndex = tempStart;
                endIndex = i;

            }

        }
        return Arrays.copyOfRange(inputArray, startIndex, endIndex+1);

    }

}
