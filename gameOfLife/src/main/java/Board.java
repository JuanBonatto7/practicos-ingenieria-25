public class Board {
    private Cell[][] matrix;
    private int col;
    private int row;

    public Board(int row, int col){
        this.col = col;
        this.row = row;

        for(int i = 0 ; i < row ;i++){
            for(int j = 0; j < col ;j++){
                setDeadCell(i,j);
            }
        }
    }

    private void setDeadCell(int i, int j) {
       matrix[i][j] = new Cell(false);
    }

    private int countNeighborsAlive(int row, int col){
        int alives = 0;

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < this.row && j >= 0 && j < this.col && !(i == row && j == col)) {
                    if (matrix[i][j].isAlive()) {
                        alives++;
                    }
                }
            }
        }
        return alives;
    }
}
