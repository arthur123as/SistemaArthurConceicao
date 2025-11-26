/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import bean.ApcVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u09947038130
 */
public class Apc_ControllerVendasProdutos extends AbstractTableModel {
    
    private List lstVendasProdutos;
    
    public void setList(List lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
        
        this.fireTableDataChanged();    
    }
    
    public Object getBean(int rowIndex) {
        return (ApcVendasProdutos) lstVendasProdutos.get(rowIndex);
    }
    
    public void addBean(ApcVendasProdutos vendasProdutos) {
        lstVendasProdutos.add(vendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ApcVendasProdutos vendasProdutos = (ApcVendasProdutos) lstVendasProdutos.get(rowIndex);
        if ( columnIndex == 0 ){
            return vendasProdutos.getApcProdutos().getApcIdProdutos();
        } else if (columnIndex ==1) {
            return vendasProdutos.getApcProdutos().getApcNome();
        } else if (columnIndex ==2) {
            return vendasProdutos.getApcQuantidade();
        } else if (columnIndex ==3) {
            return vendasProdutos.getApcPrecoUnitario();
        }else if (columnIndex ==4) {
            return vendasProdutos.getApcPrecoUnitario()*vendasProdutos.getApcQuantidade();
        }
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
