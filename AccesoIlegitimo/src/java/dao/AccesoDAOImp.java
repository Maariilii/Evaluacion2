/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Acceso;
import util.UtilDB;

/**
 *
 * @author Marili
 */
public class AccesoDAOImp implements AccesoDAO {

    private Connection connection;
    private int idAcceso;

    public AccesoDAOImp() {
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarAcceso(Acceso acceso) {
        String sql = "INSERT INTO accesoilegitimo" + "(nombre,ip,fecha,periodo)"
                + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, acceso.getNombre());
            ps.setString(2, acceso.getIp());
            ps.setString(3, acceso.getFecha());
            ps.setString(4, acceso.getPeriodo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    @Override
    public void cambiarAcceso(Acceso acceso) {
        String sql = "UPDATE accesoilegitimo SET "
                + " nombre=?, ip=?, fecha=?,periodo=? "
                + " WHERE id_acceso=?";
        try {
            PreparedStatement ps
                    = connection.prepareStatement(sql);
            ps.setString(1, acceso.getNombre());
            ps.setString(2, acceso.getIp());
            ps.setString(3, acceso.getFecha());
            ps.setString(4, acceso.getPeriodo());
            ps.setInt(5, acceso.getIdAacceso());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Acceso> desplegarAccesos() {
        List<Acceso> accesos = new ArrayList<Acceso>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(
                    "SELECT * FROM accesoilegitimo");
            while (rs.next()) {
                Acceso acceso = new Acceso(
                        rs.getInt("id_acceso"),
                        rs.getString("nombre"),
                        rs.getString("ip"),
                        rs.getString("fecha"),
                        rs.getString("periodo"));
                accesos.add(acceso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accesos;
    }

    @Override
    public Acceso elegirAcceso(int idAcceso) {
        Acceso acceso = null;
        try {
            PreparedStatement ps
                    = connection.prepareStatement(
                            "SELECT * FROM accesoilegitimo"
                            + " WHERE id_acceso=?");
            ps.setInt(1, idAcceso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                acceso = new Acceso(
                        rs.getInt("id_acceso"),
                        rs.getString("nombre"),
                        rs.getString("ip"),
                        rs.getString("fecha"),
                        rs.getString("periodo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acceso;
    }

    @Override
    public void borrarAcceso(int idAcceso) {String sql = "DELETE FROM accesoilegitimo WHERE id_acceso=?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, idAcceso);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
}

}
}
