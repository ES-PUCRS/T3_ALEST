public class Knight extends ChessmanDefault {
    public final String type = "Knight";    //Chessman type

    private int newSquarePos;       // New target between origin and new position
    private int secSquarePos;       // Sec possible target  
    private int nPosInt;            // New position on integer
    private int row;                // Current row


    public Knight(Team team){
        super(team, "Knight");
    }
      
    @Override 
    public boolean chessmanMovement(BoardSquare cPos, BoardSquare nPos){
        nPosInt = nPos.getCoordinate().getIntPos();
        row = cPos.getCoordinate().getRow();
        
        switch(compass()){
            case 1: return tryMove(10);   // (cQ == nQ)   Pos < nPos -> ok
            case 2: return tryMove(6);   // (cQ > nQ)    Pos == nPos -> ok
            case 3: return tryMove(-6);    // (cQ < nQ)    Pos == nPos -> ok
            case 4: return tryMove(-10);    // (cQ == nQ)   Pos > nPos
        }
    return false;
    }
    
    //Trying catch failures and verifying cPos to nPos 
    //Try square by square until target
    @Override
    public boolean tryMove(int p){
        switch(p){
            case 10:  return aux(p, 17);
            case 6:   return aux(p, 15);
            case -6:  return aux(p, -15);
            case -10: return aux(p, -17);
        }
    return false;
    }
    
    private boolean aux(int p, int k){
        newSquarePos = super.sumPosition(row, 0, p);
        secSquarePos = super.sumPosition(row, 0, k);
        if(nPosInt == newSquarePos || nPosInt == secSquarePos)
            return true;
        else return false;
    }
}