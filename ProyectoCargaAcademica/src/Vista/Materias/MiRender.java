/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Materias;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author negro
 */
public class MiRender implements TableCellRenderer

{

  private TableCellRenderer delegate;

 

  public MiRender(TableCellRenderer defaultRenderer)

  {

    this.delegate = defaultRenderer;

  }

 

  public Component getTableCellRendererComponent(JTable table, Object value,

                           boolean isSelected, boolean hasFocus, int row, int column)

  {

    Component c = delegate.getTableCellRendererComponent(table, value, isSelected,

                                                                hasFocus, row, column);     
    
    int modelColumn = table.convertRowIndexToView(row);

    if (!isSelected)

    { 

     

      

        c.setBackground(Color.BLACK);

     
    } 
    
    

      

        //set background and foreground for being LAF independent

        c.setBackground(Color.CYAN);

      

   return c;

  }

}
