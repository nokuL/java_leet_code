package arrays;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {

    //given an array, get a list of all subsets from it
    //constraints, whats the size of the array
    //are elements always different ? are they ever all the same ?
    //what happens is array is empty ?


    //using backtracking
    //save before loop
    //add to current
    //explore
    //remove

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {

        result.add(new ArrayList<>(current));       // Bug 1: need a COPY, not the same list
        for (int i = start; i < nums.length; i++) { // Bug 2: i starts at "start", not 0
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
