package Controller;

import java.util.ArrayList;
import java.util.List;
import model.Modem;
import model.Radcheck;
import model.daos.RadCheckDAO;

public class Controller
{
    public static ArrayList<Radcheck> findAllRadCheck()
    {
        ArrayList<Radcheck> arrRespuesta;
        
        arrRespuesta = RadCheckDAO.findAll();
        
        return arrRespuesta;
    }
    public static ArrayList<Modem> findAllModems()
    {
        ArrayList<Modem> arrRespuesta;
        
        arrRespuesta = model.daos.ModemDAO.findAll();
        
        return arrRespuesta;
    }
    public static String dameUsuarioADSLSugerido()
    {
        String respuesta = "'";
        for(int i = 0 ; i < 255; i++)
        {
            if(i == 80)
            {
                if(i < 100)
                {
                   respuesta += "adsl_0" + i;
                }
                else
                {
                    respuesta += "adsl_" + i;
                }
                
            }
        }
        respuesta += "'";
        return respuesta;
    }
    public static String dameIPSugerida()
    {
        String respuesta = "'";
        for(int i = 0 ; i < 255; i++)
        {
            if(i == 50)
            {
                respuesta += "172.36.200.17." + i;
            }
        }
        respuesta += "'";
        return respuesta;
    }
    /*
    public static void createRadcheck(Radcheck radcheck)
    {
        RadCheckDAO radcheckDAO = new RadCheckDAO();
        radcheckDAO.save(radcheck);
        
        
    }
    public static ArrayList<Radcheck> getArrRadCheck(String sql)
    {
        ArrayList<Radcheck> arr = new ArrayList<Radcheck>();
        
        ArrayList<Object> arrObjetos = RadCheckDAO.findAll(sql);
        
        for(Object o : arrObjetos)
        {
            Radcheck radcheck = (Radcheck) o;
            arr.add(radcheck);
        }
        
        return arr;
    }
    public static ArrayList<Radcheck> getArrRadCheck()
    {
        ArrayList<Radcheck> arr = new ArrayList<Radcheck>();
        
        ArrayList<Object> arrObjetos = RadCheckDAO.findAll(model.Radcheck.class);
        
        for(Object o : arrObjetos)
        {
            Radcheck radcheck = (Radcheck) o;
            arr.add(radcheck);
        }
        
        return arr;
    }*/
}
