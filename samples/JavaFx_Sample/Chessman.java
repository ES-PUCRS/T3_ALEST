import javafx.scene.layout.GridPane;

public abstract class Chessman{
    //Default movement check caller
    public abstract boolean MoveFx(BoardSquare cPos, BoardSquare nPos, GridPane board);
    //Set each chessman movement configuration ~Where the magic happens;
    public abstract boolean chessmanMovement(BoardSquare cPos, BoardSquare nPos);
    //Used to verify if the next possible movement is possible;
    public abstract boolean tryMoveNext(int newSquarePos, int nPosInt);
    //Method to square of column-row that chessman can move;
    public abstract int sumPosition(int i, int k, int p);
    //Set the refresh board to check if a movement could be canceled;
    public abstract void setBoard(GridPane board);
    //Try square by square until target
    public abstract boolean tryMove(int p);
    //Override toString to make easyer to get Image/ImageView
    public abstract String toString();
    //Return chessman type;
    public abstract String getType();
    //Return chessman team;
    public abstract Team getTeam();
    //Get an orientation of target position;
    public abstract int compass();
}