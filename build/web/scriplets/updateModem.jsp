<%

    String username = request.getParameter("username");
    String nuevoValor = request.getParameter("nuevoValor");
    if(username != null && nuevoValor != null)
    {
        out.print("recibi " + username  +  " -> " + nuevoValor + " | ");
        
        boolean updateo = Controller.Controller.updateModem(username,nuevoValor);
        
        if(updateo)
        {
            out.print("true");
        }
        else
        {
            out.print("false");
        }
    }
    else
    {
        out.print("false");
    }
    
    
%>