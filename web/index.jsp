<html>
    <head>
        <title>VPN Manager - TecnoAccion</title>
        <meta charset="UTF-8">
        <link rel="icon" href="frontend/assets/img/favicon-32x32.png" type="image/x-icon"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="Stylesheet" href="frontend/assets/fonts/fonts.css">
        <link rel="Stylesheet" href="frontend/css/index.css">
        <link rel="Stylesheet" href="frontend/css/vpn.css">
        <link rel="Stylesheet" href="frontend/css/grilla.css">
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
        <script src="frontend/scripts/jquery-ui-1.9.2.custom/js/jquery-1.8.3.js"></script>
        <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <script src="frontend/scripts/index.js"></script>
        <script src="frontend/scripts/vpn.js"></script>
        <script src="frontend/scripts/grilla.js"></script>
    </head>
    <body>
        <div id="banner" >
            <div id="wraperBanner" onclick="goToHome()">
                <div id="headerBanner">VPN - Manager TecnoAcción.</div>
                <img id="imagenBanner" src="frontend/assets/img/icon_vpn.png">
            </div>
            <div id="barraNavegacion">
                <div class="navsItems selectButtons" onclick="navegar('vpn')">VPN</div>
                <div class="navsItems selectButtons" onclick="navegar('maestro')">Plan Maestro</div>
                <div class="navsItems selectButtons" onclick="navegar('otro')">Otro</div>
                <div class="navsItems selectButtons" onclick="navegar('otro')">Otro</div>
                <div class="navsItems selectButtons" onclick="navegar('otro')">Otro</div>
            </div>
        </div>
        
        <div id="message">
            <h3 id="textMessage"></h3>
            <img id="imgMessage"src="frontend/assets/img/loading.gif">
        </div>
        
        <div class="contenedoresLaterales" id="contenedorLateralIZQ">
            <div class="desplegadoresLaterales" id="desplegadorLateralIZQ" onclick="desplegar(this)">
            </div>
            <div class="contenidosContenedoresLaterales" id="contenidoContenedorLateralesIZQ">
                <%@include file="frontend/formularios/ssh.jsp"%>
            </div>
        </div>
        
        <div id="contenedorPrincipal">
            <input type="text" id="barraBusqueda" onfocus="buscar()" onkeyup="buscar()">
            <button id="botonBusqueda">Buscar</button>
            
            <div id="wraperGrilla">
                <%@include file="frontend/formularios/esperandoGrilla.jsp"%>
            </div>
        </div>
            
        <div class="contenedoresLaterales" id="contenedorLateralDER">
            <div class="desplegadoresLaterales" id="desplegadorLateralDER"  onclick="desplegar(this)">
            </div>
            <div class="contenidosContenedoresLaterales" id="contenidoContenedorLateralesDER">
                <%@include file="frontend/formularios/formularioAltaADSL.jsp"%>
            </div>
            
        </div>
        
        <!--<footer>VPN - Manager TecnoAcción</footer>-->
    </body>
</html>
