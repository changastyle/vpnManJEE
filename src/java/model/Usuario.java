package model;
public class Usuario
{
    private String nombreUsuario;
    private String password;
    private int reintentos;
    private Radcheck radcheck;
    private Radreply radreply;
    private Radcheck radcheck2;

    public Usuario()
    {
        this.nombreUsuario = "";
        this.password = "";
        this.reintentos = 0;
        this.radcheck = new Radcheck();
        this.radreply = new Radreply();
        this.radcheck2 = new Radcheck();
    }
    public Usuario(String nombreUsuario, String password, int reintentos)
    {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.reintentos = reintentos;
        this.radcheck = new Radcheck(nombreUsuario, "User-password", "==", password, reintentos, "Usuario VPN de " + nombreUsuario);
        this.radcheck2 = new Radcheck(nombreUsuario, "NAS-IP-Address", "=~", "(10.10.20.5|192.168.59.84)", reintentos, "Usuario VPN de " + nombreUsuario);
        this.radreply = new Radreply(nombreUsuario, "Service-Type", "=", "Framed-User");
    }
    
    //<editor-fold desc="GYS">
    public String getNombreUsuario()
    {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario)
    {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getReintentos()
    {
        return reintentos;
    }

    public void setReintentos(int reintentos)
    {
        this.reintentos = reintentos;
    }

    public Radcheck getRadcheck()
    {
        return radcheck;
    }

    public void setRadcheck(Radcheck radcheck)
    {
        this.nombreUsuario = radcheck.getUsername();
        this.password =radcheck.getValue();
        this.reintentos = radcheck.getReint();
        this.radcheck = radcheck;
    }
    public Radcheck getRadcheck2()
    {
        return radcheck2;
    }

    public void setRadcheck2(Radcheck radcheck2)
    {
        this.radcheck2 = radcheck2;
    }
    public Radreply getRadreply()
    {
        return radreply;
    }

    public void setRadreply(Radreply radreply)
    {
        this.radreply = radreply;
    }


    
    //</editor-fold>

    @Override
    public String toString()
    {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", password=" + password + ", reintentos=" + reintentos +
                "\n radcheck=" + radcheck +
                "\n radcheck2=" + radcheck2 +
                "\n radreply=" + radreply + '}';
    }
    
    
}
