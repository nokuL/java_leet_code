package Strings;

import java.util.HashSet;
import java.util.List;

public class MaxNumberOfVowelsInString {

    public static int numberOfVowels(String input, int k){

        //edge case
        if(input.length() < k){
            throw new IllegalArgumentException();
        }
        int count = 0;
        int maxCount = 0;

        HashSet<Character> vowels  = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');


        //build first window
        for(int i = 0; i < k; i++){
            if(vowels.contains(input.charAt(i))){
                count++;

            }
        }
        maxCount = Math.max(count, maxCount);

        for(int right = k ; right < input.length(); right++ ){
            if(vowels.contains(input.charAt(right))){
                count++;

            }
            if(vowels.contains(input.charAt(right - k))){
                count--;
            }
            maxCount = Math.max(count, maxCount);


        }
        return  maxCount;
    }
}
