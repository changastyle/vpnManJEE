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
    
    $( "#message" ).toggle("fold" , "slow");
}
function goToHome()
{
    window.location.replace("index.jsp");
}
function navegar(paDonde)
{
    contenedor = $("#contenedorPrincipal");
    
    //console.log(paDonde);
    
    url = "";
    if(paDonde=="vpn")
    {
        url = 'jsps/vpn.jsp';   
    }
    else if(paDonde=="maestro")
    {
        url = 'jsps/maestro.jsp';
    }
    else
    {
        url ='jsps/contruccion.jsp';
    }
    $.ajax(
    {
        type:'post',
        url:url,
        data:{},
        beforeSend: function ( xhr )
        {
          message("Cargando");
        },
        success:function(data)
        {
            message("Cargando");
            $("#contenedorPrincipal").html(data);                             
        }
    }); 
}
$(document).ready()
{
    console.log("ready");

    $.ajax({ method: "POST", url: "frontend/formularios/grilla.jsp"}).done(function( resultado ) 
    {
        $("#wraperGrilla").html(resultado);
    });
}
/*
function buscar(orden)
{
    metadata = $("#barraBusqueda").val();
    console.log("Metadata:" + metadata);

    $.ajax(
    {
        type:'post',
        url:"jsps/grilla.jsp",
        data:{'metadata':metadata , 'orden':orden},
        beforeSend: function ( xhr )
        {
            //message("Buscando");
        },
        success:function(data)
        {
            //message("Buscando");
            //console.log(data);
            $("#wraperGrilla").html(data);                             
        }
    }); 
    
}*/
function buscar()
{
    metadata = $("#barraBusqueda").val().trim();
    orden = "null";
    console.log("Estoy buscando: " + metadata + "| orden: " + orden +".");
    
    //$.ajax({url:"frontend/formularios/grilla.jsp",data:{'metadata':metadata , 'orden':orden},
    $.ajax({url:"frontend/formularios/grilla.jsp",data:{'metadata':metadata },
    beforeSend: function ()
    {
        $.post("frontend/formularios/esperandoGrilla.jsp").done(function(data)
        {
            $("#wraperGrilla").html(data);  
        });
    },success:function(result)
    {
        //message("Buscando");
        //console.log(data);
        $("#wraperGrilla").html(result);                             
    }});
    
}