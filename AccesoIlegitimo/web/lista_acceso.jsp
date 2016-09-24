<%-- 
    Document   : lista_acceso
    Created on : 23-sep-2016, 15:20:22
    Author     : Marili
--%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Accesos</title>
    </head>
    <body>
        <table>
            <thead>
                <tr> ID Acceso </tr>
                <tr> Nombre </tr>
                <tr>  IP </tr>
                <tr>  Fecha </tr>
                <tr> Periodo</tr>
            </thead>
            <tbody>
                <c:forEach items="${accesos}" var="acceso">
                    <tr>
                        <td>${acceso.idAcceso}</td>
                        <td>${acceso.nombre}</td>
                        <td>${acceso.ip}</td>
                        <td>${acceso.fecha}</td>
                        <td>${acceso.periodo}</td>
                        <td> 
                            <a href="AccesoController?action=cambiar&idAcceso=${acceso.idAcceso}">Cambiar</a> 
                        </td>
                        <td> 
                            <a href="AccesoController?action=borrar&idAcceso=${acceso.idAcceso}">Borrar</a> 
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="AccesoController?action=agregar">AgregarAcceso</a>
        </p>
    </body>
</html>