class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Create an array of StringBuilder to hold the zigzag pattern for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // Initialize variables to keep track of the current row and direction
        int currentRow = 0;
        boolean goingDown = false;

        // Traverse through the string and place each character in the correct row
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // If we're at the top or bottom row, change direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down the rows based on direction
            currentRow += goingDown ? 1 : -1;
        }

        // Concatenate all rows to get the final result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}