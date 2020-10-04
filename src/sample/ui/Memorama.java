package sample.ui;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.events.EventosMemorama;

import java.awt.*;

public class Memorama extends Stage implements EventHandler {

    private String[] arImagenes = {"Avestruz.jpg","Buho.jpg","Cebra.jpg","Gorila.jpg","Leon.jpg","loro.jpg","Mariposa.jpg","Serpiente.jpg","Tigre.jpg","Tucan.jpg"};

    private Label lblTarjetas;
    private TextField txtNoTarjetas;
    private Button btnAceptar,btnAceptar2;
    private HBox hbox;
    private VBox vbox;
    private GridPane gdpMesa;
    private Button[][] arTarjetas;
    private String[][] arAsignacion;

    private int noPares;
    private Scene escena;

    public Memorama(){

        CreateUI();
        this.setTitle("Memorama");
        this.setScene(escena);
        this.show();
    }

    private void CreateUI() {
        lblTarjetas = new Label("Numero de Pares:");
        txtNoTarjetas = new TextField();
        btnAceptar = new Button("Voltear y Revolver");
        btnAceptar2 = new Button("Nuevo Mensaje");
        btnAceptar.addEventHandler(MouseEvent.MOUSE_CLICKED,this);
        //btnAceptar2.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventosMemorama(2));
        /*btnAceptar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Tercer Evento desde una clase anonima");
            }
        });*/

        hbox = new HBox();
        hbox.getChildren().addAll(lblTarjetas, txtNoTarjetas, btnAceptar,btnAceptar2);
        hbox.setSpacing(10);

        gdpMesa = new GridPane();
        vbox = new VBox();
        vbox.getChildren().addAll(hbox,gdpMesa);

        escena = new Scene(vbox,500,500);
    }

    @Override
    public void handle(Event event) {

        noPares = Integer.parseInt(txtNoTarjetas.getText());

        vbox.getChildren().remove(gdpMesa);

        gdpMesa = new GridPane();
        arAsignacion = new String[2][noPares];
        revolver();

        arTarjetas = new Button[2][noPares];
        for (int i=0; i<2; i++){
            for (int j=0; j<noPares; j++){

                Image img = new Image("sample/assets/carta_base.jpg");
                ImageView imv = new ImageView(img);
                imv.setFitHeight(120);
                imv.setPreserveRatio(true);

                arTarjetas[i][j] = new Button();
                int finalI = i;
                int finalJ = j;
                arTarjetas[i][j].setOnAction(event1 -> verTarjeta(finalI,finalJ));
                arTarjetas[i][j].setGraphic(imv);
                arTarjetas[i][j].setPrefSize(80,120);

                gdpMesa.add(arTarjetas[i][j],j,i);
            }
        }



        vbox.getChildren().add(gdpMesa);
    }

    private void verTarjeta(int finalI, int finalJ) {

        Image img = new Image("sample/assets/"+arAsignacion[finalI][finalJ]);
        ImageView imv = new ImageView(img);
        imv.setFitHeight(120);
        imv.setPreserveRatio(true);

        arTarjetas[finalI][finalJ].setGraphic(imv);
    }


    private void revolver() {

        for(int i=0; i<2; i++)
            for(int j=0; j<noPares; j++){
                arAsignacion[i][j] = new String();
            }

        int posx, posy, cont = 0;
        for (int i=0; i<noPares;){
            posx = (int)(Math.random() * 2);
            posy = (int)(Math.random() * noPares);
            if(arAsignacion[posx][posy].equals("") ) {
                arAsignacion[posx][posy] = arImagenes[i];
                cont++;
            }

            if(cont == 2){//Sirve para comprobar que la imagen se asigno 2 veces
                i++;
                cont = 0;
            }

        }
    }
}
