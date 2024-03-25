public class Ship{

    public Ship(){

    }

    private boolean canPlaceShip(Board[][] board, int y, int z) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j< board[0].length;j++){
                if(board[y][z].equals("\\uD83D\\uDEE5")){
                    return false;
                }
                if( y > board.length - 1 || z > board[0].length - 1){
                    return false;
                }
            }
        }
        return true;

    }
}

