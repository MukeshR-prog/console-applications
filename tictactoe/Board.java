public class Board {
    private char[] grid;

    private final int[][] winnigPositions = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9},
        {1, 5, 9},
        {3, 5, 7}
    };

    public Board(){
        grid = new char[10];
        for(int i=1;i<=9;i++){
            grid[i] = ' ';
        }
    }

    public void printBoard(){
        System.out.println("GRID board ");
        System.out.println(" " + grid[1] + " | " + grid[2] + " | " + grid[3]);
        System.out.println("---+---+---");
        System.out.println(" " + grid[4] + " | " + grid[5] + " | " + grid[6]);
        System.out.println("---+---+---");
        System.out.println(" " + grid[7] + " | " + grid[8] + " | " + grid[9]);
        System.out.println();

    }

    public boolean placeMove(int position , char symbol){
        if(position < 1 || position > 9) return false;
        if(grid[position] !=' ') return false;
        else{
            grid[position] = symbol;
        }
        return true;
    }

    public boolean checkWinner(char symbol){
        for(int[] combinations : winnigPositions){
            if(grid[combinations[0]] == symbol && grid[combinations[1]]==symbol && grid[combinations[2]] == symbol){
                return true;
            }
        }
        return false;
    }

    public boolean isBoardFull(){
        for(int i=1;i<=9;i++){
            if(grid[i]==' ') return false;
        }
        return true;
    }
}
