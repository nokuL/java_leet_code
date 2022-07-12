import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SplitStringTest {

    @Test
    public void test_correct_string(){
        String str = "Noxie Poxie";
        Assertions.assertEquals("Poxie Noxie", SplitString.splitString(str));
    }

}