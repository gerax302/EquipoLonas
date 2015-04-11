package Productos;

import Productos.Modelo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModelProducto extends AbstractTableModel{
    
    private String[] nombreColumnas = {"Clave","Categoría","Nombre","Cantidad","Unidad", "Precio Unitario", "Stock Mínimo", "Descripción"};
    private ArrayList<Modelo> cls;

    public TableModelProducto(ArrayList<Modelo> cls) {
        this.cls = cls;
    }

    public TableModelProducto() {
    }

    public void setProductos(ArrayList<Modelo> cls) {
        this.cls = cls;
    }
    
    @Override
    public int getRowCount() {
        return cls.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    public Modelo getFila(int index)
    {
        return cls.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        switch(columnIndex)
        {
            case 0: return cls.get(rowIndex).getPrimaryKey();
            case 1: return cls.get(rowIndex).getCategoriaProducto();
            case 2: return cls.get(rowIndex).getNombreProducto();
            case 3: return cls.get(rowIndex).getCantidad();
            case 4: return cls.get(rowIndex).getUnidad();
            case 5: return cls.get(rowIndex).getPrecioUnitario();
            case 6: return cls.get(rowIndex).getStockMinimo();
            case 7: return cls.get(rowIndex).getDescripcion();
            default: return null;          
        }
    }
}
