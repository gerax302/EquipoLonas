package Ventas;

import static Ventas.PanelVentas.tablaPedidos;
import static Ventas.PanelVentas.tablaMostrarProductos;
import javax.swing.table.TableColumnModel;

public class TablaPersonalizadaVentas {
   
    public static void tablaPedidos()
    {
        TableColumnModel columnaPedidos = tablaPedidos.getColumnModel();
        columnaPedidos.getColumn(0).setPreferredWidth(5);
        columnaPedidos.getColumn(1).setPreferredWidth(70);
        columnaPedidos.getColumn(2).setPreferredWidth(70);
        columnaPedidos.getColumn(3).setPreferredWidth(40);
        columnaPedidos.getColumn(4).setPreferredWidth(5);
        columnaPedidos.getColumn(5).setPreferredWidth(15);
        columnaPedidos.getColumn(6).setPreferredWidth(15);
        columnaPedidos.getColumn(7).setPreferredWidth(15);
    }
    
    public static void tablaMostrarProductos()
    {
        TableColumnModel columnaPedidos = tablaMostrarProductos.getColumnModel();
        columnaPedidos.getColumn(0).setPreferredWidth(5);
        columnaPedidos.getColumn(1).setPreferredWidth(30);
        columnaPedidos.getColumn(2).setPreferredWidth(50);
        columnaPedidos.getColumn(3).setPreferredWidth(50);
    }
   
    
}
