/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author yassin
 */
public class ServiceDoua extends RecursiveTreeObject<ServiceDoua>{

    public final static ObservableList<ServiceDoua> ObservableListDoua = FXCollections.observableArrayList();
    private int id;
    private String text;

    public ServiceDoua(int id, String text) {
        this.id = id;
        this.text = text;
    }
    public ServiceDoua(){};

    public static boolean fetchData() {
        ObservableListDoua.clear();
        try {
            ResultSet res = Connection.getInstance().getCnx().prepareStatement("SELECT * FROM doua").executeQuery();
            while (res.next()) {
                ObservableListDoua.add(new ServiceDoua(res.getInt(1), res.getString(2)));
            }
            return true;
        } catch (Exception ex) {
        }
        return false;
    }
    
        public List<ServiceDoua> AfficherAllDoua() {
        List<ServiceDoua> DouaList = new ArrayList<>();
        try {
            String requete = "SELECT id,doua FROM doua";
            Statement pst = Connection.getInstance().getCnx().createStatement();
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                ServiceDoua doua = new ServiceDoua();
                doua.setId(rs.getInt(1));
                doua.setText(rs.getString(2));
                DouaList.add(doua);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLSTATE: " + ex.getSQLState());
            System.out.println("VnedorError: " + ex.getErrorCode());
        }
        return DouaList;
    }

    @Override
    public String toString() {
        return "Doua{" + "id=" + id + ", text=" + text + '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
