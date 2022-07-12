
import java.util.LinkedList;

public class Main {

    public static void main(String [] args){
        LinkedList<Integer>linkedList1 = new LinkedList<>();
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(3);

        LinkedList<Integer>linkedList2 = new LinkedList<>();
        linkedList2.add(5);
        linkedList2.add(5);
        linkedList2.add(3);


        System.out.println("Linked Lists >>>>>>>>>>>>>>>>:"+ AddTwoSums.addTwoSums(linkedList1, linkedList2 ));

    }


 }