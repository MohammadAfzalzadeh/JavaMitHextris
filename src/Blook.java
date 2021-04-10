import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Blook {
    private static final int GHAME_HARKAT=10;
    private int type;
    private Pane root;
    private double x;
    private double y;
    private Image img;
    private ImageView imgVi;
    //hexagonhexagon
    Blook(Pane root){
        this.root = root;
        setType();
        drawImage(this.root);
    }
    private void drawImage(Pane root){
        String s = "file:D:/java FX Prg/HextrisMintermPrg/src/images/"+type+".png";
        img = new Image(s);
        imgVi = new ImageView(img);
        imgVi.setX(300);
        imgVi.setY(0);
        root.getChildren().add(imgVi);
    }
    private void setType(){
        type = (int) ((Math.random()*4)+1);
    }
    public void move(Scene s){
        Timeline tl = new Timeline(new KeyFrame(new Duration(1000),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        readEventAndDoIt(s);
                        imgVi.setY(imgVi.getY()+GHAME_HARKAT);
                        if(isThisTheEnd()) {
                            setType();
                            drawImage(root);
                            imgVi.setY(0);
                        }
                    }
                }));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
    }
    // this method is for Is this image at the end
    // if this at end return true
    //else return false
    //اين تابع بايد اصلاح شود
    private boolean isThisTheEnd(){
        boolean b;
        b =  imgVi.getY() >= 600;
        return b;
    }

    private void readEventAndDoIt(Scene s){
        s.setOnKeyPressed(e -> {
            if(e.getCode()== KeyCode.RIGHT)
                imgVi.setX(imgVi.getX()+GHAME_HARKAT);
            if(e.getCode()== KeyCode.LEFT)
                imgVi.setX(imgVi.getX()-GHAME_HARKAT);
            if(e.getCode()== KeyCode.DOWN)
                imgVi.setY(imgVi.getY()+GHAME_HARKAT);
        });
    }

}
