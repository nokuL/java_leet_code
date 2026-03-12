
import Strings.Compress;
import Strings.ReverseWords;
import Strings.WellformedString;
import arrays.MaximumProfit;
import sorting.MergeSort;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String [] args) throws Exception {

         int [] input = new int[]{1, 4, 2, 1, 7};
         MergeSort.mergeSort(input, 0, input.length -1);
        System.out.println(Arrays.toString(input));
    }


 }