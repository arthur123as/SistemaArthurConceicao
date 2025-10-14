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
 * @author u09947038130
 */
public class Apc_ControllerVendedor extends AbstractTableModel {
    
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
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ApcVendedor apc_vendedor = (ApcVendedor) lista.get(rowIndex);
        if (columnIndex == 0) {
            return apc_vendedor.getApcIdVendedor();
        } 
        
        if (columnIndex == 1) {
            return apc_vendedor.getApcNome();
        } 
        
        
        if (columnIndex == 2) {
            return apc_vendedor.getApcCpf();
        }
        
        if (columnIndex == 3) {
            return apc_vendedor.getApcDataNascimento();
        }
        
        if (columnIndex == 4) {
            return apc_vendedor.getApcCargo();
        }
        
        if (columnIndex == 5) {
            return apc_vendedor.getApcDataAdimissao();
        }
        return "";
    }
    
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Nome";
        if (column == 2) return "Cpf";
        if (column == 3) return "Data Nascimento";
        if (column == 4) return "Cargo";
        if (column == 5) return "Data Adimissão";
        
        return "";
    }
}
