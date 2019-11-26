//Java default API controls
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;

public class AlertList{
    private static AlertList instance;
    private static ScreenGx screen;

    private AlertList(){
        screen = ScreenGx.getInstance();
    } 
    
    public static AlertList getInstance(){
        if (instance == null)
           instance = new AlertList();
        return instance;
   }

    public void IllegalMovement(String message){
        Alert IllegalMovement = new Alert(AlertType.WARNING);

        IllegalMovement.setTitle("Invalid moviment!");
        IllegalMovement.setHeaderText(message);
        IllegalMovement.setContentText("Select another ches sman position to keep playing.");
        
        IllegalMovement.showAndWait();
    }
    
    public void LeftGame(){
        Alert LeftGame = new Alert(AlertType.CONFIRMATION);
        LeftGame.setTitle("Your game was not save.");
        LeftGame.setHeaderText("Leave will lost running game.");
        LeftGame.setContentText("Are you sur that you want to leave?");
        
        ButtonType sure, saveBefore, cancel;
        sure = new ButtonType("Leave anyway");
        saveBefore = new ButtonType("Save before");
        cancel = new ButtonType("Nevermind");
        LeftGame.getButtonTypes().setAll(sure, saveBefore, cancel);
        
        LeftGame.showAndWait().ifPresent(b ->{
            if(b == sure)
                UX.controlStage(ScreenGx.getStage(), screen.MenuGx());
            //else if(b == saveBefore)
                //UX.controlStage(ScreenGx.getStage(), screen.Save());
            else LeftGame.close();
        });
    }


}