package model.daos;

import java.util.ArrayList;
import model.Modem;
import model.Radcheck;
import model.Radreply;

public class ModemDAO
{
    public static ArrayList<Modem> findAll()
    {
        ArrayList<Modem> arrModems = new ArrayList<Modem>();
        ArrayList<Radcheck> arrRadChecks  = RadCheckDAO.findAll();
        ArrayList<Radreply> arrRadreplys  = RadreplyDAO.findAll();
       
        for(Radcheck radcheck : arrRadChecks)
        {
            if (radcheck.getUsername().startsWith("adsl_"))
            {
                Modem modem = new Modem();
                modem.setRadcheckObservaciones(radcheck);
                arrModems.add(modem);
            }
        }
        for(Radreply radreply : arrRadreplys)
        {
            if(radreply.getAttribute().equalsIgnoreCase("Framed-IP-Address"))
            {
                for(Modem modem : arrModems)
                {
                    if (modem.getNombreADSL().equalsIgnoreCase(radreply.getUsername()))
                    {
                        modem.setRadreplyIP(radreply);
                    }
                }
            }
            else if(radreply.getAttribute().equalsIgnoreCase("Framed-IP-Netmask"))
            {
                for(Modem modem : arrModems)
                {
                    if (modem.getNombreADSL().equalsIgnoreCase(radreply.getUsername()))
                    {
                        modem.setRadreplyNetMask(radreply);
                    }
                }
            }
        }
        
        /*ArrayList<Modem> ar = new ArrayList<Modem>();
        ar.add(new Modem("test", "test", "test", 0, "test"));*/
        return arrModems;
    }
    public static ArrayList<Modem> findByName(String name)
    {
        ArrayList<Modem> arrProvisorio = findAll();
        ArrayList<Modem> arrRespuesta = new ArrayList<Modem>();
        
        for (Modem modem :arrProvisorio)
        {
            if(modem.getNombreADSL() != null)
            {
                if(modem.getNombreADSL().toLowerCase().contains(name))
                {
                    arrRespuesta.add(modem);
                }
            }
        }
        
        return arrRespuesta;
    }
    public static ArrayList<Modem> findByObservacion(String observacion)
    {
        ArrayList<Modem> arrProvisorio = findAll();
        ArrayList<Modem> arrRespuesta = new ArrayList<Modem>();
        
        for (Modem modem :arrProvisorio)
        {
            if(modem.getObservaciones() != null)
            {
                if(modem.getObservaciones().toLowerCase().contains(observacion))
                {
                    arrRespuesta.add(modem);
                }
            }
        }
        
        return arrRespuesta;
    }
    public static ArrayList<Modem> findByIP(String ip)
    {
        ArrayList<Modem> arrProvisorio = findAll();
        ArrayList<Modem> arrRespuesta = new ArrayList<Modem>();
        
        for (Modem modem :arrProvisorio)
        {
            if(modem.getDireccionIP() != null)
            {
                if(modem.getDireccionIP().toLowerCase().contains(ip))
                {
                    arrRespuesta.add(modem);
                }
            }
        }
        
        return arrRespuesta;
    }
    public static boolean save(Modem modem)
    {
        boolean ok = false;
        System.out.println("MODEM TO SAVE: " + modem.toString() );
        int insertoObservaciones = model.daos.RadCheckDAO.save(modem.getRadcheckObservaciones());
        int insertoRadReplyIP = model.daos.RadreplyDAO.save(modem.getRadreplyIP());
        int insertoRadReplyNetMask = model.daos.RadreplyDAO.save(modem.getRadreplyNetMask());
      
        if(insertoObservaciones > 0 && insertoRadReplyIP > 0  && insertoRadReplyNetMask > 0)
        {
            ok = true;
        }
        return ok;
    }
    public static boolean delete(String name)
    {
        boolean respuesta = false;
        boolean respuesta1 = false;
        boolean respuesta2 = false;
        boolean respuesta3 = false;
        
         ArrayList<Modem> arr = findByName(name);
         
         if(arr.size() > 0)
         {
             respuesta1 = model.daos.AbstractDAO.delete(arr.get(0).getRadreplyIP());
             respuesta2 = model.daos.AbstractDAO.delete(arr.get(0).getRadreplyNetMask());
             respuesta3 = model.daos.AbstractDAO.delete(arr.get(0).getRadcheckObservaciones());
             if(respuesta1 && respuesta2  && respuesta3)
             {
                respuesta = true; 
             }
         }
         return respuesta;
    }
    public static boolean update(String name , String nuevoValor)
    {
        boolean respuesta = false;
        ArrayList<Modem> arr = findByName(name);
         
        if(arr.size() > 0)
        {
            arr.get(0).getRadcheckObservaciones().setObservaciones(nuevoValor);
            respuesta = model.daos.AbstractDAO.update(arr.get(0).getRadcheckObservaciones());
        }
        
         return respuesta;
    }
}
