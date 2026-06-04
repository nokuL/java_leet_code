package Strings;

import java.util.Arrays;

public class StringReversalVariant {

    public static String reverseWords(String input){
      int left = 0;
      int right = input.length() -1;
      String [] words = input.trim().split("\\s+");
      while(left < right){
          String temp = words[left];
          words[left] = words[right];
          words[right] = temp;
          left++;
          right--;

      }
      return Arrays.toString(words);
    }
}