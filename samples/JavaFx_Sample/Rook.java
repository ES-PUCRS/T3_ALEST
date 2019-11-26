public class Rook extends Movements {
    public final String type = "Rook";    //Chessman type

    public Rook(Team team){
        super(team, "Rook");
    }


    //A preset vars to catch movement validation
    @Override 
    public boolean chessmanMovement(BoardSquare cPos, BoardSquare nPos){
        
        if(cPos.getCoordinate().getColumn() != nPos.getCoordinate().getColumn() &&
           cPos.getCoordinate().getRow() != nPos.getCoordinate().getRow())
            return false;
        
        super.setVar(cPos, nPos);

        switch(compass()){
            case 6: return super.tryMove(-8);
            case 4: return super.tryMove(-1);
            case 1: return super.tryMove(1);
            case 5: return super.tryMove(8);
        }
        return false;
    }
}