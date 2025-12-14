/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.ApcVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class Apc_ControllerConsultasVendedor extends AbstractTableModel {

    private List lstVendedor;

    public void setList(List lstVendedor) {
        this.lstVendedor = lstVendedor;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstVendedor.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ApcVendedor produtos = (ApcVendedor) lstVendedor.get( rowIndex);
        if ( columnIndex == 0 ){
            return produtos.getApcIdVendedor();
        } else if (columnIndex ==1) {
            return produtos.getApcNome();        
        } else if (columnIndex ==2) {
            return produtos.getApcCargo();
        } else if (columnIndex ==3) {
            return produtos.getApcSalario();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Cargo";
        } else if ( columnIndex == 3) {
            return "Salario";
        }
        return "";
    }
}
