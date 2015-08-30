package model.daos;

import java.util.ArrayList;
import java.util.List;
import model.Radcheck;

public class RadCheckDAO
{
 
    public static ArrayList<Radcheck> findAll()
    {
        ArrayList<Radcheck> arrRespueta = new ArrayList<Radcheck>();
        List<Object> listaProvisoria;
        
        listaProvisoria = AbstractDAO.findAll(model.Radcheck.class);
        
        //System.out.println("listaProvisoria.size = " + listaProvisoria.size());
        for(Object o : listaProvisoria)
        {
            Radcheck radcheck = (Radcheck) o;
            arrRespueta.add(radcheck);
        }
        
        
        return arrRespueta;
    }
    public static ArrayList<Radcheck> filtrar(String hql)
    {
        ArrayList<Radcheck> arrRespueta = new ArrayList<Radcheck>();
        List<Object> listaProvisoria;
        
        listaProvisoria = AbstractDAO.findAll(hql);
        
        //System.out.println("listaProvisoria.size = " + listaProvisoria.size());
        for(Object o : listaProvisoria)
        {
            Radcheck radcheck = (Radcheck) o;
            arrRespueta.add(radcheck);
        }
        
        
        return arrRespueta;
    }

    static int save(Radcheck radcheck)
    {
        int id = 0;
        Radcheck lastRadcheck = null;
        int mayorID = 0;
        boolean existe=false;
        for(Radcheck r : RadCheckDAO.findAll())
        {
            if(r.getId() > mayorID)
            {
                lastRadcheck = r;
                mayorID = r.getId();
            }
            /*if(r.getUsername().equalsIgnoreCase(radcheck.getUsername()))
            {
                System.out.println("RADCHECK DUPLICADO EN EL USERNAME");
                existe = true;
            }*/
        }
        /*if(!existe)
        {*/
            System.out.println("LAST RADCHECK:" + lastRadcheck.toString());
            radcheck.setId((mayorID +  1));
            id = model.daos.AbstractDAO.save(radcheck); 
       /* }*/

        return id;
    }
    public static Radcheck get(int id)
    {
        Radcheck radcheck = null;
        
        radcheck =  (Radcheck) model.daos.AbstractDAO.get(model.Radcheck.class, id);
        
        return radcheck;
    }
    
}
