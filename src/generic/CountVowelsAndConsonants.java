package generic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowelsAndConsonants {


    //Given a string, count vowels and consonants

    //constraints
    //is the string ever null
    //is the string ever empty
    //are there blank spaces


    //sudo code
    //declare a vowelCount variable and consonantCount
    //define a hashset to store all vowels
    //loop through the string, check if value is in vowel set , if so, incremet vowel count


    public String  countVowelsAndConsonants(String input){

        int vowelCount = 0;
        int consonantCount = 0;

        HashSet<Character>hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));

        for(char c: input.toCharArray()){

              if(hashSet.contains(c)){
                  vowelCount++;
              }else if(Character.isLetter(c) &&  !hashSet.contains(c)){
                  consonantCount++;

              }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vowel Count : ");
        stringBuilder.append(":");
        stringBuilder.append(vowelCount);
        stringBuilder.append("Consonants Count : ");
        stringBuilder.append(":");
        stringBuilder.append(consonantCount);


        return  stringBuilder.toString();


    }
}
