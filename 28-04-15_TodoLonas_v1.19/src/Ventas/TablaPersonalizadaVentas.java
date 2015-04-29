package Ventas;

import static Ventas.PanelVentas.tablaPedidos;
import static Ventas.PanelVentas.tablaMostrarProductos;
import javax.swing.table.TableColumnModel;

public class TablaPersonalizadaVentas {
   
    public static void tablaPedidos()
    {
        TableColumnModel columnaPedidos = tablaPedidos.getColumnModel();
        columnaPedidos.getColumn(0).setPreferredWidth(5);
        columnaPedidos.getColumn(1).setPreferredWidth(100);
        columnaPedidos.getColumn(2).setPreferredWidth(100);
        columnaPedidos.getColumn(3).setPreferredWidth(10);
        columnaPedidos.getColumn(4).setPreferredWidth(10);
        columnaPedidos.getColumn(5).setPreferredWidth(10);
        columnaPedidos.getColumn(6).setPreferredWidth(5);
        columnaPedidos.getColumn(7).setPreferredWidth(10);
        
    }
    public static void tablaMostrarProductos()
    {
        TableColumnModel columnaPedidos = tablaMostrarProductos.getColumnModel();
        columnaPedidos.getColumn(0).setPreferredWidth(15);
        columnaPedidos.getColumn(1).setPreferredWidth(50);
        columnaPedidos.getColumn(2).setPreferredWidth(50);
        columnaPedidos.getColumn(3).setPreferredWidth(15);
    }
   
    
}
