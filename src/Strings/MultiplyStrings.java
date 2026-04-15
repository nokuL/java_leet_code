package Strings;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;

public class MultiplyStrings {

//given two strings, multiply them
//constraints :
// can i use built in conversion methods ?
//what is the maximum lenth of the string ?
//can there be leading zeros in the number ?
//can the string be empty ? if so what should i convert it to ? 0 ??
//can there be blank spaces between strings ?

//eg "2" * "3"
//numbers range from 0-9
//initalise result  to 0
//if chartAt(0) is '-', negative, throw error
//for each string , loop through each number and get the charAt the index
//convert char to digit value by subtracting charAt(i) - '0' ( this is a way of getting ASCII value of the char, the diff gives us the int value)
//multiply the conversion result by 10 to get the result
//reassign the value to result
//now you have the full integer, do the same for the second int
//multiply the two values , return result of multiplication


    public static int multiplyStrings(String stringA, String stringB){

        int intA = convertToInt(stringA);
        int intB = convertToInt(stringB);

        return intA * intB;

    }

    private static int convertToInt(String input){

        int result = 0;

        if(input.charAt(0) == '-' ){
            throw new IllegalArgumentException("Negative values not allowed");
        }

        if(input.charAt(0) == '-' ){
            throw new IllegalArgumentException("Negative values not allowed");
        }

        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("Blank spaces not allowed");
            }
            int digit = input.charAt(i) - '0';
            result = result * 10 + digit;

        }

        return result;
    }

}
