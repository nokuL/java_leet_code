package Strings;

import java.util.HashMap;
import java.util.Stack;

public class ValidStack {

    public static boolean isValidParenthesis(String input){

        HashMap<Character, Character>hashMap = new HashMap();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');

        Stack<Character>stack = new Stack<>();

        for(int i = 0; i < input.length(); i++){
            if(hashMap.containsKey(input.charAt(i))){
                stack.push(input.charAt(i));
            }else{
                //check if the closing element matches the current opening element
                //trying to close without opening
                if (stack.empty()) return false;

                char top = stack.pop();

                if(hashMap.get(top) != input.charAt(i)) return false;


            }
        }
        return stack.isEmpty();
    }
}
