class Solution {
    public boolean isValidSudoku(char[][] board) {

        int n = board.length;
        Set<Character>[] row = new HashSet[n];
        Set<Character>[] col = new HashSet[n];
        Set<Character>[] box = new HashSet[n];

        for(int i=0;i<n;i++){
            row[i] = new HashSet<Character>();
            col[i] = new HashSet<Character>();
            box[i] = new HashSet<Character>();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char val = board[i][j];
                    if(val == '.') continue;
                
                    if(row[i].contains(val)) return false;
                    row[i].add(val);

                    if(col[j].contains(val)) return false;
                    col[j].add(val);

                    int boxN = (i/3)*3+j/3;
                    if(box[boxN].contains(val)) return false;
                    box[boxN].add(val);

            }
        }

        return true;

    }
}