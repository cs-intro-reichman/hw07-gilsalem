/** Checks if a given string is a palindrome. */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(args[0]));
    }
    
    /** Checks if the given string is a palindrome. */
    public static boolean isPalindrome(String s) {
        // Base case: A string of length 0 or 1 is considered a palindrome 
        if (s.length() <= 1) {
            return true;
        }

        // Check if the first and last characters are different
        // If they are different, it is not a palindrome
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        // Recursive step: Check the substring without the first and last characters 
        // We use s.substring(1, s.length() - 1) to get the inner part of the string
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}