package Strings;

import java.util.HashMap;
import java.util.Map;

public class AnagramCheck {
    // given two strings, check if they contain the same values regardless of order
    //given an string, convert it to charArray
    //decñare a hasmpa with characte as key and count as value
    //loop through the first array ,add element to map. icrement if an element is in the first array
    //loop through second array, decrement is its in the second array
    //get all values of counts, check if there is anyother value than 0
    //If there is..its not anagram

    public boolean anagramCheck(String  stringA, String stringB){

        char [] arrayA = stringA.toCharArray();
        char [] arrayB  = stringB.toCharArray();

        Map<Character, Integer> hashMap = new HashMap<>();

        if (arrayA.length != arrayB.length) return false;
        for(int i = 0; i< arrayA.length ; i++){

                hashMap.merge(arrayA[i], 1, Integer::sum);

        }
        for(int i = 0; i< arrayB.length; i++ ){
                hashMap.merge(arrayB[i], -1, Integer::sum);

        }

        for (int count : hashMap.values()) {
            if(count != 0){
                return false;
            }
        }

        return true;

    }


}
