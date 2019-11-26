//Java default API controls
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ScreenGx {
    public static final int gPxBorded = UX.gPx - 10;
    public static final int gPyBorded = UX.gPy - 58;
    private static ScreenGx instance;
    private static Stage s;

    private static Scene changePawn;

    private GridPane gridMaster;
    private GridPane Background;
    private AlertList alert;
    private MenuBar menuBar;
    private GridPane board;

    private ScreenGx() {
        builder();
    }

    public void setStage(Stage stage) {
        s = stage;
    }

    public static Stage getStage() {
        return s;
    }

    public static ScreenGx getInstance() {
        if (instance == null)
            instance = new ScreenGx();
        return instance;
    }

    public Scene Save() {
        Picture picture = new Picture("MenuBackground");
        GridPane gridMaster = new GridPane();
        GridPane grid = new GridPane();
        grid.add(picture, 0, 0);
        Scene save = new Scene(gridMaster, UX.lPx, UX.lPy);
        return save;
    }

    public Scene MenuGx() {
        Picture picture = new Picture("MenuBackground");

        Button singlePlay = new Button("Single player");
        Button multiPlay = new Button("Multi  player");

        GridPane gridMaster = new GridPane();
        GridPane grid = new GridPane();

        gridMaster.add(picture.getView(), 0, 0);
        gridMaster.add(grid, 0, 0);

        Text menuTxt = new Text("Menu");
        menuTxt.setFont(Font.font("Times new roman", FontWeight.MEDIUM, 30));

        HBox hb = new HBox();
        VBox vb = new VBox();
        vb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(20);
        grid.setPadding(new Insets(25));

        hb.getChildren().add(menuTxt);
        vb.getChildren().add(singlePlay);
        vb.getChildren().add(multiPlay);
        grid.add(hb, 0, 0);
        grid.add(vb, 0, 1);

        /*
        singlePlay.setOnAction(e -> {
            Game.setPlayType(true);
            UX.controlStage(s, Select());
        });
        */
        
        multiPlay.setOnAction(e -> {
            Game.setPlayType(false);
            UX.controlStage(s, Select());
        });
        Scene menu = new Scene(gridMaster, UX.lPx, UX.lPy);
        return menu;
    }

    public Scene Select() {
        Picture picture = new Picture("MenuBackground");

        Button newGame = new Button("New  game");
        Button loadGame = new Button("Load game");

        Text space = new Text("  ");
        space.setFont(Font.font("Times new roman", FontWeight.MEDIUM, 20));

        GridPane gridMaster = new GridPane();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25));

        gridMaster.add(picture.getView(), 0, 0);
        gridMaster.add(grid, 0, 0);

        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(space);

        grid.setHgap(10);
        grid.setVgap(20);

        VBox vb = new VBox();
        vb.setSpacing(10);
        grid.setAlignment(Pos.CENTER);

        vb.getChildren().add(newGame);
        vb.getChildren().add(loadGame);

        grid.add(hb, 0, 0);
        grid.add(vb, 0, 1);

        newGame.setOnAction(e -> UX.controlStage(s, GameGx()));
        // loadGame.setOnAction(e -> trataAcao(e));

        Scene select = new Scene(gridMaster, UX.lPx, UX.lPy);
        return select;
    }

    /**
     * Alert set -> *Case try to leave game without saving \-> Throw Alert with
     * possible go options
     * 
     * Create all grids needed; * MasterPane = Contains every grid; * Background =
     * Hold background image; * Board = Hold every board button; * Chessmen =
     * Contains every chessmen image;
     * 
     * Set grid settings; Put background image into Background grid; Create menu bar
     * and set dependencies; Get setOnAction event buttons Put every grid into
     * Master and organize layers;
     * 
     * @return Scene game
     */
    public Scene GameGx() {
        alert = AlertList.getInstance();
        Picture picture = new Picture();

        gridMaster = new GridPane();
        Background = new GridPane();
        board = new Board();

        gridMaster.setAlignment(Pos.CENTER);

        picture.hold("Board");
        Background.add(picture.getView(gPxBorded + 2, gPyBorded + 2, 0.1), 0, 1);

        menuBar = new MenuBar();
        // Menu File
        Menu menuGame = new Menu("Game");
        MenuItem save = new MenuItem("Save");
        MenuItem load = new MenuItem("Load");
        MenuItem menu = new MenuItem("Menu");
        menuGame.getItems().addAll(save, load, menu);
        menuBar.getMenus().addAll(menuGame);

        // save.setOnAction(e -> UX.controlStage(s, Save()));
        // load.setOnAction(e -> controlStage(screenSave()));
        menu.setOnAction(e -> alert.LeftGame());

        gridMaster.add(Background, 0, 1);
        gridMaster.add(menuBar, 0, 0);
        gridMaster.add(board, 0, 1);

        Scene game = new Scene(gridMaster, UX.gPx, UX.gPy);
        return game;
    }


    public Scene wonScreen() {
        Picture picture = new Picture("Won");
        GridPane gridMaster = new GridPane();
        Button ok = new Button("Back to menu");

        ok.setOnAction(e -> {
            UX.controlStage(s, MenuGx());
            UX.getWonStage().close();
        });

        VBox vb = new VBox();
        vb.setAlignment(Pos.BOTTOM_CENTER);
        vb.getChildren().addAll(ok);

        gridMaster.add(picture.getView(500, 200),0,0);
        gridMaster.add(vb,0,0);
        Scene won = new Scene(gridMaster, 500, 200);
        return won;
    }



    private static Stage secondaryStage;
    private static GridPane newScreen;
    private static Button Bishop;
    private static Button Knight;
    private static Button Queen;
    private static Button Rook;

    private static void builder(){
        newScreen = new GridPane();
        changePawn = new Scene(newScreen, 400, 200);
        Bishop = new Button();
        Knight = new Button();
        Queen = new Button();
        Rook = new Button();
        secondaryStage = UX.getSecondaryStage();

        Label text = new Label("Your pawn got promoted."+
                               "\nThis pawn reaches the other end of the board"+
                               "\nSelect which chessman he will become.");

        VBox vb = new VBox();
        HBox hb = new HBox();

        newScreen.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(Bishop, Knight, Queen, Rook);
        vb.getChildren().addAll(text, hb);
        hb.setSpacing(25);
        vb.setSpacing(20);
        
        newScreen.add(vb,0,0);
    }
    public Scene changePawn(BoardSquare square) {
        String team;
        
        if(square.getCoordinate().getRow() == 0)
            team = "White";
        else
            team = "Black";

        setButtonImg(Bishop, team + "Bishop");
        setButtonImg(Knight, team + "Knight");
        setButtonImg(Queen, team + "Queen");
        setButtonImg(Rook, team + "Rook");

        Bishop.setOnAction(e -> {
            square.moveChessman(new Bishop(getTeam(team)));
            secondaryStage.close();});
        Knight.setOnAction(e -> {
            square.moveChessman(new Knight(getTeam(team)));
            secondaryStage.close();});
        Queen.setOnAction(e -> {
            square.moveChessman(new Queen(getTeam(team)));
            secondaryStage.close();});
        Rook.setOnAction(e -> {
            square.moveChessman(new Rook(getTeam(team)));
            secondaryStage.close();});

        return changePawn;
    }
    private static Team getTeam(String team){
        if(team == "Black")
            return Team.Black;
        else
            return Team.White;
    }
    private static void setButtonImg(Button bt, String img){
        Picture picture = new Picture(img);
        ImageView imgVW = new ImageView(picture.picture());
        
        imgVW.setFitWidth(Board.SquareSize-20);
        imgVW.setFitHeight(Board.SquareSize-20);

        bt.setGraphic(imgVW);
    }

}


//Do not use this junk.
/*
board.getChildren().forEach(item -> {
    item.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if (event.getClickCount() == 1) {
                GridPane refreshGrid = new GridPane();
                chessmen = ((Board) board).onBoard();
                refreshGrid.add(Background, 0, 1);
                refreshGrid.add(chessmen, 0, 1);
                refreshGrid.add(menuBar, 0, 0);
                refreshGrid.add(board, 0, 1);
                gridMaster.getChildren().setAll(refreshGrid);
            }
        }
    });
});
*/
