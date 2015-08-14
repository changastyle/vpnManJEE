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
        
        
        return arrModems;
    }
    public static int save(Modem modem)
    {
        int id = 0;
        System.out.println("MODEM TO SAVE: " + modem.toString() );
        model.daos.RadCheckDAO.save(modem.getRadcheckObservaciones());
      
        return id;
    }
}
