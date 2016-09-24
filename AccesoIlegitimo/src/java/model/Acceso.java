/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marili
 */
public class Acceso {
    private int idAacceso;
    private String nombre;
    private String ip;
    private  String fecha;
    private String periodo;
    
    public Acceso(int idAcceso, String nombre, String ip, String fecha, String periodo){
        this.idAacceso = idAcceso;
        this.nombre = nombre;
        this.ip = ip;
        this.fecha = fecha;
        this.periodo = periodo;
    }
     public Acceso(){//constructor vacio
        this(0,""," ","","");
    }

    public int getIdAacceso() {
        return idAacceso;
    }

    public void setIdAacceso(int idAacceso) {
        this.idAacceso = idAacceso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "Acceso{" + "idAacceso=" + idAacceso + ", nombre=" + nombre + ", ip=" + ip + ", fecha=" + fecha + ", periodo=" + periodo + '}';
    }
     
     
    
}
