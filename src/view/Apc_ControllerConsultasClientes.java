/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.ApcClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class Apc_ControllerConsultasClientes extends AbstractTableModel {

    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ApcClientes apc_clientes = (ApcClientes) lstClientes.get( rowIndex);
        if (columnIndex == 0) {
            return apc_clientes.getApcIdClientes();
        } 
        
        if (columnIndex == 1) {
            return apc_clientes.getApcNome();
        } 
        
        if (columnIndex == 2) {
            return apc_clientes.getApcCpf();
        }
        
        if (columnIndex == 3) {
            return apc_clientes.getApcDataCadastro();
        }
        
        if (columnIndex == 4) {
            return apc_clientes.getApcAtivo();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) return "Código";
        if (columnIndex == 1) return "Nome";
        if (columnIndex == 2) return "Cpf";
        if (columnIndex == 3) return "Data de Cadastro";
        if (columnIndex == 4) return "Ativo";
        
        return "";
    }
}
