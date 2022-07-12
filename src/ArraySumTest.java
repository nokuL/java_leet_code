import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ArraySumTest {

    @Test
    public  void test_correct_sum(){

        List<Integer> integers = new ArrayList<>();
        integers.add(25);
        integers.add(2);
        integers.add(2);
        integers.add(2);

        Assertions.assertEquals(31, ArraySum.arraySum(integers));
    }

    @Test
    public void test_wrong_sum(){
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(2);
        integers.add(2);
        integers.add(2);

        Assertions.assertNotEquals(3, ArraySum.arraySum(integers));

    }

}