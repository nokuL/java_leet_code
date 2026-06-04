package Strings;

public class MoveVowels {

    //given a string, move all  vowels to begining
    //constraints
    //is it case sensitive ? a same as A ?
    //whats the expected length range of input string ?
    // is it ever null or empty ? what should i return or throw an exception ?
    //what should i return if there are no vowels ?

    //sudo code
    //instantiate two stringbuilder objects, one to append variable, another for the rest of the letters
    //instantiate a string with vowels , both caps and small letter
    //loop throgh the input string,
    // if char is in vowel string, append to vowel stringbuilder object
    //else append to the other sutStringbuilder object
    //concat the two stringbuilder objects
    //return the result


    public static String moveVowels(String inputString){
        if(inputString.isEmpty()){
            return  inputString;
        }
        StringBuilder vowelsBuilder = new StringBuilder();
        StringBuilder consonutsBuilder = new StringBuilder();
        String vowelsString = "aeiouAEIOU";
        for(char c : inputString.toCharArray()){
            if(vowelsString.indexOf(c) != -1){
                vowelsBuilder.append(c);
            }else{
                consonutsBuilder.append(c);
            }
        }
        String result = vowelsBuilder.append(consonutsBuilder).toString();
        return  result;
    }



}
