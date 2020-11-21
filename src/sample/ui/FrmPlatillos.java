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

public class FrmPlatillos extends Stage {
    private TextField txtPlatillo, txtPrecio;
    private ComboBox<TipoPlatilloDAO> cbxTipo;
    private Button btnGuardar;
    private VBox vBox;
    private Scene escena;
    private PlatillosDAO objPlatillo;
    private TipoPlatilloDAO objTipoPlatilloDao;
    private TableView<PlatillosDAO> tbvPlatillos;
    private int opcion;

    public FrmPlatillos(TableView<PlatillosDAO> tbvPlatillos,PlatillosDAO objPlatillo, int opc){

        if( objPlatillo != null )
            this.objPlatillo = objPlatillo;
        else
            this.objPlatillo = new PlatillosDAO();

        CrearUI();
        opcion=opc;
        this.setTitle("Gestión de Platillos");
        this.setScene(escena);
        this.show();

        this.tbvPlatillos = tbvPlatillos;
    }

    private void CrearUI() {
        txtPlatillo = new TextField();
        txtPlatillo.setText(objPlatillo.getNombre_platillo());
        txtPrecio = new TextField();
        txtPrecio.setText(objPlatillo.getPrecio()+"");

        cbxTipo = new ComboBox<>();
        cbxTipo.setItems(new TipoPlatilloDAO().getAllTipo());

        btnGuardar = new Button("Guardar Platillo");
        btnGuardar.setOnAction(event -> Guardar());

        vBox = new VBox();
        vBox.getChildren().addAll(txtPlatillo,txtPrecio,cbxTipo,btnGuardar);
        escena = new Scene(vBox,250,250);
    }

    private void Guardar() {

        if (opcion==0){
            //agregar
            objPlatillo.setNombre_platillo(txtPlatillo.getText());
            objPlatillo.setPrecio(Float.parseFloat(txtPrecio.getText()));
            String dsc_tipo= cbxTipo.getSelectionModel().getSelectedItem().toString();
            objTipoPlatilloDao = new TipoPlatilloDAO();
            int id_tipo = objTipoPlatilloDao.obtIdTipoPlatillo(dsc_tipo);
            objPlatillo.setId_tipo(id_tipo);
            objPlatillo.insPlatillo();

        }else if(opcion==1){
            //actualizar
            objPlatillo.setNombre_platillo(txtPlatillo.getText());
            objPlatillo.setPrecio(Float.parseFloat(txtPrecio.getText()));
            String dsc_tipo= cbxTipo.getSelectionModel().getSelectedItem().toString();
            objTipoPlatilloDao = new TipoPlatilloDAO();
            int id_tipo = objTipoPlatilloDao.obtIdTipoPlatillo(dsc_tipo);
            objPlatillo.setId_tipo(id_tipo);
            objPlatillo.updPlatillo();

        }

        tbvPlatillos.setItems(objPlatillo.getAllPlatillo());
        tbvPlatillos.refresh();
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