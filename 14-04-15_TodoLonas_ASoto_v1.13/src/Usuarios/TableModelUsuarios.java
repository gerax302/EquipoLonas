package Usuarios;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModelUsuarios extends AbstractTableModel{
    
    private String[] nombreColumnas = {"Clave", "Nombre del usuario", "Contraseña", "Correo", "Tipo de usuario"};
    private ArrayList<Modelo> cls;

    public TableModelUsuarios(ArrayList<Modelo> cls) {
        this.cls = cls;
    }

    public TableModelUsuarios() {
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
            case 1:  return cls.get(rowIndex).getNombreUsuario();
            case 2:  return cls.get(rowIndex).getPasswordUsuario();
            case 3:  return cls.get(rowIndex).getCorreo();
            case 4:  return cls.get(rowIndex).getTipoUsuario();
            default: return null;          
        }
    }
}
