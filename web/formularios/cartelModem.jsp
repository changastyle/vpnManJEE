
<%@page import="model.Modem"%>
<% String nombreUsuarioADSL =  request.getParameter("metadata"); %>
<% Modem modemActual = Controller.Controller.getModem(nombreUsuarioADSL); %>


<h3 id="headerCartelModem"><% out.print(modemActual.getNombreADSL()); %><img src="assets/img/equisRoja.png" id="cruzCartelModem" onclick="cerrarCartelModem()"></h3>
<input type="text" id="observacionesCartelModem" data-text="<% out.print(modemActual.getObservaciones()); %>" value="<% out.print(modemActual.getObservaciones()); %>">

<img src="assets/img/ok.png" id="okCartelModem" onclick="updateCartelModem('<% out.print(modemActual.getNombreADSL()); %>')">
<img src="assets/img/papelera.png" id="papeleraCartelModem" onclick="borrarCartelModem('<% out.print(modemActual.getNombreADSL()); %>')">