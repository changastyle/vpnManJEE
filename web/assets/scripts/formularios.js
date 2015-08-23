function listo()
{
    collection = $(".inputsFormularioModem");

    collection.each(function(index,element)
    {
       $(element).val(   $(element).data("text")    );
    }); 
}
function limpiar(quien)
{
    if(  $(quien).val() ==  $(quien).data("text")  )
    {
        $(quien).val("");
    }
}
function blu(quien)
{
    if(  $(quien).val() == ""  )
    {
        $(quien).val(   $(quien).data("text")  );
    }
}