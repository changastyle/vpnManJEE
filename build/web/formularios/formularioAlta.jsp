<%@page import="model.Radcheck"%>
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Alta Modems</a></li>
    <li><a href="#tabs-2">Alta Usuarios</a></li>
  </ul>
  <div id="tabs-1">
      <form class='formsAltas' id='formAltaADSL'action="scriplets/altaModem.jsp" method="post">
            <table class='tablasFormularios' id='tablaFormAltaADSL'>
                <tr><td><input type="text" class="inputsFormularios" id="inputNombreformularioAltaModem" name="usuarioADSL" data-text=<%out.print(Controller.Controller.dameUsuarioADSLSugerido());%>  onfocus="limpiar(this)" onblur="blu(this)"></td></tr>
                <tr><td><input type="text" class="inputsFormularios" id="inputIPformularioAltaModem" name="direccionIP" data-text=<%out.print(Controller.Controller.dameIPSugerida());%> onfocus="limpiar(this)" onblur="blu(this)"></td></tr>
                <tr><td><input type="text" class="inputsFormularios" id="inputObservacionesformularioAltaModem" name="observaciones" data-text="Observaciones" onfocus="limpiar(this)" onblur="blu(this)"></td></tr>
                <tr><td colspan="2"><input type="submit" class="inputsFormularios" id="botonAltaADSL" value="Agregar Modem"></td></tr>
            </table>
        </form>
  </div>
  <div id="tabs-2">
        <form class='formsAltas' id='formAltaADSL'action="scriplets/altaUsuario.jsp" method="post">
            <table class='tablasFormularios' id='tablaFormAltaADSL'>
                <tr><td><input type="text" class="inputsFormularios" id="inputNombreformularioAltaUsuario" name="nombreUsuario" data-text="nombreusuario" onfocus="limpiar(this)" onblur="blu(this)"></td></tr>
                <tr><td><input type="text" class="inputsFormularios" id="inputNombreformularioAltaUsuario" name="password" data-text="password" onfocus="limpiar(this)" onblur="blu(this)"></td></tr>
                <tr><td colspan="2"><input type="submit" class="inputsFormularios" id="botonAltaUsuario" value="Agregar Usuario"></td></tr>
            </table>
        </form>
      
      <input type="text">
      <input type="text">
      <input type="submit">
  </div>
</div>

