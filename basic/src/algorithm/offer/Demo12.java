package algorithm.offer;

public class Demo12 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        //起始点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(exist(board,word,i,j,visited,0))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int i, int j, boolean[][] visited, int index) {
        if(index==word.length()){
            return true;
        }
        if(i<0||i>board.length-1||j<0||j>board[0].length-1) return false;
        if(visited[i][j]==false && board[i][j]==word.charAt(index)){
            visited[i][j]=true;
            if(exist(board, word, i-1,j,visited,index+1)||
                    exist(board, word, i+1,j,visited,index+1)||
                    exist(board, word, i,j-1,visited,index+1)||
                    exist(board, word, i,j+1,visited,index+1)){
                return true;
            }
            visited[i][j]=false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'C','A','A'},
                          {'A','A','A'},
                          {'B','C','D'}};
        String word = "AAB";
        System.out.println(new Demo12().exist(board, word));
    }
}
