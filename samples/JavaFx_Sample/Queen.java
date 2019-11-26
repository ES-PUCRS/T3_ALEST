public class Queen extends Movements {
    public final String type = "Queen";    //Chessman type

    public Queen(Team team){
        super(team, "Queen");
    }

    //A preset vars to catch movement validation
    @Override 
    public boolean chessmanMovement(BoardSquare cPos, BoardSquare nPos){

       super.setVar(cPos, nPos);
       
        switch(compass()){
            case 1: return super.tryMove(9, 1);
            case 2: return super.tryMove(7);
            case 3: return super.tryMove(-7);
            case 4: return super.tryMove(-9, -1);
            case 5: return super.tryMove(8);
            case 6: return super.tryMove(-8);
        }
    return false;
    }
}