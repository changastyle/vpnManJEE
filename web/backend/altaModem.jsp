<%@page import="model.daos.ModemDAO"%>
<%@page import="model.Modem"%>

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
%>
</table>