package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Statement;

public class TipoPlatilloDAO {

    private int id_tipo;
    private String dsc_tipo;

    public int getId_tipo() { return id_tipo; }
    public void setId_tipo(int id_tipo) { this.id_tipo = id_tipo; }
    public String getDsc_tipo() { return dsc_tipo; }
    public void setDsc_tipo(String dsc_tipo) { this.dsc_tipo = dsc_tipo; }

    public void insTipo(){
        try{
            String query = "INSERT INTO tbl_tipoplatillo (dsc_tipo) VALUES('"+dsc_tipo+"')";
            Statement stmt = Conexion.con.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void updTipo(){
        try{
            String query = "UPDATE tbl_tipoplatillo SET dsc_tipo = '"+dsc_tipo+"' WHERE id_tipo = "+id_tipo;
            Statement stmt = Conexion.con.createStatement();
            stmt.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delTipo(){
        try{
            String query = "DELETE FROM tbl_tipoplatillo WHERE id_tipo = "+id_tipo;
            Statement stmt = Conexion.con.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ObservableList<TipoPlatilloDAO> getAllTipo(){
        ObservableList<TipoPlatilloDAO> listaTipo = FXCollections.observableArrayList();
        try{
            TipoPlatilloDAO tipoP;
            String query = "select * from tbl_tipoplatillo order by dsc_tipo";
            Statement stmt = Conexion.con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                tipoP = new TipoPlatilloDAO();
                tipoP.setId_tipo(res.getInt("id_tipo"));
                tipoP.setDsc_tipo(res.getString("dsc_tipo"));
                listaTipo.add(tipoP);
            }
        }catch(Exception e){ e.printStackTrace(); }
        return listaTipo;
    }

    public int obtIdTipoPlatillo (String dsc_tipo){
        ResultSet rs = null;
        int valor = 0;
        try {
            String query = "select id_tipo from tbl_tipoplatillo where dsc_tipo = '" + dsc_tipo + "'";
            Statement st = Conexion.con.createStatement();
            rs = st.executeQuery(query);
            if(rs.next())
                do {
                    valor = rs.getInt("id_tipo");
            }while(rs.next());

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error al recuperar información...");
        }
        return valor;
    }

    public void getTipo(){}

    @Override
    public String toString() {
        return dsc_tipo;
    }
}