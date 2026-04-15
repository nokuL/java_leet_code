package Strings;

public class AppendCharAtNthVal {


    private static String insertCharAtNthIndex(String inputVal , int n, char character){

        //sudo code
        //initialise StringBuilder
        //loop through evry element at every nth element append a character
        //return string result

        int index = 1;
        StringBuilder stringBuilder = new StringBuilder();
        while(index < inputVal.length()){
            stringBuilder.append(inputVal.charAt(index-1));

            if(index % n == 0  && index != inputVal.length()){
                stringBuilder.append(inputVal.charAt(character));
            }
            index++;
        }
        return  stringBuilder.toString();
    }
}
