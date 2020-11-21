package sample.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.components.ButtonCustome;
import sample.components.ButtonCustome2;
import sample.models.PlatillosDAO;
import sample.models.TipoPlatilloDAO;

public class TipoPlatilloCRUD extends Stage {

    private VBox vBox;
    private TableView<TipoPlatilloDAO> tbvTipoPlatillos;
    private Button btnNuevo;
    private Scene escena;
    private TipoPlatilloDAO objTPDAO;
    private int opc;

    public TipoPlatilloCRUD(){

        objTPDAO = new TipoPlatilloDAO();
        CrearUI();

        this.setTitle("Administración de Tipo Platillos");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        tbvTipoPlatillos = new TableView<>();
        CrearTabla();
        btnNuevo = new Button("Nuevo Tipo de Platillo");
        btnNuevo.setOnAction(event -> {
            opc=0; //Boton Insertar
            new FrmTipoPlatillos(tbvTipoPlatillos, null, opc); });
        vBox = new VBox();
        vBox.getChildren().addAll(tbvTipoPlatillos,btnNuevo);
        escena = new Scene(vBox,300,250);
    }

    private void CrearTabla() {
        TableColumn<TipoPlatilloDAO, Integer> tbcIdTipoPlatillo = new TableColumn<>("ID");
        tbcIdTipoPlatillo.setCellValueFactory(new PropertyValueFactory<>("id_tipo"));

        TableColumn<TipoPlatilloDAO, String> tbcNomTipoPlatillo = new TableColumn<>("Nombre Tipo Platillo");
        tbcNomTipoPlatillo.setCellValueFactory(new PropertyValueFactory<>("dsc_tipo"));

        TableColumn<TipoPlatilloDAO,String> tbcEditar = new TableColumn<>("Editar");
        tbcEditar.setCellFactory(new Callback<TableColumn<TipoPlatilloDAO, String>, TableCell<TipoPlatilloDAO, String>>() {
            @Override
            public TableCell<TipoPlatilloDAO, String> call(TableColumn<TipoPlatilloDAO, String> param) {
                return new ButtonCustome2(1);
            }
        });

        TableColumn<TipoPlatilloDAO,String> tbcBorrar = new TableColumn<>("Borrar");
        tbcBorrar.setCellFactory(new Callback<TableColumn<TipoPlatilloDAO, String>, TableCell<TipoPlatilloDAO, String>>() {
            @Override
            public TableCell<TipoPlatilloDAO, String> call(TableColumn<TipoPlatilloDAO, String> param) {
                return new ButtonCustome2(2);
            }
        });


        tbvTipoPlatillos.getColumns().addAll(tbcIdTipoPlatillo,tbcNomTipoPlatillo,tbcEditar,tbcBorrar);
        tbvTipoPlatillos.setItems(objTPDAO.getAllTipo());
    }
}