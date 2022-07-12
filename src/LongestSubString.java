import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
 String a = "abcabc";
    public static int longestSubString(String s) throws Exception{
        int i =0, j =0 , max = 0;
        Set<Character> stringSet = new HashSet<>();
        while(j < s.length()){
            if(!stringSet.contains(s.charAt(j))){
                stringSet.add(s.charAt(j));
                max = Math.max(max, stringSet.size());
                j++;
            }else{
                stringSet.remove(s.charAt(i));
                i++;
            }

        }
   return max;
    }
}
