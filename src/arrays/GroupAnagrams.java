package arrays;

import java.util.*;

public class GroupAnagrams {

    //given an array of items, group anagrams together
    //constarints:
    //is this case sensitive ?
    //are the empty strings?
    //what should i return if there is no match

    //sudo code
    //initialise a hashmap , with String, List[String]
    //for each element in the
    //if hashmap doesnt contain element as key, create a new array, add the sorted element, add element as is in list, add list under hasmap key of sorted dtring

    public static List<List<String>>groupAnagrams(String [] inputArray){

         Map<String, List<String>> hashmap = new HashMap<>();
         for(String s : inputArray){
             char [] chars = s.toCharArray();
             Arrays.sort(chars);
             String key = new String(chars);
             if(!hashmap.containsKey(key)){
                 hashmap.put(key, new ArrayList<>());
              }
             hashmap.get(key).add(s);
         }

         return new ArrayList<>(hashmap.values());



    }
}
