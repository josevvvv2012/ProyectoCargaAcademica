/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Materias;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author negro
 */
class generalRenderer extends JLabel implements TableCellRenderer {    Font f = new Font( "Helvetica",Font.PLAIN,10 );
 Color colGeneralSel = new Color(117, 204, 169);

 Color colGeneral = new Color(225, 244, 238);

 public generalRenderer() {
  setOpaque(true);
 }

 public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean isSelected, boolean hasFocus,
   int row, int column) {
  setHorizontalAlignment(CENTER);
  if (isSelected) {
   setBackground(colGeneralSel); 
  } else {
   setBackground(colGeneral);
  }
  try {
   setFont(f);
   setText(valor.toString());
  } catch (NullPointerException npe) {
   System.out.println(valor.toString());
   setText("0"); 
  }
  return this;
 }

}
