package Strings;
import java.util.HashMap;
import java.util.Optional;

public class HighestFrequencyCharacter {

    //given a string, find the character with the highest frequency
    //constraints (eg Successful)
    //Is it case sensitive
    //are there ever blank spaces between a give string
    //is it ever null and how is the program expected to behave
    //whats the expected length range or the string ?
    //is the string ever empty ?
    //if two characters have the same freq , what is the expected behevior ? return a list ? or


    //sudo code
    //define a hashmap to store each value against the key
    //loop through the string , inserting elements in the hashmap, increase value at each iteration
    //getValues from hashmap, get the highest value from that list
    //find the corresponding Key in the hashmap


    public Optional<Character> highestFreq(String input){

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = 0;
        char maxChar = input.charAt(0);
         for(char c : input.toCharArray()){
             int newFreq = hashMap.getOrDefault(c, 0)+1;
             hashMap.put(c, newFreq);
             if(newFreq > max){
                 max = newFreq;
                 maxChar = c;

             }
         }


   return  Optional.of(maxChar);
    }


}
