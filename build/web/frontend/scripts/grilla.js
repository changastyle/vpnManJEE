function ordenar(parametro)
{
    console.log("Parametro:" + parametro);
    
    if(parametro == 'nombre')
    {
        parametro = 'username';
    }
    if(parametro == 'password')
    {
        parametro = 'value';
    }
    buscar(parametro);
}