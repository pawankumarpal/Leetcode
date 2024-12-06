class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**String largestString = "";
        for(int i=0;i<s.length();i++){
            String tempLargestString = "";
            tempLargestString =String.valueOf(s.charAt(i)); 
            for(int j =i+1;j<s.length();j++){
                if(!tempLargestString.contains(String.valueOf(s.charAt(j)))){
                    tempLargestString +=String.valueOf(s.charAt(j)) ;
                }else{
                    break;
                }
            }
            if(tempLargestString.length()>largestString.length()){
                        largestString=tempLargestString;
            }
        }
        return largestString.length();*/

        int start = 0, maxLength = 0;
        String largestString = "";

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // Check for duplicate character in the current window
            for (int k = start; k < end; k++) {
                if (s.charAt(k) == currentChar) {
                    // Move the start of the window to exclude the duplicate
                    start = k + 1;
                    break;
                }
            }

            // Calculate the current length of the window
            int currentLength = end - start + 1;

            // Update the largest substring if a new maximum is found
            if (currentLength > maxLength) {
                maxLength = currentLength;
                largestString = s.substring(start, end + 1);
            }
        }
        return (maxLength);
    }
}
