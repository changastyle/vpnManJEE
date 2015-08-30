<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla VPN</title>
        
    </head>
    <body>
        <!--<h1>VPN</h1>-->
        
        <input type="text" class='barrasDeBusqueda' id="barraBusquedaModems" onfocus="buscarModem()" onblur="buscarModem()" onkeypress="buscarModem()" onkeyup="buscarModem()">
        
        <button class="botones" id="botonBusqueda">Buscar</button>
     
        <div id="wraperGrilla"></div>
    </body>
</html>
