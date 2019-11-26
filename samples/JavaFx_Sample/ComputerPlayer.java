import javafx.scene.layout.GridPane;
import java.util.Random;

public class ComputerPlayer{
private static Random random;
private static BoardSquare fPos;
private static BoardSquare sPos;
private static GridPane board;

    public static void Play(){
        if(random == null)
            random = new Random();

            board = Game.getOnBoard();
            fPos = null;
            sPos = null;

        if(Game.getProgramCounter() == 2){
            do{
                findfsPos();
                System.out.println("Really nigga?");
                System.out.println("Coord 1: "+fPos.getCoordinate());
                System.out.println("Coord 2: "+sPos.getCoordinate());
                //if(fPos.getChessman().MoveFx(fPos, sPos, board)){
                //    fPos.moveChessman(sPos);
                //    break;
                //}
            }while(true);    
        }
    }


    private static void findfsPos(){
        int rdm;
        do{
            rdm = random.nextInt(64);
            fPos = (BoardSquare) board.getChildren().get(rdm);
        }while(fPos.getChessman() == null || fPos.getChessman().getTeam() != Team.Black);

        do{
            rdm = random.nextInt(64);
            sPos = (BoardSquare) board.getChildren().get(rdm);
        }while(fPos.getCoordinate().compareTo(sPos.getCoordinate()) == 0 ||
               sPos.getChessman().getTeam() == Team.Black);
    }
}