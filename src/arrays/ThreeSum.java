package arrays;

import java.util.Arrays;

public class ThreeSum {

    //given an array of numbers, find 3 numbers whose sum is closest to


    // sort the array
// get the first sum as sum of the 1st three numbers (closestSum)
// loop through the array, starting from i = 0 to length - 2
//     initialise left = i + 1
//     right = array.length - 1
//     while left less than right
//         currentSum = nums[i] + nums[left] + nums[right]
//         if currentSum == target, return target
//         if Math.abs(currentSum - target) < Math.abs(closestSum - target)
//             closestSum = currentSum
//         if currentSum > target, right-- else left++
// return closestSum


    public static int[] threeSum(int[] inputArray, int target) {
        Arrays.sort(inputArray);
        int closestSum = inputArray[0] + inputArray[1] + inputArray[2];

        for (int i = 0; i < inputArray.length - 2; i++) {
            int left = i + 1;                    // ← moves with i, not fixed
            int right = inputArray.length - 1;

            while (left < right) {
                int sum = inputArray[i] + inputArray[left] + inputArray[right];

                if (sum == target) {
                    // found exact match, return immediately
                    return new int[]{inputArray[i], inputArray[left], inputArray[right]};
                }

                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        // find the actual triplet that made closestSum
        // (or just return closestSum as an int if that's all you need)
        return new int[]{closestSum};
    }
}
