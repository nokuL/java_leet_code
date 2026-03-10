package Strings;

import java.util.*;

public class WellformedString {

    // given a string, check if it is wellformed
// can the string contain other characters as well ?
// what should i return if it is empty ? false or throw an error ?
// what is the expected length of string ?
// what is the definition of being wellformed ?
// what characters count as brackets ? [](){} only ?

//given a string, check if it is wellformed
//sudo code
//define a hashmap of key, value pairs , opening as keys and closing as values
//loop through the charArray of the string, if char is opening, push to stack
//else if its closing, check if it corresponds with the most recent opening ,
//if it does , then pop the  opening out
//else terminate and return false immediately
//after loop returt stack is empty


    public static boolean isWellFormedString(String input, int maxLength){

        if(input.isEmpty() || (input.isEmpty() || input.length() > maxLength || input == null)){
            throw new IllegalArgumentException("Invalid input string length");
        }

        Map<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');

        Deque<Character> stack = new ArrayDeque<>();

        try{
            for(char character : input.toCharArray()){

                if(hashMap.containsKey(character)){
                    stack.push(character);
                }else if (hashMap.containsValue(character)){
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(hashMap.get(stack.peek()) != character){
                        return false;
                    }
                    stack.pop();


                }
            }

        } catch (Exception e) {
            System.out.println(e);

        }


        return  stack.isEmpty();

    };



}
