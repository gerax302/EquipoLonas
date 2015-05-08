package Usuarios;

public class Modelo {
    
    public static String SELECT_ALL = "SELECT * FROM usuario order by tipoUsuario";
    public static String SELECT_ALL_NO_FOTO = "SELECT idUsuario, nombreUsuario, passwordUsuario, tipoUsuario, correo from usuario";
    public static String UPDATE_SIN_FOTO = "UPDATE  usuario SET "+
	"nombreUsuario = ? ,"+
	"passwordUsuario = ?, "+
	"tipoUsuario = ?, "+
	"correo = ?  WHERE idUsuario = ?";
     
    public static String INSERT_SIN_FOTO = "INSERT INTO usuario "
    + "( nombreUsuario, passwordUsuario, tipoUsuario, correo) VALUES(?, ?, ?, ? )"; 
    public static String DELETE = "DELETE FROM usuario where idUsuario = ?";

    //Campos tabla producto
    private int idUsuario;
    private String nombreUsuario;
    private String passwordUsuario;
    private String tipoUsuario;
    private String correo;


    //Constructor con pk
    public Modelo(int idUsuario, String nombreUsuario, String passwordUsuario, String tipoUsuario,String correo)
    {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario =passwordUsuario;
        this.tipoUsuario =tipoUsuario;
        this.correo =correo;
    }
    
    //Constructor sin pk    
    public Modelo(String nombreUsuario, String passwordUsuario, String tipoUsuario,String correo)
    {
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario =passwordUsuario;
        this.tipoUsuario =tipoUsuario;
        this.correo =correo;
    }

    public Modelo() 
    {
    }
    
    public int getPrimaryKey() 
    {
        return idUsuario;
    }
    public void setPrimaryKey(int idUsuario) 
    {
        this.idUsuario = idUsuario;
    }

    
    public String getNombreUsuario()
    {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario)
    {
        this.nombreUsuario = nombreUsuario;
    }    
    
    public String getPasswordUsuario()
    {
        return passwordUsuario;
    }
    public void setPasswordUsuario(String passwordUsuario)
    {
        this.passwordUsuario = passwordUsuario;
    }

    
    public String getTipoUsuario() 
    {
        return tipoUsuario;
    }
    public void setTipoUsuario(String tipoUsuario)
    {
        this.tipoUsuario = tipoUsuario;
    }    
    
    
    public String getCorreo() 
    {
        return correo;
    }
    public void setCorreo(String correo) 
    {
        this.correo = correo;
    }     

    @Override
    public String toString() 
    {
        return nombreUsuario + ": "+tipoUsuario;
    }
}
