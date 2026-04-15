package Strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithAtMostKDistinctCharacters {

    //given a string find the longest substring with at most  k disticnt characters (i.e not more than k diff characters)
    //constraints
    //input : whats the length range of the string , are there blank spaces between the string ? are there special characters ? is it case sensitive ?
    //output: what should i return if string is empty  ?, length of substring or substring
    //perfomance: expected time complexity, can i use extra space

    //eg abceaadb

    //sudo code
    //initialise a hashmap
    //loop through each element in the arrayH
    //check if hashmap includes the element, if so increment the element
    //count the number of keys is less or equal to k , continue looping+
    // else calc maxlENGTH using substring(left, right)  shrink window , increment left , subtract 1 from left key element
    //return subsrting with thw longest

    public String longestSubWithAtMostKChars(String inputString, int k) {

        int left = 0;
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer> hashMap = new HashMap<>();

        for (int right = 0; right < inputString.length(); right++) {
            char rightChar = inputString.charAt(right);

            if (!hashMap.containsKey(rightChar)) {
                // NEW character — add it to the map
                hashMap.put(rightChar, 1);

                // adding a new character might push us over k distinct
                // so shrink from the left until we're back to k
                while (hashMap.size() > k) {
                    char leftChar = inputString.charAt(left);
                    hashMap.put(leftChar, hashMap.get(leftChar) - 1);
                    if (hashMap.get(leftChar) == 0) {
                        hashMap.remove(leftChar);
                    }
                    left++;
                }

            } else {
                // character ALREADY exists — just increase its count
                // no need to shrink because distinct count didn't change
                hashMap.put(rightChar, hashMap.get(rightChar) + 1);
            }

            // after every step, check if current window is the longest
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }

        return inputString.substring(start, start + maxLength);
    }
}
