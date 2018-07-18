import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testWordToDequeBackwards() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeLast();
        }
        assertEquals("egalfisrep", actual);
    }

    @Test
    public void testisPalindrome(){
   assertTrue(palindrome.isPalindrome("dad"));
   assertFalse(palindrome.isPalindrome("get"));
   assertTrue(palindrome.isPalindrome(""));
   assertTrue(palindrome.isPalindrome("a"));
    }
    @Test
    public void testisPalidrome(){
        OffByOne a = new OffByOne();
        assertFalse(palindrome.isPalindrome("dad", a));
        assertTrue(palindrome.isPalindrome("", a));
        assertTrue(palindrome.isPalindrome("flake", a));
        OffByN b = new OffByN(10);
        assertTrue(palindrome.isPalindrome("lab", b));
    }

}
