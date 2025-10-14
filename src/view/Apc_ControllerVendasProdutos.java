/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u09947038130
 */
public class Apc_ControllerVendasProdutos extends AbstractTableModel {
    
    List lista;
    
    public void setList(List lista) {
        this.lista = lista;
    }
    
    public Object getBean(int rowIndex) {
        return lista.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return "";
    }
    
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Nº do Pedido";
        if (column == 1) return "Data do Pedido";
        if (column == 2) return "Total";
        if (column == 3) return "Total";
        if (column == 4) return "Total";
        
        return "";
    }
}
