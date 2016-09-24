/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Acceso;

/**
 *
 * @author Marili
 */
public interface AccesoDAO {

    void agregarAcceso(Acceso acceso);

    void borrarAcceso(int idAcceso);

    void cambiarAcceso(Acceso acceso);

    List<Acceso> desplegarAccesos();

    Acceso elegirAcceso(int idAcceso);

}
