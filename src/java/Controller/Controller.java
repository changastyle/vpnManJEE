package Controller;

import model.Radcheck;
import model.daos.RadCheckDAO;

public class Controller
{
    public static void createRadcheck(Radcheck radcheck)
    {
        RadCheckDAO radcheckDAO = new RadCheckDAO();
        radcheckDAO.create(radcheck);
        
        
    }
}
