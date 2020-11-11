import java.util.ArrayList;
import java.util.Arrays;

public class Puzzle {
    private int [][] testMeta;
    private Board initialBoard;
    public Puzzle(int [][] initialBoard, int [][] testMeta){

        this.testMeta = testMeta;
        this.initialBoard = new Board(initialBoard);
    }
    public void resolve(){
        boolean found = false;
        ArrayList<Board> expandedList = new ArrayList<>();
        expandedList.add(initialBoard);
        while(!found){
            Board ini = expandedList.remove(0);
            int [] pos = getPosCero(ini);
            System.out.println("current board");
            ini.print();
            if (Arrays.deepEquals(ini.getState(), testMeta)){
                System.out.println("solution found");
                found = true;
                ini.print();
            }else{
                generateState(ini, pos, expandedList);
            }
        }
    }
    private void generateState(Board board, int [] posCero, ArrayList<Board> expandedList){
        if (posCero[0] - 1 >= 0 ){
            int [][] state = clone(board.getState());
            int positionNumber = state[posCero[0]-1][posCero[1]];
            state[posCero[0]-1][posCero[1]] = 0;
            state[posCero[0]][posCero[1]] = positionNumber;
            Board newState = new Board(state);
            newState.print();
            expandedList.add(newState);
        }
        if (posCero[0] + 1 < board.getState().length){
            int [][] state = clone(board.getState());
            int positionNumber = state[posCero[0] + 1][posCero[1]];
            state[posCero[0] + 1][posCero[1]] = 0;
            state[posCero[0]][posCero[1]] = positionNumber;
            Board newState = new Board(state);
            newState.print();
            expandedList.add(newState);
        }
        if (posCero[1] - 1 >= 0){
            int [][] state = clone(board.getState());
            int positionNumber = state[posCero[0]][posCero[1] - 1];
            state[posCero[0]][posCero[1] - 1] = 0;
            state[posCero[0]][posCero[1]] = positionNumber;
            Board newState = new Board(state);
            newState.print();
            expandedList.add(newState);
        }
        if (posCero[1] + 1 < board.getState().length){
            int [][] state = clone(board.getState());
            int positionNumber = state[posCero[0]][posCero[1] + 1];
            state[posCero[0]][posCero[1] + 1] = 0;
            state[posCero[0]][posCero[1]] = positionNumber;
            Board newState = new Board(state);
            newState.print();
            expandedList.add(newState);
        }
    }
    private int [][] clone(int [][] board){
        int [][] state = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                state[i][j] = board[i][j];
            }
        }
        return state;
    }
    private int [] getPosCero(Board board){
        int [] pos = new int[2];
        for (int i = 0; i < board.getState().length; i++) {
            for (int j = 0; j < board.getState().length; j++) {
                if (board.getState()[i][j] == 0) {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        return pos;
    }
}
