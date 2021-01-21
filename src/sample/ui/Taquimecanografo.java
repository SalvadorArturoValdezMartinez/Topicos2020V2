
package sample.ui;

import sample.events.EventoTeclado;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.TimerTask;
import java.util.Timer;


public class Taquimecanografo extends Stage{

    private Scene escena;
    private VBox vbox;
    private ToolBar tlbMenu;
    private TextArea txtTexto, txtescritura;
    public HBox[] filas;
    public VBox vTeclado;
    private Button btnAbrir, btnFinal;
    private FileChooser flcArchivo;
    public FileInputStream entrada;
    private Label lblEr, lblCont;
    private TextField txtConta, txtEr;
    private     Timer timer = new Timer();
    Icon iconT, iconF;


    private Button[] arTFunciones;
    private Button[] arTNumeros;
    private Button[] arTTabulador;
    private Button[] arTMayus;
    private Button[] arTShift;
    private Button[] arTEspacio;

    public Taquimecanografo(){
        CrearGui();
        this.setTitle("Taquimecanografo");
        this.setScene(escena);
        this.setMaximized(true);
        //escena.getStylesheets().add(getClass().getResource("../CSS/taqui.css").toExternalForm());
        this.show();

    }

    private void CrearGui() {

        //ImageView img = new ImageView("src/Images/finaliza.png");
        ImageView img = new ImageView("assets/finaliza.jpg");
        img.setFitWidth(50);
        img.setFitHeight(50);

        vbox = new VBox();

        /* crear toolbar*/

        tlbMenu = new ToolBar();

        btnAbrir = new Button();
        btnAbrir.setOnContextMenuRequested(event -> BuscarArchivo());
        btnAbrir.setGraphic(new ImageView("assets/open.png"));


        lblEr = new Label(" Errores: ");
        txtEr = new TextField("0");
        txtEr.setEditable(false);

        lblCont = new Label(" Tiempo: ");
        txtConta = new TextField("000");
        txtConta.setEditable(false);




        btnFinal = new Button("Finalizar");
        btnFinal.setOnAction(MouseEvent -> btnFinalizar());
        btnFinal.setGraphic(img);

        tlbMenu.getItems().addAll(btnAbrir, lblEr, txtEr, lblCont, txtConta, btnFinal);

        //////////////////

        /* Caja de texto*/

        txtTexto = new TextArea();
        txtTexto.setPrefColumnCount(100);//Columnas que se visializan (hay que revisar)
        txtTexto.setPrefRowCount(5);//renglos que se visualizan
        txtTexto.setEditable(false);

        //////////////////


        ////////////////////////////////

        /* Creamos la seccion del teclado*/

        CrearTeclado();

        ////////////////////

        /* Caja de texto para capturar*/
        int a=0;
        txtescritura = new TextArea();
        txtescritura.setPrefRowCount(5);
        txtescritura.addEventHandler(KeyEvent.KEY_PRESSED, new EventoTeclado(this,1 ));//se asigna el evento que se realizara
        txtescritura.addEventHandler(KeyEvent.KEY_RELEASED, new EventoTeclado(this,0 ));


        vbox.getChildren().addAll(tlbMenu,txtTexto, txtescritura,vTeclado);

        escena = new Scene(vbox,400,500);

    }

    private void BuscarArchivo() {


        flcArchivo = new FileChooser();
        flcArchivo.setTitle("Buscar archivo");
        FileChooser.ExtensionFilter filtro = new FileChooser.ExtensionFilter("Archivos TXT (*.txt)", "*.txt");
        flcArchivo.getExtensionFilters().add(filtro);
        File archivo =  flcArchivo.showOpenDialog(this);


        if(archivo != null){


            if(archivo.canRead()){

                if(archivo.getName().endsWith("txt")){

                    String doc = openFile(archivo);
                    txtTexto.setText(doc);

                }

            }

        }

        metTimer();

        System.out.println("hola");


    }

    private String openFile(File archivo) {



        String doc = "";
        try{
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read()) != -1){
                char caracter = (char) ascci;
                doc += caracter;
            }
        }catch (Exception e){

        }

        return doc;

    }

    public void  metTimer(){



        Platform.runLater(new Runnable() {
            @Override
            public void run() {



                TimerTask tarea = new TimerTask() {

                    int cont = 0;
                    @Override
                    public void run() {

                        txtConta.setText(String.valueOf(cont));
                        System.out.println("Cuento: "+cont);
                        cont++;

                    }
                };


                timer.schedule(tarea, 0, 1000);

            }
        });



    }

    public void btnFinalizar(){

        iconF = new ImageIcon("assets/Doh.jpg");
        iconT = new ImageIcon("assets/termine.gif");
        ((ImageIcon) iconT).getImage().getScaledInstance(28, 28, Image.SCALE_DEFAULT);
        int error=0;


        if((txtTexto.getText().equals(txtescritura.getText())) == true) {


            timer.cancel();
            JOptionPane.showMessageDialog(null,""," ¡¡YUUJUUU!! ",JOptionPane.WARNING_MESSAGE,iconT);
            //txtescritura.setText(null);
            //txtTexto.setText(null);


        }else{


            for (int i = 0; i < txtTexto.getText().length(); i++) {

                if (txtTexto.getText().charAt(i) != txtescritura.getText().charAt(i)) {

                    error++;

                }

            }


            System.out.println("Error: "+error);

            timer.cancel();
            txtEr.setText(String.valueOf(error));
            JOptionPane.showMessageDialog(null,"Errores: "+error, "¡Noooo!", JOptionPane.OK_OPTION,iconF);

        }


    }


    private void CrearTeclado() {//metodo generico para todas las filas

        String [] tecla = {"Esc","F1","F2","F3","F4","F5","F6","F7","F8","F9","F10","F11","F12","supr"};//etiqueta para todos los nombres
        String [] tecla2 = {"1","2","3","4","5","6","7","8","9","0","'","¿", "←"};//etiqueta para todos los nombres
        String [] tecla3 = {"⇄","Q","W","E","R","T","Y","U","I","O","P","´","+", "↵"};//etiqueta para todos los nombres
        String [] tecla4 = {"Mayús","A","S","D","F","G","H","J","K","L","Ñ","{","}","↵"};//etiqueta para todos los nombres
        String [] tecla5 = {"<","Z","X","C","V","B","N","M",",",".","-", "↑","↑"};//etiqueta para todos los nombres
        String [] tecla6 = {"ctrl", "fn", "windows", "alt", "  espacio  ", "AltGr", "≡", "Ctrl", "←", "↓", "→"};//etiqueta para todos los nombres

        filas = new HBox[6];
        vTeclado = new VBox();
        for (int i = 0; i < 6; i++){
            filas[i] = new HBox();
            vTeclado.getChildren().add(filas[i]);
        }

        /////Es para pintar las teclas////
        CrearFila(tecla,arTFunciones,filas[0]);
        CrearFila(tecla2,arTNumeros,filas[1]);
        CrearFila(tecla3,arTTabulador,filas[2]);
        CrearFila(tecla4,arTMayus,filas[3]);
        CrearFila(tecla5,arTShift,filas[4]);
        CrearFila(tecla6,arTEspacio,filas[5]);
        /////////////////////////

    }

    private void CrearFila(String[] tecla, Button[] arBotones, HBox hFilas){

        arBotones = new Button[tecla.length];
        for (int i = 0; i < tecla.length; i++){

            arBotones[i] = new Button(tecla[i]);
            arBotones[i].setId(tecla[i]);
            arBotones[i].setPrefSize(230,50);
            arBotones[i].setStyle("-fx-base: #333333");
            hFilas.getChildren().add(arBotones[i]);

        }

    }

}