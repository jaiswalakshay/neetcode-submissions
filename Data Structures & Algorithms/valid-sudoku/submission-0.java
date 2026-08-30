class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use sets to track used numbers for rows, columns, and 3x3 subgrids
        Set<String> rows = new HashSet<>();
        Set<String> cols = new HashSet<>();
        Set<String> boxes = new HashSet<>();
        
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                if (board[i][j] == '.') continue;
                String rowsKey = "rows_"+i+"_"+board[i][j];
                String columnsKey = "columns_"+j+"_"+board[i][j];
                String boxesKey = "boxes_"+i/3+"_"+j/3+"_"+board[i][j];
                if(rows.contains(rowsKey)){
                    return false;
                }
                if(cols.contains(columnsKey)){
                    return false;
                }
                if(boxes.contains(boxesKey)){
                    return false;
                }
                rows.add(rowsKey);
                cols.add(columnsKey);
                boxes.add(boxesKey);
            }
        }
        // If no duplicates are found, return true
        return true;
    }
}