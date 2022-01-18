public class App {
    public static void main(String[] args) throws Exception {
        Solve solve = new Solve();
        int[][] board = {
            {6,0,0,0,0,8,0,5,0},
            {2,0,5,4,0,0,0,0,9},
            {3,0,4,0,0,0,0,0,0},
            {0,0,0,9,4,0,0,0,0},
            {0,0,0,0,0,0,8,1,0},
            {0,0,0,0,0,0,0,0,7},
            {0,9,0,0,0,0,0,7,0},
            {4,0,0,0,6,1,0,8,0},
            {0,0,0,0,0,0,5,0,3}
        };
        
        System.out.println("Unsolve board look like..");
        solve.printSudoku(board);
        if(solve.solve(board)){
            System.out.println("\n\n We are ready , the sudoku is solved!");
            solve.printSudoku(board);
        }else{
            System.out.println("Cannot be solved");
        }
        
    }
}