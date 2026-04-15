package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindDuplicatesInAnArray {



    //sudo code
    //initialise a hashmap
    //loop through the array
    //add element to array if its not there, if it is add ti to result array
    //return result array

    //sudo without extra space
    //initialise count
    //start index at 1
    //sort array
    //loop through array
    //check if el at  1 is eq to element at 0
    // if they are, increment count , add elemet to result array
    //if they are not, rest count to zero

   //using extra space
 /*   public static List<Integer> findDuplicates(int [] input){
        HashMap < Integer, Integer> hashMap = new HashMap<>();
        List<Integer> resultArray = new ArrayList<>();
        for(int i = 0; i<input.length; i++ ){
            if(!hashMap.containsKey(input[i])){
                hashMap.put(input[i], hashMap.getOrDefault(input[i], 0)+1);

            }else{
               resultArray.add(input[i]);

            }

        }
        return  resultArray;
    }*/

    public static List<Integer> findDuplicates(int [] input){
        Arrays.sort(input);
        List<Integer>result = new ArrayList<>();
        int count = 1;
        for(int j = 1; j< input.length; j ++){
            if(input[j] == input[j -1]){
                if(!result.contains(input[j])){
                    result.add(input[j]);
                }
            }

        }
        return  result;
    }


}
