//Java default API controls
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;


public class BoardSquare extends Button{
    private final Coordinate coordinate;
    private Chessman chessman;

    //Constructor without chessman
    //@Param set board coordinate without chessman (empty spot);
    public BoardSquare(Coordinate coordinate){
        super();
        this.coordinate = coordinate;
        this.chessman = null;
    }
    //Overload constructor
    //@Param set board coordinate and the respective chessman at;
    public BoardSquare(Coordinate coordinate, Chessman piece){
        super();
        this.coordinate = coordinate;
        this.chessman = piece;
    }

    //Return square coordinate
    public Coordinate getCoordinate(){ return coordinate; }

    //Return currently chessman on the square
    public Chessman getChessman(){
        return chessman;
    }


    //Move the currently chessman to a new spot
    //@Param is the new place which the chessman will be moved.
    public void moveChessman(BoardSquare newSpot){
        newSpot.moveChessman(chessman);
        chessman = null;
        setImg();
    }

    //Replace the currently chessman by a new one
    //@Param is the new chessman that will stay at square;
    public void moveChessman(Chessman newPiece){
        chessman = newPiece;
        setImg();
    }

    //Set button style to transparent
    public void SquareTransparent(){
        setStyle("-fx-background-color: transparent;");
    }

    public void SquareSelect(){
        setStyle("-fx-background-color: red;" +
                 "-fx-opacity: 0.15;");
    }

    public void setImg(){
        Picture picture;
        if(chessman == null)
            picture = new Picture("Null");
        else
            picture = new Picture(chessman.toString());

        ImageView imgVW = new ImageView(picture.picture());
        imgVW.setFitWidth(Board.SquareSize-20);
        imgVW.setFitHeight(Board.SquareSize-20);
        setGraphic(imgVW);
    }
}