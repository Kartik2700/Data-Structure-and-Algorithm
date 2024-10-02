class Solution {
    
    private List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


    private void solve(int col,int n,char [][] board,int [] leftRow,int[]upperDiagonal,int[] lowerDiagonal,List<List<String>> ans){
        if(col == n){
            ans.add(construct(board));
        }

        for(int row=0;row<n;row++){
            if(leftRow[row]==0 && upperDiagonal[(n-1)+col-row]==0 && lowerDiagonal[row+col]==0){
                board[row][col]='Q';
                leftRow[row]=1;
                upperDiagonal[(n-1)+col-row]=1;
                lowerDiagonal[row+col] =1;

                solve(col+1,n,board,leftRow,upperDiagonal,lowerDiagonal,ans);

                board[row][col]='.';
                leftRow[row]=0;
                upperDiagonal[(n-1)+col-row]=0;
                lowerDiagonal[row+col] =0;


            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        int[] leftRow = new int[n];

        int upperDiagonal[] = new int[2*n-1];
        int lowerDiagonal[] = new int[2*n-1];
        List<List<String>> ans = new ArrayList<List<String>>();
        solve(0,n,board,leftRow,upperDiagonal,lowerDiagonal,ans);

        return ans;
    }
}