package Clientes;

import java.io.FileInputStream;

public class Modelo {
    
    public static String SELECT_ALL = "SELECT * FROM cliente order by categoriaCliente, nombreCliente";

    public static String SELECT_ALL_NO_FOTO = "SELECT idCliente,categoriaCliente,nombreCliente, referencia, telefonoFijo, telefonoMovil, correo, domicilio, colonia, ciudad, rfcCliente, fechaRegistro FROM cliente order by categoriaCliente, nombreCliente";

     public static String UPDATE_SIN_FOTO = "UPDATE  cliente SET "+
	"categoriaCliente = ? ,"+
	"nombreCliente = ?, "+
	"referencia = ?, "+
        "telefonoFijo = ?, "+
        "telefonoMovil = ?, "+
        "correo = ?, "+
        "domicilio = ?, "+             
        "colonia = ?, "+   
        "ciudad = ?, "+  
        "rfcCliente = ?, "+                
	"fechaRegistro = ?  WHERE idCliente = ?";
     
    public static String INSERT_SIN_FOTO = "INSERT INTO cliente "
    + "( categoriaCliente, nombreCliente, referencia, telefonoFijo, telefonoMovil, correo, domicilio, colonia, ciudad, rfcCliente, fechaRegistro) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
     
     public static String DELETE = "DELETE FROM cliente where idCliente = ?";

    //Campos tabla producto
    private int idCliente;
    private String categoriaCliente;
    private String nombreCliente;
    private String referencia;
    private String telefonoFijo;
    private String telefonoMovil;
    private String correo;
    private String domicilio;
    private String colonia;
    private String ciudad;
    private String rfcCliente;
    private String fechaRegistro;

    //Constructor con pk
    public Modelo
    (
        int idCliente, String categoriaCliente, String nombreCliente, String referencia, String telefonoFijo, String telefonoMovil,
        String correo, String domicilio, String colonia, String ciudad, String rfcCliente, String fechaRegistro
    )
    {
        this.idCliente = idCliente;
        this.categoriaCliente = categoriaCliente;
        this.nombreCliente =nombreCliente;
        this.referencia =referencia;
        this.telefonoFijo =telefonoFijo;
        this.telefonoMovil =telefonoMovil;
        this.correo =correo;
        this.domicilio =domicilio;
        this.colonia =colonia;
        this.ciudad =ciudad;
        this.rfcCliente =rfcCliente;
        this.fechaRegistro =fechaRegistro;
    }
    
    //Constructor sin pk    
    public Modelo
    (
        String categoriaCliente, String nombreCliente, String referencia, String telefonoFijo, String telefonoMovil,
        String correo, String domicilio, String colonia, String ciudad, String rfcCliente, String fechaRegistro
    )
    {
        this.categoriaCliente = categoriaCliente;
        this.nombreCliente =nombreCliente;
        this.referencia =referencia;
        this.telefonoFijo =telefonoFijo;
        this.telefonoMovil =telefonoMovil;
        this.correo =correo;
        this.domicilio =domicilio;
        this.colonia =colonia;
        this.ciudad =ciudad;
        this.rfcCliente =rfcCliente;
        this.fechaRegistro =fechaRegistro;
    }

    public Modelo() 
    {
    }
    
    public int getPrimaryKey() 
    {
        return idCliente;
    }
    public void setPrimaryKey(int idCliente) 
    {
        this.idCliente = idCliente;
    }

    
    public String getCategoriaCliente()
    {
        return categoriaCliente;
    }
    public void setCategoriaCliente(String categoriaCliente)
    {
        this.categoriaCliente = categoriaCliente;
    }    
    
    
    public String getNombre()
    {
        return nombreCliente;
    }
    public void setNombre(String nombreCliente)
    {
        this.nombreCliente = nombreCliente;
    }

    
    public String getRef() 
    {
        return referencia;
    }
    public void setRef(String referencia)
    {
        this.referencia = referencia;
    }    


    public String getTelFijo() 
    {
        return telefonoFijo;
    }
    public void setTelFijo(String telefonoFijo)
    {
        this.telefonoFijo = telefonoFijo;
    }    

    public String getTelMovil() 
    {
        return telefonoMovil;
    }
    public void setTelMovil(String telefonoMovil)
    {
        this.telefonoMovil = telefonoMovil;
    }     
    
    public String getCorreo() 
    {
        return correo;
    }
    public void setCorreo(String correo) 
    {
        this.correo = correo;
    }     

       
    public String getDomicilio() 
    {
        return domicilio;
    }
    public void setDomicilio(String domicilio)
    {
        this.domicilio = domicilio;
    }

    public String getColonia() 
    {
        return colonia;
    }
    public void setColonia(String colonia)
    {
        this.colonia = colonia;
    }
    
    public String getCiudad() 
    {
        return ciudad;
    }
    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
    }  
    
    public String getRFC() 
    {
        return rfcCliente;
    }
    public void setRFC(String rfcCliente)
    {
        this.rfcCliente = rfcCliente;
    } 
    
    public String getFechaReg() 
    {
        return fechaRegistro;
    }
    public void setFechaReg(String fechaRegistro)
    {
        this.fechaRegistro = fechaRegistro;
    }    

    @Override
    public String toString() 
    {
        return nombreCliente + ": "+categoriaCliente;
    }
   
}
