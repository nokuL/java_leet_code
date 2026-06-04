package Strings;

public class AppendCharAtNthVal {


    private static String insertCharAtNthIndex(String inputVal , int n, char character){

     //given a value of  a string, insert a # at every 2nd element

        //constraints
        //is length of string always greater than n ? if not what am i supposed to return ? the string as is or throw an error ?
        //what is the expected length range of inputVal ?
        //is inputVal ever null or empty ?
        //is n always positive ? what should i return if it negative ? throw an error or return the input val string ?

        //sudo code
        //instantiate a stringbuilder object to append values to
        //declare index at 1 to count
        //loop through the string,
        //if (index value +1 ) % n == 0, append #
        //else append value charAt
        //return stringbuilder

        if(inputVal == null){
            throw new IllegalArgumentException("Value cant be null");
        }
        if(n <= 0){
            throw new IllegalArgumentException("N cant be zero");
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < inputVal.length(); i++){
            result.append(inputVal.charAt(i));
            if((i+1) % n ==0){
                result.append("#");
            }

        }
        return  result.toString();



    }
}
