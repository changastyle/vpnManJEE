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
        
        System.out.println("listaProvisoria.size = " + listaProvisoria.size());
        for(Object o : listaProvisoria)
        {
            Radreply radreply = (Radreply) o;
            arrRespueta.add(radreply);
        }
        
        
        return arrRespueta;
    }
}
