package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
 HBox hBox;
 Button btn1, btn2;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        btn1 = new Button("Boton1");
        btn2 = new Button("Boton2");
        hBox = new HBox();
        hBox.getChildren().addAll(btn1,btn2);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(hBox, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
