//Java default API controls
import javafx.collections.ObservableList;
import java.util.InputMismatchException;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;


public class Board extends GridPane{
    public static final int SquareSize = 65;
    public static final int COLUMNS = 8;
    public static final int ROWS = 8;
    public static final int SIZE = COLUMNS * ROWS;

    private Coordinate coordinate;
    private BoardSquare square;
    private Chessman chessman;

    
    public Board() throws InputMismatchException{
        super();
        setExceptionWay();

        //Create every 64 board spots
        //@Params treeMap(Key, Value) --Key = Integer -> Board coordinate position 
        //                             --Value = BoardSquare -> Squart Coordinated
        //@Params BoardSquare(Coordinate, Chessman)
        //@Params Coordinate(i) --i = board coordinate position "(Matrix)Vector"
        for(int i = 0; i < SIZE; i ++){
            chessman = Game.UnboxChessmen(i);
            coordinate = new Coordinate(i);
            square = new BoardSquare(coordinate, chessman);
            square.setOnAction(e -> squareCatch(e));
            square.setMinSize(SquareSize, SquareSize);
            square.SquareTransparent();
            square.setImg();
            super.add(square, coordinate.getColumn(), coordinate.getRow());
        }

        //Set grid settings
        coordinate = new Coordinate(0);
        //setGridLinesVisible(true);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(1));
        setHgap(1.3);
        setVgap(1.3);
    }

    //Catch onAction event
    public void squareCatch(ActionEvent e) throws InputMismatchException{
        BoardSquare square = (BoardSquare) e.getSource();
        if(Game.getProgramCounter() == 0 || Game.getProgramCounter() == 2)
            square.SquareSelect();
            
        Game.setOnBoard(onBoard());    
        Game.setPointer(square);
    }

    //Get all BoardSquares occupied
    private GridPane onBoard(){
        GridPane grid = new GridPane();

        //Copy containing grid on super class
        ObservableList<Node> childrens = super.getChildren();
        //Iterate grid finding positions and which is filled
        for (Node node : childrens){
            if(node instanceof BoardSquare){
                BoardSquare osquare = (BoardSquare) node;
                square = new BoardSquare(osquare.getCoordinate(), osquare.getChessman());
                grid.add(square, square.getCoordinate().getColumn(), square.getCoordinate().getRow());
            }
        }

            //Set grid settings
            //grid.setGridLinesVisible(true);
            grid.setAlignment(Pos.CENTER);
            grid.setPadding(new Insets(1));
            grid.setHgap(1.3);
            grid.setVgap(1.3);
        return grid;
    }

    //Set where (Screen-> Game)Exception should be treated 
    public static void setExceptionWay(){
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
    }
}