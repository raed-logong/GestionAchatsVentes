package view.components;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;

public class MyTable extends JTable {
    public MyTable() {
        MyRenderer renderer = new MyRenderer();
        Dimension dimension = new Dimension(100, 50);
        getTableHeader().setMinimumSize(dimension);
        getTableHeader().setReorderingAllowed(false);
        setBackground(new Color(0, 0, 0, 0));
        setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getTableHeader().setMinimumSize(new Dimension(100, 100));
        //e.getTableHeader().setFont(new Font(Font.SERIF,Font.BOLD,18));
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
        getTableHeader().setOpaque(false);
        getTableHeader().setBackground(new Color(32, 136, 203));
        getTableHeader().setForeground(new Color(255, 255, 255));
        setSelectionBackground(new java.awt.Color(232, 57, 124));
        setRowHeight(30);
        setDefaultRenderer(Object.class, renderer);

        setFont(new Font("Tahoma", Font.PLAIN, 17));

    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component component = super.prepareRenderer(renderer, row, column);

        //  Alternate row color

        if (!isRowSelected(row))
            //component.setBackground(getValueAt(row,15).equals("true") ? Color.green : Color.RED);
            component.setBackground(Color.WHITE);
        int rendererWidth = component.getPreferredSize().width;
        TableColumn tableColumn = getColumnModel().getColumn(column);
        tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
        return component;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void setHeaderFontsize(int size) {
        getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, size));
    }

    public void settablefontsize(int size) {
        setFont(new Font("Tahoma", Font.PLAIN, size));
    }

    public class MyRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBorder(noFocusBorder);
            return this;
        }

    }
}
