import java.util.ArrayList;
import model.Usuario;

public class main
{
    public static void main(String args[])
    {
        /*ArrayList<model.Usuario> arr = Controller.Controller.findAllUsuarios();
        System.out.println("SIZE  = " + arr.size());*/
        
        model.Usuario u = new Usuario("eee", "12346", 0);
        System.out.println("" + Controller.Controller.saveUsuario(u));
        /*
        for(model.Usuario u : arr)
        {
            System.out.println("" + u.toString());
            System.out.println("");
        }*/
    }

}
