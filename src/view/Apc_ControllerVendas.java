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
    
    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
    }
    
    public ApcVendas getBean(int rowIndex) {
        return (ApcVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ApcVendas vendas = (ApcVendas) lstVendas.get(rowIndex);
        if ( columnIndex == 0 ){
            return vendas.getApcIdPedidos();
        } else if (columnIndex ==1) {
            return vendas.getApcDataPedido();        
        } else if (columnIndex ==2) {
            return vendas.getApcTotal();
        } else if (columnIndex ==3) {
            return vendas.getApcClientes().getApcNome();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        
        if (columnIndex == 0) return "Nº da Venda";
        if (columnIndex == 1) return "Data da Venda";
        if (columnIndex == 2) return "Total";
        if (columnIndex == 3) return "Cliente";
        
        return "";
    }

    

}
