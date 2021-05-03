
package chess_game;


    //piece class
    //parent class of all piece subclasses
    //all pieces have alive status, white/black color, and board coordinates
public class Piece {
    
    Boolean alive;
    String color;
    int coordx;
    int coordy;
    
        //contructor with color and coordinate parameters, auto sets status to alive
    public Piece(int coordx, int coordy, String color){
        this.coordx = coordx;
        this.coordy = coordy;
        this.color = color;
        alive = true;
    }
    
}
