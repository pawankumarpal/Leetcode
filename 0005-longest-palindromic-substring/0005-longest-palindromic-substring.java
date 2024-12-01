class Solution {
    public String longestPalindrome(String s) {
        return findLargestPalindrome(s);
    }

    public static String findLargestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        String largestPalindrome = "";

        for (int i = 0; i < s.length(); i++) {
            // Expand for odd-length palindrome (single character center)
            String oddPalindrome = expandAroundCenter(s, i, i);

            // Expand for even-length palindrome (two characters center)
            String evenPalindrome = expandAroundCenter(s, i, i + 1);

            // Update the largest palindrome if necessary
            if (oddPalindrome.length() > largestPalindrome.length()) {
                largestPalindrome = oddPalindrome;
            }
            if (evenPalindrome.length() > largestPalindrome.length()) {
                largestPalindrome = evenPalindrome;
            }
        }

        return largestPalindrome;
    }

    private static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Return the palindrome substring
        return s.substring(left + 1, right);
    }
}