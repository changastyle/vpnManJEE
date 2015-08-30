<%@page import="model.Usuario"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="model.Modem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Radcheck"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <% 
        
    String metadata =  request.getParameter("metadata").toLowerCase();
    String orden =  request.getParameter("orden");
    ArrayList<Usuario> arrUsuariosVPN;
         
    /*if(metadata != null && !metadata.trim().equalsIgnoreCase(""))
    {
        arrModems = Controller.Controller.buscar(metadata);
        //out.print("Buscando: " + metadata + " | ");
    }
    else
    {*/
        arrUsuariosVPN = Controller.Controller.findAllUsuarios();
        //out.print("METADATA = NULL");
    //}
    String msgResultadosObtenidos = "";
    if(arrUsuariosVPN.size() == 1)
    {
        msgResultadosObtenidos = "resultado obtenido";
    }
    else
    {
        msgResultadosObtenidos = "resultados obtenidos";
    }
    
    out.print("<div id='divCantidadResultadosGrilla'>" + arrUsuariosVPN.size() + " " + msgResultadosObtenidos + " </div>");
    %>

<table id="grilla" >
    <tr>
        <td class="tableHeaders grillaColumnaID"><a class="enlacesHeaderGrilla" href="javascript:ordenarPorModem('ID')">Nombre Usuario</a></td>
        <td class="tableHeaders"><a class="enlacesHeaderGrilla" href="javascript:ordenarPorModem('Direccion IP')">Password</td>
        <td class="tableHeaders"><a class="enlacesHeaderGrilla" href="javascript:ordenarPorModem('NetMask')">Reintentos</a></td>
        <td class="tableHeaders"><a class="enlacesHeaderGrilla" href="javascript:ordenarPorModem('Observaciones')">Observaciones</a></td>
    </tr>
    

  <%  
    for(Usuario u : arrUsuariosVPN)
    {
        out.print("<tr><td>" + u.getNombreUsuario() + "</td><td>" + u.getPassword() + "</td><td>" +u.getReintentos()+ "</td><td>" + u.getRadcheck().getObservaciones() +"</td></tr>");
    }
    /*if(arrUsuariosVPN != null)
    {
        if(orden.equalsIgnoreCase("ID") || orden.equalsIgnoreCase("NetMask"))
        {
            Collections.sort(arrUsuariosVPN, new Comparator<Modem>() 
            {
                @Override
                public int compare(Modem  m1, Modem  m2)
                {
                    return  m1.getNombreADSL().compareTo(m2.getNombreADSL());
                }
            });
        }
        else if(orden.equalsIgnoreCase("Direccion IP"))
        {
            Collections.sort(arrModems, new Comparator<Modem>() 
            {
                @Override
                public int compare(Modem  m1, Modem  m2)
                {
                    return  m1.getDireccionIP().compareTo(m2.getDireccionIP());
                }
            });
        }
        else if(orden.equalsIgnoreCase("Observaciones"))
        {
            Collections.sort(arrModems, new Comparator<Modem>() 
            {
                public int compare(Modem  m1, Modem  m2) 
                {
                if (m1.getObservaciones() == null && m2.getObservaciones() == null)
                    return 0;
                if (m1.getObservaciones() == null)
                    return 1;
                else if (m2.getObservaciones() == null)
                    return -1;
                return m1.getObservaciones().compareTo(m2.getObservaciones());
                }
            });
        }
            
        

    

        int contador = 0;
        String paridad = "";
        for(Usuario usuario : arrUsuariosVPN)
        {
            if( contador % 2 == 0  )
            {
                paridad = "filaPar";
            }
            else
            {
                paridad = "filaImpar";
            }
            out.print("<tr>");
            out.print("<td class='filas selectButtons " + paridad + "' onclick='openModem(this)' >" + usuario.getNombreUsuario() +"</td>");
            out.print("<td class='filas " + paridad + "'>" + usuario.getReintentos()+ "</td>");
           out.print("<td class='filas " + paridad + "'>" + modem.getMascaraDeSubRed() + "</td>");
            out.print("<td class='filas " + paridad + "'>" + modem.getObservaciones() + "</td>");
            out.print("</tr>");
        }
    }else
    {
        //out.print("No hay resultados");
    }*/
    %>

</table>
