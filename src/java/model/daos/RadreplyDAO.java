package model.daos;

import java.util.ArrayList;
import java.util.List;
import model.Radcheck;
import model.Radreply;

public class RadreplyDAO
{
    public static ArrayList<Radreply> findAll()
    {
        ArrayList<Radreply> arrRespueta = new ArrayList<Radreply>();
        List<Object> listaProvisoria;
        
        listaProvisoria = AbstractDAO.findAll(model.Radreply.class);
        
        //System.out.println("listaProvisoria.size = " + listaProvisoria.size());
        for(Object o : listaProvisoria)
        {
            Radreply radreply = (Radreply) o;
            arrRespueta.add(radreply);
        }
        
        
        return arrRespueta;
    }

    public static int save(Radreply radreplyASalvar)
    {
        int id = 0;
        Radreply lastRadreply = null;
        int mayorID = 0;
        boolean existe=false;
        for(Radreply r : RadreplyDAO.findAll())
        {
            if(r.getId() > mayorID)
            {
                lastRadreply = r;
                mayorID = r.getId();
            }
            if(r.getUsername().equalsIgnoreCase(radreplyASalvar.getUsername()) && r.getAttribute().equalsIgnoreCase("Framed-IP-Netmask"))
            {
                System.out.println("RADREPLY DUPLICADO EN EL USERNAME y ATTRIBUTE.");
                existe = true;
            }
        }
        if(!existe)
        {
            System.out.println("LAST Radreply:" + radreplyASalvar.toString());
            radreplyASalvar.setId((mayorID + 1));
            id = model.daos.AbstractDAO.save(radreplyASalvar); 
        }

        return id;
    }
}
