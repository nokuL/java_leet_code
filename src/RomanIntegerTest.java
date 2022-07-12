import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanIntegerTest {

    @Test
    public void test_correct_Roman(){
        String str = "MCMXCIV";
        int expected = 1994;
        assertEquals(expected, RomanInteger.romanToInt(str));
    }

    @Test
    public void assert_exception_isThrown(){
        String str = "MCMXCBV";
       IllegalArgumentException  exception= assertThrows(IllegalArgumentException.class, ()->{
            RomanInteger.romanToInt(str);
        });
        assertEquals("Invalid character", exception.getMessage() );
    }



}