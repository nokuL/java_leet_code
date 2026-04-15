package Strings;

public class LongestCommonPrefix {

    //given an array of strings, find the longest common prefix
    //constraints:
    //what is the expected length range of an array ?
    //are there ever blank strings ?
    //are there ever blank spaces between strings ?
    //is this problem case sensitive ?


    //sudo
    //get the 1st element of the array as a whole
    //assign it to the commonPrefix
    //looop through the rest of the array
    //compare elements of prefixstring and current arraystring, if the elements are the same, continue, else exit the loop, assign new prefix to last point where the elements matched
    // and move to the next element
    //


    public static String longestCommonPrefix(String [] inputString){

        String prefix = inputString[0];
        for(int i = 1; i < inputString.length; i++){
            String currentString = inputString[i];
            int left = 0;
            int minLength = Math.min(prefix.length(), currentString.length());
            while(left < minLength ){
                if(prefix.charAt(left) == currentString.charAt(left)){
                    left++;
                }else{
                    break;
                }
                prefix = prefix.substring(0, left+1);


            }
            if (prefix.isEmpty()) return "";
        }
        return  prefix;

    }
}
