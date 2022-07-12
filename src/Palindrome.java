public class Palindrome {

    public static boolean palindrome(int number){

        String str = String.valueOf(number);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        String reverse =  stringBuilder.reverse().toString();
        int newInt = Integer.parseInt(reverse);
        return number == newInt;
    }
}
