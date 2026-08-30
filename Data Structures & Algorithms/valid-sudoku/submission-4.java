class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int d = c - '0';           // 1..9
                int bit = 1 << (d - 1);

                int b = (i / 3) * 3 + (j / 3); // box index 0..8

                // If already seen in row, col, or box -> invalid
                if ((rows[i] & bit) != 0) return false;
                if ((cols[j] & bit) != 0) return false;
                if ((boxes[b] & bit) != 0) return false;

                // Mark as seen
                rows[i] |= bit;
                cols[j] |= bit;
                boxes[b] |= bit;
            }
        }

        return true;
    }
}