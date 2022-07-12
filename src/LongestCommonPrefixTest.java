import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;



class LongestCommonPrefixTest {

    @Test
    public void test_correct(){
        List<String> testArray = Arrays.asList("Tree", "Trash", "Trap");
        Assertions.assertEquals("Tr", LongestCommonPrefix.getLongestPrefix(testArray));
    }

    @Test
    public void test_Incorrect(){
        List<String> testArray = Arrays.asList("Tree", "Blue", "Trap");
        Assertions.assertEquals("", LongestCommonPrefix.getLongestPrefix(testArray));
    }


}