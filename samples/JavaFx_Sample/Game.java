//Package import
import java.util.InputMismatchException;
import javafx.scene.layout.GridPane;


public class Game{
    private static int ProgramCounter = 0;
    private static BoardSquare fPos;
    private static BoardSquare sPos;
    private static ScreenGx screen;
    private static boolean single;
    private static GridPane board;
    private static Game instance;

    private Game(){}    

    public static Game getInstance(){
         if (instance == null)
            instance = new Game();
         return instance;
    }

    public static void setOnBoard(GridPane boardplay) {
        board = boardplay;
    }

    public static GridPane getOnBoard() { return board; }

    //Get Board onAction event and deal with
    public static void setPointer(BoardSquare square) throws InputMismatchException{

        if(ProgramCounter == 0 || ProgramCounter == 2){
            fPos = square;
            GameRun();
        }else
        if(ProgramCounter == 1 || ProgramCounter == 3){
            sPos = square;
            GameRun();
        }
    }

    public static void GameRun() throws InputMismatchException{
        if(ProgramCounter == 0 || ProgramCounter == 2){
           if(fPos.getChessman() == null){
                posClear();
                throw new InputMismatchException("There is no chessman at this position.");
            }else
            if(rightPlayer())
                ProgramCounter++;
        }else

        if(ProgramCounter == 1 || ProgramCounter == 3){
            if(canMove(fPos, sPos)){
                fPos.moveChessman(sPos);
                ProgramCounter++;
                posClear();
            }else{
                posClear();
                throw new InputMismatchException("Selected chessman can not move to target.");
            }
        }
        
        //if(single) ComputerPlayer.Play();
        if(ProgramCounter == 4){
            ProgramCounter = 0;
        }
    }

    private static boolean rightPlayer(){
        if(ProgramCounter == 0)
            if(fPos.getChessman().getTeam() == Team.Black){
                posClear();
                throw new InputMismatchException("This is not your chessman.");
            }
        if(ProgramCounter == 2)
            if(fPos.getChessman().getTeam() == Team.White){
                posClear();
                throw new InputMismatchException("This is not your chessman.");
            }
        return true;
    }


    public static int getProgramCounter(){ return ProgramCounter; }

    /**
     * First position can not be null;
     * New position state
     *      New position can not be fill with same team Chessman
     *
     * @param cPos - Current Position
     * @param nPos - New Position
     * @return True if the chessman can assume that new coordinate
     */
    //Test if the chessman can move to designed position
    public static boolean canMove(BoardSquare cPos, BoardSquare nPos){
        if(cPos.getCoordinate().compareTo(nPos.getCoordinate()) == 0){
            posClear();
            throw new InputMismatchException("Can not move a chessman to the same square.");
        }else if(cPos.getChessman() == null){
            posClear();
            throw new InputMismatchException("There is no chessman at this position.");
        }else if(nPos.getChessman() != null){
            if(nPos.getChessman().getTeam() == cPos.getChessman().getTeam()){
                posClear();
                throw new InputMismatchException("Can not move to a same team chessman position.");
            }
        }
        
        if(cPos.getChessman().MoveFx(cPos, nPos, board)){
            if(nPos.getChessman() != null && nPos.getChessman().getType() == "King"){
                screen = ScreenGx.getInstance();
                UX.controlStage(UX.getWonStage(), screen.wonScreen());
                return true;
            }else
                return true;
        }

        return false;
    }

    private static void posClear(){
        if(ProgramCounter == 4 || ProgramCounter == 1)
            ProgramCounter = 0;
        if(ProgramCounter >= 2)
            ProgramCounter = 2;

        fPos.SquareTransparent();
        fPos = null;
        sPos = null;
    }

    public static void changePawn(){
        if(sPos.getChessman() == null || sPos.getChessman().getType() != "King"){
            screen = ScreenGx.getInstance();
            UX.controlStage(UX.getSecondaryStage(), screen.changePawn(sPos));
        }
    }

    //Set single or multiplayer type game
    public static void setPlayType(boolean b){
        single = b;
    }

    //Send all chessmen on start position
    public static Chessman UnboxChessmen(int pos){
        return iniPosPiece(pos);
    }
    
    /*
     *   Private Methods aux class *
     */

    //Set chessman team at start position
    private static Team iniPosTeam(int pos){
        if(pos <= 15)
            return Team.Black;
        else if(pos >= 48)
            return Team.White;
        else 
            return Team.NONE;
    }

    //Create all chessmen
    private static Chessman iniPosPiece(int pos){
        ProgramCounter = 0;
        if(pos >= 8 && pos <=15 || pos >= 48 && pos <= 55)
            return new Pawn(iniPosTeam(pos));
        else if(pos == 0 || pos == 7 || pos == 56 || pos == 63)
            return new Rook(iniPosTeam(pos));
        else if(pos == 1 || pos == 6 || pos == 57 || pos == 62)
            return new Knight(iniPosTeam(pos));
        else if(pos == 2 || pos == 5 || pos == 58 || pos == 61)
            return new Bishop(iniPosTeam(pos));
        else if(pos == 3 || pos == 59)
            return new Queen(iniPosTeam(pos));
        else if(pos == 4 || pos == 60)
            return new King(iniPosTeam(pos));
        return null;
    }
}
