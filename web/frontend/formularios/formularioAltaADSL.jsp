<%@page import="model.Radcheck"%>
<%

    Radcheck radcheck = new Radcheck();
    radcheck.setUsername(String.valueOf(request.getParameter("username")));
    radcheck.setAttribute("User-Password");
    radcheck.setOp("==");
    radcheck.setValue(String.valueOf(request.getParameter("value")));
    radcheck.setReint(0);
    radcheck.setObservaciones(String.valueOf(request.getParameter("observaciones")));

    out.print(radcheck);

%>
