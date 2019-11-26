//Java default API controls
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class Images extends Button{
public static final int square_Height = 100;
public static final int square_Width = 100;

private static Map<String, Image> images;

    public Images(){
        images = new HashMap<>();
        preLoadImage();
    }
    
    public static Image getImage(String key){
        return images.get(key);
    }

    public static Image getImage(String team, String piece){
        return images.get(team+piece);
    }

    public static void loadImage(String key, String path){
        Image img = new Image(path);
        images.put(key, img);
    }


    public static void preLoadImage(){
        images.put("WhitePawn", new Image("file:Images\\White\\Pawn.png"));
        images.put("WhiteRook", new Image("file:Images\\White\\Rook.png"));
        images.put("WhiteKnight", new Image("file:Images\\White\\Knight.png"));
        images.put("WhiteBishop", new Image("file:Images\\White\\Bishop.png"));
        images.put("WhiteQueen", new Image("file:Images\\White\\Queen.png"));
        images.put("WhiteKing", new Image("file:Images\\White\\King.png"));

        images.put("BlackPawn", new Image("file:Images\\Black\\Pawn.png"));
        images.put("BlackRook", new Image("file:Images\\Black\\Rook.png"));
        images.put("BlackKnight", new Image("file:Images\\Black\\Knight.png"));
        images.put("BlackBishop", new Image("file:Images\\Black\\Bishop.png"));
        images.put("BlackQueen", new Image("file:Images\\Black\\Queen.png"));
        images.put("BlackKing", new Image("file:Images\\Black\\King.png"));
        
        images.put("MenuBackground", new Image("file:Images\\BackgroundMenu.png"));
        images.put("Won", new Image("file:Images\\congrats.jpeg"));
        images.put("Board", new Image("file:Images\\Board.jpg"));
        images.put("Icon", new Image("file:Images\\Icon.png"));
        images.put("null", new Image("file:Images\\Null.jpg"));
        
        //images.put("BoardSquare", new Image("file:Images\\BoardSquare.png"));
    }
}