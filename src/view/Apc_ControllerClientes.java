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
 * @author u09947038130
 */
public class Apc_ControllerClientes extends AbstractTableModel {
    
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ApcClientes apc_clientes = (ApcClientes) lista.get(rowIndex);
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
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Nome";
        if (column == 2) return "Cpf";
        if (column == 3) return "Data de Cadastro";
        if (column == 4) return "Ativo";
        
        return "";
    }
}
