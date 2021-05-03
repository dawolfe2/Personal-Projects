
package chess_game;

    //Pawn class
    //Has Piece functionality and a move method designed for pawn movement
public class Pawn extends Piece{
    
        //pawn constructor with coordinates and color parameters
    public Pawn(int coordx, int coordy, String color){
        super(coordx, coordy, color);   
        alive = true;
    }
    
        //pawn movement pattern
    public void Move(Board board, int x, int y){
        
            //checks for forward movement first
            //if statement checks if target coordinates are forward y 1 space and if that space is empty
        if((coordy == y + 1) && !board.getSquare()[x][y]){
            coordy = y + 1;
            board.setSquare(true, x, y);
            board.setSquare(false, x, y - 1);
        }
    }
            
            
    
}
