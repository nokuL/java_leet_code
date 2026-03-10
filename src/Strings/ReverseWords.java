package Strings;

public class ReverseWords {

    // given an input string , reverse words in a string
//what are the constraints:
//1. size of the string , is there a maximum or minimum
//2. Is the input ever empty or null ?
 //   3. Are there multiple spaces between the words or its always 1 ?
 //  4: Are there trailing spaces before or after ? Should i trim them ?
 //  5. Are they always words or they can characters ?

//edge cases :
// 1.if there is only one word ?
// 2.if string is longer than stipulated expected length
//3.if string is empty ?


//sudo code
//loop through the array of characters
//keep track of counter to track start index, start at 0
//if string is empty throw illegal argiument exception
//if string is longer than length, throw illegalArgumentException
//if character is whitespace, get substring from start to that index, update start index
//loop through the characters and get them as a substring, add them to an array
//insert word to end of result array
//loop through result array append values to StringBuilder class
//return string


    public static String reverseWords(String input, int maxLength) {

        if (input == null || (input.isEmpty() || input.length() > maxLength)) {
            throw new IllegalArgumentException("Invalid String length");

        }
        int startIndex = 0;

        int resultArrayIndex = input.length() - 1;

        StringBuilder result = new StringBuilder();

        String[] resultArray = new String[input.length()];

        for (int i = 0; i < input.length(); i++) {
            if (Character.isWhitespace(input.charAt(i))) {
                if(i > startIndex){
                    String subString = input.substring(startIndex, i );
                    resultArray[resultArrayIndex] = subString;
                    resultArrayIndex--;

                }

             int spaceIndex = i;
                while(i<input.length() && Character.isWhitespace(input.charAt(i))){
                    i++;

                }
                resultArray[resultArrayIndex] = input.substring(spaceIndex, i);
                resultArrayIndex--;

                startIndex = i;
                i--;


            }
            if(i == input.length() -1){
                String subString = input.substring(startIndex);
                resultArray[resultArrayIndex] = subString;
            }
        }
        for (int j = 0; j<  resultArray.length; j++) {
            if(resultArray[j] != null){
                result.append(resultArray[j]);

            }


        }
        return result.toString();
    }
}
