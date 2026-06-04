package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindElementsThatAppearMoreThanOnce {


    //given a string , find characters that appear more than once

    //constraints
    //Are there ever blank spaces between the string ?
    //is the string ever null ?
    //is it ever empty
    //is it case sensitive ?
    //how do you want the output ? unique values or each occurance ?

    //sudo code
    //define a hashmap Character, Integer
    //loop through the input string, inserting elements incrementally
    //get the values loop through the keys
    //if any value is greater than 1 , insert in a result list
    //


    public List<Character> elementsMorethanOnce(String input){

        List<Character> result = new ArrayList<>();
        HashMap<Character, Integer > hashMap = new HashMap<>();
        for(char c : input.toCharArray()){
            hashMap.merge(c, 1, Integer::sum);
        }
        for(char c : hashMap.keySet()){
            if(hashMap.get(c) >1){
                result.add(c);

            }

        }
        return result;
    }
}
