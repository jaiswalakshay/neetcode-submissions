class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use sets to track used numbers for rows, columns, and 3x3 subgrids
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];
        
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                if (board[i][j] == '.') continue;
                
                int index = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + (j / 3);
                
                if((rows[i] & (1 << index)) != 0){
                    return false;
                }else {
                    rows[i] |= (1 << index);
                }
                if((columns[j] & (1 << index)) != 0){
                    return false;
                }else{
                    columns[j] |= (1 << index);
                }
                if((boxes[boxIndex] & (1 << index)) != 0){
                    return false;
                }else{
                    boxes[boxIndex] |= (1 << index);
                }
            }
        }
        // If no duplicates are found, return true
        return true;
    }
}