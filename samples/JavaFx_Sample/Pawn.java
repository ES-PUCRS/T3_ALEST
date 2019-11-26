public class Pawn extends ChessmanDefault {
    public final String type = "Pawn";    //Chessman type
    private BoardSquare nPos;       // new target Position
    private int newSquarePos;       // New target between origin and new position
    private int nPosInt;            // New position on integer
    private int row;                // Current row

    public Pawn(Team team){
        super(team, "Pawn");
    }

    //A preset vars to catch movement validation
    @Override 
    public boolean chessmanMovement(BoardSquare cPos, BoardSquare nPos){
        nPosInt = nPos.getCoordinate().getIntPos();
        row = cPos.getCoordinate().getRow();
        this.nPos = nPos;
        
        
        if(getTeam() == Team.White){
            if(cPos.getCoordinate().compareTo(nPos.getCoordinate()) == -1)
                return false;
                
            switch(compass()){
                case 3: return tryMove(-7);
                case 4: return tryMove(-9);
                case 6: return tryMove(-8);
            }
        }else{
            if(cPos.getCoordinate().compareTo(nPos.getCoordinate()) == 1)
                return false;
                
            switch(compass()){
                case 1: return tryMove(9);
                case 2: return tryMove(7);
                case 5: return tryMove(8);
            }
        }
        
        return true;
    }

    //Trying catch failures and verifying cPos to nPos 
    //Try square by square until target
    @Override
    public boolean tryMove(int p){
        newSquarePos = super.sumPosition(row, 0, p);

        if(nPosInt == newSquarePos){
            
            //Diagonally
            if(p != 8 && p != -8){
                if(nPos.getChessman() == null)
                    return false;
                else{
                    if(newSquarePos < 8 || newSquarePos > 55)
                    Game.changePawn();
                    return true;
                }
            }
            
            //Forward, backward
            if(p == 8 || p == -8){
                if(nPos.getChessman() != null)
                    return false;
                if(newSquarePos < 8 || newSquarePos > 55)
                        Game.changePawn();
                return true;
            }
            
            //first move -> 2 square
        }else if (row == 1 || row == 6)
            if(p == 8 || p == -8){
                if(super.tryMoveNext(newSquarePos, nPosInt))
                    newSquarePos = super.sumPosition(row, 0, p*2);
                    if(newSquarePos == nPosInt)
                        return true;
            }
        return false;
    }
}
