package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Main extends Application {
    private Controller controller;
    private Stage mainStage;

    @Override
    public void start(Stage theStage) throws Exception{
        mainStage = theStage;
        theStage.setTitle( "POE INC" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 1024, 768 );
        root.getChildren().add( canvas );

        controller = new Controller(canvas);

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {

                controller.nextTurn();

            }
        }.start();


//        theScene.setOnKeyPressed(
//                new EventHandler<KeyEvent>()
//                {
//                    public void handle(KeyEvent e)
//                    {
//                        String code = e.getCode().toString();
//                        System.out.println("Pressed: " + code);
//                    }
//                });
//
//        theScene.setOnKeyReleased(
//                new EventHandler<KeyEvent>()
//                {
//                    public void handle(KeyEvent e)
//                    {
//                        String code = e.getCode().toString();
//                        System.out.println("Released: " + code);
//                    }
//                });

        theStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
