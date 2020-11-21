package sample.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.PlatillosDAO;


public class Dashboard extends Stage {

    Button btnAdminPlatillo, btnAdmTipoPlatillo;
    private VBox vBox;
    private Scene escena;

    public Dashboard(){

        CrearUI();
        this.setTitle("Panel de administracion del Restaurante el antojito");
        this.setScene(escena);
        this.show();

        //new PlatilloCRUD();
        //new TipoPlatilloCRUD();
    }

    private void CrearUI() {
        btnAdminPlatillo = new Button("Administracion de Platillos");
        btnAdmTipoPlatillo = new Button("Administracion Tipo Platillo");
        vBox = new VBox();

        vBox.getChildren().addAll(btnAdminPlatillo, btnAdmTipoPlatillo);
        escena = new Scene(vBox,250,300);
        btnAdminPlatillo.setOnAction(event -> {
            new PlatilloCRUD();
        });

        btnAdmTipoPlatillo.setOnAction(event -> {
            new TipoPlatilloCRUD();
        });
    }
}

//Creamos en el dashboard una administracion de botones los cuales
//tendran las administraciones de platillo y el administracion de tipo de platillos
//