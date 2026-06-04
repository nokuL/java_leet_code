package Strings;

public class StringCompression {

    public static String stringCompression(String input){

        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for(int j = 1; j <= input.length(); j++){
            if(j == input.length() || input.charAt(j -1) != input.charAt(j)){
                stringBuilder.append(input.charAt(j-1));
                stringBuilder.append(count);
                count = 1;
            }else{
                count++;
            }

        }
        return stringBuilder.toString();

    }
}
