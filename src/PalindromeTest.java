import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeTest {


    @Test
    void palindrome_correctResult(){
        int integer = 9999;
        Assertions.assertTrue(Palindrome.palindrome(integer));

    }

    @Test
    void palindrome_wrongResult(){
        int integer2 = 10978;
        Assertions.assertFalse(Palindrome.palindrome(integer2));
    }
}