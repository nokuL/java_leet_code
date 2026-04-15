package Strings;

import java.util.HashSet;

public class LongestSubstringWIthoutRepeatingCharacters {


    //given a string , find the longest substring without repeating characters
    //constraints :
    //input : what is the expected length range of the input string ? is the problem case sensitive ? are there blank spaces ? can the string be empty ?
    //output: if string is empty what is expected output ?should i return length of the string or the actual string ? if there are multiple strings with same length ,
    //return any or all ?
    //performance: what is the acceptance time complexity ? O(n) or 0(n2) Can i use extra space ?


    //sudo code;
    //initialise 2 pointers, left and right both at 0
    //have a hashset to track elements
    //loop from 0, incrementing right, up to length -1
    //as you loop, check if element is in set, if not, add to set, calculate length of set
    //if it is in set already, remove left element, increment left
    //loop again
    //return maxlenth

    public static int longestSubstring(String input){

        int left = 0,maxLength = 0;
        HashSet<Character>hashSet = new HashSet<>();
        for(int right = 0; right < input.length(); right++){
            if(!hashSet.contains(input.charAt(right))){
                hashSet.add(input.charAt(right));
                maxLength = Math.max(maxLength, hashSet.size() );
            }else{
                hashSet.remove(input.charAt(right));
                left ++;

            }

        }
        return  maxLength;
    }




}
