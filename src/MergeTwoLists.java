import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MergeTwoLists {


    public static List<Integer> mergeLists(List<Integer>integerList1, List<Integer>integerList2){
        HashSet<Integer>hashSet = new HashSet<>(integerList2);
        integerList1.addAll(hashSet);
        Collections.sort(integerList1);
        return integerList1;

    }


}
