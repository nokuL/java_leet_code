package Strings;

public class Compress {

    public static String compress(String input, int maxLength){

        //given a string, compress it by counting character and appending the count immmediately after the counted character
//constraints ;
// is the problem case sensitive ?
// is there an expected length range ?
// is the string ever empty ?
// Can the input contain digits, spaces or special characters


//sudo code
//start at index = 1
//keep track of count value for characters, start at count = 1
//loop through the character array
// check the previous character
//if it is not equal to the current index character,
//if case senistive then dont do anything but if not, change everything to lowercase
//append previous character to stringbuilder ,
//append count
//reset count to 1
//else continue incrementing count until you reach a diff character

        int count = 1;
        StringBuilder resultBuilder = new StringBuilder();
        if (input == null || (input.isEmpty() || input.length() > maxLength)) {
            throw new IllegalArgumentException("Invalid String length");

        }
        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i) != input.charAt(i-1)){
                resultBuilder.append(input.charAt(i-1));
                resultBuilder.append(count);
                count = 1;

            }else{
                count++;
            }
        }
        resultBuilder.append(input.charAt(input.length() - 1));
        resultBuilder.append(count);
        return  resultBuilder.toString();
    }
}
