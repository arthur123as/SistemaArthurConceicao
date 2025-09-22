/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.Apc_Usuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u09947038130
 */
public class Apc_ControllerUsuarios extends AbstractTableModel {
    
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
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Apc_Usuarios apc_usuarios = (Apc_Usuarios) lista.get(rowIndex);
        if (columnIndex == 0) {
            return apc_usuarios.getApc_idUsuarios();
        } 
        
        if (columnIndex == 1) {
            return apc_usuarios.getApc_nome();
        } 
        
        if (columnIndex == 2) {
            return apc_usuarios.getApc_apelido();
        }
        
        if (columnIndex == 3) {
            return apc_usuarios.getApc_cpf();
        }
        
        if (columnIndex == 4) {
            return apc_usuarios.getApc_dataNascimento();
        }
        
        if (columnIndex == 5) {
            return apc_usuarios.getApc_senha();
        }
        
        if (columnIndex == 6) {
            return apc_usuarios.getApc_nivel();
        }
        
        if (columnIndex == 7) {
            return apc_usuarios.getApc_ativo();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Nome";
        if (column == 2) return "Apelido";
        if (column == 3) return "Cpf";
        if (column == 4) return "Data Nascimento";
        if (column == 5) return "Senha";
        if (column == 6) return "Nível";
        if (column == 7) return "Ativo";
        
        return "";
    }
}
