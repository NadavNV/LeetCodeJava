public class WordSearch {
    // for pruning, I used https://medium.com/@tabassum_k/79-word-search-leetcode-22b155ce226
    int rows, columns;
    int[] yMoves = {1, 0, -1, 0};
    int[] xMoves = {0, 1, 0, -1};
    String word;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        columns = board[0].length;

        //prune 1 : check if the word length > whole matrix length
        if (word.length() > rows * columns) return false;

        //prune 2: check if the char count in the word and the char count in the board is at least equal or greater
        int[] boardCount = new int['z' - 'A' + 1];
        int[] wordCount = new int['z' - 'A' + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boardCount[board[i][j] - 'A']++;
            }
        }
        for (char c : word.toCharArray()) {
            wordCount[c - 'A']++;
        }

        for (char c : word.toCharArray()) {
            if (wordCount[c - 'A'] > boardCount[c - 'A']) return false;
        }

        //prune 3: Reverse the string if the count of the last char < count of the first char

        char[] wordArray = word.toCharArray();

        if (boardCount[wordArray[word.length() - 1] - 'A'] < boardCount[wordArray[0] - 'A']) {
            for (int left = 0, right = word.length() - 1; left < right; left++, right--) {
                char temp = wordArray[left];
                wordArray[left] = wordArray[right];
                wordArray[right] = temp;
            }
        }

        this.word = new String(wordArray);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == this.word.charAt(0) && search(board, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int index, int row, int col) {
        if (index == word.length()) return true;
        if (row < 0 || row >= rows || col < 0 || col >= columns || word.charAt(index) != board[row][col]) return false;
        for (int i = 0; i < yMoves.length; i++) {
            board[row][col] = '#';
            if (search(board, index + 1, row + yMoves[i], col + xMoves[i])) return true;
            board[row][col] = word.charAt(index);
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch sol = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(sol.exist(board, "ABCCED"));
        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(sol.exist(board, "SEE"));
        board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(!sol.exist(board, "ABCB"));
    }
}
