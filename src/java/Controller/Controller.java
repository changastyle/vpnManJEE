package Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
    public static ArrayList<Modem> buscar(String parametro)
    {
        ArrayList<Modem> arrRespuesta = new ArrayList<>();
        
        arrRespuesta.addAll(model.daos.ModemDAO.findByName(parametro));
        arrRespuesta.addAll(model.daos.ModemDAO.findByObservacion(parametro));
        arrRespuesta.addAll(model.daos.ModemDAO.findByIP(parametro));
        
        return arrRespuesta;
    }
    public static Modem getModem(String nombreUsuario)
    {
        Modem respuesta = null;
        
        for(Modem m : findAllModems())
        {
            if (m.getNombreADSL().equalsIgnoreCase(nombreUsuario))
            {
                respuesta = m;
            }
        }
        
        return respuesta;
    }
    public static boolean borrarModem(String username)
    {
         return model.daos.ModemDAO.delete(username);
    }
    public static boolean updateModem(String username , String nuevoValor)
    {
        return model.daos.ModemDAO.update(username, nuevoValor);
    }
    public static ArrayList<Modem> ordenarModemsBy()
    {
        ArrayList<Modem> arrOrdenado = new ArrayList<Modem>();
        
        
        return arrOrdenado;
    }
    
    public static ArrayList<Modem> filtrarModems(String metadatos)
    {
        ArrayList<Modem> arrProvisorio = new ArrayList<Modem>();
        ArrayList<Modem> arrRespuesta = new ArrayList<Modem>();
        
        for(Modem m : Controller.findAllModems())
        {
            if (m.getNombreADSL() != null )
            {
                if(m.getNombreADSL().toLowerCase().contains(metadatos))
                {
                    arrRespuesta.add(m);
                }
            } 
            if (m.getDireccionIP() != null )
            {
                if(m.getDireccionIP().toLowerCase().contains(metadatos))
                {
                    arrRespuesta.add(m);
                }
            } 
            if (m.getObservaciones() != null )
            {
                if(m.getObservaciones().toLowerCase().contains(metadatos))
                {
                    arrRespuesta.add(m);
                }
            } 
        }
        
        return arrRespuesta;
    }
    public static String dameUsuarioADSLSugerido()
    {
        String respuesta = "'";
        String compara = "";
        ArrayList<Modem> arrDeModems = findAllModems();
        if(arrDeModems != null)
        {
            for(int i = 1 ; i < 255; i++)
            {
                if(i <10)
                {
                    compara = "adsl_00" +i;
                }
                else if(i <100)
                {
                    compara = "adsl_0" +i;
                }
                else
                {
                    compara = "adsl_" +i;
                }
                boolean usado = false;
                for(Modem modem : arrDeModems)
                {
                    
                    if (modem.getNombreADSL().equalsIgnoreCase( compara ))
                    {
                        usado = true;
                        break;
                    }
                }
                if(!usado)
                {
                    if(i <10)
                    {
                        compara = "adsl_00" +i;
                    }
                    else if(i <100)
                    {
                        compara = "adsl_0" +i;
                    }
                    else
                    {
                        compara = "adsl_" +i;
                    }
                    respuesta += compara;
                    break;
                }
            }
        }
       
       
        respuesta += "'";
        return respuesta;
    }
    public static String dameIPSugerida()
    {
        String respuesta = "'";
        
        
        
        ArrayList <Modem> arrDeModems = findAllModems();
        ArrayList<Integer> arrDireccionesOcupadas = new ArrayList<Integer>();
        System.out.print("arrDeModems = " + arrDeModems.size());
        for(int i = 1 ; i < 255; i++)
        {
            boolean existe = false;
            for(Modem modem : arrDeModems)
            {
                if(modem.getDireccionIP().equals("172.36.200." + i))
                {
                    existe = true;
                    break;
                }
            }
            
            if(!existe)
            {
                respuesta += "172.36.200."+i;
                break;
            }
        }/*
        for(int i = 1; i< 255;i++)
        {
            
            boolean existe = false;
            for(Integer entero :arrDireccionesOcupadas)
            {
                existe = false;
                if(entero == i)
                {
                    existe = true;
                    System.out.println("ENTERO = i -> "+ entero);
                    break;
                }
            }
            if(!existe)
            {
                System.out.println("i = "+ i);
                respuesta += i;
                break;
            }
            
        }*/
        
        respuesta += "'";
        return respuesta;
    }
    public static String dameUltimaTuplaDeUnaIP(String direccionIP)
    {
        String respuesta = "";
        
        String acumulador = "";
        for(int i = 0 ; i < direccionIP.length();i++)
        {
            if(direccionIP.charAt(i) == '.')
            {
                acumulador = "";
            }
            else
            {
                acumulador+= direccionIP.charAt(i);
            }
            if(i == (direccionIP.length() -1))
            {
                respuesta = acumulador;
            }
        }
        
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
