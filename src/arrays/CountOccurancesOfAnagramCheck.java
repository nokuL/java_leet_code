package arrays;


import java.util.Arrays;

public class CountOccurancesOfAnagramCheck {

    public static  int countOccurancesAnagram(String input , String pattern ){
        //sudo
        //what am i tracking ? count of the occurances of an anagram i.e same letters as in pattern
        //what is k ? its the size of the pattern
        //what am i computing per window ? checking if the letters are an anagram match with the pattern

        int count = 0;
        int [] patternFrequency = new  int [26];
        int [] windowFreqency = new  int [26];


        for(int i = 0; i < pattern.length(); i++){
            //build pattern freq
            patternFrequency[pattern.charAt(i) -'a']++;
        }
        //build first window
        for(int i = 0; i < pattern.length(); i++){
            windowFreqency[input.charAt(i) -'a']++;
        }
        if(Arrays.equals(windowFreqency, patternFrequency)){
            count++;
        }

        for(int right = 0; right < pattern.length(); right++){
            windowFreqency[input.charAt(right)-'a']++;
            windowFreqency[input.charAt(right -pattern.length())-'a']--;
            if(Arrays.equals(windowFreqency, patternFrequency)){
                count++;
            }

        }
        return count;


    }
}
