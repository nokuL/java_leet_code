import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class AddTwoSumsTest {


    @Test
    public void test_correct_sum(){
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(3);

        LinkedList<Integer>linkedList2 = new LinkedList<>();
        linkedList2.add(4);
        linkedList2.add(5);
        linkedList2.add(6);

        LinkedList<Integer>linkedList3 = new LinkedList<>();
        linkedList3.add(9);
        linkedList3.add(7);
        linkedList3.add(5);

        Assertions.assertEquals(linkedList3, AddTwoSums.addTwoSums(linkedList1, linkedList2));
    }


    @Test
    public void test_incorrect_sum(){
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(3);

        LinkedList<Integer>linkedList2 = new LinkedList<>();
        linkedList2.add(5);
        linkedList2.add(5);
        linkedList2.add(5);

        LinkedList<Integer>linkedList3 = new LinkedList<>();
        linkedList3.add(9);
        linkedList3.add(7);
        linkedList3.add(5);


        Assertions.assertNotEquals(linkedList3, AddTwoSums.addTwoSums(linkedList1, linkedList2));
    }

}