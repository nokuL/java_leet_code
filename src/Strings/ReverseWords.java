package Strings;

public class ReverseWords {

    // given an input string , reverse words in a string
    // what are the constraints:
    // 1. size of the string , is there a maximum or minimum
    // 2. Is the input ever empty or null ?
    // 3. Are there multiple spaces between the words or its always 1 ?
    // 4: Are there trailing spaces before or after ? Should i trim them ?
    // 5. Are they always words or they can characters ?

    // edge cases :
    // 1. if there is only one word ?
    // 2. if string is longer than stipulated expected length
    // 3. if string is empty ?

    // sudo code
    // loop through the array of characters
    // keep track of counter to track start index, start at 0
    // if string is empty throw illegal argument exception
    // if string is longer than length, throw illegalArgumentException
    // if character is whitespace, get substring from start to that index, update start index
    // loop through the characters and get them as a substring, add them to an array
    // insert word to end of result array
    // loop through result array append values to StringBuilder class
    // return string

    // -------------------------------------------------------
    // Approach 1 — split + two pointer swap
    // uses built-in split and join
    // O(n) time, O(n) space
    // -------------------------------------------------------
    public static String reverseWords(String input, int maxLength) {

        if (input == null || input.isEmpty() || input.length() > maxLength) {
            throw new IllegalArgumentException("Invalid string");
        }

        // trim leading/trailing spaces, split on any whitespace
        String[] words = input.trim().split("\\s+");

        // single word — nothing to reverse
        if (words.length == 1) return words[0];

        // two pointer swap on word array
        int left  = 0;
        int right = words.length - 1;

        while (left < right) {
            String temp  = words[left];
            words[left]  = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        return String.join(" ", words);
    }

    // -------------------------------------------------------
    // Approach 2 — double reverse, no split
    // step 1: reverse entire char array
    // step 2: reverse each individual word back
    // O(n) time, O(1) extra space
    // -------------------------------------------------------
    public static String reverseWordsWithoutSplit(String input, int maxLength) {

        if (input == null || input.isEmpty() || input.length() > maxLength) {
            throw new IllegalArgumentException("Invalid string");
        }

        // clean multiple spaces so logic stays simple
        String cleaned = input.trim().replaceAll("\\s+", " ");
        char[] chars   = cleaned.toCharArray();

        // step 1 — reverse the entire string
        reverseString(chars, 0, chars.length - 1);

        // step 2 — reverse each word individually
        // i <= chars.length so the last word (no space after it) is caught
        int start = 0;
        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                reverseString(chars, start, i - 1);
                start = i + 1;
            }
        }

        return new String(chars);
    }

    // -------------------------------------------------------
    // helper — reverses chars in place between left and right inclusive
    // -------------------------------------------------------
    private static void reverseString(char[] chars, int left, int right) {
        while (left < right) {
            char temp    = chars[left];
            chars[left]  = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    // -------------------------------------------------------
    // main — manual tests
    // -------------------------------------------------------
    public static void main(String[] args) {

        // normal case
        System.out.println(reverseWords("Hello World", 100));
        // → "World Hello"

        // multiple spaces
        System.out.println(reverseWords("I   love   Java", 100));
        // → "Java love I"

        // single word
        System.out.println(reverseWords("Hello", 100));
        // → "Hello"

        // trailing spaces
        System.out.println(reverseWords("  Hello World  ", 100));
        // → "World Hello"

        // double reverse versions
        System.out.println(reverseWordsWithoutSplit("Hello World", 100));
        // → "World Hello"

        System.out.println(reverseWordsWithoutSplit("I   love   Java", 100));
        // → "Java love I"

        System.out.println(reverseWordsWithoutSplit("  Hello World  ", 100));
        // → "World Hello"
    }
}