/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.text.ParseException;


/**
 *
 * @author u09947038130
 */ 
public class Util {
    public static void habilitar(boolean valor, JComponent ... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);  
        }
    }
    
    public static void limpar(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            }

            if (componentes[i] instanceof JComboBox) {
                ((JComboBox<?>) componentes[i]).setSelectedIndex(-1);
            }

            if (componentes[i] instanceof JCheckBox) {
                ((JCheckBox) componentes[i]).setSelected(false);
            }

            if (componentes[i] instanceof JFormattedTextField) {
                ((JFormattedTextField) componentes[i]).setText("");
            }

            if (componentes[i] instanceof JPasswordField) {
                ((JPasswordField) componentes[i]).setText("");
            }
        }
    }
    
    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);
    }

    public static boolean perguntar(String cad){
        int resp = JOptionPane.showConfirmDialog(null, cad, "Perguntar", JOptionPane.YES_NO_OPTION);
        
        return resp == JOptionPane.YES_OPTION; //se isso for verdadeiro vai retornar verdadeiro, se não retorna false ( tudo em uma linha)
        
        //if(resp == JOptionPane.YES_OPTION){
        //    return true;
        //} else {
        //    return false; 
        //}
        
    }

    public static int strToInt(String cad) {
        return Integer.parseInt(cad);
    }
    
    public static String intToStr(int num) {
        return String.valueOf(num);
    }

    public static double strToDouble(String cad){
        return Double.parseDouble(cad);
    }

    public static String doubleToStr(double num){
        return String.valueOf(num);
    }

    public static Date strToDate(String cad){
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            return formato.parse(cad);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String dateToStr(Date data){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }
}
    