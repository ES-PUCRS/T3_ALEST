public class King extends ChessmanDefault {
    public final String type = "King";    //Chessman type

    private BoardSquare shouldTry;              // BoardSquare that would catch by newSquarePos
    private BoardSquare cPos;
    private BoardSquare nPos;
    private int newSquarePos;       // New target between origin and new position
    private int cPosInt;            // Current position on integer
    private int nPosInt;            // New position on integer
    private int row;                // Current Row


    public King(Team team){
        super(team, "King");
    }
    
    //A preset vars to catch movement validation
    @Override 
    public boolean chessmanMovement(BoardSquare cPos, BoardSquare nPos){
        cPosInt = cPos.getCoordinate().getIntPos();
        nPosInt = nPos.getCoordinate().getIntPos();
        row = cPos.getCoordinate().getRow();
        this.cPos = cPos;
        this.nPos = nPos;
        
        switch(compass()){
            case 1: return tryMove(1, 9);
            case 2: return tryMove(7);
            case 3: return tryMove(-7);
            case 4: return tryMove(-1, -9);
            case 5: return tryMove(8);  
            case 6: return tryMove(-8);
        }
        return false;
    }



    //Override
    public boolean tryMove(int p, int k){
        int dif = cPosInt - nPosInt;
        if(dif != 1 && dif != -1)
            return tryMove(k);
        return tryMove(p);
    }
    //Trying catch failures and verifying cPos to nPos 
    //Try square by square until target
    @Override
    public boolean tryMove(int p){
        newSquarePos = super.sumPosition(row, 0, p);
        if(nPosInt == newSquarePos)
            if(tryMoveNext(newSquarePos, nPosInt))
                return true;
        return false;
    }

    @Override
    public boolean tryMoveNext(int newSquarePos, int nPosInt){
        
        int p = 0;
        for(int i = 1; i < 9; i++){
 
            switch(i){
                case 1: p = 1; break;
                case 2: p = 7; break;
                case 3: p = -7; break;
                case 4: p = -1; break;
                case 5: p = 8; break;
                case 6: p = -8; break;
                case 7: p = 9; break;
                case 8: p = -9; break;
            }
            
            newSquarePos = super.sumPosition(nPos.getCoordinate().getRow(), nPos.getCoordinate().getColumn(), 0, p);
            if(newSquarePos < 0 || newSquarePos > 63)
                continue;
            shouldTry = (BoardSquare) getBoard().getChildren().get(newSquarePos);
            if(shouldTry.getChessman() != null)
                if(shouldTry.getChessman().getTeam() != cPos.getChessman().getTeam() &&
                    shouldTry.getChessman().getType().equals("King"))
                    return false;
        }
        return true;
    }
}
