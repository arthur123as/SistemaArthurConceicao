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
 * @author Marcos
 */
public class Apc_ControllerConsultasVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            ApcVendas vendas = (ApcVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendas.getApcIdPedidos();
        } else if (columnIndex ==1) {
            return vendas.getApcClientes();        
        } else if (columnIndex ==2) {
            return vendas.getApcVendedor();
        } else if (columnIndex ==3) {
            return vendas.getApcDataPedido();
        } else if (columnIndex ==4) {
            return vendas.getApcTotal();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código da Venda";
        } else if ( columnIndex == 1) {
            return "Nome Cliente";         
        } else if ( columnIndex == 2) {
            return "Nome Vendedor";
        } else if ( columnIndex == 3) {
            return "Data Venda";
        } else if ( columnIndex == 4) {
            return "Total";
        }
        return "";
    }
}
