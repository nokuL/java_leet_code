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

                hashMap.put(arrayA[i], hashMap.getOrDefault(arrayA[i], 0)+1);

        }
        for(int i = 0; i< arrayB.length; i++ ){
                hashMap.put(arrayB[i], hashMap.getOrDefault(arrayB[i], 0)-1);

        }

        for (int count : hashMap.values()) {
            if(count != 0){
                return false;
            }
        }

        return true;

    }


}
