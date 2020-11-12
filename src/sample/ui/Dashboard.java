package sample.ui;

import javafx.scene.control.TableView;
import javafx.stage.Stage;
import sample.models.PlatillosDAO;

public class Dashboard extends Stage {
    
    public Dashboard(){
        CrearUI();
        this.setTitle("Panel de administracion del Restaurante el antojito");
        this.show();

        new PlatilloCRUD();
    }

    private void CrearUI() {
    }
}
