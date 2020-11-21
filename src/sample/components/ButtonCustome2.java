package sample.components;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import sample.models.PlatillosDAO;
import sample.models.TipoPlatilloDAO;
import sample.ui.FrmPlatillos;
import sample.ui.FrmTipoPlatillos;

import java.util.Optional;

public class ButtonCustome2 extends TableCell<TipoPlatilloDAO,String> {

    private Button btnCelda;
    private TipoPlatilloDAO objTipoPlatillo;

    public ButtonCustome2(int opc){
        if( opc == 1 ) {
            btnCelda = new Button("Editar");
            btnCelda.setOnAction( event -> {
                objTipoPlatillo = ButtonCustome2.this.getTableView().getItems().get(ButtonCustome2.this.getIndex());
                new FrmTipoPlatillos(ButtonCustome2.this.getTableView(),objTipoPlatillo,opc);
            });
        }
        else{
            btnCelda = new Button("Borrar");
            btnCelda.setOnAction(event -> {

                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Mensaje del Sistema :)");
                alerta.setHeaderText("Confirmando acción");
                alerta.setContentText("¿Realmente deseas borrar el registro?");
                Optional<ButtonType> result = alerta.showAndWait();
                if( result.get() == ButtonType.OK ){
                    // Obtenemos el objeto de tipo Platillos de acuerdo al renglón seleccionado
                    objTipoPlatillo = ButtonCustome2.this.getTableView().getItems().get(ButtonCustome2.this.getIndex());
                    objTipoPlatillo.delTipo();

                    // Actualizamos el TableView
                    ButtonCustome2.this.getTableView().setItems(objTipoPlatillo.getAllTipo());
                    ButtonCustome2.this.getTableView().refresh();
                }
            });
        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if( !empty )
            setGraphic(btnCelda);
    }
}