<%@page import="java.util.ArrayList"%>
<%@page import="model.Radcheck"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String metadata =  request.getParameter("metadata");
    out.print("Buscando: " + metadata + " | ");
    String orden =  request.getParameter("orden");
    out.print("Ordenando por: " + orden + " | ");
%>
<table id="grilla" >
    <tr>
        <td class="tableHeaders"><a class="enlacesHeaderGrilla" href="javascript:ordenar('id')">ID</a></td>
        <td class="tableHeaders"><a class="enlacesHeaderGrilla" href="javascript:ordenar('nombre')">Nombre</a></td>
        <td class="tableHeaders"><a class="enlacesHeaderGrilla" href="javascript:ordenar('password')">Password</a></td>
        <td class="tableHeaders">Operaciones</td>
    </tr>
    <% 
    String sql;
    if( metadata == null)
    {
        sql = "FROM model.Radcheck R ";
    }
    else
    {
        sql = "FROM model.Radcheck r WHERE r.username LIKE '%" + metadata + "%' OR r.value LIKE '%" + metadata + "%'" ;
        
        if(orden != null)
        {
            sql += "ORDER BY "+ orden +" ASC";
        }
    }
    out.print("SQL enviado: " + sql);
    ArrayList<Radcheck> arr = Controller.Controller.getArrRadCheck(sql) ;

    if(arr != null)
    {
        int contador = 0;
        for (Radcheck  radcheck : arr)
        {
            String paridad = "";
            if( contador % 2 == 0  )
            {
                paridad = "filaPar";
            }
            else
            {
                paridad = "filaImpar";
            }
            out.print("<tr>");
                out.print("<td class='filas selectButtons " + paridad + "'>" + radcheck.getId() + "</td>");
                out.print("<td class='filas " + paridad + "'>" + radcheck.getUsername() + "</td>");
                out.print("<td class='filas " + paridad + "'>" + radcheck.getValue() + "</td>");
                out.print("<td class='filas " + paridad + "'>Del / Upd</td>");
            out.print("</tr>");
            contador++;
        }
    }
    %>

</table>
