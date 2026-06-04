package Strings;

import java.util.HashMap;
import java.util.Stack;

public class FirstInvalidIndexStack {
    public static int firstInvalidIndex(String input) {

        if (input == null || input.isEmpty()) return -1;

        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (hashMap.containsKey(c)) {
                stack.push(i);                           // push index of opening bracket

            } else {
                if (stack.isEmpty()) return i;           // closing with nothing open

                int topIndex = stack.pop();              // get index of last opening bracket
                char topChar = input.charAt(topIndex);  // reconstruct char from index

                if (hashMap.get(topChar) != c) return i; // mismatch — return current index
            }
        }

        // unclosed brackets remain — find the first one
        // stack is LIFO so bottom = first pushed = first unclosed
        if (!stack.isEmpty()) {
            while (stack.size() > 1) {
                stack.pop();                             // discard newer unclosed brackets
            }
            return stack.peek();                        // first unclosed opening bracket
        }

        return -1;
    }
}
