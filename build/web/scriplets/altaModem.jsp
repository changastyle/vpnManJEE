<%@page import="model.daos.ModemDAO"%>
<%@page import="model.Modem"%>

<%
    /*
    Radcheck radcheck = new Radcheck();
    radcheck.setUsername(String.valueOf(request.getParameter("username")));
    radcheck.setAttribute("User-Password");
    radcheck.setOp("==");
    radcheck.setValue(String.valueOf(request.getParameter("value")));
    radcheck.setReint(0);
    radcheck.setObservaciones(String.valueOf(request.getParameter("observaciones")));

    out.print(radcheck);*/

%>

<table border="1">
<%
    String usuarioADSL = request.getParameter("usuarioADSL");
    String direccionIP = request.getParameter("direccionIP");
    String observaciones = request.getParameter("observaciones");
    
    Modem modem = new Modem();
    
    modem.setNombreADSL(usuarioADSL);
    modem.setDireccionIP(direccionIP);
    modem.setObservaciones(observaciones);
    
    out.print(modem.toWebExt());
    out.print(ModemDAO.save(modem));
    
    String url = "../index.jsp";
    response.sendRedirect(url);
%>
</table>