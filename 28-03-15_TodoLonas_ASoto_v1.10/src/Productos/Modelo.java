package Productos;

import java.io.FileInputStream;

public class Modelo {
    
    public static String SELECT_ALL = "SELECT * FROM producto order by categoriaProducto, nombreProducto";
    public static String SELECT_ALL_NO_FOTO = "SELECT idProducto, categoriaProducto, nombreProducto, cantidad, unidad, precioUnitario, stockMinimo, descripcion FROM producto order by categoriaProducto, nombreProducto";
    
    public static String UPDATE_CON_FOTO = "UPDATE producto SET "+
	"categoriaProducto = ? ,"+
	"nombreProducto = ?, "+
	"cantidad = ?, "+
        "unidad = ?, "+
        "precioUnitario = ?, "+
        "stockMinimo = ?, "+
	"descripcion = ?, "+
	"imagenProducto = ? WHERE idProducto = ?";
     public static String UPDATE_SIN_FOTO = "UPDATE  producto SET "+
	"categoriaProducto = ? ,"+
	"nombreProducto = ?, "+
	"cantidad = ?, "+
        "unidad = ?, "+
        "precioUnitario = ?, "+
        "stockMinimo = ?, "+
	"descripcion = ?  WHERE idProducto = ?";
     
     public static String INSERT_CON_FOTO = "INSERT INTO producto "
             + "(categoriaProducto, nombreProducto, cantidad, unidad, precioUnitario, stockMinimo, descripcion, imagenProducto) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
     public static String INSERT_SIN_FOTO = "INSERT INTO producto "
             + "(categoriaProducto, nombreProducto, cantidad, unidad, precioUnitario, stockMinimo, descripcion) VALUES(?, ?, ?, ?, ?, ?, ?)";
     
     public static String DELETE = "DELETE FROM producto where idProducto = ?";

    //Campos tabla producto
    private int idProducto;
    private String categoriaProducto;
    private String nombreProducto;
    private String cantidad;
    private String unidad;
    private String precioUnitario;
    private String  stockMinimo;
    private String descripcion;
    private FileInputStream imagenProducto;

    //Constructor con pk
    public Modelo
    (
        int idProducto, String categoriaProducto, String nombreProducto, String cantidad, String unidad, 
        String precioUnitario, String stockMinimo, String descripcion, FileInputStream imagenProducto
    )
    {
        this.idProducto = idProducto;
        this.categoriaProducto = categoriaProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.precioUnitario = precioUnitario;
        this.stockMinimo = stockMinimo;
        this.descripcion = descripcion;
        this.imagenProducto = imagenProducto;
    }
    
    //Constructor sin pk    
    public Modelo
    (
        String categoriaProducto, String nombreProducto, String cantidad, String unidad, 
        String precioUnitario, String stockMinimo, String descripcion, FileInputStream imagenProducto
    )
    {
        this.categoriaProducto = categoriaProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.precioUnitario = precioUnitario;
        this.stockMinimo = stockMinimo;
        this.descripcion = descripcion;
        this.imagenProducto = imagenProducto;
    }

    public Modelo() 
    {
    }
    
    public int getPrimaryKey() 
    {
        return idProducto;
    }
    public void setPrimaryKey(int idProducto) 
    {
        this.idProducto = idProducto;
    }

    
    public String getCategoriaProducto()
    {
        return categoriaProducto;
    }
    public void setCategoriaProducto(String categoriaProducto)
    {
        this.categoriaProducto = categoriaProducto;
    }    
    
    
    public String getNombreProducto()
    {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto)
    {
        this.nombreProducto = nombreProducto;
    }

    
    public String getCantidad() 
    {
        return cantidad;
    }
    public void setCantidad(String cantidad)
    {
        this.cantidad = cantidad;
    }    


    public String getUnidad() 
    {
        return unidad;
    }
    public void setUnidad(String unidad)
    {
        this.unidad = unidad;
    }    

    
    public String getPrecioUnitario() 
    {
        return precioUnitario;
    }
    public void setPrecioUnitario(String precioUnitario) 
    {
        this.precioUnitario = precioUnitario;
    }     

    
    public String getStockMinimo() 
    {
        return stockMinimo;
    }
    public void setStockMinimo(String stockMinimo)
    {
        this.stockMinimo = stockMinimo;
    }

    
    public String getDescripcion() 
    {
        return descripcion;
    }
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }


    public FileInputStream getFoto() 
    {
        return imagenProducto;
    }
    public void setFoto(FileInputStream imagenProducto)
    {
        this.imagenProducto = imagenProducto;
    }

    @Override
    public String toString() 
    {
        return categoriaProducto + ": "+nombreProducto;
    }   
}
