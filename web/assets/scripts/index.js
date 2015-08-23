$().ready(init());
function init()
{
    console.log("ready");
    cargarBanner();
    cargarContenedorPrincipal();
    cargarLateralDerecho();
}
function cargarBanner()
{
    $.ajax({ method: "POST", url: "formularios/banner.jsp"}).done(function( resultado ) 
    {
        $("#banner").html(resultado);
    },function()
    {
        cargarBarraNavegacion();
    });
    
}
function cargarBarraNavegacion()
{
    $.ajax({ method: "POST", url: "formularios/barraNavegacion.jsp"}).done(function( resultado ) 
    {
        $("#barraNavegacion").html(resultado);
    });
}
function cargarContenedorPrincipal(orden)
{
    $.ajax({url:"formularios/vpn.jsp", method: "POST", 
    success:function(resultado)
    {
        $("#contenedorPrincipal").html(resultado);
        
        buscar(orden);
    }});
}
function buscar(orden)
{
    
    metadata = $("#barraBusqueda").val();
    if(orden == null)
    {
        orden = "ID";
    }
    console.log("Metadata: " + metadata );
    console.log("Orden: " + orden );
    
    $.ajax({url:"formularios/grilla.jsp", method: "POST", data:{'metadata':metadata,'orden':orden},
    beforeSend: function ()
    {
        cargando();
/*        $.post("formularios/esperandoGrilla.jsp").done(function(data)
        {
            $("#wraperGrilla").html(data);  
        });*/
    },success:function(result)
    {
        $("#wraperGrilla").html(result);                             
    }});
    
}
function cargando()
{
    $.post("formularios/esperandoGrilla.jsp").done(function(data)
    {
        $("#wraperGrilla").html(data);  
    });
}
function cargarLateralDerecho()
{
    $.ajax({ method: "POST", url: "formularios/formularioAlta.jsp"}).done(function( resultado ) 
    {
        $("#contenidoContenedorLateralesDER").html(resultado);
        listo();
    },function()
    {
        $( "#tabs" ).tabs();
    });
    
    
}
function desplegar(quien)
{
    console.log(quien.id);
    
    if(quien.id == "desplegadorLateralDER")
    {
        console.log($("#contenedorLateralDER").innerWidth());
        if($("#contenedorLateralDER").innerWidth() > 80)
        {
            $("#contenedorLateralDER").css("width", "80px");
            $("#contenedorLateralIZQ").css("width", "80px");
        }
        else
        {
            $("#contenedorLateralDER").css("width", "600px");
            $("#contenedorLateralIZQ").css("width", "0px");
        }

    }
    else
    {
        if($("#contenedorLateralIZQ").innerWidth() > 80)
        {
            $("#contenedorLateralIZQ").css("width", "80px");
            $("#contenedorLateralDER").css("width", "80px");
        }
        else
        {
            $("#contenedorLateralDER").css("width", "0px");
            $("#contenedorLateralIZQ").css("width", "600px");
        }
    }
}
function message(mensaje)
{
    $("#textMessage").html(mensaje);
    
    //$( "#message" ).toggle("slow");
    $( "#message" ).toggle("fold" , "slow");
}
function goToHome()
{
    window.location.replace("index.jsp");
}
function navegar(paDonde)
{
    contenedor = $("#contenedorPrincipal");
    
    console.log(paDonde);
    url = paDonde;
    if(url == "formularios/vpn.jsp")
    {
        cargarContenedorPrincipal();
    }
    else
    {
        $.ajax(
        {
            type:'post',
            url:url,
            data:{},
            beforeSend: function ( xhr )
            {
              //message("Cargando");
              cargando();
            },
            success:function(data)
            {
                //message("Cargando");
                $("#contenedorPrincipal").html(data);                             
            }
        }); 
    }
    
}
function openModem(quien)
{
    usuarioADSL = $(quien).html() ;
    console.log( "Usuario ADSL = " + usuarioADSL );
    
    if($("#cartelModem").css("visibility") == "visible")
    {
        cerrarCartelModem();
    }
    $("#cartelModem").show("slow");
    
    $.ajax({url:"formularios/cartelModem.jsp",data:{'metadata':usuarioADSL },success:function(result)
    {
        //console.log(result);
        $("#cartelModem").html(result);
        //$("#headerCartelModem").html(usuarioADSL);                             
    }});
}
function updateCartelModem(username)
{
    nuevoValor = $("#observacionesCartelModem").val();
    console.log("update " + username + " -> " + nuevoValor);
    
    $.ajax({url:"scriplets/updateModem.jsp",data:{'username':username , 'nuevoValor':nuevoValor},success:function(result)
    {
        cargarContenedorPrincipal();   
        cerrarCartelModem();                         
    }});
}
function borrarCartelModem(username)
{
    console.log("Borrar " + username);
    var seguro = confirm("Seguro de borrar " + username + "??");
    
    if (seguro == true)
    {
        $.ajax({url:"scriplets/borrarModem.jsp",data:{'username':username },success:function(result)
        {
            cargarContenedorPrincipal();   
            cerrarCartelModem();
        }});
    } else 
    {
        alert(""+ username +" NO fue borrado, mas cuidado la proxima!");
    }
    
}
function cerrarCartelModem()
{
    $("#cartelModem").hide("slow");
}

function resize()
{
    console.log("Cartel Modem ancho = " + $("#cartelModem").innerWidth() );
    console.log("Cartel Modem alto = " + $("#cartelModem").innerHeight() );
}

