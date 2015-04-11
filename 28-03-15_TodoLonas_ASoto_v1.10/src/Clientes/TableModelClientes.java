package Clientes;

import Clientes.Modelo;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModelClientes extends AbstractTableModel{
    
    private String[] nombreColumnas = {"Clave","Categoría","Nombre","Referencia","Tel. Fijo", "Tel. Móvil", "Correo", "Domicilio", "Colonia", "Ciudad", "RFC", "Fecha"};
    private ArrayList<Modelo> cls;

    public TableModelClientes(ArrayList<Modelo> cls) {
        this.cls = cls;
    }

    public TableModelClientes() {
    }

    public void setClientes(ArrayList<Modelo> cls) {
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
            case 0:  return cls.get(rowIndex).getPrimaryKey();
            case 1:  return cls.get(rowIndex).getCategoriaCliente();
            case 2:  return cls.get(rowIndex).getNombre();
            case 3:  return cls.get(rowIndex).getRef();
            case 4:  return cls.get(rowIndex).getTelFijo();
            case 5:  return cls.get(rowIndex).getTelMovil();
            case 6:  return cls.get(rowIndex).getCorreo();
            case 7:  return cls.get(rowIndex).getDomicilio();
            case 8:  return cls.get(rowIndex).getColonia();
            case 9:  return cls.get(rowIndex).getCiudad();
            case 10: return cls.get(rowIndex).getRFC();
            case 11: return cls.get(rowIndex).getFechaReg();
            default: return null;          
        }
    }    
}
