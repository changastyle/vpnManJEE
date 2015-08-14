<%-- 
    Document   : newjs
    Created on : 13/08/2015, 16:25:54
    Author     : NICOLAS
--%>

<%@page import="model.Modem"%>
<%@page import="model.Radcheck"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
        <script src="frontend/scripts/pruebas.js"></script>
        <title>JSP de Pruebas</title>
    </head>
    <body onload="listo()">
        <h1>Hello World!</h1>
        <form action="backend/altaModem.jsp" method="post">
            <table>
                <tr><td><input type="text" class="inputsFormularioModem" id="inputNombreformularioAltaModem" name="usuarioADSL" data-text=<%out.print(Controller.Controller.dameUsuarioADSLSugerido());%>  onfocus="limpiar(this)" onblur="blu(this)"></td></tr>
                <tr><td><input type="text" class="inputsFormularioModem" id="inputIPformularioAltaModem" name="direccionIP" data-text=<%out.print(Controller.Controller.dameIPSugerida());%> onfocus="limpiar(this)" onblur="blu(this)"></td></tr>
                <tr><td><input type="text" class="inputsFormularioModem" id="inputObservacionesformularioAltaModem" name="observaciones" data-text="Observaciones" onfocus="limpiar(this)" onblur="blu(this)"></td></tr>
                
                <tr><td colspan="2"><input type="submit" value="Agregar Modem"></td></tr>
            </table>
            
        </form>
        
        <table border="1">
            <%
                out.print("size = " + Controller.Controller.findAllModems().size());
                for(Modem modem : Controller.Controller.findAllModems())
                {
                    out.print(modem.toWeb());
                }
            %>
        </table>
    </body>
</html>
