<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="frontend/altaRadCheck.jsp" method="post">
            <table>
                <tr>
                    <td>Nombre de usuario:</td>
                    <td><input type="text" value="username"></td>
                </tr>
                <tr>
                    <td>Nombre de usuario:</td>
                    <td><input type="text" value="value"></td>
                </tr>
                <tr>
                    <td>Nombre de usuario:</td>
                    <td><input type="text" value="observaciones"></td>
                </tr>
                <tr colspan="2">
                    <td colspan="2"><button id="botonAgregarUsuario">Agregar Usuario</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
