import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MergeTwoListsTest {

    @Test
    public void test_correct_list(){
        List<Integer> arrayList1 = new ArrayList<>();
        arrayList1.addAll( Arrays.asList(1 , 2 , 17, 12, 9, 4));

        List<Integer>arrayList2 = new ArrayList<>();
        arrayList2.addAll(Arrays.asList(3, 5, 19, 28, 16 ));

        List<Integer>arrayList3 = Arrays.asList(1,2,3,4,5, 9, 12, 16, 17, 19, 28);


        Assertions.assertEquals(MergeTwoLists.mergeLists(arrayList1, arrayList2), arrayList3 );

    }

}