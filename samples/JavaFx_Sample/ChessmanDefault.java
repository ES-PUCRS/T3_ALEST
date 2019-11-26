//Package import
import javafx.scene.layout.GridPane;


public abstract class ChessmanDefault extends Chessman{
    protected static final int SquareRows = 8;  // BoardSquare 8x8
    
    private final String type;                  // Holds chessman type
    private final Team team;                    // Record chessman team (Team.WHITE || Team.BLACK)

    private BoardSquare shouldTry;              // BoardSquare that would catch by newSquarePos
    private int comparedPosition;               // Get if target is under or above current position
    private GridPane board;                     // All board to try square by square until target
    private int cQ;                             // Current quadrant
    private int nQ;                             // New quadrant


    public ChessmanDefault(Team team, String type){ 
        this.team = team;
        this.type = type;
    }

    //Return chessman team;
    @Override
    public Team getTeam(){
        return team;
    }

    //Return chessman type;
    @Override
    public String getType(){
        return type;
    }
    
    //Set the refresh board to check if a movement could be canceled;
    @Override
    public void setBoard(GridPane board){
        this.board = board;
    }
    public GridPane getBoard(){ return board; }
    
    //Override toString to make easyer to get Image/ImageView
    @Override
    public String toString(){
        String toString = "";
        if(team == Team.White)
            toString = "White" + type;
        else if (team == Team.Black)
            toString = "Black" + type;
            else
        toString = "Null";
        
        return toString;
    }

    //Default movement check caller
    @Override 
    public boolean MoveFx(BoardSquare cPos, BoardSquare nPos, GridPane board){
        comparedPosition = cPos.getCoordinate().compareTo(nPos.getCoordinate());
        cQ = cPos.getCoordinate().getColumn();
        nQ = nPos.getCoordinate().getColumn();
        cPos.SquareTransparent();
        setBoard(board);
        return chessmanMovement(cPos, nPos);
    }
    
    //Get an orientation of target position
    @Override
    public int compass(){
        //Point to target
        //Catch direction of movement
        if(comparedPosition == -1){
            if(cQ == nQ)
                return 5;               //DOWN
            else if(cQ < nQ)
                return 1;               //DOWN-RIGHT - RIGHT
            else 
                return 2;               //DOWN-LEFT
        }else{
            if(cQ == nQ)
                return 6;               //UP
            else if(cQ < nQ)
                return 3;               // UP-RIGHT
            else
                return 4;               // UP-LEFT - LEFT
        }
    }

    
    //Method to square of column-row that chessman can move;
    @Override
    public int sumPosition(int i, int k, int p){
        return (((i * SquareRows) + (cQ - k)) + p);
    }
    //Overload
    public int sumPosition(int i, int c, int k, int p){
        return (((i * SquareRows) + (c - k)) + p);
    }

    //Used to verify if the next possible movement is possible
    @Override
    public boolean tryMoveNext(int newSquarePos, int nPosInt){
        shouldTry = (BoardSquare) board.getChildren().get(newSquarePos);
        if(shouldTry.getChessman() != null && newSquarePos != nPosInt)
                return false;
        return true;
    }

    //Set each chessman movement configuration
    //Also a preset vars to catch movement validation
    public abstract boolean chessmanMovement(BoardSquare cPos, BoardSquare nPos);
   
    //Trying catch failures and verifying cPos to nPos 
    //Try square by square until target
    public abstract boolean tryMove(int p);
}

