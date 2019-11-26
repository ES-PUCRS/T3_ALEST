public class Bishop extends Movements {
    public final String type = "Bishop";    //Chessman type

    public Bishop(Team team){
        super(team, "Bishop");
    }
    

    //A preset vars to catch movement validation
    @Override 
    public boolean chessmanMovement(BoardSquare cPos, BoardSquare nPos){

        if(cPos.getCoordinate().getColumn() == nPos.getCoordinate().getColumn() ||
           cPos.getCoordinate().getRow() == nPos.getCoordinate().getRow())
            return false;

        super.setVar(cPos, nPos);
            
        switch(compass()){
            case 1: return super.tryMove(9);
            case 2: return super.tryMove(7);
            case 3: return super.tryMove(-7);
            case 4: return super.tryMove(-9);
        }
        return false;
    }
}