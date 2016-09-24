/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import dao.AccesoDAO;
import dao.AccesoDAOImp;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Acceso;

/**
 *
 * @author Marili
 */
public class AccesoController {
       private final String LISTA_ACCESOS = "/lista_accesos.jsp";
    private final String AGREGAR_CAMBIAR = "/acceso.jsp";
    private AccesoDAO dao;

    public AccesoController() {
        dao = new AccesoDAOImp();
    }
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        String action = request.getParameter("action");
        String forward = "";
        
        if (action.equalsIgnoreCase("borrar")){
            forward = LISTA_ACCESOS;
            int idacceso = Integer.parseInt(request.getParameter("idacceso"));
            dao.borrarAcceso(idacceso);
            request.setAttribute("accesos", dao.desplegarAccesos());        
        }else if (action.equalsIgnoreCase("cambiar")){
            forward = AGREGAR_CAMBIAR;
            int idAcceso = Integer.parseInt(request.getParameter("idacceso"));
            Acceso acceso = dao.elegirAcceso(idAcceso);
            request.setAttribute("acceso",acceso);
        }else if (action.equalsIgnoreCase("agregar")){
            forward = AGREGAR_CAMBIAR;
        }else{
            forward = LISTA_ACCESOS;
            request.setAttribute("accesos", dao.desplegarAccesos());
        }
        
        RequestDispatcher view = request.getRequestDispatcher(forward);
        
        view.forward(request, response);
        
    }
               
            
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Acceso acceso = new Acceso();
        acceso.setNombre(request.getParameter("nombre"));
        acceso.setIp(request.getParameter("ip"));
        acceso.setFecha(request.getParameter("fecha"));
        acceso.setPeriodo(request.getParameter("periodo"));

        String idAcceso = request.getParameter("idAcceso");

        if (idAcceso == null || idAcceso.isEmpty()) {
            dao.agregarAcceso(acceso);
        } else {
            acceso.setIdAacceso(Integer.parseInt(idAcceso));
            dao.cambiarAcceso(acceso);
        }

        RequestDispatcher view = request.getRequestDispatcher(LISTA_ACCESOS);
        request.setAttribute("accesos", dao.desplegarAccesos());
        view.forward(request, response);

    }
    
}
