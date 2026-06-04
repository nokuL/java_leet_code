package Strings;

import java.util.Arrays;

public class ZigZagString {

    public static String zigzag(String input, int rows){

        //sudo code
        //given the number of rows , form a zigzag string
        //create as many string builders as the number of rows
        //keep a counter, counting the row number to append to
        //count from 0 up to num of rows -1, (append character to respective row)
        //subtract 1 continously up to 0, repeat up to end of string (append character to respective row)
        //jpin the builders
        //return
        int count = 0;
        boolean goingDown = false;
        StringBuilder [] stringBuilders = new StringBuilder[rows];

        for(int i = 0; i < rows; i++){
            stringBuilders[i] = new StringBuilder();
        }
        for(int i = 0; i < input.length(); i++){
                stringBuilders[count].append(input.charAt(i));

                if(count == 0 || (count == rows -1)){
                    goingDown = !goingDown;

                }
                count += goingDown ? 1 : -1;
            }


        System.out.println(Arrays.stream(stringBuilders));
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < stringBuilders.length ; i++ ){
            result.append(stringBuilders[i]);
        }
        return result.toString();
    }
}
