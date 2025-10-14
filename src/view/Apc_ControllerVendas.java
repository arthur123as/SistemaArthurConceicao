/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.ApcVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u09947038130
 */
public class Apc_ControllerVendas extends AbstractTableModel {
    
    List lista;
    
    public void setList(List lista) {
        this.lista = lista;
    }
    
    public Object getBean(int rowIndex) {
        return lista.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ApcVendas apc_vendas = (ApcVendas) lista.get(rowIndex);
        if (columnIndex == 0) {
            return apc_vendas.getApcIdPedidos();
        } 
        
        if (columnIndex == 1) {
            return apc_vendas.getApcDataPedido();
        } 
        
        if (columnIndex == 2) {
            return apc_vendas.getApcTotal();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Nº do Pedido";
        if (column == 1) return "Data do Pedido";
        if (column == 2) return "Total";
        
        return "";
    }
}
