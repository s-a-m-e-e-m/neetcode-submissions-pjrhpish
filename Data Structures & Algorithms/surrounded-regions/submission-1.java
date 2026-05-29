class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for(int i=0;i<m;i++){
            if(board[i][0] == 'O') capture(board, i, 0, m, n);

            if(board[i][n-1]=='O') capture(board, i, n-1, m, n);
        }

        for(int j=0;j<n;j++){
            if(board[0][j]=='O') capture(board, 0, j, m, n);

            if(board[m-1][j]=='O') capture(board, m-1, j, m, n);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j] = 'X';

                else if(board[i][j]=='T') board[i][j] = 'O';
            }
        }
    }

    private void capture(char[][] board, int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || board[i][j] != 'O') return;

        board[i][j] = 'T';
        capture(board, i+1, j, m, n);
        capture(board, i-1, j, m, n);
        capture(board, i, j+1, m, n);
        capture(board, i, j-1, m, n);
    }
}
