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
function goToHome()
{
    window.location.replace("index.html");
}