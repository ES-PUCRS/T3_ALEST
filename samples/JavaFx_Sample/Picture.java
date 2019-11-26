//Java default API controls
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Picture extends Images{
    private ImageView imageView;
    private Image image;

    public Picture(){
        super();
    }
    public Picture(String picture){
        super();
        hold(picture);
    }

    //Get a picture from Images class and hold on instance
    public void hold(String key){
        image = super.getImage(key);
        getView();
    }

    //Return image holded in class
    public Image picture(){
        return image;
    }

    //Return Imageview default
    public ImageView getView(){
        return getView(300, 400, 0.0);
    }
    //Overload with rotation
    public ImageView getView(double dg){
        return getView(300, 400, dg);
    }
    //Overload with custom size without rotation
    public ImageView getView(int px, int py){
        return getView(px, py, 0.0);
    }
    //Overload with custom size and rotation
    public ImageView getView(int px, int py, double dg){
        imageView = new ImageView(image);
        imageView.setFitWidth(px);
        imageView.setFitHeight(py);
        setGraphic(imageView);
        imageView.setRotate(dg);
        return imageView;
    }
}