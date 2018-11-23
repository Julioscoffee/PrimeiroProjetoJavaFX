import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloWorldJavaFX extends Application {
    public static void main(String[] args){
        launch();
    }
    
    String musica = getClass().getResource("ROCKADOWN.LIDIOP.mp3").toString();
    
    @Override
    public void start(Stage palco){
        
        //Trilha sonora
        AudioClip clip = new AudioClip(musica);
        clip.play();
        
        //Personagem
        Rectangle ceu = new Rectangle(900, 450, Color.ORANGERED);
        Rectangle mar = new Rectangle(900, 450, Color.DARKBLUE);
        Circle sol = new Circle(130, Color.YELLOW);
        
        //Posicionamento
        ceu.setTranslateY(-200);
        mar.setTranslateY(200);
        sol.setTranslateY(50);
        
        //Movimento
        TranslateTransition mov = new TranslateTransition(Duration.millis(10000), sol);
        mov.setByY(-300);
        mov.setCycleCount(Timeline.INDEFINITE);
        mov.setAutoReverse(true);
        mov.play();
        
        //Transição de cor ceu
        FadeTransition movCeu = new FadeTransition(Duration.millis(10000), ceu);
        movCeu.setFromValue(1.0);
        movCeu.setToValue(0.5);
        movCeu.setCycleCount(Timeline.INDEFINITE);
        movCeu.setAutoReverse(true);
        movCeu.play();
        
        //Transição de cor mar
        FadeTransition movMar = new FadeTransition(Duration.millis(10000), mar);
        movMar.setFromValue(1.0);
        movMar.setToValue(0.8);
        movMar.setCycleCount(Timeline.INDEFINITE);
        movMar.setAutoReverse(true);
        movMar.play();
        
        //coment
        ceu.setStyle("-fx-fill: "
            + "linear-gradient(#efaa22, #ffea6a),"
            + "linear-gradient(#f2ba44, #ffef84),"
            + "linear-gradient(#e68400, #ffd65b),"
            + "linear-gradient(#ffe657 100%, #f8c202 50%, #eea10b 0%),"
            + "linear-gradient(from 0% 0% to 55% 50%, "
            + "rgba(255,255,255,0.9), rgba(255,255,255,0));");
        
        mar.setStyle("-fx-fill: "
            + "linear-gradient(#7FFFD4, #00CED1),"
            + "linear-gradient(#008B8B, #2F4F4F),"
            + "linear-gradient(#00CED1 0%, #20B2AA 50%, #0000CD 100%),"
            + "linear-gradient(from 0% 0% to 55% 50%, "
            + "rgba(255,255,255,0.9), rgba(255,255,255,0));");
        
        //História
        StackPane historia = new StackPane();
        historia.getChildren().addAll(ceu, sol, mar);
        
        //Cena
        Scene cena = new Scene(historia, 900, 900);
        
        //Inserindo a cena no palco
        palco.setScene(cena);
        palco.show();
    }
}
