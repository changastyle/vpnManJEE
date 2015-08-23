<%

    String username = request.getParameter("username");
    
    if(username != null)
    {
        //out.print("username recibido = " + username );
        boolean ok = Controller.Controller.borrarModem(username);
        if(ok)
        {
            out.print("true" );
        }
        else
        {
            out.print("false");
        }
    }
    else
    {
        //out.print("No se recibio username.");
        out.print("false");
    }
    
    
    
%>