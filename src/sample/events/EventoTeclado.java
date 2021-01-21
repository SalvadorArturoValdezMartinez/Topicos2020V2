package sample.events;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import sample.ui.Taquimecanografo;

import java.util.ArrayList;
import java.util.List;

public class EventoTeclado implements EventHandler<KeyEvent>{

    private Taquimecanografo tecla;
    private int opc;
    private Scene escena;

    public void setEscena(Scene escena) {
        this.escena = escena;
    }

    public EventoTeclado(Taquimecanografo tecla, int opc){

        this.tecla = tecla;
        this.opc = opc;

    }


    @Override
    public void handle(KeyEvent event) {
        //System.out.println("Pica: "+event.getText());
        List<Node> botonesTemp;
        List<Node> botones= new ArrayList<>();

        for (int i = 0; i < tecla.filas.length; i++) {
            botonesTemp=tecla.filas[i].getChildren();
            for (int j = 0; j < botonesTemp.size() ; j++) {
                botones.add(botonesTemp.get(j));
                //System.out.println(botonesTemp.get(j).getId());
            }
        }


        for (int i = 0; i <botones.size() ; i++) {


            if(botones.get(i).getId().equals("<-")){
                if((event.getCode()+"").equals("BACK_SPACE")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("Enter")){
                if((event.getCode()+"").equals("ENTER")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("¿")){
                if((event.getCode()+"").equals("INVERTED_EXCLAMATION_MARK")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("Esc")){
                if((event.getCode()+"").equals("ESCAPE")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("F1")){
                if((event.getCode()+"").equals("F1")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("F2")){
                if((event.getCode()+"").equals("F2")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("F3")){
                if((event.getCode()+"").equals("F3")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("F4")){
                if((event.getCode()+"").equals("F4")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("F5")){
                if((event.getCode()+"").equals("F5")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("F6")){
                if((event.getCode()+"").equals("F6")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("F7")){
                if((event.getCode()+"").equals("F7")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("F8")){
                if((event.getCode()+"").equals("F8")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("F9")){
                if((event.getCode()+"").equals("F9")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals("F10")){
                if((event.getCode()+"").equals("F10")){

                    if (opc==1){
                        botones.get(i).setStyle("-fx-base: #888888");

                    }
                    else{
                        botones.get(i).setStyle("-fx-base: #333333");
                    }
                }
            }
            if(botones.get(i).getId().equals(event.getText()) || botones.get(i).getId().equals(event.getText().toUpperCase() )){

                if (opc==1){
                    botones.get(i).setStyle("-fx-base: #888888");

                    //System.out.println("Si entreeeeeeeeeeeeeeeee");
                }
                else{
                    botones.get(i).setStyle("-fx-base: #333333");
                }

            }
        }
    }
}
