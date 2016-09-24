<%-- 
    Document   : acceso
    Created on : 23-sep-2016, 15:44:22
    Author     : Marili
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Accesos</title>
    </head>
    <body>
        <form action="AccesoController" method="post">
            <fieldset> 
                <legend> Registro de Accesos </legend>
                <div>
                    <label for="idAcceso">ID Acceso: </label>
                    <input type="text" name="idAcceso" placeholder="ID Acceso" values="${acceso.idAcceso}" readonly="readonly">
                </div>
                <div>
                    <label for="nombre">Nombre Acceso: </label>
                    <input type="text" name="nombre" placeholder="Nombre del Acceso" values="${acceso.nombre}">
                </div>
                <div>
                    <label for="ip">IP del Acceso: </label>
                    <input type="text" name="ip" placeholder="Ip del Acceso" values="${acceso.ip}">
                </div>
                <div>
                    <label for="fecha">Fecha del Acceso: </label>
                    <input type="text" name="fecha" placeholder="Fecha del Acceso" values="${acceso.fecha}">
                </div>
                <div>
                    <label for="periodo">Periodo del Acceso: </label>
                    <input type="text" name="periodo" placeholder="Periodo del Acceso" values="${acceso.periodo}">
                </div>
                <div>
                    <input type="submit" values="Guardar">
                </div>
            </fieldset>
        </form>
    </body>
</html>
