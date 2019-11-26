
//Java default API controls
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class UX extends Application{
public static final int COLUMNS = 8;//Game.COLUMNS;
public static final int ROWS = 8;//Game.ROWS;
public static final int lPx = 300;
public static final int lPy = 400;
public static final int gPx = 600;
public static final int gPy = 650;
private static Picture picture;
private static Stage secundaryStage;
private static Stage wonStage;
private Stage primaryStage;
private Scene fitScene;
private ScreenGx screen;

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;

        picture = new Picture("Icon");
        screen = ScreenGx.getInstance();
        screen.setStage(primaryStage);

        Group root = new Group();
        fitScene = new Scene(root, lPx, lPy);
        primaryStage.setTitle("Chess");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(picture.picture());
        
        controlStage(fitScene);
        controlStage(screen.MenuGx());
        primaryStage.show(); 
    }

    public Stage getPrimaryStage(){ return primaryStage; }
    public static Stage getSecondaryStage(){
        if(secundaryStage == null){
            secundaryStage = new Stage();
            secundaryStage.initModality(Modality.APPLICATION_MODAL);
            secundaryStage.initStyle(StageStyle.UNDECORATED);
        }
        return secundaryStage;
    }
    public static Stage getWonStage(){
        if(wonStage == null){
            wonStage = new Stage();
            wonStage.initModality(Modality.APPLICATION_MODAL);
            wonStage.initStyle(StageStyle.UNDECORATED);
        }
        return wonStage;
    }

    public void controlStage(Scene scene){
        controlStage(primaryStage, scene);
    }

    public static void controlStage(Stage s, Scene scene){
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

            //Revifying return
            //System.out.println(Screen.getPrimary().getVisualBounds());

        int px, py;
        px = (int) scene.getWidth();
        py = (int) scene.getHeight();

        //set Stage boundaries to the lower right corner of the visible bounds of the main screen
        s.setX((primaryScreenBounds.getWidth() - px)/2);
        s.setY((primaryScreenBounds.getHeight() - py)/2);
        s.setWidth(px);
        s.setHeight(py);

        s.setScene(scene);
        s.show();
    }
}