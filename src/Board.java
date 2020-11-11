public class Board {
    private int [][] state;
    public Board(int [][] state){
        this.state = state;
    }

    public int[][] getState() {
        return state;
    }
    public void print(){
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                System.out.print("["+ state[i][j]+"]");
            }
            System.out.println("");
        }
        System.out.println("===============================");
    }
}
