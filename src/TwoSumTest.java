import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TwoSumTest {
    @Test
    public void given_correct_twoSum(){
        int [] arraySum = {2,7, 11,15};
        int target = 9;
        int [] expectedArray = {0, 1};
        Assertions.assertArrayEquals(expectedArray,TwoSum.twoSum(arraySum, target ) );
    }

    @Test
    public void given_incorrect_twoSum(){
        int [] arraySum = {2,7, 11,15};
        int target = 9;
        int [] expectedArray = {1, 1};
        Assertions.assertFalse(Arrays.equals(expectedArray, TwoSum.twoSum(arraySum, target)));
    }

}