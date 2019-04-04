/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author elearning02
 */
public class myTableModel extends GenericDomainTableModel {
    private String[] titulo;
    private Object[][] datos;
    
    public myTableModel(ArrayList headings, Object[][] data){
        super(headings);
        //this.titulo = headings;
        this.datos = data;
    }
    

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return datos[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        datos[rowIndex][columnIndex] = aValue;
    }
    
}
