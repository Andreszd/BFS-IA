public class Main {

    public static void main(String[] args) {
        int [][] initialBoard = {{1,2,3},{4,5,6},{7,0,8}};
        int [][] testMeta = {{1,2,3},{4,5,6},{7,8,0}};
        Puzzle f = new Puzzle(initialBoard, testMeta);
        f.resolve();
    }
}
