<%@page import="model.Usuario"%>
<%
String nombreUsuario = request.getParameter("nombreUsuario");
String password = request.getParameter("password");

if(nombreUsuario != null && password != null)
{
    if(nombreUsuario.trim().equalsIgnoreCase("") || password.trim().equalsIgnoreCase(""))
    {
        out.print("false");
    }
    else
    {
        /*out.print("Nombre de Usuario = " + nombreUsuario +"<br>");
        out.print("Password = " + password +"<br>" );*/
        
        Usuario usuarioNuevo = new Usuario(nombreUsuario, password, 0);
        boolean ok = Controller.Controller.saveUsuario(usuarioNuevo);
        if(ok)
        {
            response.sendRedirect("../index.jsp");
        }else
        {
            out.print("ERROR.");
        }
    }  
}
else
{
    out.print("false");
    //out.print("No se recibio nombre de usuario o password correctos:");
}
    
%>