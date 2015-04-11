package Proveedores;

import java.io.FileInputStream;

public class Modelo {
    
    public static String SELECT_ALL = "SELECT * FROM proveedor order by nombreProveedor";

    public static String SELECT_ALL_NO_FOTO = "SELECT idProveedor, "
            + "nombreProveedor, "
            + "domicilio, "
            + "colonia, "
            + "codigoPostal, "
            + "ciudad, "
            + "telefonoFijo, "
            + "telefonoMovil, "
            + "correo, "
            + "razonSocial, "
            + "rfcProveedor, "
            + "banco, "
            + "numeroCuenta, "
            + "tipoCuenta "
            + "FROM proveedor "
            + "order by nombreProveedor";

     public static String UPDATE_SIN_FOTO = "UPDATE  proveedor SET "+
	"nombreProveedor = ? ,"+
	"domicilio = ?, "+
	"colonia = ?, "+
        "codigoPostal = ?, "+
        "ciudad = ?, "+
        "telefonoFijo = ?, "+
        "telefonoMovil = ?, "+             
        "correo = ?, "+   
        "razonSocial = ?, "+  
        "rfcProveedor = ?, "+                
	"banco = ?,  " +
        "numeroCuenta = ?, "  + 
        "tipoCuenta = ? WHERE idProveedor = ?";
          
    public static String INSERT_SIN_FOTO = "INSERT INTO proveedor "
            + "( nombreProveedor, "
            + "domicilio, "
            + "colonia, "
            + "codigoPostal, "
            + "ciudad, "
            + "telefonoFijo, "
            + "telefonoMovil, "
            + "correo, "
            + "razonSocial, "
            + "rfcProveedor, "
            + "banco, "
            + "numeroCuenta, "
            + "tipoCuenta) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
     
     public static String DELETE = "DELETE FROM proveedor where idProveedor = ?";

    //Campos tabla proveedor
    private int idProveedor;
    private String nombreProveedor;
    private String domicilio;
    private String colonia;
    private String codigoPostal;
    private String ciudad;
    private String telefonoFijo;
    private String telefonoMovil;
    private String correo;
    private String razonSocial;
    private String rfcProveedor;
    private String banco;
    private String numeroCuenta;
    private String tipoCuenta;

    //Constructor con pk
    public Modelo
    (
        int idProveedor, String nombreProveedor, String domicilio,
            String colonia, String codigoPostal, String ciudad,
            String telefonoFijo, String telefonoMovil, String correo,
            String razonSocial, String rfcProveedor, String banco, 
            String numeroCuenta, String tipoCuenta
    )
        {
            this.idProveedor = idProveedor;
            this.nombreProveedor = nombreProveedor;
            this.domicilio = domicilio;
            this.colonia = colonia;
            this.codigoPostal = codigoPostal;
            this.ciudad = ciudad;
            this.telefonoFijo = telefonoFijo;
            this.telefonoMovil = telefonoMovil;
            this.correo = correo;
            this.razonSocial = razonSocial;
            this.rfcProveedor = rfcProveedor;
            this.banco = banco;
            this.numeroCuenta = numeroCuenta;
            this.tipoCuenta = tipoCuenta;
        }
    
    //Constructor sin pk    
    public Modelo
    (
        String nombreProveedor, String domicilio, String colonia, 
        String codigoPostal, String ciudad, String telefonoFijo, 
        String telefonoMovil, String correo, String razonSocial,
        String rfcProveedor, String banco, String numeroCuenta,
        String tipoCuenta
    )
    {
        this.nombreProveedor = nombreProveedor;
        this.domicilio = domicilio;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
        this.correo = correo;
        this.razonSocial = razonSocial;
        this.rfcProveedor = rfcProveedor;
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
    }

    public Modelo() 
    {
    }
    
    public int getPrimaryKey() 
    {
        return idProveedor;
    }
    public void setPrimaryKey(int idProveedor) 
    {
        this.idProveedor = idProveedor;
    }

    
    public String getNombre()
    {
        return nombreProveedor;
    }
    public void setNombre(String nombreProveedor)
    {
        this.nombreProveedor = nombreProveedor;
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

    
    public String getCodigoPostal()
    {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal)
    {
        this.codigoPostal = codigoPostal;
    }
    
    
    public String getCiudad()
    {
        return ciudad;
    }
    public void setCiudad(String ciudad)
    {
        this.ciudad = ciudad;
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

       
    public String getRazonSocial() 
    {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial)
    {
        this.razonSocial = razonSocial;
    }

    
    public String getRFC() 
    {
        return rfcProveedor;
    }
    public void setRFC(String rfcProveedor)
    {
        this.rfcProveedor = rfcProveedor;
    }
    
    
    public String getBanco() 
    {
        return banco;
    }
    public void setBanco(String banco)
    {
        this.banco = banco;
    }  
    
    
    public String getNumeroCuenta() 
    {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta)
    {
        this.numeroCuenta = numeroCuenta;
    } 
    
    
    public String getTipoCuenta() 
    {
        return tipoCuenta;
    }
    public void setTipoCuenta(String tipoCuenta)
    {
        this.tipoCuenta = tipoCuenta;
    }    

    @Override
    public String toString() 
    {
        return nombreProveedor + ": "+domicilio;
    }
}
