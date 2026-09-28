class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows=new HashSet[9];
        Set<Integer>[] cols=new HashSet[9];
        Set<Integer>[] boxset=new HashSet[9];
        for(int i=0;i<9;i++){
            rows[i]=new HashSet<>();
            cols[i]=new HashSet<>();
            boxset[i]=new HashSet<>();
        }
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    continue;
                }
                int num=board[row][col]-'0';
                int box=(row/3)*3+(col/3);
                if(rows[row].contains(num) || cols[col].contains(num) || boxset[box].contains(num)){
                    return false;
                }
                rows[row].add(num);
                cols[col].add(num);
                boxset[box].add(num);
            }
        }
        return true;
    }
}