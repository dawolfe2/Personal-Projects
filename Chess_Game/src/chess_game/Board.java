
package chess_game;


public class Board {
    
    public Boolean[][] square;
    public String turn;
    
    public Board(){
        
        square = new Boolean[8][8];
        turn = "White";
        
            //initial board setup for square Boolean status
            //sets squares with pieces to true and the rest to false
        for(int i = 1; i <= 8; i++){
            for(int j = 1; j <= 8; j++){
                
                if(i > 2 && i < 7){
                    square[i][j] = false;
                }
                else{
                    square[i][j] = true;
                }
                
            }
        }
   
    }

    public Boolean[][] getSquare() {
        return square;
    }

    public void setSquare(Boolean status, int x, int y) {
        square[x][y] = status;
    }
}
