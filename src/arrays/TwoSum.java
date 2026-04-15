package arrays;

import java.util.Arrays;

public class TwoSum {

    //given an array and a target , find two numbers that add up to the target
    //what is the expected length range
    //is the array ever empty ? what should it behave like
    //is the array always sorted

    //sudo
    //have two pointers, one starting at left 0 and another at length -1
    //add the two values
    //check if sum == target, return int array with the two values
    //else if sum less than target increment left (because we want to draw closer to the target)
    //else right --
    //if not found find an empty pair


    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        Arrays.sort(numbers);

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}
