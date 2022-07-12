import java.util.List;

public class ArraySum {

    public static int  arraySum(List<Integer> integerList){
        int sum =0;
        for(Integer integer : integerList){
            sum += integer;
        }
        return sum;
    }
}
