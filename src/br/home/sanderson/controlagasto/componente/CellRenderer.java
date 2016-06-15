package br.home.sanderson.controlagasto.componente;

import br.home.sanderson.controlagasto.util.Utils;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author AJFILHO
 */
public class CellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

    public CellRenderer() {
        super();
    }

    @Override
    public void setHorizontalAlignment(int alignment) {
        super.setHorizontalAlignment(alignment);
    }

//    public void set
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JPanel panel = new JPanel(new GridLayout(1, 0));
        if (table.getValueAt(row, 4).equals("SIM")) { //[232,154,132]
            panel.setBackground(new java.awt.Color(153, 255, 153));
        } else if (Utils.getDate(table.getValueAt(row, 2).toString()).isBefore(Utils.getDtAtual().plusDays(5))
                && Utils.getDate(table.getValueAt(row, 2).toString()).isAfter(Utils.getDtAtual())) {
            //Vencido
            panel.setBackground(new java.awt.Color(232, 238, 148));
        } else if (Utils.getDate(table.getValueAt(row, 2).toString()).isBefore(Utils.getDtAtual())) {
            //Vencendo
            panel.setBackground(new java.awt.Color(232, 154, 132));
        } else {
            panel.setBackground(Color.WHITE);
        }
        if (isSelected) {
            panel.setBackground(new java.awt.Color(194, 210, 238));
        }
        JLabel jlabel = new JLabel(value.toString());
        jlabel.setForeground(Color.BLACK);
        panel.add(jlabel);
        return panel;
    }
}
