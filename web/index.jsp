<html>
    <head>
        <title>VPN Manager - TecnoAccion</title>
        <meta charset="UTF-8">
        <link rel="icon" href="assets/img/favicon-32x32.png" type="image/x-icon"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="Stylesheet" href="assets/fonts/fonts.css">
        <link rel="Stylesheet" href="assets/css/index.css">
        <link rel="Stylesheet" href="assets/css/vpn.css">
        <link rel="Stylesheet" href="assets/css/grilla.css">
        <link rel="Stylesheet" href="assets/scripts/jquery-ui-1.9.2.custom/css/ui-lightness/jquery-ui-1.9.2.custom.css">
        <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.3.min.js"></script>
        <script src="assets/scripts/jquery-ui-1.9.2.custom/js/jquery-1.8.3.js"></script>
        <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <script src="assets/scripts/index.js"></script>
        <script src="assets/scripts/formularios.js"></script>
    </head>
    <body onresize="resize()">
        <div id="banner"></div>
        
        <div id="message"><h3 id="textMessage"></h3><img id="imgMessage"src="assets/img/loading.gif"></div>
        <div id="cartelModem"></div>
        
        <div class="contenedoresLaterales" id="contenedorLateralIZQ">
            <div class="desplegadoresLaterales" id="desplegadorLateralIZQ" onclick="desplegar(this)">
            </div>
            <div class="contenidosContenedoresLaterales" id="contenidoContenedorLateralesIZQ">
            </div>
        </div>
        
        <div id="contenedorPrincipal"></div>
            
        <div class="contenedoresLaterales" id="contenedorLateralDER">
            <div class="desplegadoresLaterales" id="desplegadorLateralDER"  onclick="desplegar(this)">
            </div>
            <div class="contenidosContenedoresLaterales" id="contenidoContenedorLateralesDER"> 
            </div> 
        </div>
        
        <!--<footer>VPN - Manager TecnoAcción</footer>-->
    </body>
</html>
