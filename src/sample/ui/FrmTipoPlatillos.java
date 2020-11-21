package sample.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.PlatillosDAO;
import sample.models.TipoPlatilloDAO;

public class FrmTipoPlatillos extends Stage {
    private TextField txtdscPlatillo;
    private Button btnGuardar;
    private VBox vBox;
    private Scene escena;
    private TipoPlatilloDAO objTipoPlatillo;
    private TableView<TipoPlatilloDAO> tbvTipoPlatillos;
    private int opcion;

    public FrmTipoPlatillos(TableView<TipoPlatilloDAO> tbvTipoPlatillos, TipoPlatilloDAO objTipoPlatillo, int opc){

        if( objTipoPlatillo != null )
            this.objTipoPlatillo = objTipoPlatillo;
        else
            this.objTipoPlatillo = new TipoPlatilloDAO();

        CrearUI();
        opcion=opc;
        this.setTitle("Gestión de Tipo de Platillos");
        this.setScene(escena);
        this.show();

        this.tbvTipoPlatillos = tbvTipoPlatillos;
    }

    private void CrearUI() {
        txtdscPlatillo = new TextField();
        txtdscPlatillo.setText(objTipoPlatillo.getDsc_tipo());

        btnGuardar = new Button("Guardar Tipo de Platillo");
        btnGuardar.setOnAction(event -> Guardar());

        vBox = new VBox();
        vBox.getChildren().addAll(txtdscPlatillo,btnGuardar);
        escena = new Scene(vBox,250,250);
    }

    private void Guardar() {

        if (opcion==0){
            //agregar
            objTipoPlatillo.setDsc_tipo(txtdscPlatillo.getText());
            objTipoPlatillo.insTipo();
        }else if(opcion==1){
            //actualizar
            objTipoPlatillo.setDsc_tipo(txtdscPlatillo.getText());
           objTipoPlatillo.updTipo();
        }

        tbvTipoPlatillos.setItems(objTipoPlatillo.getAllTipo());
        tbvTipoPlatillos.refresh();
        this.close();
    }
}
//Creamos opciones de agregar y crear con las opciones
//




/*objPlatillo.setNombre_platillo(txtPlatillo.getText());
        objPlatillo.setPrecio(Float.parseFloat(txtPrecio.getText()));
        objPlatillo.setId_tipo(1);  // Valor fijo temporalmente

        if( objPlatillo == null ) { // PROCESO DE NUEVO PLATILLO
            objPlatillo.insPlatillo();
        }else {                     // PROCESO PARA ACTUALIZAR EL PLATILLO
            objPlatillo.updPlatillo();
        }

        tbvPlatillos.setItems(objPlatillo.getAllPlatillo());
        tbvPlatillos.refresh();
        this.close();*/

        /*objPlatillo = new PlatillosDAO();
        objPlatillo.setNombre_platillo(txtPlatillo.getText());
        objPlatillo.setPrecio(Float.parseFloat(txtPrecio.getText()));
        objPlatillo.setId_tipo(1);
        objPlatillo.insPlatillo();

        tbvPlatillos.setItems(objPlatillo.getAllPlatillo());
        tbvPlatillos.refresh();
        this.close();*/