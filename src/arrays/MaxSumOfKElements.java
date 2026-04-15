package arrays;

public class MaxSumOfKElements {



    public static int maxSumOfKElements(int [] input, int k){

        int maxSum = 0;
        int currentSum = 0;
        int left = 0;

        if(input.length < k){
            throw new IllegalArgumentException("Invalid array length !");
        }

        //build the first window and sum
        for(int i = 0; i < k; i++ ){
            currentSum += input[i];
            maxSum = currentSum;

        }

        //looping from k upto end of string
      for(int right = k; right < input.length -1; right++ ){
          currentSum -= input[left];
          currentSum += input[right];
          left++;

          maxSum = Math.max(currentSum, maxSum);
      }
      return  maxSum;
    }
}

