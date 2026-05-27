class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean [][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            if(visited[i][0] == false && board[i][0] == 'O'){
                dfs(i, 0, n, m, visited, board);
            }
        }

        for(int i = 0; i < n; i++){
            if(visited[i][m-1] == false && board[i][m-1] == 'O'){
                dfs(i, m-1, n, m, visited, board);
            }
        }

        for(int j = 0; j < m; j++){
            if(visited[0][j] == false && board[0][j] == 'O'){
                dfs(0, j, n, m, visited, board);
            }
        }

        for(int j = 0; j < m; j++){
            if(visited[n-1][j] == false && board[n-1][j] == 'O'){
                dfs(n-1, j, n, m, visited, board);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && visited[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, int n, int m, boolean [][] visited, char [][] board){
        visited[i][j] = true;

        if(isSafe(i+1, j, n, m, visited, board)){
            dfs(i+1, j, n, m, visited, board);
        }

        if(isSafe(i-1, j, n, m, visited, board)){
            dfs(i-1, j, n, m, visited, board);
        }

        if(isSafe(i, j-1, n, m, visited, board)){
            dfs(i, j-1, n, m, visited, board);
        }

        if(isSafe(i, j+1, n, m, visited, board)){
            dfs(i, j+1, n, m, visited, board);
        }

    }

    private boolean isSafe(int i, int j, int n, int m, boolean [][] visited, char[][] board){
        if(i >= 0 && i < n && j >= 0 && j < m && visited[i][j] == false && board[i][j] == 'O'){
            return true;
        }

        return false;
    }
}
